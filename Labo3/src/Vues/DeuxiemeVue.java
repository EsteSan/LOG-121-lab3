package Vues;

import Controleur.ControlVueTranslation;
import Modele.Image2;
import Modele.ImageLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        lab.setBounds(50+insets.left,30+insets.right,300,300);
        add(lab);
    }


    public void addImage(ImageIcon image) {
        lab.setImage(image);
    }
}
