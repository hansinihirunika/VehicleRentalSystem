package vehicleRental.com;

public class Car extends DefaultVehicle {
    private int noOfDoors;
    private String airConditioned;

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    public String getAirConditioned() {
        return airConditioned;
    }

    public void setAirConditioned(String airConditioned) {
        this.airConditioned = airConditioned;
    }
}
