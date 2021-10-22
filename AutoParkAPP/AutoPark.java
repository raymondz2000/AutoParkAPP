package AutoParkAPP;

// Raymond Zhu  101158903

public class AutoPark{

    final int MAX_PROD = 10;
    public static int totprod;

    private String name;
    private double revenue;
    private Product[] products;

    public AutoPark(String name){
        this.name = name;
        revenue = 0;
        products = new Product[MAX_PROD];
        totprod = 0;
    }
    //original code, not used
    public String getName(){return name;}
    public double getRevenue(){ return revenue;}

    public Product[] getProducts(){return products;}

    public boolean addProduct(Product p){
        if(totprod < MAX_PROD){
            products[totprod] = p;
            totprod++;
            return true;
        }
        return false;
    }
    //original code, not used
    public void displayAllProducts(){
        for(int i = 0; i< totprod; i++){
            System.out.println(products[i]);
        }
    }
    //original code, not used
    public void sellProducts(int index, int amount){
        if(index >= 0 && index < totprod){
           if(products[index].getInvQuantity() >= amount){
               revenue += products[index].sellUnits(amount);

           }
           else {
               System.out.println("Not enough items in Stock");
           }
        }
    }

    public static AutoPark createPark(){
        AutoPark park = new AutoPark("Carleton");

        Sedan s1 = new Sedan(100, 10, "Ford", "Model-1", 2018, "White");
        Sedan s2 = new Sedan(200, 10, "Honda", "Model-2", 2019, "Red");
        park.addProduct(s1);
        park.addProduct(s2);

        SUV suv1 = new SUV(300, 10, "Ford", "Model-1", 2018, "White",true);
        SUV suv2 = new SUV(400, 10, "Honda", "Model-2", 2019, "Red",false);
        park.addProduct(suv1);
        park.addProduct(suv2);
        Truck t1 = new Truck(500, 10, "Ford", "Model-1", 2018, "goods",true);
        Truck t2 = new Truck(600, 10, "Honda", "Model-2", 2019, "people",false);
        park.addProduct(t1);
        park.addProduct(t2);
        Van v1 = new Van(700, 10, "Ford", "Model-1", 2018, "goods",true);
        Van v2 = new Van(800, 10, "Honda", "Model-2", 2019, "people",false);
        park.addProduct(v1);
        park.addProduct(v2);
        Tire tire1 = new Tire(900, 20, 14, 35, true);
        Tire tire2 = new Tire(1000, 20, 14, 45, false);
        park.addProduct(tire1);
        park.addProduct(tire2);
        return park;
    }

}
