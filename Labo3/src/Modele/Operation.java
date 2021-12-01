package Modele;

import java.io.Serializable;
/**
 * Une interface qui repr�sente les op�rations sur une image
 * 
 * Contient des methodes non d�finis ;execute,undo,redo
 * 
 */
public interface Operation extends Serializable {
    public void execute();
    public void undo();
    public void redo();

}
