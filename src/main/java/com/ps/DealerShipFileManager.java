package com.ps;

import java.io.*;

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
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory.csv", true));
                String text;
                text = String.format()

            }catch(IOException e){
                e.printStackTrace();
            }

        }

}
