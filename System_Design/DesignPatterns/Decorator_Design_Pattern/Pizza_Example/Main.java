package System_Design.DesignPatterns.Decorator_Design_Pattern.Pizza_Example;

public class Main {
    public static void main(String[] args){
        BasePizza pizza = new ExtraCheese(new Margherita());
        System.out.println( "pizza.cost(): "+pizza.cost());

        BasePizza pizza2 = new MushRoom(new ExtraCheese(new Margherita()));
        System.out.println( "pizza2.cost(): "+pizza2.cost());
    }
}
