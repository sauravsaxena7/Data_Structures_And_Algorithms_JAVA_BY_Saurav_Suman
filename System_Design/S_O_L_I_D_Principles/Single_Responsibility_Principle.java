package System_Design.S_O_L_I_D_Principles;

//Marker Entity
class Marker{
    String name;
    String color;
    int year;
    int price;

    public Marker(String name,String color,int year, int price){
        this.name=name;
        this.color=color;
        this.year=year;
        this.price=price;
    }
}

class Invoice{
    private Marker marker;
    private int quantity;

    public Invoice (Marker marker,int quantity){
        this.marker=marker;
        this.quantity=quantity;
    }

    public int calculateTotal(){
        int price = (marker.price)*this.quantity;
        return price;
    }

    public void printInvoice(){
        //print the Invoice
    }

    public void saveToDB(){
        //save into DATABASE
    }
}

//below classes are following S-> single reason to change

class InvoiceDao {
    Invoice invoice;
    public InvoiceDao(Invoice invoice){
        this.invoice = invoice;
    }

    public void saveToDB(){
        //save To DB
    }
}

class InvoicePrinter {
    Invoice invoice;
    public InvoicePrinter(Invoice invoice){
        this.invoice = invoice;
    }

    public void printInvoice(){
        //print invoice
    }
}





public class Single_Responsibility_Principle {
}
