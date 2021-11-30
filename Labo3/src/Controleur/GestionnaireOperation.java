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
    private GestionnaireOperation(){
        operations=new LinkedList<>();

    }
    public static GestionnaireOperation getInstance(){
        if(instance==null){
            instance= new GestionnaireOperation();
        }
        return instance;
    }
    public static void setInstance(GestionnaireOperation gestionnaireOperation){
        instance= gestionnaireOperation;
    }

    public static void reset() {
        instance=new GestionnaireOperation();
    }

    public void zoom(ImageLabel imageLabel,int size_x,int size_y){
        Zoom zoom=new Zoom(imageLabel);
        zoom.setModification_x(size_x);
        zoom.setModification_y(size_y);
        zoom.execute();
    }
    public void translate(ImageLabel imageLabel,int x,int y){
        Translation translation=new Translation(imageLabel);
        translation.setPosX(x);
        translation.setPosY(y);
        translation.execute();
    }
    public void addZoom(ImageLabel imageLabel,int size_x,int size_y){
        Zoom zoom=new Zoom(imageLabel);
        zoom.setModification_x(size_x);
        zoom.setModification_y(size_y);
        addOperation(zoom);
    }
    public void addTranslation(ImageLabel imageLabel,int x,int y){
        Translation translation=new Translation(imageLabel);
        translation.setPosX(x);
        translation.setPosY(y);
        addOperation(translation);
    }
    public void undo(){
        if(current>=0){
            it=operations.listIterator(current);
            it.next().undo();
            it.previous();
            current=it.previousIndex();
            System.out.println(current);
            System.out.println(operations);
        }
    }
    public void redo(){
        if(current<size-1){
            if(current<0){
                it=operations.listIterator(0);
            }else {
                it=operations.listIterator(current+1);
            }
            it.next().execute();
            current++;
        }
    }

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
        System.out.println(operations);
    }

    @Override
    public String toString() {
        return "GestionnaireOperation{" +
                "operations=" + operations +
                '}';
    }
}
