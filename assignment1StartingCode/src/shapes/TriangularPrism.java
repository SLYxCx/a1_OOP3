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

}
