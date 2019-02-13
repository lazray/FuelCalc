package ru.alekseenko.fuel_calc;

public class Rashod {

    String RASHOD_ID;
    String date;
    String cost;
    String odometr;
    String capacity;


    public Rashod(){
    }

    public Rashod(String RASHOD_ID, String date, String cost, String odometr){
        this.RASHOD_ID = RASHOD_ID;
        this.date = date;
        this.cost = cost;
        this.odometr = odometr;
        this.capacity = capacity;
    }

    public Rashod(String date, String cost, String odometr){
        this.date = date;
        this.cost = cost;
        this.odometr = odometr;
        this.capacity = capacity;
    }

    public String getRASHOD_ID() {
        return RASHOD_ID;
    }

    public void setRASHOD_ID(String RASHOD_ID) {
        this.RASHOD_ID = RASHOD_ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getOdometr() {
        return odometr;
    }

    public void setOdometr(String odometr) {
        this.odometr = odometr;
    }
    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
