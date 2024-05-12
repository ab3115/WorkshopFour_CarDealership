package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealerShipFileManager {

        public static void bufReader(){

            try{
                BufferedReader bufferedReader = new BufferedReader( new FileReader("inventory.csv"));
                String line;
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
                    Vehicle temp_date = new Vehicle(vin, year, make, model, vehicle_type, color, odometer, price);

                }

            }catch(IOException e){
                e.printStackTrace();
            }

        }

        public static DealerShip getDealerShip(){
            return null;
        }

        public static void saveDealerShip(DealerShip dealerShip){

        }

}
