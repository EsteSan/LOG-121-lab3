package Controleur;

import Modele.ImageLabel;
import Modele.Operation;
import Modele.Translation;
import Modele.Zoom;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GestionnaireOperation implements Serializable {
    private LinkedList<Operation> operations;

    private static GestionnaireOperation instance;
    private int size=0;
    private int current=0;
    transient ListIterator<Operation> it;

    /**
     * Constructeur privé pour s'assurer que ça reste un singleton
     *
     **/
    private GestionnaireOperation(){
        operations=new LinkedList<>();

    }

    /**
     * Fonction pour récupérer l'instance unique du gestionnaire opération
     *
     * @return l'instance unique du gestionnaire d'opération
     **/
    public static GestionnaireOperation getInstance(){
        if(instance==null){
            instance= new GestionnaireOperation();
        }
        return instance;
    }

    /**
     * Fonction pour changer l'instance unique du gestionnaire opération, par exemple
     * en cas de chargement d'un état qu'on a sauvegardé.
     *
     **/
    public static void setInstance(GestionnaireOperation gestionnaireOperation){
        instance= gestionnaireOperation;
    }

    /**
     * Fonction pour recréer une nouvelle instance, par exemple pour que lorsqu'on importe un nouvelle image les
     * opérations de l'image précédente ne soit pas enregistrer.
     *
     **/
    public static void reset() {
        instance=new GestionnaireOperation();
    }

    /**
     * Fonction qui permet d'effectuer l'opération de zoom nécessaire sur l'image selon les axes x et y
     *
     * @param imageLabel L'image qu'il faut modifier
     * @param size_x La taille du changement par rapport aux x
     * @param size_y La taille du changement par rapport aux x
     **/
    public void zoom(ImageLabel imageLabel,int size_x,int size_y){
        Zoom zoom=new Zoom(imageLabel);
        zoom.setModification_x(size_x);
        zoom.setModification_y(size_y);
        zoom.execute();
    }

    /**
     * Fonction qui permet d'effectuer l'opération de translation nécessaire sur l'image selon les axes x et y
     *
     * @param imageLabel L'image qu'il faut modifier
     * @param x La taille du changement par rapport aux x
     * @param y La taille du changement par rapport aux x
     **/
    public void translate(ImageLabel imageLabel,int x,int y){
        Translation translation=new Translation(imageLabel);
        translation.setPosX(x);
        translation.setPosY(y);
        translation.execute();
    }

    /**
     * Permet d'ajouter le zoom (sans l'exécuter) à la liste du gestionnaire. C'est cette opération qu"il va défaire
     *
     * @param imageLabel image sur laquelle l'opération a été effectuée
     * @param size_x taille totale des changements en x
     * @param size_y taille totale des changements en y
     **/
    public void addZoom(ImageLabel imageLabel,int size_x,int size_y){
        Zoom zoom=new Zoom(imageLabel);
        zoom.setModification_x(size_x);
        zoom.setModification_y(size_y);
        addOperation(zoom);
    }

    /**
     * Permet d'ajouter la translation(sans l'exécuter) à la liste du gestionnaire. C'est cette opération qu"il va défaire
     *
     * @param imageLabel image sur laquelle l'opération a été effectuée
     * @param x taille totale des changements en x
     * @param y taille totale des changements en y
     **/
    public void addTranslation(ImageLabel imageLabel,int x,int y){
        Translation translation=new Translation(imageLabel);
        translation.setPosX(x);
        translation.setPosY(y);
        addOperation(translation);
    }

    /**
     * Permet de défaire la dernière opération effectuée
     **/
    public void undo(){
        if(current>=0){
            it=operations.listIterator(current);
            it.next().undo();
            it.previous();
            current=it.previousIndex();
        }
    }

    /**
     * Permet de refaire la dernière opération annulée
     **/
    public void redo(){
        if(current<size-1){
            if(current<0){
                it=operations.listIterator(0);
            }else {
                it=operations.listIterator(current+1);
            }
            it.next().redo();
            current++;
        }
    }

    /**
     * Permet d'ajouter les opérations la liste (code commun pour zoom et translation)
     **/
    private void addOperation(Operation op){
        if(current<size-1){
            if(current<0){
                it=operations.listIterator(0);
            }else {
                it=operations.listIterator(current+1);
            }
            while (it.hasNext()){
                it.next();
                it.remove();
                size--;
            };
        }
        operations.add(op);
        current=size++;
        it=operations.listIterator(current);
    }

    /**
     * Pour l'affichage on veut juste afficher la liste d'opération
     *
     * @return l'affichage voulu
     **/
    @Override
    public String toString() {
        return "GestionnaireOperation{" +
                "operations=" + operations +
                '}';
    }
}
