package com.ps;
import java.util.ArrayList;
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
        System.out.println("\t(99)Exit");
        String response = scanner.next();

        switch(response){
            case("1"):
                break;
            case("2"):
                break;
            case("3"):
                break;
            case("4"):
                break;
            case("5"):
                break;
            case("6"):
                break;
            case("7"):
                processGetAllVehiclesRequest();
                break;
            case("8"):
                break;
            case("9"):
                break;
            case("99"):
                break;
            default:
                System.out.println("Please select one of the choices listed.");
                break;

        }
    }

    public void processGetByPriceRequest(){
        System.out.println("Please enter the minimum price");
        int min = scanner.nextInt();
        System.out.println("Please enter the maximum price");
        int max = scanner.nextInt();
        System.out.println("The vehicles listed between that price range are: ");
        List<Vehicle> vehicle_list = dealerShip.getVehiclesByPrice(min, max);
        displayVehicles(vehicle_list);
    }

    public void processGetByMakeModelRequest(){

    }

    public void processGetByYearRequest(){

    }

    public void processGetByColorRequest(){

    }

    public void processGetByMileageRequest(){

    }

    public void processGetByVehicleTypeRequest(){

    }

    public void processGetAllVehiclesRequest(){
        System.out.println("All vehicles in our lineup are: ");
        List<Vehicle> vehicle_list = dealerShip.getAllVehicles();
        displayVehicles(vehicle_list);
    }

    public void processAddVehiclesRequest(){

    }

    public void processRemoveVehiclesRequest(){

    }

    private void displayVehicles(List<Vehicle> inventory){

        for(int i = 0;i < inventory.size();i++){
            System.out.println(inventory.get(i).toString());
        }
    }

}
