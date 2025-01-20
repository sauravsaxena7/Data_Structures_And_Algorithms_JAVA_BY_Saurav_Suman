package System_Design.LLD.zoomCarRentalSystem;

import System_Design.LLD.zoomCarRentalSystem.Product.Bike;
import System_Design.LLD.zoomCarRentalSystem.Product.Car;
import System_Design.LLD.zoomCarRentalSystem.Product.Vehicle;
import System_Design.LLD.zoomCarRentalSystem.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ZoomCarRentalMainClass {
    public static void main(String args[]){
        List<User> userList = addUser();
        List<Vehicle> vehicleList = addVehicles();
        List<Store> storeList = addStores(vehicleList);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(storeList,userList);

        //0 index user comes
        User user = userList.getFirst();

        //1. user search store based on location
        Location location = new Location("Ward no 11","Bhabua","Bihar",821101);
        Store store = rentalSystem.getStore(location);

        //2. get all Vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);

        //3. reserving the particular vehicles
        Reservation reservation = store.createReservation(storeVehicles.getFirst(),userList.getFirst());

        //4. generate the bill
        Bill bill = new Bill(reservation);

        //5.make payment
        Payment payment = new Payment();
        payment.payBill(bill);

        //6. trip completed, submit the vehicle and close the reservation
       boolean isCompleted= store.completeReservation(reservation.reservationId);
       System.out.println(isCompleted ? "Trip Completed":"Reservation is not Completed yet");
    }

    private static List<Store> addStores(List<Vehicle> vehicleList) {
        List<Store> stores = new ArrayList<>();
        Store store = new Store();
        store.setVehicles(vehicleList);
        store.storeId=1;
        stores.add(store);

        return stores;
    }

    private static List<Vehicle> addVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Car();
        vehicle.setVehicleId(1);
        vehicle.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Bike();
        vehicle2.setVehicleId(2);
        vehicle2.setVehicleType(VehicleType.BIKE);

        vehicles.add(vehicle);
        vehicles.add(vehicle2);
        return vehicles;

    }

    private static List<User> addUser() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUserId(1);
        users.add(user);
        return users;
    }
}
