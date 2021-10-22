package AutoParkAPP;
// Raymond Zhu  101158903
public class Tire extends Product{
    int wheelDiameter;
    int sectionWidth;
    boolean passengerTire;

    public Tire(double p, int quantity, int w, int s, boolean pt){
        super(p,quantity);
        this.wheelDiameter = w;
        this.sectionWidth = s;
        this.passengerTire = pt;
    }

    public String toString(){
        String result = "";
        if(passengerTire) {
            result += "Passenger tire";
        } else {
            result = "Tire";
        }
        return result + " with " + wheelDiameter + "in. wheel diameter " + sectionWidth +
                " mm. section width, costs $" + String.format("%,.2f",getPrice()) + " each (" + getInvQuantity() +" in stock, " + getSoldQuantity()
                + " sold).";
    }

    public double sellProd(int amount){return super.sellUnits(amount);}
}
