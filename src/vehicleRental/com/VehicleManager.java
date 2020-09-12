package vehicleRental.com;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleManager {

    void AddCar(Car vehicle);
    void AddMotorBike(MotorBike vehicle);
    void AddDefaultVehicle(DefaultVehicle vehicle);
    void DeleteCar(int plateNo);
    void DeleteMotorBike(int plateNo);
    void DeleteDefaultVehicle(int plateNo);
    ArrayList<DefaultVehicle> ShowAllVehicle()throws SQLException;
}
