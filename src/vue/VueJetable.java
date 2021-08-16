package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controleur.*;
import metier.*;

public class VueJetable {

    static Session session;
    static JFrame frame;

    public static void main(String[] args) {
        Client.initializeClients();
        Commande.initializeCommandes();
        Produit.initializeProduits();

        session = new Session();
        TraiterConnexionReponse reponse = session.traiterConnexion();
        if (reponse.typeEcran == EnumTypeEcran.ECRAN_ACCUEIL) {
            afficherEcranAccueil();
        }

    }

    private static void afficherEcranAccueil() {
        frame = new JFrame();
        frame.setTitle("French Chic - Accueil");
        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        JPanel accueilPanel = new JPanel();
        accueilPanel.setBackground(Color.WHITE);
        frame.setContentPane(accueilPanel);
        frame.setLayout(null);
        //initialiserPanel(); 

        JLabel title = new JLabel("French Chic");
        title.setLocation(150, 50);
        title.setSize(1000, 100);
        Font f = new Font("", Font.PLAIN, 70);
        title.setFont(f);
        title.setForeground(Color.MAGENTA);

        JLabel pseudoLabel = null;
        JLabel mdpLabel = null;

        pseudoLabel = new JLabel("Pseudo");
        pseudoLabel.setSize(120, 20);
        pseudoLabel.setLocation(150, 200);
        mdpLabel = new JLabel("Mot de passe");
        mdpLabel.setSize(120, 20);
        mdpLabel.setLocation(150, 250);

        int longueur = 200;
        int largeur = 30;

        final JTextField pseudoField;
        final JPasswordField mdpField;

        pseudoField = new JTextField();
        pseudoField.setSize(longueur, largeur);
        pseudoField.setLocation(250, 200);
        mdpField = new JPasswordField();
        mdpField.setSize(longueur, largeur);
        mdpField.setLocation(250, 250);
        JButton login = new JButton("S'identifier");
        login.setLocation(250, 300);
        login.setSize(longueur, largeur);

        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                TraiterIdentificationReponse reponse = session.traiterIdentification(pseudoField.getText(), mdpField.getText());
                frame.setVisible(false);
                if (reponse.typeEcran == EnumTypeEcran.ECRAN_ACCUEIL_PERSO) {
                    afficherEcranAccueilPerso(reponse.leClient, reponse.leProduit);
                }
            }
        });

        frame.add(title);
        frame.add(pseudoLabel);
        frame.add(mdpLabel);
        frame.add(pseudoField);
        frame.add(mdpField);
        frame.add(login);
        frame.setVisible(true);

    }

    private static void afficherEcranAccueilPerso(final Client client, final Produit produit) {
        frame = new JFrame();
        frame.setTitle("French Chic - Produit du jour");
        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        JPanel accueilPanel = new JPanel();
        accueilPanel.setBackground(Color.WHITE);
        frame.setContentPane(accueilPanel);
        frame.setLayout(null);

        JLabel title = new JLabel("French Chic");
        title.setLocation(150, 50);
        title.setSize(1000, 100);
        Font f = new Font("", Font.PLAIN, 70);
        title.setFont(f);
        title.setForeground(Color.MAGENTA);

        JLabel bonjourTexte = null;
        JLabel produitDuJourTexte = null;
        JLabel quantiteLabel = null;

        String bonjourTxt = "Bonjour " + client.getPrenom() + " " + client.getNom();
        bonjourTexte = new JLabel(bonjourTxt);
        bonjourTexte.setSize(250, 20);
        bonjourTexte.setLocation(150, 200);

        String produitTxt = "Le produit du jour est le \"" + produit.getNom() + "\" au prix de " + produit.getPrix() + " Euros";
        produitDuJourTexte = new JLabel(produitTxt);
        produitDuJourTexte.setSize(500, 20);
        produitDuJourTexte.setLocation(150, 250);

        quantiteLabel = new JLabel("Quantite");
        quantiteLabel.setSize(120, 20);
        quantiteLabel.setLocation(250, 325);

        int longueur = 200;
        int largeur = 30;

        final JTextField quantiteField;

        quantiteField = new JTextField();
        quantiteField.setSize(longueur, largeur);
        quantiteField.setLocation(320, 320);
        quantiteField.setSize(50, largeur);

        JButton ajouterProduit = new JButton("Ajouter le produit du jour au panier");
        ajouterProduit.setLocation(250, 370);
        ajouterProduit.setSize(longueur, largeur);

        ajouterProduit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Integer intg = new Integer(quantiteField.getText());
                TraiterAjoutPanierReponse reponse = session.traiterAjoutPanier(produit, intg);
                frame.setVisible(false);
                if (reponse.typeEcran == EnumTypeEcran.ECRAN_PANIER) {
                    afficherEcranPanier(reponse.laCommande);
                }
            }
        });

        frame.add(title);
        frame.add(bonjourTexte);
        frame.add(produitDuJourTexte);
        frame.add(quantiteField);
        frame.add(quantiteLabel);
        frame.add(ajouterProduit);
        frame.setVisible(true);
    }

    private static void afficherEcranPanier(Commande laCommande) {
        frame = new JFrame();
        frame.setTitle("French Chic - Panier");
        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        JPanel accueilPanel = new JPanel();
        accueilPanel.setBackground(Color.WHITE);
        frame.setContentPane(accueilPanel);
        frame.setLayout(null);

        JLabel title = new JLabel("Votre Panier");
        title.setLocation(150, 50);
        title.setSize(1000, 100);
        Font f = new Font("", Font.PLAIN, 70);
        title.setFont(f);
        title.setForeground(Color.MAGENTA);

        LigneCommande ligneC = (LigneCommande) laCommande.getLesLignesCommande();
        NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
        nf.setMinimumFractionDigits(2);

        String prixHTLg = nf.format(ligneC.getProduit().getPrix());
        String montantLg = nf.format(ligneC.getMontant());

        String[] entetes = {"Libelle", "Prix HT", "Quantite", "Montant"};

        Object[][] donnees = {
            {ligneC.getProduit().getNom(), prixHTLg, new Integer(ligneC.getQuantite()).toString(), montantLg},};

        JTable table = new JTable(donnees, entetes);
        table.setSize(400, 100);
        table.setLocation(125, 200);
        JPanel paneTab = new JPanel();
        paneTab.setLocation(125, 200);
        paneTab.setSize(400, 200);
        paneTab.setBackground(Color.WHITE);
        paneTab.add(table.getTableHeader(), BorderLayout.NORTH);
        paneTab.add(table, BorderLayout.CENTER);

        JLabel montantLabel = null;

        montantLabel = new JLabel("Montant panier");
        montantLabel.setSize(120, 20);
        montantLabel.setLocation(250, 423);

        int longueur = 200;
        int largeur = 30;

        final JTextField montantField;

        montantField = new JTextField();
        montantField.setSize(longueur, largeur);
        montantField.setLocation(350, 420);
        montantField.setSize(100, largeur);

        String total = nf.format(laCommande.getMontant());

        String montantTxt = String.valueOf(total) + " Euros";
        montantField.setText(montantTxt);
        montantField.setEditable(false);

        frame.add(title);
        frame.add(montantField);
        frame.add(montantLabel);
        frame.add(paneTab);
        frame.setVisible(true);
    }
}
