package utils;

public class Fruits extends Basket{
    String name;
    public Fruits(String basketCategory, String name){
        super(basketCategory);
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
