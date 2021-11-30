package Vues.EnvironnementGraphique;

import Controleur.GestionnaireOperation;
import Modele.Sauvegarde;
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

    public Menu(JFrame frame, PremiereVue vue1, DeuxiemeVue vue2, TroisiemeVue vue3, Sauvegarde sauve){

        setAlignmentX(0);
        setAlignmentY(0);
        setSize(DIMENSION);
        ajouterMenuFichier(frame,vue1,vue2,vue3,sauve);
        ajouterMenuCommande();

    }

    /**
     * Cr�ation du menu fichier
     * @param frame
     */
    private void ajouterMenuFichier(JFrame frame,PremiereVue vue1, DeuxiemeVue vue2, TroisiemeVue vue3, Sauvegarde sauve){
        JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
        JMenuItem nouvelleImage = new JMenuItem(MENU_FICHIER_NOUVELLE_IMAGE);
        JMenuItem sauvegarder = new JMenuItem(MENU_FICHIER_SAUVEGARDER);
        JMenuItem charger = new JMenuItem(MENU_FICHIER_CHARGER);
        JFileChooser fileChooser =new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        /**
         * POUR INS�RER UNE NOUVELLE IMAGE
         */
        nouvelleImage.addActionListener((ActionEvent e)->{

            fileChooser.setDialogTitle("Choisissez une image");
            fileChooser.setAcceptAllFileFilterUsed(false);
            //Cr�ation d'un filtre
            FileNameExtensionFilter filtre = new FileNameExtensionFilter(".jpg", "jpg");
            fileChooser.addChoosableFileFilter(filtre);

            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                ImageIcon image = new ImageIcon(selectedFile.getAbsolutePath());
                vue2.addImage(image);
                vue1.addImage(image);
                sauve.setPath(selectedFile.getAbsolutePath());
                vue3.addImage(image);
            }
        });

        /**
         * POUR SAUVEGARDER
         */
        sauvegarder.addActionListener((e) -> {
            fileChooser.setDialogTitle("Sauvegarder");
            int returnValue = fileChooser.showSaveDialog((Component)null);
            if (returnValue == 0) {
                File fileToSave = fileChooser.getSelectedFile();

                try {
                    FileOutputStream fileOut = new FileOutputStream(fileToSave.getPath() + ".ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(sauve);
                    out.flush();
                    out.close();
                    fileOut.close();
                } catch (IOException var7) {
                    var7.printStackTrace();
                }
            }

        });

        /**
         * POUR CHARGER
         */
        charger.addActionListener((ActionEvent e) ->{
            fileChooser.setDialogTitle("Charger un fichier");
            fileChooser.setAcceptAllFileFilterUsed(false);
            //Cr�ation d'un filtre
            FileNameExtensionFilter filtre = new FileNameExtensionFilter(".ser", "ser");
            fileChooser.addChoosableFileFilter(filtre);

            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                Sauvegarde sauvegarde=null;
                File selectedFile = fileChooser.getSelectedFile();
                FileInputStream fileIn = null;
                try {
                    fileIn = new FileInputStream(selectedFile.getAbsolutePath());
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    sauvegarde = (Sauvegarde) in.readObject();
                    vue1.setContenu(sauvegarde.getPath());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

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

        undo.addActionListener((ActionEvent e) ->{
            GestionnaireOperation.getInstance().undo();
        });
        redo.addActionListener((ActionEvent e) ->{
            GestionnaireOperation.getInstance().redo();
        });
        menuCommande.add(undo);
        menuCommande.add(redo);

        add(menuCommande);
    }

}
