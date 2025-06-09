package shapes;

public class TriangularPrism extends Prism
{
    
    private double base;
    private double prismHeight;

    public TriangularPrism(double base, double height, double prismHeight) {
        this.base = base;
        this.height = height;
        this.prismHeight = prismHeight;
    }

    @Override
    public double calcVolume() {
        return (0.5 * base * height) * prismHeight;
    }

    @Override
    public double calcBaseArea() {
        return 0.5 * base * height;
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
