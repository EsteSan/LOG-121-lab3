package Vues;

import Controleur.ControlVueTranslation;
import Modele.ImageLabel;

import javax.swing.*;
import java.awt.*;

public class DeuxiemeVue extends JPanel{

    /**
     * Cr�ation de la premi�re vue
     */
    //attributs
    private static final int X=800;
    private static final int Y=90;
    private static final int LARGEUR = 400;
    private static final int HAUTEUR = 300;
    private static final Color COLOR= Color.WHITE;

    public int px;
    public int py;
    public ImageLabel lab=new ImageLabel();
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

    public ImageLabel getLab() {
        return lab;
    }

    public void setLab(ImageLabel lab_p) {
        remove(lab);
        this.lab = lab_p;
        add(lab);
        repaint();
    }

    public void addImage(ImageIcon image) {
        lab.setImage(image);
    }
}
