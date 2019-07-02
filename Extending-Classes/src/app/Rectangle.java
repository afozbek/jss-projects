package app;

public class Rectangle extends Shape {
	private int height;
	private int width;

	public Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int drawArea() {
		return this.height * this.width;
	}
}