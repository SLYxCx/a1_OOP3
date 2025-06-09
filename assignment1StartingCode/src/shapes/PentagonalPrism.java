package shapes;

public class PentagonalPrism extends Prism
{


    public PentagonalPrism(double side, double height) {
        this.side = side;
        this.height = height;
    }

    @Override
    public double calcVolume() {
        return (5 * Math.pow(side, 2) * Math.sqrt(5 + 2 * Math.sqrt(5)) / 4) * height;
    }

    @Override
    public double calcBaseArea() {
        return (5 * Math.pow(side, 2) * Math.sqrt(5 + 2 * Math.sqrt(5))) / 4;
    }

}
