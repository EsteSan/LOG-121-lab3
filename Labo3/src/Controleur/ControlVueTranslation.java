package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

import EnvironnementGraphique.Menu;
import Modele.Translation;
import Vues.DeuxiemeVue;
import Vues.PremiereVue;

public class ControlVueTranslation  implements MouseMotionListener {
	
	
	DeuxiemeVue vue;
	Translation translation= new Translation();
	private int px;
	private int py;

	public ControlVueTranslation(DeuxiemeVue p_vue) {
		
		vue =p_vue;
	}

public void changerPosition() {
		if(vue!=null && vue.lab!=null){
			translation.setPosX(px);
			translation.setPosY(py);
			translation.execute(vue);
			vue.lab.repaint();
			System.out.println("check");
		}
}

	@Override
	public void mouseDragged(MouseEvent e) {
		//creer une nouvelle instance de Zoom  pour envoyer au controleur
		System.out.println("Dragged");
		px = e.getX();
		py = e.getY();
		changerPosition();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}