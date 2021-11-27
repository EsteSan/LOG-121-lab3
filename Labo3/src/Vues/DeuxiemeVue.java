package Vues;

import Controleur.ControlVueTranslation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DeuxiemeVue extends JPanel implements java.io.Serializable{

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
    public JLabel lab;
    public DeuxiemeVue() {
        setBounds(X,Y,LARGEUR,HAUTEUR);
        setBackground(COLOR);
        setVisible(true);
        setBorder(BorderFactory.createTitledBorder("VUE_TRANSLATION"));
        addMouseMotionListener(new ControlVueTranslation(this));
    }


    public void addImage(ImageIcon image) {
        lab = new JLabel();
        add(lab);
        lab.setSize(300,300);
        Image img=image.getImage();
        Image imgScale=img.getScaledInstance(lab.getWidth(),lab.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon =new ImageIcon(imgScale);
        lab.setIcon(scaledIcon);
    }
}
