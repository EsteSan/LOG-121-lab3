package Vues;



import Controleur.ControlVueZoom;
import Modele.ImageLabel;
import Modele.Sauvegarde;

import java.awt.*;

import javax.swing.JPanel;


import javax.swing.*;
public class PremiereVue extends JPanel{

    /**
     * CREATION DE LA PREMIERE VUE POUR LE ZOOM
     */

    //ATTRIBUTS
    private static final int X = 200;
    private static final int Y = 90;
    private static final int LARGEUR = 400;
    private static final int HAUTEUR = 300;
    private static final Color COLOR = Color.WHITE;
    public ImageLabel lab=new ImageLabel();

    //CONSTRUCTEUR
    public PremiereVue(){
        setBounds(X,Y,LARGEUR,HAUTEUR);
        setBackground(COLOR);
        setVisible(true);
        setBorder(BorderFactory.createTitledBorder("VUE_ZOOM"));
        ControlVueZoom controlVueZoom=new ControlVueZoom(this);
        addMouseListener(controlVueZoom);
        addMouseMotionListener(controlVueZoom);
        add(lab);
    }

    /**
     * Ajoute une image a un JLabel
     * @param image, de type ImageIcon
     */
    public void addImage(ImageIcon image) {
        lab.setImage(image);
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
}