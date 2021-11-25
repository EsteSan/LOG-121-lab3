package Modele;

public class Perspective extends Image {

    public Perspective(String pathImage,int posX,int posY) {
        super(pathImage);
        this.posX=posX;
        this.posY=posY;
    }
    private int posX;
    private int posY;
    private int mulitplicateurZoom;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getMulitplicateurZoom() {
        return mulitplicateurZoom;
    }

    public void setMulitplicateurZoom(int mulitplicateurZoom) {
        this.mulitplicateurZoom = mulitplicateurZoom;
    }
}
