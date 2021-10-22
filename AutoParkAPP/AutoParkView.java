package AutoParkAPP;
// Raymond Zhu  101158903

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class AutoParkView extends Pane{

    //declear variable we used

    public double price,revenue,tot_r_by_s = 0;
    public int number_sales =0;
    public int first, second,third;

    private Product top1 = null,top2 = null,top3=null;

    private ListView<Product>    avaliableList,cartList,recommandList;
    private AutoPark carmodel;
    private Button  add,remove,reset,complete;
    private Label label1,label2,label3;
    private TextField tot_sales,tot_revenue,r_by_s;

    //get method for private variable
    public ListView<Product> getparkList() { return avaliableList; }
    public ListView<Product> getselectedList() { return cartList; }
    public Product gettop1(){return top1;}
    public Product gettop2(){return top2;}
    public Product gettop3(){return top3;}

    //set method for private variable (used in event handler)

    public void setSelectedList(Product selected){
        cartList.getItems().add(selected);
    }
    public void setDeleteList(Product item){
        avaliableList.getItems().remove(item);
    }

    public void setaddbackList(Product item){ avaliableList.getItems().add(item); }
    public void setcartbackList(Product item){
        cartList.getItems().remove(item);
    }

    //return button and listview
    public ListView<Product> getrecommandList() { return recommandList; }
    public Button getadd() {return add;};
    public Button getdelete() {return remove;}
    public Button getreset() {return reset;};
    public Button getcomplete() {return complete;};

    // update price (used in event handler)
    public void priceupdate(double price2) {
        price += price2;
        label2.setText("Your Cart ($"+ price +")");
    }
    //complete button event handler
    public void completed_sales(int number){
        number_sales=(number);
        tot_sales.setText(String.valueOf(number_sales));
        price = 0;
    }
    //calculate and set total revenue
    public void totalrevenue(){
        revenue += price;
        tot_revenue.setText(String.valueOf(revenue));
    }
    //calculate and set revenue by sales
    public void r_by_s(){
        float tot_r_by_s =(int) Math.round(revenue/number_sales);
        r_by_s.setText(String.valueOf(tot_r_by_s));
    }
    //reset textfield (used for reset button partially)
    public void reset(){
        tot_sales.setText("0");
        tot_revenue.setText("N/A");
        r_by_s.setText("0.0");
        label2.setText("Your Cart ($0.0)");
        price=0;
        revenue = 0;
        number_sales=0;
        tot_r_by_s=0;
    }
    //find top3 sales items
    public void looppark(){
        int first = 0, second = 0,third = 0;

        for (int i = 0; i < (cartList.getItems().size()); i++){

            int sold = cartList.getItems().get(i).getSoldQuantity();
            //avoiding duplicated
            if (sold > first && sold != second && sold != third){
                third =second;
                second=first;
                first = sold;
                top1 = cartList.getItems().get(i);
            }
            else if (sold > second && sold != first && sold != third){
                third = second;
                second = sold;
                top2=cartList.getItems().get(i);

            }
            else if (sold>third && sold != second && sold != first){

                third = sold;
                top3=cartList.getItems().get(i);

            }


        }

        /*
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println("----");
        System.out.println(top1);
        System.out.println(top2);
        System.out.println(top3);

         */


    }
    //random recommend list
    public void random(){
        first = (int)(Math.random() * 10);

        second = (int)(Math.random() * 10);

        if (first == second){
            second = (int)(Math.random() * 10);
        }

        third = (int)(Math.random() * 10);

        if(second == third || first == third){
            third = (int)(Math.random() * 10);
        }

    }

    public AutoParkView() {
        //get product
        carmodel = AutoPark.createPark();

        // Create the labels
        label1 = new Label("Available Items");
        label1.relocate(15, 15);

        label2 = new Label("Your Cart ($0.0)");

        label2.relocate(215, 15);

        label3 = new Label("Recommended Items");
        label3.relocate(415, 15);

        //Avaliable cars listview

        avaliableList = new ListView<Product>();

        avaliableList.relocate(10, 40);
        avaliableList.setPrefSize(190,280);
        //String[] avaliablecars = {};
        //ObservableList<String> carlist = FXCollections.observableArrayList(avaliablecars);
        for (int i = 0; i < (carmodel.getProducts()).length; i++){
            avaliableList.getItems().add(carmodel.getProducts()[i]);
        }


        //cart listview
        cartList = new ListView<Product>();
        cartList.relocate(210, 40);
        cartList.setPrefSize(190, 280);


        //recommand listview
        recommandList = new ListView<Product>();

        recommandList.relocate(410, 40);
        recommandList.setPrefSize(230, 130);
        random();
        recommandList.getItems().add(0,carmodel.getProducts()[first]);
        recommandList.getItems().add(1,carmodel.getProducts()[second]);
        recommandList.getItems().add(2,carmodel.getProducts()[third]);

        //create three buttons
        add = new Button("Add to Cart");
        add.relocate(80,340);
        add.setPrefSize(90,20);

        remove = new Button("Remove");
        remove.relocate(210,340);
        remove.setPrefSize(70,20);

        complete = new Button("Complete Sale");
        complete.relocate(300,340);
        complete.setPrefSize(100,20);

        reset = new Button("Reset AutoPark");
        reset.relocate(500,340);
        reset.setPrefSize(100,20);


        //summary info
        Label summary = new Label("Store Summary");
        summary.relocate(480,180);

        Label total_sale = new Label("Total Sales");
        total_sale.relocate(415,220);
        Label revenue = new Label("Total Revenue");
        revenue.relocate(415,260);
        Label r_by_sales = new Label("Revenue/Sales");
        r_by_sales.relocate(415,300);

        // Create the TextFields
        tot_sales = new TextField("0");
        tot_sales.relocate(500, 217);
        tot_sales.setPrefSize(130,5);
        tot_sales.setEditable(false);

        tot_revenue = new TextField("0.0");
        tot_revenue.relocate(500,255);
        tot_revenue.setPrefSize(130,5);
        tot_revenue.setEditable(false);

        r_by_s = new TextField("0.00");
        r_by_s.relocate(500,295);
        r_by_s.setPrefSize(130,5);
        r_by_s.setEditable(false);

        //add to panel
        getChildren().addAll(add,avaliableList,
                cartList,label1,label2,label3,
                remove,recommandList,complete,summary,total_sale,r_by_sales,revenue,tot_sales
                ,tot_revenue,r_by_s,reset);
        setPrefSize(660,390);
        setStyle("-fx-background-color: LINEN" );

    }



}
