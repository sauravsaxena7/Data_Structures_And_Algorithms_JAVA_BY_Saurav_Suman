package System_Design.DesignPatterns.factory_design_pattern.shape_example;

public class ShapeMain {
    public static void main(String[] args){
        ShapeFactory factory = new ShapeFactory();

        Shape shapeCircle = factory.getShape("CIRCLE");
        shapeCircle.draw();

        Shape shapeRectangle = factory.getShape("RECTANGLE");
        shapeRectangle.draw();

        Shape shapeSquare = factory.getShape("SQUARE");
        shapeSquare.draw();

    }
}
