package shapes;

abstract public class Shape {

    public double height;
    boolean compareByVolume; //boolean to determine comparison type

    abstract public double calcVolume();

    abstract public double calcBaseArea();
    
}
