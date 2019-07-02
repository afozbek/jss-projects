package app;

public class Circle extends Shape {
    private int radius;

    @Override
    public int drawArea() {
        return (int) (Math.PI * Math.pow(this.radius, 2));
    }
}