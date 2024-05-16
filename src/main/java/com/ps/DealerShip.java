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

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){

        List<Vehicle> storage = new ArrayList<>();
        for(int i = 0; i<inventory.size(); i++){
            double price = inventory.get(i).getPrice();
            if(min < price && price > max){
                storage.add(inventory.get(i));
            }
        }
        return storage;
    }


    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        List<Vehicle> storage = new ArrayList<>();
        for(int i = 0; i<inventory.size(); i++){
            String inv_make = inventory.get(i).getMake();
            String inv_model = inventory.get(i).getModel();
            if(inv_make.equalsIgnoreCase(make) && inv_model.equalsIgnoreCase(model)){
                storage.add(inventory.get(i));
            }
        }
        return storage;
    }

    public List<Vehicle> getVehicleByYear(int min, int max){
        List<Vehicle> storage = new ArrayList<>();
        for(int i = 0; i<inventory.size(); i++){
            int inv_year = inventory.get(i).getYear();
            if(min < inv_year && inv_year > max){
                storage.add(inventory.get(i));
            }
        }
        return storage;
    }

    public List<Vehicle> getVehicleByColor(String color){
        List<Vehicle> storage = new ArrayList<>();
        for(int i = 0; i<inventory.size(); i++){
            String inv_color = inventory.get(i).getColor();
            if(color.equalsIgnoreCase(inv_color)){
                storage.add(inventory.get(i));
            }
        }
        return storage;
    }

    public List<Vehicle> getVehicleByMileage(int min, int max){
        List<Vehicle> storage = new ArrayList<>();
        for(int i = 0; i<inventory.size(); i++){
            int inv_mileage = inventory.get(i).getOdometer();
            if(min < inv_mileage && inv_mileage > max){
                storage.add(inventory.get(i));
            }
        }
        return storage;
    }

    public List<Vehicle> getVehicleByType(String vehicleType){
        List<Vehicle> storage = new ArrayList<>();
        for(int i = 0; i<inventory.size(); i++){
            String inv_type = inventory.get(i).getVehicleType();
            if(inv_type.equalsIgnoreCase(vehicleType)){
                storage.add(inventory.get(i));
            }
        }
        return storage;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }


    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
        System.out.println("Your vehicle has been successfully added!");
    }

    public void removeVehicle(Vehicle vehicle){

        for(int i = 0;i < inventory.size();i++){
            if(inventory.get(i).equals(vehicle)){
                inventory.remove(vehicle);
            }
        }
    }

}
