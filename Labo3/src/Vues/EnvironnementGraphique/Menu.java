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
    Sauvegarde sauve=new Sauvegarde();
    public Menu(JFrame frame, PremiereVue vue1, DeuxiemeVue vue2, TroisiemeVue vue3, Sauvegarde sauve){

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
            fileChooser.resetChoosableFileFilters();
            fileChooser.setDialogTitle("Choisissez une image");
            fileChooser.setAcceptAllFileFilterUsed(false);
            //Cr�ation d'un filtre
            FileNameExtensionFilter filtre = new FileNameExtensionFilter(".jpg", "jpg");
            fileChooser.addChoosableFileFilter(filtre);

            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                ImageIcon image = new ImageIcon(selectedFile.getAbsolutePath());
                GestionnaireOperation.reset();
                vue1.lab.reset();
                vue2.lab.reset();
                vue3.lab.reset();
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
            fileChooser.resetChoosableFileFilters();
            fileChooser.setDialogTitle("Sauvegarder");
            FileNameExtensionFilter filtre = new FileNameExtensionFilter(".ser", "ser");
            fileChooser.addChoosableFileFilter(filtre);
            int returnValue = fileChooser.showSaveDialog((Component)null);
            sauve.setZoom(vue1.lab);
            sauve.setTranslation(vue2.lab);
            sauve.setOriginal(vue3.lab);
            sauve.setGestionnaireOperation(GestionnaireOperation.getInstance());
            System.out.println(sauve);
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
            fileChooser.resetChoosableFileFilters();
            fileChooser.setDialogTitle("Charger un fichier");
            fileChooser.setAcceptAllFileFilterUsed(false);
            //Cr�ation d'un filtre
            FileNameExtensionFilter filtre = new FileNameExtensionFilter(".ser", "ser");
            fileChooser.addChoosableFileFilter(filtre);


            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                FileInputStream fileIn = null;
                try {
                    fileIn = new FileInputStream(selectedFile.getAbsolutePath());
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    sauve = (Sauvegarde) in.readObject();
                    GestionnaireOperation.setInstance(sauve.getGestionnaireOperation());
                    vue1.setLab(sauve.getZoom());
                    vue2.setLab(sauve.getTranslation());
                    vue3.setLab(sauve.getOriginal());
                    System.out.println(sauve);
                    System.out.println(sauve.getPath());
                    ImageIcon image = new ImageIcon(sauve.getPath());
                    vue2.addImage(image);
                    vue1.addImage(image);
                    sauve.setPath(sauve.getPath());
                    vue3.addImage(image);
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
