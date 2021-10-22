package AutoParkAPP;
// Raymond Zhu  101158903
public class Truck extends CommercialVehicle {
    private boolean heavyDuty;

    public Truck(double price, int quantity, String make, String model, int year,
                 String carries, boolean h) {
        super(price, quantity, make, model, year, carries);
        this.heavyDuty = h;
    }

    public String toString(){
        String result = getMake() + " " + getModel();
        if(heavyDuty){
            result += " heavy duty";
        }
        return result += "Truck ("+  getYear() + ") carries " + getCarries() +
                ", costs $" + String.format("%,.2f",getPrice()) + " each (" +getInvQuantity()+ " in stock, " + getSoldQuantity() + " sold).";
    }

}
