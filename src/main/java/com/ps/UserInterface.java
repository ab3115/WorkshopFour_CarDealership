package com.ps;

public class UserInterface {

    DealerShip dealerShip;
    static boolean menu_flag = true;

    public void display(){
        init();
        while(menu_flag) {
            displayHelper();
        }
    }

    public void displayHelper(){
        System.out.println("Welcome to the car dealership");
        System.out.println("");
    }



    private void init(){
        DealerShipFileManager dealerShipFileManager = new DealerShipFileManager();
        this.dealerShip = dealerShipFileManager.getDealerShip();
    }


    public void processGetByPriceRequest(){

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

    }

    public void processAddVehiclesRequest(){

    }

    public void processRemoveVehiclesRequest(){

    }

}
