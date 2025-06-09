package shapes;

public class OctagonalPrism extends Prism
{

    public OctagonalPrism(double side, double height) {
        this.side = side;
        this.height = height;
    }

    @Override
    public double calcVolume() {
        return (2 * (1 + Math.sqrt(2)) * Math.pow(side, 2)) * height;
    }

    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
    }

}
