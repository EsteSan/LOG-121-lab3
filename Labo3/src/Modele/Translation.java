package Modele;

import Controleur.ControlVueTranslation;

public class Translation implements Operation{
    boolean etat =false;
	ImageLabel label;
	public Translation(ImageLabel imageLabel) {
		label=imageLabel;
	}

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


	@Override
	public void execute() {
		System.out.println(label.getX()+","+label.getY());
		label.setLocation(label.getX()+posX, label.getY()+posY);
	}

	@Override
    public void undo() {

    }

	@Override
	public void redo() {

	}


}
