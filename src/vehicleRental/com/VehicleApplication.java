package vehicleRental.com;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleApplication {

    public static MyVehicleManager myVehicleManager;
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws SQLException {

        myVehicleManager = new MyVehicleManager();
        while (true) {
            printMenu();
        }
    }

    public static void printMenu() throws SQLException {

        System.out.println("----Vehicle Rental System----");
        System.out.println("1. ADD Vehicle");
        System.out.println("2. SHOW All Vehicle");
        System.out.println("3. REMOVE Vehicle");
        System.out.println("0. EXIT");
        String choice = scanner.next();

        chooseMethod(Integer.parseInt(choice));

    }

    public static void chooseMethod(int choice) throws SQLException {

        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                AddVehicle();
                break;
            case 2:
                ShowAllVehicle();
                break;
            case 3:
                deleteVehicle();
                break;

            default:
                throw new AssertionError();
        }
    }

    //Add method

    public static void AddVehicle() {
        System.out.println("Add the Vehicle Type");
        System.out.println("1.Car");
        System.out.println("2.Motor Bike");
        System.out.println("3.Default Vehicle");
        int type = Integer.parseInt(scanner.next());

        System.out.println("Enter Plate Number: ");
        int plateNo = scanner.nextInt();
        System.out.println("Enter Model Name: ");
        String model = scanner.next();
        System.out.println("Enter The engineCapacity: ");
        int engineCapacity = scanner.nextInt();
        System.out.println("Enter Fuel Type: ");
        String fuelType = scanner.next();

        if (type == 1) {
            System.out.println("Enter the Car AirConditioned or Not: ");
            String airConditioned = scanner.next();

            System.out.println("Enter the Number of Doors: ");
            int noOfDoors = scanner.nextInt();

            Car car = new Car();
            car.setPlateNo(plateNo);
            car.setModel(model);
            car.setEngineCapacity(engineCapacity);
            car.setFuelType(fuelType);
            car.setAirConditioned(airConditioned);
            car.setNoOfDoors(noOfDoors);

            myVehicleManager.AddCar(car);

            System.out.println("Added");


        } else if (type == 2) {
            System.out.println("Enter The Number of Helmates: ");
            int noOfHelmates = scanner.nextInt();
            System.out.println("Enter the Bike Type: ");
            String bikeType = scanner.next();

            MotorBike motorBike = new MotorBike();
            motorBike.setPlateNo(plateNo);
            motorBike.setModel(model);
            motorBike.setEngineCapacity(engineCapacity);
            motorBike.setFuelType(fuelType);
            motorBike.setBikeType(bikeType);
            motorBike.setNoOfHelmates(noOfHelmates);

            myVehicleManager.AddMotorBike(motorBike);


        } else if (type == 3) {
            DefaultVehicle def = new DefaultVehicle();
            def.setPlateNo(plateNo);
            def.setModel(model);
            def.setEngineCapacity(engineCapacity);
            def.setFuelType(fuelType);

            myVehicleManager.AddDefaultVehicle(def);

        } else {
            System.out.println("Invalid Input!!!");
        }
    }

    //delete method

    public static void deleteVehicle() {

        System.out.println("Enter the Plate Number: ");
        int plateNo = scanner.nextInt();
        myVehicleManager.DeleteDefaultVehicle(plateNo);

        myVehicleManager.DeleteCar(plateNo);

        myVehicleManager.DeleteMotorBike(plateNo);

        System.out.println("Deleted");
    }

    //Show method


    public static void ShowAllVehicle() throws SQLException {

        ArrayList<DefaultVehicle> defaultVehicles = myVehicleManager.ShowAllVehicle();
        for (DefaultVehicle vehicle : defaultVehicles) {
            System.out.println("PlateNo: " + vehicle.getPlateNo() + ", Model: " + vehicle.getModel() +", Engine Capacity: " + vehicle.getEngineCapacity() +", Fuel Type: " + vehicle.getFuelType());

        }

    }

}