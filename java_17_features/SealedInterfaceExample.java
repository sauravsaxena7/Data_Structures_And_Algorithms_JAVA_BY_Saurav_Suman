package java_17_features;


sealed interface Shape permits Circle,Rectangles{
    double area();
}

//Sealed interface implemented class we need to make it final so other class cannot extend their property and implement sealed interface method
//Modifier 'sealed', 'non-sealed' or 'final' expected
 final class Circle implements Shape{

    double radius;
    @Override
    public double area() {
        return Math.PI*radius*radius;
    }
}

final class Rectangles implements Shape{

    Double length,breadth;

    @Override
    public double area() {
        return length*breadth;
    }
}

public class SealedInterfaceExample {
}
