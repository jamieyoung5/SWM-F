package com.napier;

public class DatabaseConnectionManager implements IDatabaseConnectionManager{


    public DatabaseConnectionManager(){

    }

    public void CreateConnection(){
        VerifyDriver("");
    }

    private void VerifyDriver(String driverPath){
        try{
            Class.forName(driverPath);
        } catch (ClassNotFoundException exception){
            throw new RuntimeException("SQL driver not found");
        }
    }

}
