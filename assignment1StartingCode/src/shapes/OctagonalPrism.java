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

    @Override
    public int compareTo(Prism other) {
        if (this.height < other.height) {
            return -1;
        } else if (this.height > other.height) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int compare(Prism p1, Prism p2) {
        if (p1.calcVolume() < p2.calcVolume()) {
            return -1;
        } else if (p1.calcVolume() > p2.calcVolume()) {
            return 1;
        } else {
            return 0;
        }
    }

}
