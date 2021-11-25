package Vues;

import javax.swing.*;
import java.awt.*;

public class PremiereVue extends JPanel implements java.io.Serializable{

    /**
     * Création de la première vue
     */
    //attributs
    private static final int X = 200;
    private static final int Y = 90;
    private static final int LARGEUR = 400;
    private static final int HAUTEUR = 300;
    private static final Dimension DIMENSION = new Dimension(400,300);
    private static final Color COLOR = Color.WHITE;

    public PremiereVue(){
        setBounds(X,Y,LARGEUR,HAUTEUR);
        setBackground(COLOR);
        setVisible(true);
        setBorder(BorderFactory.createTitledBorder("VUE_ZOOM"));
    }
    public void addImage(ImageIcon image) {
        JLabel lab = new JLabel();
        lab.setSize(300,300);
        Image img=image.getImage();
        Image imgScale=img.getScaledInstance(lab.getWidth(),lab.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon =new ImageIcon(imgScale);
        lab.setIcon(scaledIcon);
        add(lab);
    }
}
