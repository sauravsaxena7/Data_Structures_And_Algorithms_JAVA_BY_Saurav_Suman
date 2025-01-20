package System_Design.LLD.zoomCarRentalSystem;

import System_Design.LLD.zoomCarRentalSystem.Product.*;

import java.util.Date;

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date bookFrom;
    Date bookTill;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickupLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;

    public int createReserve(User user,Vehicle vehicle){
        //generate new id
        reservationId=1232;
        this.user=user;
        this.vehicle=vehicle;
        reservationStatus=ReservationStatus.SCHEDULED;
        reservationType=ReservationType.DAILY;
        return reservationId;
    }
}
