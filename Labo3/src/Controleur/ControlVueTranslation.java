package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Vues.DeuxiemeVue;

public class ControlVueTranslation  implements MouseMotionListener, MouseListener {
	
	
	DeuxiemeVue vue;
	private int px;
	private int py;
	private int pressed_x,pressed_y,memento_x,memento_y;
	private GestionnaireOperation gestionnaireOperation;

	public ControlVueTranslation(DeuxiemeVue p_vue) {
		
		vue =p_vue;
	}

public void changerPosition() {
		if(vue!=null && vue.lab!=null){
			gestionnaireOperation=GestionnaireOperation.getInstance();
			gestionnaireOperation.translate(vue.lab,px-pressed_x,py-pressed_y);
			pressed_y=py;
			pressed_x=px;
		}
}

	@Override
	public void mouseDragged(MouseEvent e) {
		//creer une nouvelle instance de Zoom  pour envoyer au controleur
		px = e.getX();
		py = e.getY();
		changerPosition();
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
		gestionnaireOperation=GestionnaireOperation.getInstance();
		pressed_x=e.getX();
		pressed_y=e.getY();
		gestionnaireOperation.addTranslation(vue.lab,pressed_x-memento_x,pressed_y-memento_y);
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}