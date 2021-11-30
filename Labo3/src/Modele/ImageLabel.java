package Modele;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class ImageLabel extends JLabel implements Serializable {

    transient Image image;
    int width=300;
    int height=300;

    int xOriginale=0;
    int yOriginale=0;
    public ImageLabel() {
    }

    public ImageLabel(Image image_p){
        this.image=image_p;
        setSize(width,height);
        Image imgScale=image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon =new ImageIcon(imgScale);
        setIcon(scaledIcon);
        repaint();
    }

    public Image getImage() {
        return  image;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidthImage() {
        return width;
    }

    public int getHeightImage() {
        return height;
    }

    public void setImage(Image image_p) {
        yOriginale=getY();
        xOriginale=getX();
        System.out.println(image_p);
        this.image=image_p;
        Image imgScale=image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon =new ImageIcon(imgScale);
        setIcon(scaledIcon);
        repaint();
    }
    public void setSizeImage(int width_p,int height_p){
        width=width_p;
        height=height_p;
        Image imgScale=image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon =new ImageIcon(imgScale);
        setIcon(scaledIcon);
        repaint();
    }

    public void setImage(ImageIcon imageIcon) {
        Image image=imageIcon.getImage();
        setImage(image);
    }

    public void reset() {
        width=300;
        height=300;
        System.out.println(xOriginale+","+yOriginale);
        setAlignmentX(xOriginale);
        setAlignmentY(yOriginale);
        setBounds(50,23,300,300);
    }
}
