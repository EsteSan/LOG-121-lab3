package Vues;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DeuxiemeVue extends JPanel implements java.io.Serializable{

    /**
     * Création de la première vue
     */
    //attributs
    private static final int X=800;
    private static final int Y=90;
    private static final int LARGEUR = 400;
    private static final int HAUTEUR = 300;
    private static final Color COLOR= Color.WHITE;


    public DeuxiemeVue() {
        setBounds(X,Y,LARGEUR,HAUTEUR);
        setBackground(COLOR);
        setVisible(true);
        setBorder(BorderFactory.createTitledBorder("VUE_TRANSLATION"));
    }

    public void addImage(ImageIcon image) {
        JLabel lab = new JLabel();
        add(lab);
        lab.setSize(300,300);
        Image img=image.getImage();
        Image imgScale=img.getScaledInstance(lab.getWidth(),lab.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon =new ImageIcon(imgScale);
        lab.setIcon(scaledIcon);
    }
}
