package System_Design.LLD.zoomCarRentalSystem;

import java.util.List;

public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> userList;

    VehicleRentalSystem(List<Store> storeList,List<User> userList){
        this.storeList=storeList;
        this.userList=userList;
    }

    public Store getStore(Location location){
        //based on location, we will filter out the Store from the store List
        return storeList.get(0);
    }

    //add users

    //remove users

    //add stores

    //remove stores


}
