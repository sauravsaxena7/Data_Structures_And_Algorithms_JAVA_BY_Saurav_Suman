package System_Design.LLD.zoomCarRentalSystem;

public class User {
    int userId;
    String drivingLicesence;
    String username;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDrivingLicesence() {
        return drivingLicesence;
    }

    public void setDrivingLicesence(String drivingLicesence) {
        this.drivingLicesence = drivingLicesence;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
