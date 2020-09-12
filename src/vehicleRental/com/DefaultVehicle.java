package vehicleRental.com;

public class DefaultVehicle {
    private int plateNo;
    private String model;
    private int engineCapacity;
    private String fuelType;

    public int getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(int plateNo) {
        this.plateNo = plateNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
