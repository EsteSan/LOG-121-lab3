package Vues;



import Controleur.ControlVueZoom;
import Modele.Image2;
import Modele.ImageLabel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.*;
public class PremiereVue extends JPanel implements java.io.Serializable{

    /**
     * Cr�ation de la premi�re vue
     */
    //attributs
    private static final int X = 200;
    private static final int Y = 90;
    private static final int LARGEUR = 400;
    private static final int HAUTEUR = 300;
    private static final Dimension DIMENSION = new Dimension(400,300);
    private static final Color COLOR = Color.WHITE;
    

    public int px;
    public int py;
    public ImageLabel lab=new ImageLabel();


    public PremiereVue(){
        setBounds(X,Y,LARGEUR,HAUTEUR);
        setBackground(COLOR);
        setVisible(true);
        setBorder(BorderFactory.createTitledBorder("VUE_ZOOM"));
        addMouseMotionListener(new ControlVueZoom(this));
        add(lab);
    }
    public void addImage(Image2 image) {
        Image img=image.getImage();
        lab.setImage(img);
    }
    
    public void setPositionLab(float x, float y){
        lab.setAlignmentX(x);
        lab.setAlignmentY(y);
    }
}