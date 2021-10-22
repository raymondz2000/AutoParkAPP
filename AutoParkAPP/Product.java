package AutoParkAPP;
// Raymond Zhu  101158903
public abstract class Product {
    private double price;
    private int invQuantity;
    private int soldQuantity;

    public Product(double price, int invQuantity){
        this.price = price;
        this.invQuantity = invQuantity;
        this.soldQuantity = 0;
    }

    public double sellUnits(int amount){
        if( amount > 0 && invQuantity >= amount){
            invQuantity -= amount;
            soldQuantity += amount;
            return amount * price;
        }
        if(amount < 0){
            invQuantity += -amount;
            soldQuantity -= -amount;
            return -(amount * price);
        }
        return 0.0;
    }

    public double getPrice(){return price;}
    public int getInvQuantity(){return invQuantity;}
    public int getSoldQuantity(){return soldQuantity;}
    public abstract String toString();
}
