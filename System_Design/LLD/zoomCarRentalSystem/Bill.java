package System_Design.LLD.zoomCarRentalSystem;

public class Bill {
    Reservation reservation;
    double amount;
    boolean isBillPaid;

    Bill(Reservation reservation){
        this.reservation=reservation;
        this.amount=computeBillAmount();
        isBillPaid=false;
    }

    private double computeBillAmount() {
        return 100.00;
    }
}
