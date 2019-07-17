package assigment2.classes.beans;

public class Food {
    private String name;
    private double price;
    private int time;

    @Override
    public String toString() {
        return "This food's name: " + getName() +
                " - This food's price: " + getPrice() +
                " - This food's prepare time: " + getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
