package System_Design.DesignPatterns.Decorator_Design_Pattern.Pizza_Example;

public class ExtraCheese extends ToppingDecorator{
    BasePizza basePizza;
    public ExtraCheese(BasePizza pizza){
        this.basePizza=pizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+150;
    }
}
