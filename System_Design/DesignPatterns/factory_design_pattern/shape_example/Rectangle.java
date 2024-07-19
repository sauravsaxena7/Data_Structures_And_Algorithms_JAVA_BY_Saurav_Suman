package System_Design.DesignPatterns.factory_design_pattern.shape_example;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
