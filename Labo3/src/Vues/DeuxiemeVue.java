package Vues;

import javax.swing.*;
import java.awt.*;

public class DeuxiemeVue extends JPanel{

    /**
     * Création de la première vue
     */
    //attributs
    private static final int X=800;
    private static final int Y=90;
    private static final int LARGEUR = 400;
    private static final int HAUTEUR = 300;
    private static final Color COLOR= Color.WHITE;

    public DeuxiemeVue(){
        setBounds(X,Y,LARGEUR,HAUTEUR);
        setBackground(COLOR);
        setVisible(true);
        setBorder(BorderFactory.createTitledBorder("VUE_TRANSLATION"));
    }
}
