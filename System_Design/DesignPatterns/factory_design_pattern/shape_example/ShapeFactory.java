package System_Design.DesignPatterns.factory_design_pattern.shape_example;

public class ShapeFactory {
    public Shape getShape(String input){
        switch (input){
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            default:
                return null;
        }
    }
}
