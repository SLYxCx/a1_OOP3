package shapes;

public class Pyramid extends Shape
{
    private double side;

    public Pyramid(double side, double height) {
        this.side = side;
        this.height = height;
    }

    @Override
    public double calcVolume() {
        return (Math.pow(side, 2) * height) / 3.0;
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2);
    }

}
