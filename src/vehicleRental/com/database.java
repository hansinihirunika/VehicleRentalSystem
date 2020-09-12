package vehicleRental.com;

import java.sql.*;
import java.util.ArrayList;

public class database {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement = null;
    String connectionString = "jdbc:mysql://localhost/vehicle_rental_system";
    String username = "root";
    String password = "";
    String query;

    public database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString, username, password);
            System.out.println("[DATABASE] - Connected!");
            this.statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("[DATABASE] - Error in Connecting\n" + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("[DATABASE] - Error in Connecting\n" + ex);
        } catch (Exception ex) {
            System.out.println("[DATABASE] - Error in Connecting\n" + ex);
        }
    }

    //adding default members to database

    public void AddDefaultVehicle(DefaultVehicle vehicle) {
        PreparedStatement prestatement = null;
        try {
            prestatement = connection.prepareStatement("insert into default_vehicle values(?,?,?,?)");
            prestatement.setInt(1, vehicle.getPlateNo());
            prestatement.setString(2, vehicle.getModel());
            prestatement.setInt(3, vehicle.getEngineCapacity());
            prestatement.setString(4, vehicle.getFuelType());
            prestatement.execute();
            System.out.println("[DATABASE] -Successfully added vehicle");
        } catch (Exception ex) {
            System.out.println("[DATABASE] - ERROR");
            ex.printStackTrace();
        }
    }

    public void AddCar(Car vehicle) {
        PreparedStatement prestatement = null;
        try {
            prestatement = connection.prepareStatement("insert into car values(?,?,?,?,?,?)");
            prestatement.setInt(1, vehicle.getPlateNo());
            prestatement.setString(2, vehicle.getModel());
            prestatement.setInt(3, vehicle.getEngineCapacity());
            prestatement.setString(4, vehicle.getFuelType());
            prestatement.setString(5, vehicle.getAirConditioned());
            prestatement.setInt(6, vehicle.getNoOfDoors());
            prestatement.execute();
            System.out.println("[DATABASE] -Successfully added vehicle");
        } catch (Exception ex) {
            System.out.println("[DATABASE] - ERROR");
            ex.printStackTrace();
        }
    }

    public void AddMotorBike(MotorBike vehicle) {
        PreparedStatement prestatement = null;
        try {
            prestatement = connection.prepareStatement("insert into motor_bike values(?,?,?,?,?,?)");
            prestatement.setInt(1, vehicle.getPlateNo());
            prestatement.setString(2, vehicle.getModel());
            prestatement.setInt(3, vehicle.getEngineCapacity());
            prestatement.setString(4, vehicle.getFuelType());
            prestatement.setString(5, vehicle.getBikeType());
            prestatement.setInt(6, vehicle.getNoOfHelmates());
            prestatement.execute();
            System.out.println("[DATABASE] -Successfully added vehicle");
        } catch (Exception ex) {
            System.out.println("[DATABASE] - ERROR");
            ex.printStackTrace();
        }
    }

    //delete default vehicle from database


    public void DeleteDefaultVehicle(int plateNo) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("delete from default_vehicle where plate_no =?");
            preparedStatement.setInt(1, plateNo);
            preparedStatement.execute();
            System.out.println("[DATABASE] -Successfully Deleted vehicle");

        } catch (Exception ex) {
            System.out.println("[DATABASE] -Member is Not FOUND");
            ex.printStackTrace();
        }
    }

    //delete car from database


    public void DeleteCar(int plateNo) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("delete from car where plate_no =?");
            preparedStatement.setInt(1, plateNo);
            preparedStatement.execute();
            System.out.println("[DATABASE] -Successfully Deleted member");

        } catch (Exception ex) {
            System.out.println("[DATABASE] -Member is Not FOUND");
            ex.printStackTrace();
        }

    }

    //delete motorbike from database


    public void DeleteMotorBike(int plateNo) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("delete from motor_bike where plate_no =?");
            preparedStatement.setInt(1, plateNo);
            preparedStatement.execute();
            System.out.println("[DATABASE] -Successfully Deleted vehicle");

        } catch (Exception ex) {
            System.out.println("[DATABASE] -Vehicle is Not FOUND");
            ex.printStackTrace();
        }

    }

    //show member from database

    public ArrayList<DefaultVehicle> ShowAllVehicle(){
        ArrayList<DefaultVehicle> defaultVehicles = new ArrayList<>();

        try {

            query = "SELECT * " + "FROM default_vehicle";
            resultSet = statement.executeQuery(query);




            while(resultSet.next()) {
                DefaultVehicle defaultVehicle = new DefaultVehicle();

                defaultVehicle.setPlateNo(resultSet.getInt("plate_no"));
                defaultVehicle.setModel(resultSet.getString("model"));
                defaultVehicle.setEngineCapacity(resultSet.getInt("engine_capacity"));
                defaultVehicle.setFuelType(resultSet.getString("fuel_type"));
                defaultVehicles.add(defaultVehicle);

            }



        }catch (Exception ex){
            System.out.println(ex);
        }
        return defaultVehicles;
    }
}
