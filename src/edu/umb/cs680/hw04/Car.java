package edu.umb.cs680.hw04;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;

    public Car(String make, String model, int year, int mileage, float price){
        if((make == null) | (model == null)){
            throw new NullPointerException("Make and Model should be string values!!!");
        }
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    public int getMileage(){
        return this.mileage;
    }

    public int getYear(){
        return this.year;
    }

    public float getPrice(){
        return this.price;
    }

    public static void main(String[] args) {
        Car instance = new Car("Mercedes‑Benz", "A-Class",2022, 25, 34000.0F);
        System.out.println("Make    : "+instance.getMake());
        System.out.println("Model   : "+instance.getModel());
        System.out.println("Year    : "+instance.getYear());
        System.out.println("Mileage : "+instance.getMileage());
        System.out.println("Price   : "+instance.getPrice());
    }
}