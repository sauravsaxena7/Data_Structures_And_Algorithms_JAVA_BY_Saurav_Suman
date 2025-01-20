package System_Design.LLD.zoomCarRentalSystem;


import System_Design.LLD.zoomCarRentalSystem.Product.Vehicle;
import System_Design.LLD.zoomCarRentalSystem.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeId;
    VehicleInventoryManager vehicleInventoryManager;
    Location location;

    List<Reservation> reservationList = new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        return vehicleInventoryManager.getVehicles();
    }

    //addVehicles, update, use inventory management to thouse.
    public void setVehicles(List<Vehicle> vehicles){
        vehicleInventoryManager = new VehicleInventoryManager(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle,User user){
        Reservation reservation = new Reservation();
        reservation.createReserve(user,vehicle);
        reservationList.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationId){
        //take the out the reservation from the list and call complete the reservation method
        return true;
    }
}
