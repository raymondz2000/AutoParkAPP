package AutoParkAPP;
// Raymond Zhu  101158903
import javafx.application.Application;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.stage.StageStyle.*;

public class AutoParkAPP extends Application {
    int salesnum = 0;
    int reset = 0;
    public void startAutoParkapp(Stage Stage) {

        Pane aPane = new Pane();

        AutoParkView view = new AutoParkView();
        aPane.getChildren().add(view);

        //inialize buttons attribute
        view.getdelete().setDisable(true);
        view.getadd().setDisable(true);
        view.getcomplete().setDisable(true);

        //check if reset been clicked
        if (reset > 0){
            view.reset();
        }

        //define an event handler
        view.getparkList().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getadd().setDisable(false);
                view.getdelete().setDisable(true);
                //view.getdelete().setDisable(false);
            }});
        //define an event handler
        view.getselectedList().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                view.getadd().setDisable(true);
                if(view.getselectedList().getItems().size()!=0){
                    view.getdelete().setDisable(false);
                }
            }});
        //define an event handler
        view.getrecommandList().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getdelete().setDisable(true);
                view.getadd().setDisable(true);

            }});


        // Define an event handler
        view.getadd().setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {

                view.getcomplete().setDisable(false);

                Product selected = view.getparkList().getSelectionModel().getSelectedItem();

                selected.sellUnits(1);


                view.setSelectedList(selected);

                int times = selected.getInvQuantity() + selected.getSoldQuantity();

                if (selected.getSoldQuantity() == times){
                    view.setDeleteList(selected);

                }

                view.getselectedList().getSelectionModel().selectIndices(0);

                double price = selected.getPrice();


                view.priceupdate(price);

                view.getdelete().setDisable(false);

                if(view.getparkList().getItems().size()==0){
                    view.getadd().setDisable(false);
                }
            }
        });

        //Define an event handler
        view.getdelete().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                Product deleted = view.getselectedList().getSelectionModel().getSelectedItem();
                //int index = view.getselectedList().getSelectionModel().getSelectedIndex();
                double price = deleted.getPrice();

                deleted.sellUnits(-1);

                if(view.getparkList().getItems().contains(deleted) == false){
                    view.setaddbackList(deleted);
                }
                view.setcartbackList(deleted);
                view.priceupdate(-price);
                if(view.getselectedList().getItems().size()==0){
                    view.getdelete().setDisable(true);
                    view.getcomplete().setDisable(true);
                }

            }
        });
        //define an event handler
        view.getcomplete().setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {

                view.looppark();

                salesnum++;
                view.getcomplete().setDisable(true);
                view.getadd().setDisable(true);
                view.getdelete().setDisable(true);

                view.totalrevenue();
                view.completed_sales(salesnum);
                view.priceupdate(0);

                view.getselectedList().getItems().clear();
                view.r_by_s();

                view.getreset().requestFocus();

                if (view.gettop1() != null&& (view.getrecommandList().getItems().equals(view.gettop1())==false)){

                    view.getrecommandList().getItems().set(0,view.gettop1());
                }
                if (view.gettop2() != null && (view.getrecommandList().getItems().equals(view.gettop2())==false)){

                    view.getrecommandList().getItems().set(1,view.gettop2());

                }
                if (view.gettop3() != null && (view.getrecommandList().getItems().equals(view.gettop3())==false)){

                    view.getrecommandList().getItems().set(2,view.gettop3());
                }
            }
        });
        //Define an event handler
        view.getreset().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                reset++;
                startAutoParkapp(Stage);

                salesnum=0;
            }
        });


        //create the view

        Stage.getIcons().add(new Image(getClass().getResourceAsStream("parking.png")));
        Stage.setTitle("AutoPark Sales View");
        Stage.setResizable(true);
        Stage.setScene(new Scene(aPane));
        Stage.show();



    }
    //restart
    @Override
    public void start(Stage primaryStage){
        startAutoParkapp(primaryStage);

    }
    public static void main(String[] args) {
        launch(args);
    }


}
