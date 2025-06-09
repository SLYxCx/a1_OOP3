package shapes;

public class Cylinder extends Shape
{

    private double radius;
    private double height;  

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double calcVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}
