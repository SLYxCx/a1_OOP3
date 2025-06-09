package shapes;

import java.util.Comparator;

abstract public class Prism implements Comparable<Prism>, Comparator<Prism> {

    double height;
    double side;
    boolean compareByVolume; //boolean to determine comparison type


    abstract public double calcVolume();

    abstract public double calcBaseArea();
    
}
