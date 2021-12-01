package Modele;

import Controleur.ControlVueTranslation;

/**
 * Cette classe qui implemente l'interface operation represente  la methode translation avec des etats
 * 
 */
public class Translation implements Operation{
    boolean etat =false;
	ImageLabel label;
	
	/**
     * constructeur qui initialise une translation 
     * @param imageLabel l'image qui va subir la translation
     */
	public Translation(ImageLabel imageLabel) {
		label=imageLabel;
	}
	
	/**
     * Accesseur sur la position finale en x de la translation
     * @return la position en x 
     */
	public int getPosX() {
		return posX;
	}

	/**
     * Mutateur sur la position finale en x de la translation
     * @param posX la nouvelle position de la translation
     */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
     * Accesseur sur la position finale en y de la translation
     * @return la position en y
     */
	public int getPosY() {
		return posY;
	}

	/**
     * Mutateur sur la position finale en y de la translation
     * @param posY la nouvelle position de la translation
     */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	int posX;
    int posY;
 


    /**
     * Methode qui execute la methode de translation
     */
	@Override
	public void execute() {
		label.setLocation(label.getX()+posX, label.getY()+posY);
	}
	/**
     * Methode qui retourne � l'etat precedent apres une translation
     */
	@Override
    public void undo() {

		label.setLocation(label.getX()-posX, label.getY()-posY);
    }
	/**
     * Methode qui retourne � l'etat precedent apres avoir effectuer la methode undo
     */
	@Override
	public void redo() {
execute();
	}


}
