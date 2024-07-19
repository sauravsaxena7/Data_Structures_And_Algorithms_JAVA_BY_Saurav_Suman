package System_Design.LLD.zoomCarRentalSystem.Product;


import java.util.List;

public class Store {
    int storeId;
    VehicleInventoryManager vehicleInventoryManager;
    Location location;

    List<Res> reservationList;

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        return vehicleInventoryManager.getVehicles();
    }

    //addVehicles, update, use inventory management to thouse.
    public void setVehicles(List<Vehicle> vehicles){
        vehicleInventoryManager = new VehicleInventoryManager(vehicles);
    }
}
