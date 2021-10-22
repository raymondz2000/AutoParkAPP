package AutoParkAPP;
// Raymond Zhu  101158903
public abstract class PersonalVehicle extends Vehicle {
    private String color;

    public PersonalVehicle(double price, int quantity, String make, String model, int year,
                           String color){
        super(price,quantity,make,model,year);
        this.color = color;
    }

    public String getColor(){return color;}

}
