package Modele;

import javax.swing.ImageIcon;

public class Image2 extends ImageIcon {

    String pathImage;

    public Image2(String pathImage){
    	super(pathImage);
        this.pathImage=pathImage;
  
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
}
