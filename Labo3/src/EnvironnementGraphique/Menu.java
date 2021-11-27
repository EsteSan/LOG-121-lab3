package EnvironnementGraphique;

import Vues.DeuxiemeVue;
import Vues.PremiereVue;
import Vues.TroisiemeVue;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import Modele.Image2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.filechooser.FileFilter;

public class Menu extends JMenuBar {
    /**
     * Cr�ation de la barre de menu et de ses �l�ments
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
    Image2 image2;

    public Menu(JFrame frame, PremiereVue vue1, DeuxiemeVue vue2, TroisiemeVue vue3){

        setAlignmentX(0);
        setAlignmentY(0);
        setSize(DIMENSION);
        ajouterMenuFichier(frame,vue1,vue2,vue3);
        ajouterMenuCommande();

    }

    /**
     * Cr�ation du menu fichier
     * @param frame
     */
    private void ajouterMenuFichier(JFrame frame,PremiereVue vue1, DeuxiemeVue vue2, TroisiemeVue vue3){
        JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
        JMenuItem nouvelleImage = new JMenuItem(MENU_FICHIER_NOUVELLE_IMAGE);
        JMenuItem sauvegarder = new JMenuItem(MENU_FICHIER_SAUVEGARDER);
        JMenuItem charger = new JMenuItem(MENU_FICHIER_CHARGER);
        JFileChooser fileChooser =new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        /**
         * POUR INS�RER UNE NOUVELLE IMAGE
         */
        nouvelleImage.addActionListener((ActionEvent e)->{
        
            ImageIcon image;
            fileChooser.setDialogTitle("Choisissez une image");
            fileChooser.setAcceptAllFileFilterUsed(false);
            //Cr�ation d'un filtre
            FileNameExtensionFilter filtre = new FileNameExtensionFilter(".jpg", "jpg");
            fileChooser.addChoosableFileFilter(filtre);

            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                image = new ImageIcon(selectedFile.getAbsolutePath());
                 image2 = new Image2(selectedFile.getAbsolutePath());
                vue1.addImage(image2);
                vue2.addImage(image2);
                vue3.addImage(image2);
            }
        });

        /**
         * POUR SAUVEGARDER
         */
        sauvegarder.addActionListener((ActionEvent e) ->{
            fileChooser.setDialogTitle("Sauvegarder");
            //S�rialisation
            try {
                FileOutputStream fileOut= new FileOutputStream("C:\\Users\\Public\\Sauvegarde.ser");
                ObjectOutputStream out= new ObjectOutputStream(fileOut);
                out.writeObject(frame);
                out.close();
                fileOut.close();
            }  catch (IOException i) {
                i.printStackTrace();
            }
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
            /*fileChooser.setDialogTitle("Charger");
            //D�rialisation
            try {
                FileInputStream fileIn= new FileInputStream("C:\\Users\\Public\\Sauvegarde.ser");
                ObjectInputStream out= new ObjectInputStream(fileIn);
                out.writeObject(frame);
                out.close();
                fileOut.close();
            }  catch (IOException i) {
                i.printStackTrace();
            }
            int returnValue = fileChooser.showSaveDialog(frame);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                System.out.println("Sauvegarder comme: " + fileToSave.getAbsolutePath());
            }*/
        });
        /**
         * Impl�menter les actions listener
         */

        menuFichier.add(nouvelleImage);
        menuFichier.add(sauvegarder);
        menuFichier.add(charger);

        add(menuFichier);
    }

    /**
     * Cr�ation du menu commande
     */
    private void ajouterMenuCommande(){
        JMenu menuCommande = new JMenu(MENU_COMMANDE_TITRE);
        JMenuItem undo = new JMenuItem(MENU_COMMANDE_UNDO);
        JMenuItem redo = new JMenuItem(MENU_COMMANDE_REDO);

        /**
         * Impl�menter les actions listener
         */

        menuCommande.add(undo);
        menuCommande.add(redo);

        add(menuCommande);
    }

}
