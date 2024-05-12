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

                }

            }catch(IOException e){
                e.printStackTrace();
            }

        }

}
