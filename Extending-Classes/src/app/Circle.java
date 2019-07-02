package app;

public class Circle extends Shape {
    private int radius;

    public int drawArea() {
        return (int) (Math.PI * Math.pow(this.radius, 2));
    }
}