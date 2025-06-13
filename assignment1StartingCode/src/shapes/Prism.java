package shapes;

import java.util.Comparator;

abstract public class Prism extends Shape implements Comparable<Prism>, Comparator<Prism> {

    public double height;
    double side;
    boolean compareByVolume;

    abstract public double calcVolume();
    abstract public double calcBaseArea();


    
}
