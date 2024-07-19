package System_Design.LLD.zoomCarRentalSystem.Product;

import java.util.List;

public class VehicleInventoryManager {
    List<Vehicle> vehicles;

    public VehicleInventoryManager(List<Vehicle> vehicles) {
        this.vehicles=vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
