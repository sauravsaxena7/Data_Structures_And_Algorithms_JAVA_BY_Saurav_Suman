package System_Design.DesignPatterns.Decorator_Design_Pattern.Pizza_Example;

public class MushRoom extends ToppingDecorator{

    BasePizza basePizza;
    public MushRoom(BasePizza pizza){
        this.basePizza=pizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+15;
    }
}
