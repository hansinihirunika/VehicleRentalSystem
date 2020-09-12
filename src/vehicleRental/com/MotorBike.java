package vehicleRental.com;

public class MotorBike extends DefaultVehicle{
    private  String bikeType;
    private int noOfHelmates;

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public int getNoOfHelmates() {
        return noOfHelmates;
    }

    public void setNoOfHelmates(int noOfHelmates) {
        this.noOfHelmates = noOfHelmates;
    }
}
