package shapes;

abstract public class Shape {

    double height;
    boolean compareByVolume; //boolean to determine comparison type

    abstract double calcVolume();

    abstract double calcBaseArea();
    
}
