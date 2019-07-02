package app;

public class Pen {

    public double draw(Shape shape) {
        return shape.drawArea();
    }

    public void setColor(String color, Shape shape) {
        shape.changeColor(color);
    }

    public static void main(String[] args) {
        Pen pen = new Pen();
        Rectangle rectangle = new Rectangle(25, 30);
        pen.draw(rectangle);
        pen.setColor("red", rectangle);
    }
}