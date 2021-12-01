package Modele;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Cette classe est une reprentation d'un label qui contient une image
 * 
 */
public class ImageLabel extends JLabel implements Serializable {

    transient Image image;
    int width=300;
    int height=300;

    int xOriginale=0;
    int yOriginale=0;
    
    /**
     * constructeur par defaut 
     */
    public ImageLabel() {
    }

    /**
     * constructeur qui cree un label avec une image
     * @parama image_P image qui sera utilise dans le programme 
     */
    public ImageLabel(Image image_p){
        this.image=image_p;
        setSize(width,height);
        Image imgScale=image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon =new ImageIcon(imgScale);
        setIcon(scaledIcon);
        repaint();
    }
    /**
	 * Accesseur sur l'image
	 * @return l'image
	 */
    public Image getImage() {
        return  image;
    }

    /**
	 * Mutateur sur la largeur du label
	 * @param width la nouvelle largeur
	 */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
	 * Mutateur sur la hauteur du label
	 * @param height la nouvelle hauteur 
	 */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
	 * Accesseur sur la largeur du label avec l'image
	 * @return la largeur 
	 */
    public int getWidthImage() {
        return width;
    }

    /**
   	 * Accesseur sur la hauteur du label avec l'image
   	 * @return la hauteur 
   	 */
    public int getHeightImage() {
        return height;
    }

    /**
   	 * Mutateur sur l'image
   	 * @param image_p nouvelle image 
   	 */
    public void setImage(Image image_p) {
        yOriginale=getY();
        xOriginale=getX();
        this.image=image_p;
        Image imgScale=image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon =new ImageIcon(imgScale);
        setIcon(scaledIcon);
        repaint();
    }
    
    /**
   	 * Methode qui definie la grosseur de l'image
   	 * @param width_p la largeur qu'on veut attribuer � l'image
   	 * @param height_p la hateur qu'on veut attribuer � l'image
   	 */
    public void setSizeImage(int width_p,int height_p){
        width=width_p;
        height=height_p;
        Image imgScale=image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon =new ImageIcon(imgScale);
        setIcon(scaledIcon);
        repaint();
    }
    /**
   	 * Mutateur sur l'image
   	 * @param imageIcon ....
   	 */
    public void setImage(ImageIcon imageIcon) {
        Image image=imageIcon.getImage();
        setImage(image);
    }
    /**
   	 * Methide qui r�instiallisera un label dans une vue
   	 */
    public void reset() {
        width=300;
        height=300;
        setAlignmentX(xOriginale);
        setAlignmentY(yOriginale);
        setBounds(50,23,300,300);
    }
}
