package application;


import java.awt.image.BufferedImage;

public class Kosc {

    private BufferedImage image;
    private boolean isSelected;
    private int value;

    public Kosc() {
        this.isSelected = false;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
