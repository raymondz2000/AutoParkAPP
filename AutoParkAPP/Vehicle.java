package AutoParkAPP;

public abstract class Vehicle extends Product{
    private String make;
    private String model;
    private int year;


    public Vehicle(double price, int quantity, String make, String model, int year){
        super(price, quantity);
        this.make = make;
        this.model = model;
        this.year = year;
   }

   public String getMake(){return make;}
   public String getModel(){return model;}
   public int getYear(){return year;}
   public double sellProd(int amount){return super.sellUnits(amount);}




}
