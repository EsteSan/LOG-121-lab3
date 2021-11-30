package Modele;

import javax.swing.*;
import java.awt.*;

public class ImageLabel extends JLabel implements java.io.Serializable {

    Image image;

    int width=300;
    int height=300;

    public ImageLabel() {
    }

    public ImageLabel(Image image_p){
        this.image=image_p;
        setSize(300,300);
        Image imgScale=image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon =new ImageIcon(imgScale);
        setIcon(scaledIcon);
        repaint();
    }

    public Image getImage() {
        return  image;
    }

    public int getWidthImage() {
        return width;
    }

    public int getHeightImage() {
        return height;
    }

    public void setImage(Image image_p) {
        width=300;
        height=300;
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
}
