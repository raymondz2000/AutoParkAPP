package AutoParkAPP;
// Raymond Zhu  101158903
public abstract class CommercialVehicle extends Vehicle{
    private String carries;

    public CommercialVehicle(double price, int quantity, String make, String model, int year,
                             String carries){
        super(price,quantity,make,model,year);
        this.carries = carries;
    }

    public String getCarries(){return carries;}

}
