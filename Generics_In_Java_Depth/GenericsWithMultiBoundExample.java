package Generics_In_Java_Depth;

class PrintClass{
    public void print(long value){
        System.out.println(value);
    }
}

interface Perimeter{
    long perimeter(long length,long breadth);
}

interface Area{
    long area(long length,long breadth);
}

class Calc<T extends PrintClass & Perimeter & Area>{

}

class Rectangle extends PrintClass implements Perimeter,Area{

    @Override
    public long area(long length, long breadth) {
        return length*breadth;
    }

    @Override
    public long perimeter(long length, long breadth) {
        return length+breadth;
    }
}

class Square extends PrintClass implements Area{

    @Override
    public long area(long side, long breadth) {
        return side*side;
    }
}

public class GenericsWithMultiBoundExample {
    public static void main(String[] args){

        Calc<Rectangle> rectangleCalc = new Calc<Rectangle>();
        //Type parameter 'Generics_In_Java_Depth.Square' is not within
        // its bound; should implement
        // 'Generics_In_Java_Depth.Perimeter'
        //Calc<Square> squareCalc = new Calc<Square>(); compile time error


    }
}
