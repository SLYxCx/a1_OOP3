import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sort {

    public static void main(String[] args) {
        // Check if we have the minimum required arguments
        if (args.length < 3) {
            System.out.println("Usage: java -jar Sort.jar -f<filename> -t<v|h|a> -s<b|s|i|m|q|z>");
            System.out.println("  -f: file name and path");
            System.out.println("  -t: type (v=volume, h=height, a=base area)");
            System.out.println("  -s: sort algorithm (b=bubble, s=selection, i=insertion, m=merge, q=quick, z=shell)");
            return;
        }

        // Parse command line arguments
        String filename = null;
        char sortType = 0;
        char sortAlgorithm = 0;

        for (String arg : args) {
            if (arg.toLowerCase().startsWith("-f")) {
                filename = arg.substring(2);
            } else if (arg.toLowerCase().startsWith("-t")) {
                if (arg.length() > 2) {
                    sortType = Character.toLowerCase(arg.charAt(2));
                }
            } else if (arg.toLowerCase().startsWith("-s")) {
                if (arg.length() > 2) {
                    sortAlgorithm = Character.toLowerCase(arg.charAt(2));
                }
            }
        }

        // Validate arguments
        if (filename == null || filename.isEmpty()) {
            System.out.println("Error: File name is required (-f)");
            return;
        }

        if (sortType != 'v' && sortType != 'h' && sortType != 'a') {
            System.out.println("Error: Sort type must be v (volume), h (height), or a (base area)");
            return;
        }

        if (sortAlgorithm != 'b' && sortAlgorithm != 's' && sortAlgorithm != 'i' && 
            sortAlgorithm != 'm' && sortAlgorithm != 'q' && sortAlgorithm != 'z') {
            System.out.println("Error: Sort algorithm must be b, s, i, m, q, or z");
            return;
        }

        // Array of Prism objects
        shapes.Prism[] prismArray = new shapes.Prism[10062];
        
        // Read the file
        readFile(prismArray, filename);
        
        // Count actual number of prisms loaded
        int actualCount = 0;
        for (shapes.Prism prism : prismArray) {
            if (prism != null) {
                actualCount++;
            }
        }
        
        if (actualCount == 0) {
            System.out.println("Error: No valid data found in file");
            return;
        }

        // Create array for the values we want to sort
        double[] valueArray = new double[actualCount];
        shapes.Prism[] validPrisms = new shapes.Prism[actualCount];
        
        // Fill the arrays with valid data only
        int index = 0;
        for (int i = 0; i < prismArray.length && index < actualCount; i++) {
            if (prismArray[i] != null) {
                validPrisms[index] = prismArray[i];
                switch (sortType) {
                    case 'h':
                        valueArray[index] = prismArray[i].height;
                        break;
                    case 'v':
                        valueArray[index] = prismArray[i].calcVolume();
                        break;
                    case 'a':
                        valueArray[index] = prismArray[i].calcBaseArea();
                        break;
                }
                index++;
            }
        }

        // Perform the sort and display results
        performSort(valueArray, validPrisms, sortType, sortAlgorithm);
    }

    public static void readFile(shapes.Prism prismArray[], String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;
            
            while ((line = reader.readLine()) != null && index < prismArray.length) {
                String[] tokens = line.split(" ");
                String type = tokens[0];
                shapes.Prism prism = null;

                switch (type) {
                    case "SquarePrism":
                        double side = Double.parseDouble(tokens[1]);
                        double height1 = Double.parseDouble(tokens[2]);
                        prism = new shapes.SquarePrism(side, height1);
                        break;

                    case "TriangularPrism":
                        double base = Double.parseDouble(tokens[1]);
                        double triHeight = Double.parseDouble(tokens[2]);
                        prism = new shapes.TriangularPrism(base, triHeight);
                        break;

                    case "OctagonalPrism":
                        double octSide = Double.parseDouble(tokens[1]);
                        double height2 = Double.parseDouble(tokens[2]);
                        prism = new shapes.OctagonalPrism(octSide, height2);
                        break;
                        
                    case "PentagonalPrism":
                        double pentSide = Double.parseDouble(tokens[1]);
                        double height3 = Double.parseDouble(tokens[2]);
                        prism = new shapes.PentagonalPrism(pentSide, height3);
                        break;
                        
                    case "Cylinder":
                        double radius1 = Double.parseDouble(tokens[1]);
                        double cylHeight = Double.parseDouble(tokens[2]);
                        prism = new shapes.Cylinder(radius1, cylHeight);
                        break;
                        
                    case "Cone":
                        double radius2 = Double.parseDouble(tokens[1]);
                        double coneHeight = Double.parseDouble(tokens[2]);
                        prism = new shapes.Cone(radius2, coneHeight);
                        break;
                        
                    case "Pyramid":
                        double pyrSide = Double.parseDouble(tokens[1]);
                        double pyrHeight = Double.parseDouble(tokens[2]);
                        prism = new shapes.Pyramid(pyrSide, pyrHeight);
                        break;

                    default:
                        continue;
                }
                
                if (prism != null) {
                    prismArray[index] = prism;
                    index++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many entries in file, array size exceeded.");
        }
    }

    public static void performSort(double[] valueArray, shapes.Prism[] prismArray, char sortType, char sortAlgorithm) {
        String typeName = "";
        switch (sortType) {
            case 'h': typeName = "Height"; break;
            case 'v': typeName = "Volume"; break;
            case 'a': typeName = "Base Area"; break;
        }

        String algorithmName = "";
        switch (sortAlgorithm) {
            case 'b': algorithmName = "Bubble Sort"; break;
            case 's': algorithmName = "Selection Sort"; break;
            case 'i': algorithmName = "Insertion Sort"; break;
            case 'm': algorithmName = "Merge Sort"; break;
            case 'q': algorithmName = "Quick Sort"; break;
            case 'z': algorithmName = "Shell Sort"; break;
        }

        System.out.println("Sorting " + valueArray.length + " elements by " + typeName + " using " + algorithmName);
        
        // Record start time
        long startTime = System.nanoTime();
        
        // Perform the sort
        switch (sortAlgorithm) {
            case 'b': // Bubble Sort
                sorting.BubbleSort.bubbleSort(valueArray); 
                break;
            case 's': // Selection Sort
                sorting.SelectionSort.selectionSortMethod(valueArray);
                break;
            case 'i': // Insertion Sort
                sorting.InsertSort.insertSortMethod(valueArray); 
                break;
            case 'q': // Quick Sort
                sorting.QuickSort.quickSortMethod(valueArray, 0, valueArray.length - 1);
                break;
            case 'm': // Merge Sort
                sorting.Mergesort.mergeSort(valueArray, 0, valueArray.length - 1);
                break;
            case 'z': // Shell Sort
                Double[] boxedArray = new Double[valueArray.length];
                for (int i = 0; i < valueArray.length; i++) {
                    boxedArray[i] = valueArray[i];
                }
                sorting.ShellSort.shellSort(boxedArray, java.util.Comparator.naturalOrder());
                for (int i = 0; i < valueArray.length; i++) {
                    valueArray[i] = boxedArray[i];
                }
                break;
        }
        
        // Record end time
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        
        // Display results
        System.out.println("\nSorted Results:");
        
                // Display results
        System.out.println("\nSorted Results:");
        
        // Display first element
        System.out.printf("First element: %s   %s   %.4f%n", prismArray[0].getClass().getSimpleName(), typeName, valueArray[0]);
        
        // Display every thousandth element
        for (int i = 999; i < valueArray.length; i += 1000) {
            System.out.printf("Element %d: %s   %s   %.4f%n", i + 1, prismArray[i].getClass().getSimpleName(), typeName, valueArray[i]);
        }
        
        // Display last element
        System.out.printf("Last element: %s   %s   %.4f%n ", prismArray[valueArray.length - 1].getClass().getSimpleName(), typeName ,valueArray[valueArray.length - 1]);
        
        System.out.println("\nTime taken: " + duration + " ms");
    }
}