// Abstract class Shape
abstract class Shape {
    protected int side1;
    protected int side2;

    // Constructor
    public Shape(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    // Abstract method to be implemented by subclasses
    public abstract void printArea();
}

// Rectangle class
class Rectangle extends Shape {
    // Constructor
    public Rectangle(int length, int width) {
        super(length, width);
    }

    // Implementation of printArea for Rectangle
    public void printArea() {
        int area = side1 * side2;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Triangle class
class Triangle extends Shape {
    // Constructor
    public Triangle(int base, int height) {
        super(base, height);
    }

    // Implementation of printArea for Triangle
    public void printArea() {
        double area = 0.5 * side1 * side2;
        System.out.println("Area of Triangle: " + area);
    }
}

// Circle class
class Circle extends Shape {
    // Constructor
    public Circle(int radius) {
        super(radius, 0); // Side2 is not used for circles
    }

    // Implementation of printArea for Circle
    public void printArea() {
        double area = Math.PI * side1 * side1;
        System.out.println("Area of Circle: " + area);
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        // Create instances of Rectangle, Triangle, and Circle
        Rectangle rectangle = new Rectangle(5, 8);
        Triangle triangle = new Triangle(4, 6);
        Circle circle = new Circle(3);

        // Call printArea for each shape
        rectangle.printArea();
        triangle.printArea();
        circle.printArea();
    }
}
