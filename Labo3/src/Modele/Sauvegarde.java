package Modele;

import Controleur.GestionnaireOperation;

import javax.swing.*;

/**
 * Cette classe est une reprentation de la sauvergade des donnees du programme
 * 
 */
public class Sauvegarde implements java.io.Serializable {
    private String path;
    ImageLabel zoom, translation, original;
    GestionnaireOperation gestionnaireOperation;

    /**
     * constructeur par defaut 
     */
    public Sauvegarde() {
    }
    /**
  	 * Accesseur sur le gestionnaire d'operation
  	 * @return le gestionnaire d'operation
  	 */
    public GestionnaireOperation getGestionnaireOperation() {
        return gestionnaireOperation;
    }
    /**
  	 * Mutateur sur le gestionnaire d'operation
  	 * @param gestionnaireOperation le nouveau gestionnaire d'operation
  	 */
    public void setGestionnaireOperation(GestionnaireOperation gestionnaireOperation) {
        this.gestionnaireOperation = gestionnaireOperation;
    }

    //ACCESSEURS ET MUTATEURS
    /**
  	 * Accesseur sur le zoom de l'imageLabel
  	 * @return l'imageLabel qui est zoome
  	 */
    public ImageLabel getZoom() {
        return zoom;
    }
    
    /**
  	 * Mutateur sur le zoom de l'imageLabel
  	 * @param zoom le nouveau imageLabel qui est zoome
  	 */
    public void setZoom(ImageLabel zoom) {
        this.zoom = zoom;
    }
    
    /**
  	 * Accesseur sur la translation de l'imageLabel
  	 * @return l'imageLabel qui est translate
  	 */
    public ImageLabel getTranslation() {
        return translation;
    }
    
    /**
  	 * Mutateur sur la translation de l'imageLabel 
  	 * @param translation le nouveau imageLabel qui a ete translate
  	 */
    public void setTranslation(ImageLabel translation) {
        this.translation = translation;
    }

    /**
  	 * Accesseur sur l'image original qui n'a pas ete zoome et ni translater
  	 * @return l'image original
  	 */
    public ImageLabel getOriginal() {
        return original;
    }
    /**
  	 * Mutateur sur l'image original
  	 * @param original la nouvelle image original
  	 */
    public void setOriginal(ImageLabel original) {
        this.original = original;
    }
    /**
  	 * Accesseur sur le lien de l'image
  	 * @return le lien de l'image
  	 */
    public String getPath() {
        return this.path;
    }
    /**
  	 * Mutateur sur le lien de l'image
  	 * @param path lien qui fera reference a une nouvelle image
  	 */
    public void setPath(String path) {
        this.path = path;
    }

    /**
  	 * Methode qui returne une representation d'une sauvegarde
  	 
  	 */
    @Override
    public String toString() {
        return "Sauvegarde{" +
                "path='" + path + '\'' +
                ", zoom=" + zoom +
                ", translation=" + translation +
                ", original=" + original +
                ", gestionnaireOperation=" + gestionnaireOperation +
                '}';
    }
}
