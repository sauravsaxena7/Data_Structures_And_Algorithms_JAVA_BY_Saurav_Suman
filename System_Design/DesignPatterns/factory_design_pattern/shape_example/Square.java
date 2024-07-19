package System_Design.DesignPatterns.factory_design_pattern.shape_example;

public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Square");
    }
}
