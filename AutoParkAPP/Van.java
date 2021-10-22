package AutoParkAPP;

public class Van extends CommercialVehicle {
    private boolean covered;

    public Van(double price, int quantity, String make, String model, int year,
                 String carries, boolean c) {
        super(price, quantity, make, model, year, carries);
        this.covered = c;
    }

    public String toString(){
        String result = getMake() + " " + getModel();
        if(covered) result += " covered";
        return result += "Van ("+  getYear() + ") carries " + getCarries() +
                ", costs $" + String.format("%,.2f",getPrice()) + " each (" +getInvQuantity()+ " in stock, " + getSoldQuantity() + " sold).";
    }


}
