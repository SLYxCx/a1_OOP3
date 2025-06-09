package shapes;

public class Cone extends Shape
{
    private double height;
    private double radius;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calcVolume() {
        return (Math.PI * Math.pow(radius, 2) * height) / 3.0;
    }

    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}
