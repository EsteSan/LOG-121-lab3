package Vues;

import javax.swing.*;
import java.awt.*;

public class PremiereVue extends JPanel{

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
    }
}
