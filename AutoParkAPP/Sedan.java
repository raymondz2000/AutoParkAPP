package AutoParkAPP;
// Raymond Zhu  101158903
public class Sedan extends PersonalVehicle {
    public Sedan(double price, int quantity, String make, String model, int year,
                           String color){
        super(price,quantity,make,model,year,color);
    }

    public String toString(){
        String result = "";
        return result += getColor() +" " + getMake() + " " + getModel() + " Sedan (" + getYear() +
                "), costs $" + String.format("%,.2f",getPrice()) + " each (" + getInvQuantity()+ " in stock, " + getSoldQuantity() + " sold).";
    }

}
