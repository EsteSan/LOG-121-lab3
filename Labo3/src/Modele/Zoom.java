package Modele;

import javax.swing.*;
import java.awt.*;

public class Zoom implements Operation {
    boolean etat;
    private int  modification_x=0, modification_y=0;
    ImageLabel label_to_modify;

    public Zoom(ImageLabel label_to_modify) {
        this.label_to_modify = label_to_modify;
    }

    public void setModification_x(int modification_x) {
        this.modification_x = modification_x;
    }

    public void setModification_y(int modification_y) {
        this.modification_y = modification_y;
    }

    public void setLabel_to_modify(ImageLabel label_to_modify) {
        this.label_to_modify = label_to_modify;
    }

    //Zoomer
    public void execute(){
        label_to_modify.setSizeImage(label_to_modify.getWidthImage()+modification_x,label_to_modify.getHeightImage()+modification_y);
    }

    @Override
    public void undo() {
        label_to_modify.setSizeImage(label_to_modify.getWidthImage()-modification_x,label_to_modify.getHeightImage()-modification_y);
    }

    @Override
    public void redo() {
        execute();
    }
}
