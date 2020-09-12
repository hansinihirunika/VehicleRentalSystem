package vehicleRental.com;

import java.sql.SQLException;
import java.util.ArrayList;

public class MyVehicleManager implements VehicleManager {

    private database database;

    MyVehicleManager(){
        this.database=new database();
    }

    @Override
    public void AddCar(Car vehicle) {
        database.AddCar(vehicle);

    }

    @Override
    public void AddMotorBike(MotorBike vehicle) {
        database.AddMotorBike(vehicle);

    }

    @Override
    public void AddDefaultVehicle(DefaultVehicle vehicle) {
        database.AddDefaultVehicle(vehicle);

    }

    @Override
    public void DeleteCar(int plateNo) {

    }

    @Override
    public void DeleteMotorBike(int plateNo) {

    }

    @Override
    public void DeleteDefaultVehicle(int plateNo) {

    }

    @Override
    public ArrayList<DefaultVehicle> ShowAllVehicle() throws SQLException {
        return database.ShowAllVehicle();
    }
}
