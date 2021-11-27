package Controleur;

import Modele.Translation;
import Modele.Zoom;
import Vues.DeuxiemeVue;
import Vues.PremiereVue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ControlVueZoom implements MouseMotionListener, MouseListener {


    PremiereVue vue;
    Zoom zoom;
    private int px;
    private int py;
    private int pressed_x;
    private int pressed_y;

    public ControlVueZoom(PremiereVue p_vue) {
        vue =p_vue;
        zoom= new Zoom(vue.lab);
    }

    public void changerZoom() {
        if(vue!=null && vue.lab!=null){
            zoom.setLabel_to_modify(vue.lab);
            int size_mod_x=px-pressed_x;
            int size_mod_y=py-pressed_y;
            zoom.setModification_x(size_mod_x);
            zoom.setModification_y(size_mod_y);
            pressed_y=py;
            pressed_x=px;
            zoom.execute();
            System.out.println("check");
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //creer une nouvelle instance de Zoom  pour envoyer au controleur
        System.out.println("Dragged");
        px = e.getX();
        py = e.getY();
        changerZoom();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed_x=e.getX();
        pressed_y=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}