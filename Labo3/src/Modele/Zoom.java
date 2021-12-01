package Modele;

import javax.swing.*;
import java.awt.*;

/**
 * Cette classe qui implemente l'interface operation represente  la methode zoom avec des etats
 * 
 */
public class Zoom implements Operation {
    boolean etat;
    private int  modification_x=0, modification_y=0;
    ImageLabel label_to_modify;
    
    /**
     * constructeur qui initialise un zoom
     * @param label_to_modify l'image qui va subir le zoom
     */
    public Zoom(ImageLabel label_to_modify) {
        this.label_to_modify = label_to_modify;
    }
    
    /**
     * Mutateur sur le parametre en x du zoom
     * @param modification_x parametre qui sera additionner ou soustrait a la largeur de l'image
     */
    public void setModification_x(int modification_x) {
        this.modification_x = modification_x;
    }
    /**
     * Mutateur sur le parametre en y du zoom
     * @param modification_y parametre qui sera additionner ou soustrait a la hauteur de l'image
     */
    public void setModification_y(int modification_y) {
        this.modification_y = modification_y;
    }
    /**
     * Mutateur sur le label a modifier
     * @param label_to_modify le label qui sera modifier
     */
    public void setLabel_to_modify(ImageLabel label_to_modify) {
        this.label_to_modify = label_to_modify;
    }

    /**
     * Methode qui execute la methode de zoom
     */
    public void execute(){
        label_to_modify.setSizeImage(label_to_modify.getWidthImage()+modification_x,label_to_modify.getHeightImage()+modification_y);
    }

    /**
     * Methode qui retourne � l'etat precedent apres le zoom
     */
    @Override
    public void undo() {
        label_to_modify.setSizeImage(label_to_modify.getWidthImage()-modification_x,label_to_modify.getHeightImage()-modification_y);
    }

    /**
     * Methode qui retourne � l'etat precedent apres avoir effectuer la methode undo
     */
    @Override
    public void redo() {
        execute();
    }
}
