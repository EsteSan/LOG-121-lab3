package Vues;

import javax.swing.*;

import Controleur.ControlVueTranslation;
import Modele.Image2;
import Modele.ImageLabel;

import java.awt.*;

public class TroisiemeVue extends JPanel implements java.io.Serializable{

    /**
     * Cr�ation de la premi�re vue
     */
    //attributs
    private static final int X = 500;
    private static final int Y = 450;
    private static final int LARGEUR = 400;
    private static final int HAUTEUR = 300;
    private static final Color COLOR = Color.WHITE;
    public ImageLabel lab=new ImageLabel();
    

    public TroisiemeVue(){
        setBounds(X,Y,LARGEUR,HAUTEUR);
        setBackground(COLOR);
        setVisible(true);
        setBorder(BorderFactory.createTitledBorder("VUE_STATIQUE"));
        add(lab);
    }
    public void addImage(ImageIcon image) {
        lab.setImage(image);
    }
}

