package shapes;

public class SquarePrism extends Prism
{

    public SquarePrism(double side, double height) {
        this.side = side;
        this.height = height;
    }

    @Override
    public double calcVolume() {
        return Math.pow(side, 2) * height;
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2);
    }

}
