package System_Design.S_O_L_I_D_Principles;

interface RestaurantEmployee{
    void washDishes();
    void serveCustomers();
    void cookFood();
}

class waiter implements RestaurantEmployee{

    @Override
    public void washDishes() {
        //not my job
    }

    @Override
    public void serveCustomers() {
        //ues and here is my implementation
        System.out.println("Serving the customer");

    }

    @Override
    public void cookFood() {
        //not my job
    }
}

interface WaiterInterface{
   void serveToCustomers();
   void takeOrder();

}

interface  ChefInterface{
    void cookFood();
    void decideMenu();
}

class OnlyWaiter implements WaiterInterface{

    @Override
    public void serveToCustomers() {
        System.out.println("Serving To customers");
    }

    @Override
    public void takeOrder() {
        System.out.println("Taking order from Customers");
    }
}



public class Interface_Segmented_Principle {
}
