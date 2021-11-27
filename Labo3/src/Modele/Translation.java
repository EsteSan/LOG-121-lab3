package Modele;

import Controleur.ControlVueTranslation;
import EnvironnementGraphique.FenetrePrincipale;
import Vues.DeuxiemeVue;
import Vues.PremiereVue;

public class Translation implements Operation{
    boolean etat =false;
    public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	int posX;
    int posY;
    ControlVueTranslation control;
    
    //Translater
   public void execute(DeuxiemeVue vue){

	  vue.lab.setLocation(posX, posY);
	   System.out.print("clicl");

    }

	@Override
	public void execute() {

	}

	@Override
    public void undo() {

    }


}
