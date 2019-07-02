package app;

public class Shape {
    private String color;

    public void changeColor(String color) {
        this.color = color;
    }

    public String showColor() {
        return this.color;
    }

    public int drawArea() {
        return 0;
    }
}
