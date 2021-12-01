package Vues;

import javax.swing.*;

import Modele.ImageLabel;

import java.awt.*;

public class TroisiemeVue extends JPanel{

    /**
     * CREATION DE LA TROISIEME VUE STATIQUE
     */
    //attributs
    private static final int X = 500;
    private static final int Y = 450;
    private static final int LARGEUR = 400;
    private static final int HAUTEUR = 300;
    private static final Color COLOR = Color.WHITE;
    public ImageLabel lab=new ImageLabel();
    
    //CONSTRUCTEUR
    public TroisiemeVue(){
        setBounds(X,Y,LARGEUR,HAUTEUR);
        setBackground(COLOR);
        setVisible(true);
        setBorder(BorderFactory.createTitledBorder("VUE_STATIQUE"));
        add(lab);
    }

    /**
     * Permet de redéfinir un component du panneau de type JLabel
     * @param lab_p, de type ImageLabel
     */
    public void setLab(ImageLabel lab_p) {
        remove(lab);
        this.lab = lab_p;
        add(lab);
        repaint();
    }

    /**
     * Ajoute une image a un JLabel
     * @param image, de type ImageIcon
     */
    public void addImage(ImageIcon image) {
        lab.setImage(image);
    }
}

