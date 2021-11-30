package Vues;



import Controleur.ControlVueZoom;
import Modele.Image2;
import Modele.ImageLabel;
import Modele.Sauvegarde;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.*;
public class PremiereVue extends JPanel{

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
    private Sauvegarde sauv= new Sauvegarde();
    

    public int px;
    public int py;
    public ImageLabel lab=new ImageLabel();


    public PremiereVue(){
        setBounds(X,Y,LARGEUR,HAUTEUR);
        setBackground(COLOR);
        setVisible(true);
        setBorder(BorderFactory.createTitledBorder("VUE_ZOOM"));
        ControlVueZoom controlVueZoom=new ControlVueZoom(this);
        addMouseListener(controlVueZoom);
        addMouseMotionListener(controlVueZoom);
        add(lab);
    }
    public void addImage(ImageIcon image) {
        lab.setImage(image);
    }
    
    public void setPositionLab(float x, float y){
        lab.setAlignmentX(x);
        lab.setAlignmentY(y);
    }
    public Sauvegarde getSauv(){
        return this.sauv;
    }
    public void setContenu(String path){
        removeAll();
        add(lab);
        ImageIcon im = new ImageIcon(path);
        addImage(im);
    }
}