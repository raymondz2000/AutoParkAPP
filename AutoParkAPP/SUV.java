package AutoParkAPP;
// Raymond Zhu  101158903
public class SUV extends PersonalVehicle {
    private boolean fourWD;

    public SUV(double price, int quantity, String make, String model, int year,
                 String color, boolean fourWD){
        super(price,quantity,make,model,year,color);
        this.fourWD = fourWD;
    }

    public String toString(){
        String result = "";
        String fwd ="";
        if(fourWD) fwd = " FourWD";
        return result += getColor() +" " + getMake() + " " + getModel() + fwd+ " SUV (" + getYear() +
                "), costs $" + String.format("%,.2f",getPrice()) + " each (" +getInvQuantity()+ " in stock, " + getSoldQuantity() + " sold).";
    }
}
