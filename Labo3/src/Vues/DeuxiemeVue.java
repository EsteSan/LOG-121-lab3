package Vues;

import Controleur.ControlVueTranslation;
import Modele.ImageLabel;

import javax.swing.*;
import java.awt.*;

public class DeuxiemeVue extends JPanel{

    /**
     * CREATION DE LA DEUXIEME VUE POUR LA TRANSLATION
     */

    //ATTRIBUTS
    private static final int X=800;
    private static final int Y=90;
    private static final int LARGEUR = 400;
    private static final int HAUTEUR = 300;
    private static final Color COLOR= Color.WHITE;
    public ImageLabel lab=new ImageLabel();

    //CONSTRUCTEUR
    public DeuxiemeVue() {
        setLayout(null);
        Insets insets = getInsets();
        setBounds(X,Y,LARGEUR,HAUTEUR);
        setBackground(COLOR);
        setVisible(true);
        setBorder(BorderFactory.createTitledBorder("VUE_TRANSLATION"));
        ControlVueTranslation controlVueTranslation=new ControlVueTranslation(this);
        addMouseListener(controlVueTranslation);
        addMouseMotionListener(controlVueTranslation);
        lab.setBounds(50+insets.left,23+insets.right,300,300);
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
