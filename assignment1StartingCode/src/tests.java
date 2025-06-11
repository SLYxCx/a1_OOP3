import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class tests {

    public static void main(String[] args) {

        //array of Prism objects and Shape objects
        shapes.Prism [] prismArray = new shapes.Prism[5];
        shapes.Shape [] shapeArray = new shapes.Shape[5];

        shapes.SquarePrism squarePrism = new shapes.SquarePrism(4, 5);
        System.out.println("Square Prism Volume: " + squarePrism.calcVolume()); // Expected: 80.0
        System.out.println("Square Prism Base Area: " + squarePrism.calcBaseArea()); // Expected: 16.0

        shapes.TriangularPrism triangularPrism = new shapes.TriangularPrism(3, 4, 5);
        System.out.println("Triangular Prism Volume: " + triangularPrism.calcVolume()); // Expected: 30.0
        System.out.println("Triangular Prism Base Area: " + triangularPrism.calcBaseArea()); // Expected: 6.0

        shapes.OctagonalPrism octagonalPrism = new shapes.OctagonalPrism(5, 1);
        System.out.println("Octagonal Prism Volume: " + octagonalPrism.calcVolume()); // Expected: 120.7
        System.out.println("Octagonal Prism Base Area: " + octagonalPrism.calcBaseArea()); // Expected: 120.7

        System.out.println("Comparing Square Prism and Triangular Prism by height: " + squarePrism.compareTo(triangularPrism)); // Expected: 1 (since 5 > 4)


    }

    public static void readFile(shapes.Prism prismArray[], shapes.Shape[] shapeArray, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;

            // Read each line of the file until we reach the end or fill the array
            while ((line = reader.readLine()) != null && index < prismArray.length) {
                // Split the line into parts using comma as the separator
                String[] tokens = line.split(",");

                // First token tells us what kind of prism this is
                String type = tokens[0];
                shapes.Prism prism = null;

                // Depending on the type, create the appropriate prism object
                switch (type) {
                    case "SquarePrism":
                        // For SquarePrism, read side and height from file
                        double side = Double.parseDouble(tokens[1]);
                        double height1 = Double.parseDouble(tokens[2]);
                        prism = new shapes.SquarePrism(side, height1);
                        break;

                    case "TriangularPrism":
                        // For TriangularPrism, read base, triangle height, and prism height
                        double base = Double.parseDouble(tokens[1]);
                        double triHeight = Double.parseDouble(tokens[2]);
                        double triPrismHeight = Double.parseDouble(tokens[3]);
                        prism = new shapes.TriangularPrism(base, triHeight, triPrismHeight);
                        break;

                    case "OctagonalPrism":
                        // For OctagonalPrism, read side and height from file
                        double octSide = Double.parseDouble(tokens[1]);
                        double height2 = Double.parseDouble(tokens[2]);
                        prism = new shapes.OctagonalPrism(octSide, height2);
                        break;

                    default:
                        // If the shape type isn't recognized, just skip this line
                        System.out.println("Unknown shape type: " + type);
                        continue;
                }

                // Store the created object in both the prism and shape arrays
                prismArray[index] = prism;
                shapeArray[index] = prism; // Prism is also a Shape
                index++;
            }

        } catch (IOException e) {
            // Problem opening or reading the file
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Couldn't convert one of the values into a number
            System.out.println("Error parsing number: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // The file had more entries than the arrays can hold
            System.out.println("Too many entries in file, array size exceeded.");
        }
    }
};