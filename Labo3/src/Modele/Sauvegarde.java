package Modele;

import Controleur.GestionnaireOperation;

import javax.swing.*;

public class Sauvegarde implements java.io.Serializable {
    private String path;
    ImageLabel zoom, translation, original;
    GestionnaireOperation gestionnaireOperation;

    public Sauvegarde() {
    }

    public GestionnaireOperation getGestionnaireOperation() {
        return gestionnaireOperation;
    }

    public void setGestionnaireOperation(GestionnaireOperation gestionnaireOperation) {
        this.gestionnaireOperation = gestionnaireOperation;
    }

    //ACCESSEURS ET MUTATEURS
    public ImageLabel getZoom() {
        return zoom;
    }

    public void setZoom(ImageLabel zoom) {
        this.zoom = zoom;
    }

    public ImageLabel getTranslation() {
        return translation;
    }

    public void setTranslation(ImageLabel translation) {
        this.translation = translation;
    }

    public ImageLabel getOriginal() {
        return original;
    }

    public void setOriginal(ImageLabel original) {
        this.original = original;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

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
