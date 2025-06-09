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
        if (compareByVolume) {
            // Compare by volume
            if (p1.calcVolume() < p2.calcVolume()) {
                return -1;
            } else if (p1.calcVolume() > p2.calcVolume()) {
                return 1;
            } else {
                return 0;
            }
        } else {
            // Compare by base area
            if (p1.calcBaseArea() < p2.calcBaseArea()) {
                return -1;
            } else if (p1.calcBaseArea() > p2.calcBaseArea()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
