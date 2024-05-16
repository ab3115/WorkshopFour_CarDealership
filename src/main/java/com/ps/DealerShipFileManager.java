package com.ps;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealerShipFileManager {


        public DealerShip getDealerShip(){

            DealerShip dealership = null;

            try{

                BufferedReader bufferedReader = new BufferedReader( new FileReader("inventory.csv"));
                String line = bufferedReader.readLine();
                String[] dealership_info_storage = line.split("\\|");
                String name = dealership_info_storage[0];
                String address = dealership_info_storage[1];
                String phone = dealership_info_storage[2];
                DealerShip dealerShip = new DealerShip(name, address, phone);

                while((line = bufferedReader.readLine()) != null){
                    String[] vehicle_info_storage = line.split("\\|");
                    int vin = Integer.parseInt(vehicle_info_storage[0]);
                    int year = Integer.parseInt(vehicle_info_storage[1]);
                    String make = vehicle_info_storage[2];
                    String model = vehicle_info_storage[3];
                    String vehicle_type = vehicle_info_storage[4];
                    String color = vehicle_info_storage[5];
                    int odometer = Integer.parseInt(vehicle_info_storage[6]);
                    double price = Double.parseDouble(vehicle_info_storage[7]);
                    Vehicle temp_data = new Vehicle(vin, year, make, model, vehicle_type, color, odometer, price);
                    dealerShip.addVehicle(temp_data);

                }

                return  dealerShip;
            }catch(IOException e){
                e.printStackTrace();
            }
            //Could not return the dealership object from outside the try catch
            return dealership;
        }

        public void saveDealerShip(DealerShip dealerShip){

            try{

                List<Vehicle> writer_inventory = dealerShip.getAllVehicles();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory.csv", true));

                String name = dealerShip.getName();
                String address = dealerShip.getAddress();
                String phone = dealerShip.getPhone();
                bufferedWriter.write(String.format("%s|%s|%s,", name, address, phone));

                for(int i = 0;i < writer_inventory.size();i++){
                    int vin = writer_inventory.get(i).getVin();
                     int year = writer_inventory.get(i).getYear();
                     String make = writer_inventory.get(i).getMake();
                     String model = writer_inventory.get(i).getModel();
                    String vehicleType = writer_inventory.get(i).getVehicleType();
                     String color = writer_inventory.get(i).getColor();
                     int odometer = writer_inventory.get(i).getOdometer();
                    double price = writer_inventory.get(i).getPrice();
                    bufferedWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\\n,", vin, year, make, model, vehicleType, color, odometer, price));
                }

                bufferedWriter.close();

            }catch(IOException e){
                e.printStackTrace();
            }

        }

}
