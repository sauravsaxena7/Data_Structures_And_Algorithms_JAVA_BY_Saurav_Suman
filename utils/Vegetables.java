package utils;

public class Vegetables extends Basket{
        String name;
    public Vegetables(String basketCategory, String name){
            super(basketCategory);
            this.name=name;
        }

        public String getName() {
            return name;
        }
}


