package com.ps;

import java.util.ArrayList;
import java.util.List;

public class DealerShip {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;


    public DealerShip(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public List<Vehicle> getVehiclesByPrice(int min, int max){
        return null;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        return null;
    }

    public List<Vehicle> getVehicleByYear(int min, int max){
        return null;
    }

    public List<Vehicle> getVehicleByColor(String color){
        return null;
    }

    public List<Vehicle> getVehicleByMileage(int min, int max){
        return null;
    }

    public List<Vehicle> getVehicleByType(String vehicleType){
        return null;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);

    }

    public void removeVehicle(Vehicle vehicle){

        for(int i = 0;i < inventory.size();i++){
            if(inventory.get(i).equals(vehicle)){
                inventory.remove(vehicle);
            }
        }
    }

}
