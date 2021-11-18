package EnvironnementGraphique;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.filechooser.FileFilter;

public class Menu extends JMenuBar {
    /**
     * Création de la barre de menu et de ses éléments
     */
    //Attributs
    private static final int X = 0;
    private static final int Y = 0;
    private static final Dimension DIMENSION=new Dimension(1400,30);
    private static final String MENU_FICHIER_TITRE = "Fichier";
    private static final String MENU_FICHIER_NOUVELLE_IMAGE = "Nouvelle Image";
    private static final String MENU_FICHIER_SAUVEGARDER = "Sauvegarder";
    private static final String MENU_FICHIER_CHARGER = "Charger";
    private static final String MENU_COMMANDE_TITRE = "Commande";
    private static final String MENU_COMMANDE_UNDO = "Undo";
    private static final String MENU_COMMANDE_REDO = "Redo";

    public Menu(JFrame frame){

        setAlignmentX(0);
        setAlignmentY(0);
        setSize(DIMENSION);
        ajouterMenuFichier(frame);
        ajouterMenuCommande();

    }

    /**
     * Création du menu fichier
     * @param frame
     */
    private void ajouterMenuFichier(JFrame frame){
        JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
        JMenuItem nouvelleImage = new JMenuItem(MENU_FICHIER_NOUVELLE_IMAGE);
        JMenuItem sauvegarder = new JMenuItem(MENU_FICHIER_SAUVEGARDER);
        JMenuItem charger = new JMenuItem(MENU_FICHIER_CHARGER);
        JFileChooser fileChooser =new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        /**
         * POUR CHARGER UNE IMAGE
         */
        nouvelleImage.addActionListener((ActionEvent e)->{

            fileChooser.setDialogTitle("Choisissez une image");
            fileChooser.setAcceptAllFileFilterUsed(false);
            //Création d'un filtre
            FileNameExtensionFilter filtre = new FileNameExtensionFilter(".jpeg", "jpeg");
            fileChooser.addChoosableFileFilter(filtre);

            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println(selectedFile.getAbsolutePath());
            }
        });

        /**
         * POUR SAUVEGARDER
         */
        sauvegarder.addActionListener((ActionEvent e) ->{
            fileChooser.setDialogTitle("Sauvegarder");
            int returnValue = fileChooser.showSaveDialog(frame);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                System.out.println("Sauvegarder comme: " + fileToSave.getAbsolutePath());
            }
        });

        /**
         * POUR CHARGER
         */
        charger.addActionListener((ActionEvent e) ->{
            fileChooser.setDialogTitle("Veuillez charger un fichier");
        });
        /**
         * Implémenter les actions listener
         */

        menuFichier.add(nouvelleImage);
        menuFichier.add(sauvegarder);
        menuFichier.add(charger);

        add(menuFichier);
    }

    /**
     * Création du menu commande
     */
    private void ajouterMenuCommande(){
        JMenu menuCommande = new JMenu(MENU_COMMANDE_TITRE);
        JMenuItem undo = new JMenuItem(MENU_COMMANDE_UNDO);
        JMenuItem redo = new JMenuItem(MENU_COMMANDE_REDO);

        /**
         * Implémenter les actions listener
         */

        menuCommande.add(undo);
        menuCommande.add(redo);

        add(menuCommande);
    }

}
