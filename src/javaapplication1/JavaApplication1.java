/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 6302743
 */
public class JavaApplication1 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        //Task 1:
        BorderPane root = new BorderPane();
        ListView<String> BagList = new ListView<String>();
        String[]  bags = {"Full Decorative", "Beaded", "Pirate Design", "Fringed", 
            "Leather", "Plane"};
        BagList.setItems(FXCollections.observableArrayList(bags));
        BagList.setPrefSize(100, 100);
        Label listLabel = new Label("Select Bag Style: ");
        HBox center = new HBox(listLabel, BagList);
        
        ComboBox<Integer> quantity = new ComboBox<>();
        quantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Label boxLabel = new Label("Select Quantity: ");
        GridPane right = new GridPane();
        right.add(boxLabel, 0, 0);
        right.add(quantity, 1, 0);
        
        RadioButton small = new RadioButton("Small");
        RadioButton medium = new RadioButton("Medium");
        RadioButton large = new RadioButton("Large");
        ToggleGroup sizes = new ToggleGroup();
        small.setToggleGroup(sizes);
        medium.setToggleGroup(sizes);
        large.setToggleGroup(sizes);
        small.setSelected(true);
        VBox v = new VBox(small, medium, large);
        right.add(v, 0, 2);
        
        Button order = new Button("Order");
        Button clear = new Button("Clear");
        right.add(order, 0, 3);
        right.add(clear, 1, 3);
        right.setVgap(20);
        right.setHgap(10);
        
        Label message = new Label("");
        
        order.setOnAction(e -> {
            String bag = BagList.getSelectionModel().getSelectedItem();
            int num = quantity.getValue();
            String size = "";
            
            if (medium.isSelected()) {
                size = "small";
            } else if (large.isSelected()){
                size = "medium";
            } else  {
                size = "small";
            }
            message.setText("You ordered " + num + " " + size + " " + bag + " bags!");
        });
        
        clear.setOnAction(e -> {
            message.setText("");
            
            small.setSelected(true);
            quantity.setValue(null);
            BagList.getSelectionModel().select(null);
        });
        
        root.setCenter(center);
        root.setRight(right);
        root.setBottom(message);
        
        //Task 2
        GridPane root2 = new GridPane();
        root2.setAlignment(Pos.CENTER);
        root2.setVgap(25);
        
        
        ArrayList<MenuItem> bev = new ArrayList<MenuItem>();
        bev.add(new MenuItem("Coffee", 2.50));
        bev.add(new MenuItem("Juice", 1.75));
        bev.add(new MenuItem("Soft Drink", 1.75));
        bev.add(new MenuItem("Hot Chocolate", 2.25));
        
        ComboBox<String> beverages = new ComboBox<>();
        beverages.getItems().addAll("Coffee", "Juice", "Soft Drink", "Hot Chocolate", "None");
        root2.add(beverages, 1, 0);
        Label bevLabel = new Label("Select Beverage: ");
        root2.add(bevLabel, 0, 0);
        
        ArrayList<MenuItem> appet = new ArrayList<MenuItem>();
        appet.add(new MenuItem("Wings", 9.75));
        appet.add(new MenuItem("Salad", 6.50));
        appet.add(new MenuItem("Fries", 5.75));
        appet.add(new MenuItem("Soup", 6.25));
        
        ComboBox<String> appetizers = new ComboBox<>();
        appetizers.getItems().addAll("Wings", "Salad", "Fries", "Soup", "None");
        root2.add(appetizers, 1, 1);
        Label appetLabel = new Label("Select Appetizer: ");
        root2.add(appetLabel, 0, 1);
        
        ArrayList<MenuItem> main = new ArrayList<MenuItem>();
        main.add(new MenuItem("Steak", 21.50));
        main.add(new MenuItem("Pasta", 16.50));
        main.add(new MenuItem("Grilled Chicken", 19.50));
        main.add(new MenuItem("Pizza", 17.50));
        
        ComboBox<String> mainCourse = new ComboBox<>();
        mainCourse.getItems().addAll("Steak", "Pasta", "Grilled Chicken", "Pizza", "None");
        root2.add(mainCourse, 1, 2);
        Label mainLabel = new Label("Select Main Course: ");
        root2.add(mainLabel, 0, 2);
     
        ArrayList<MenuItem> desserts = new ArrayList<MenuItem>();
        desserts.add(new MenuItem("Tiramisu", 7.50));
        desserts.add(new MenuItem("Applie Pie", 5.75));
        desserts.add(new MenuItem("Ice Cream", 4.50));
        
        ComboBox<String> dessert = new ComboBox<>();
        dessert.getItems().addAll("Tiramisu", "Applie Pie", "Ice Cream", "None");
        root2.add(dessert, 1, 3);
        Label dessLabel = new Label("Select Dessert: ");
        root2.add(dessLabel, 0, 3);


        Button add = new Button("Add To Bill");
        root2.add(add, 0, 4);
        Button calculate = new Button("Calculate Bill");
        root2.add(calculate, 1, 4);
        Button clearBill = new Button("Clear Bill");
        root2.add(clearBill, 2, 4);
        Label total = new Label("");
        
        root2.add(total, 0, 6);
        
        Slider tip = new Slider(0.0, 20.0, 0.0);
        tip.setOrientation(Orientation.HORIZONTAL);
        tip.setShowTickMarks(true);
        tip.setMajorTickUnit(1);
        tip.setMinorTickCount(20);
        tip.setShowTickLabels(true);
        tip.setSnapToTicks(true);
        
        root2.add(tip, 1, 5);
        Label selectTip = new Label("Select Tip (%): ");
        root2.add(selectTip, 0, 5);
        
        ArrayList<MenuItem> bill = new ArrayList<>();
        
        add.setOnAction(e -> {
            if (beverages.getValue() != null) {
                for(MenuItem item : bev) {
                    if (item.getName().toUpperCase().equals(beverages.getValue().toUpperCase())) {
                        bill.add(item);
                    }
                }
            }
            if (appetizers.getValue() != null) {
                for(MenuItem item : appet) {
                    if (item.getName().toUpperCase().equals(appetizers.getValue().toUpperCase())) {
                        bill.add(item);
                    }
                }
            }
            if (mainCourse.getValue() != null) {
                for(MenuItem item : main) {
                    if (item.getName().toUpperCase().equals(mainCourse.getValue().toUpperCase())) {
                        bill.add(item);
                    }
                }
            }
            if (dessert.getValue() != null) {
                for(MenuItem item : desserts) {
                    if (item.getName().toUpperCase().equals(dessert.getValue().toUpperCase())) {
                        bill.add(item);
                    }
                }
            }
        });
        
        calculate.setOnAction(e -> {
            double billTotal = 0.0;
            for(MenuItem item : bill) {
                billTotal += item.getPrice();
            }
            billTotal = billTotal * (1 + (tip.getValue() / 100));
            billTotal = billTotal * 1.15; //Tax
            
            String print = String.format("Your total is: %.2f%n ", billTotal, "$");
            total.setText(print);
        });
        
        clearBill.setOnAction(e -> {
            bill.clear();
            tip.setValue(0);
            total.setText("");
            beverages.setValue(null);
            appetizers.setValue(null);
            mainCourse.setValue(null);
            dessert.setValue(null);
        });
        
        
        Scene s1 = new Scene(root, 400, 400);
        Scene s2 = new Scene(root2, 400, 400);
        
        //Choosing task
        Scanner scanner = new Scanner(System.in);
        System.out.println("What Task");
        int task = scanner.nextInt();
        
        if (task == 1) {
            stage.setScene(s1);
            stage.setTitle("Bag Order");
        } else if (task == 2) {
            stage.setScene(s2);
            stage.setTitle("Restaurant Bill");
        } else {
            System.out.println("Not a valid task!");
        }
        stage.show();
    }
    
    
}
