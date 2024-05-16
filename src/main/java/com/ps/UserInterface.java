package com.ps;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    DealerShip dealerShip;
    static boolean menu_flag = true;
    static Scanner scanner = new Scanner(System.in);


    public void display(){
        init();
        while(menu_flag) {
            displayHelper();
        }
    }


    private void init(){
        DealerShipFileManager dealerShipFileManager = new DealerShipFileManager();
        this.dealerShip = dealerShipFileManager.getDealerShip();
    }

    public void displayHelper(){

        System.out.println("Welcome to the car dealership! Please select an option!");
        System.out.println("\t(1)Get vehicles by price");
        System.out.println("\t(2)Get vehicles by make & model");
        System.out.println("\t(3)Get vehicles by year");
        System.out.println("\t(4)Get vehicles by color");
        System.out.println("\t(5)Get vehicles by mileage");
        System.out.println("\t(6)Get vehicles by vehicle type");
        System.out.println("\t(7)List all vehicles");
        System.out.println("\t(8)Add a vehicle to our inventory");
        System.out.println("\t(9)Remove a vehicle from our lineup");
        System.out.println("\t(99)Exit\n");
        String response = scanner.next();

        switch(response){
            case("1"):
                processGetByPriceRequest();
                break;
            case("2"):
                processGetByMakeModelRequest();
                break;
            case("3"):
                processGetByYearRequest();
                break;
            case("4"):
                processGetByColorRequest();
                break;
            case("5"):
                processGetByMileageRequest();
                break;
            case("6"):
                processGetByVehicleTypeRequest();
                break;
            case("7"):
                processGetAllVehiclesRequest();
                break;
            case("8"):
                processAddVehiclesRequest();
                break;
            case("9"):
                processRemoveVehiclesRequest();
                break;
            case("99"):
                System.out.println("Exiting application...\n");
                System.exit(0);
            default:
                System.out.println("Please select one of the choices listed.\n");
                break;

        }
    }

    public void processGetByPriceRequest(){

    try {

        System.out.println("Please enter the minimum price.");
        double min = scanner.nextDouble();
        System.out.println("Please enter the maximum price.");
        double max = scanner.nextInt();
        List<Vehicle> vehicle_list = dealerShip.getVehiclesByPrice(min, max);

        if(!vehicle_list.isEmpty()){
            System.out.println("The vehicles listed between that price range are: \n");
             displayVehicles(vehicle_list);}
        else{
            System.out.println("No vehicles were found in that price range.");
        }

    }catch(InputMismatchException e){

        System.out.println("Invalid input, please enter a valid price.");
    }

    }

    public void processGetByMakeModelRequest(){

        try {

            System.out.println("Please enter the make you'd like the search for.");
            String make = scanner.next();
            System.out.println("Please enter the model you'd like to search for.");
            String model = scanner.next();
            List<Vehicle> vehicle_list = dealerShip.getVehicleByMakeModel(make, model);

            if(!vehicle_list.isEmpty()) {
                System.out.println("The vehicles listed with that make and model are:\n");
                displayVehicles(vehicle_list);
            }else{
                System.out.println("No vehicles were found with that specific make and model");
            }

        }catch(InputMismatchException e){
            System.out.println("Please enter a valid make and model.");
        }

    }

    public void processGetByYearRequest(){

        try {

            System.out.println("Please enter the lowest/minimum year you'd like:");
            int min = scanner.nextInt();
            System.out.println("Please enter the maximum year you'd like to search up until.");
            int max = scanner.nextInt();
            List<Vehicle> vehicle_list = dealerShip.getVehicleByYear(min, max);

            if(!vehicle_list)
            System.out.println("The vehicles listed between those years are:\n");

            displayVehicles(vehicle_list);
        }catch(InputMismatchException e){
            System.out.println("Invalid year, please enter a valid year.");
        }
    }

    public void processGetByColorRequest(){
        try {
            System.out.println("Please enter the color you'd like to filter by.");
            String color = scanner.next();
            System.out.println("The results listed for your specific color are: \n");
            List<Vehicle> vehicle_list = dealerShip.getVehicleByColor(color);
            displayVehicles(vehicle_list);
        }catch(InputMismatchException e){
            System.out.println("Invalid input, please enter a valid color.");
        }
    }

    public void processGetByMileageRequest(){

        try {
            System.out.println("Please enter the minimum mileage.");
            int min = scanner.nextInt();
            System.out.println("Please enter the maximum mileage.");
            int max = scanner.nextInt();
            System.out.println("The vehicles listed between the given mileage range are: \n");
            List<Vehicle> vehicle_list = dealerShip.getVehicleByMileage(min, max);
            displayVehicles(vehicle_list);
        }catch(InputMismatchException e){
            System.out.println("Invalid input, please enter a valid minimum and maximum year.");
        }
    }

    public void processGetByVehicleTypeRequest(){
        try{
        System.out.println("Please enter the vehicle type you'd like to filter by.");
        String type = scanner.next();
        System.out.println("The results listed for your specific vehicle type are: \n");
        List<Vehicle> vehicle_list = dealerShip.getVehicleByType(type);
        displayVehicles(vehicle_list);}
        catch(InputMismatchException e){
            System.out.println("Please enter a valid vehicle type");
        }
    }

    public void processGetAllVehiclesRequest(){
        System.out.println("All vehicles in our lineup are: \n");
        List<Vehicle> vehicle_list = dealerShip.getAllVehicles();
        System.out.println(dealerShip.getName());
        displayVehicles(vehicle_list);
    }

    public void processAddVehiclesRequest(){
        try {
            System.out.println("Please add the vin number of the vehicle.");
            int vin = scanner.nextInt();
            System.out.println("Please enter the year of your vehicle.");
            int year = scanner.nextInt();
            System.out.println("Please enter the make of the vehicle.");
            String make = scanner.next();
            System.out.println("Please enter the model of the vehicle.");
            String model = scanner.next();
            System.out.println("Please enter the type of vehicle.");
            String type = scanner.next();
            System.out.println("Please enter the color of the vehicle.");
            String color = scanner.next();
            System.out.println("Please enter the odometer reading(Please be honest).");
            int odometer = scanner.nextInt();
            System.out.println("Please enter the price of the vehicle you'd like to sell it for.");
            double price = scanner.nextInt();
            Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
            dealerShip.addVehicle(vehicle);
            DealerShipFileManager.saveDealerShip(dealerShip);
            System.out.println("You've succesfully added: " + vehicle.toString());

        }catch(InputMismatchException e){
            System.out.println("Please re-enter a valid input type.");
        }
    }

    public void processRemoveVehiclesRequest(){
        try {
            System.out.println("Please enter the specific vin number of the vehicle you'd like to remove from lineup.");
            int vin = scanner.nextInt();
            for (Vehicle vehicle : dealerShip.getAllVehicles()) {
                int search_vin = vehicle.getVin();
                if (search_vin == vin) {
                    dealerShip.removeVehicle(vehicle);
                    System.out.println("You have successfully removed " + vehicle.toString());
                }
            }
            DealerShipFileManager.saveDealerShip(dealerShip);
        }catch(InputMismatchException e){
            System.out.println("Please enter a valid vin number.");
        }
    }

    private void displayVehicles(List<Vehicle> inventory){

        for(int i = 0;i < inventory.size();i++){
            System.out.println(inventory.get(i).toString());
        }
    }

}
