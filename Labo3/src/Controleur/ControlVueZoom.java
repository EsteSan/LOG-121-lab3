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
    private int px;
    private int py;
    private int pressed_x;
    private int pressed_y;
    private int memento_x, memento_y,size_mod_x,size_mod_y;
    GestionnaireOperation gestionnaireOperation;

    public ControlVueZoom(PremiereVue p_vue) {
        vue =p_vue;
        gestionnaireOperation=GestionnaireOperation.getInstance();
    }

    public void changerZoom() {
        if(vue!=null && vue.lab!=null){
            size_mod_x=px-pressed_x;
            size_mod_y=py-pressed_y;
            gestionnaireOperation.zoom(vue.lab,size_mod_x,size_mod_y);
            pressed_y=py;
            pressed_x=px;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //creer une nouvelle instance de Zoom  pour envoyer au controleur
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
        memento_x=pressed_x;
        memento_y=pressed_y;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed_x=e.getX();
        pressed_y=e.getY();
        gestionnaireOperation.addZoom(vue.lab,pressed_x-memento_x,pressed_y-memento_y);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}