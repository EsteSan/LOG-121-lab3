package Vues;

import javax.swing.*;
import java.awt.*;

public class TroisiemeVue extends JPanel{

    /**
     * Création de la première vue
     */
    //attributs
    private static final int X = 500;
    private static final int Y = 450;
    private static final int LARGEUR = 400;
    private static final int HAUTEUR = 300;
    private static final Color COLOR = Color.WHITE;

    public TroisiemeVue(){
        setBounds(X,Y,LARGEUR,HAUTEUR);
        setBackground(COLOR);
        setVisible(true);
    }
}

