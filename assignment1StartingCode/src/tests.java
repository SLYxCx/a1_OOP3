

public class tests {

    public static void main(String[] args) {

        //array of Prism objects and Shape objects
        shapes.Prism [] prismArray = new shapes.Prism[5];
        shapes.Shape [] shapeArray = new shapes.Shape[5];

        shapes.SquarePrism squarePrism = new shapes.SquarePrism(4, 4);
        System.out.println("Square Prism Volume: " + squarePrism.calcVolume()); // Expected: 80.0
        System.out.println("Square Prism Base Area: " + squarePrism.calcBaseArea()); // Expected: 16.0

        shapes.TriangularPrism triangularPrism = new shapes.TriangularPrism(3, 4, 5);
        System.out.println("Triangular Prism Volume: " + triangularPrism.calcVolume()); // Expected: 30.0
        System.out.println("Triangular Prism Base Area: " + triangularPrism.calcBaseArea()); // Expected: 6.0

        shapes.OctagonalPrism octagonalPrism = new shapes.OctagonalPrism(2, 6);
        System.out.println("Octagonal Prism Volume: " + octagonalPrism.calcVolume()); // Expected: 48.0
        System.out.println("Octagonal Prism Base Area: " + octagonalPrism.calcBaseArea()); // Expected: 32.0

        System.out.println("Comparing Square Prism and Triangular Prism by height: " + squarePrism.compareTo(triangularPrism)); // Expected: 1 (since 5 > 4)


    }

    public static void readFile(shapes.Prism prismArray[], shapes.Shape [] shapeArray ,String filename) {
        // Function to read file and populate prismArray and shapeArray
    }
        
}
