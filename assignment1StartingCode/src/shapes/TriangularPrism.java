package shapes;

public class TriangularPrism extends Prism
{


    public TriangularPrism(double base, double height) {
        this.side = base;
        this.height = height;
    }

    @Override
    public double calcVolume() {
        return (0.5 * side * height) * height;
    }

    @Override
    public double calcBaseArea() {
        return 0.5 * side * height;
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
