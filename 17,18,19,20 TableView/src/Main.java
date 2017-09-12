import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
    Stage window;
    Scene scene ;
    Button btn;
    TableView <Product>table;
    TextField nameInput,priceInput,quantityInput;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window =primaryStage;
        window.setTitle("Java-Fx");
        btn= new Button("Click me");  
       
        //name coloumn
        TableColumn<Product,String>nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
         
        //price coloumn
        TableColumn<Product,Double>priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        //Quanatity coloumn
        TableColumn<Product,Integer>quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        //name Input
        nameInput= new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);
        
         //Price Input
        priceInput= new TextField();
        priceInput.setPromptText("Price");
        
         //Quantity Input
        quantityInput= new TextField();
        quantityInput.setPromptText("Quantity");
        
        //button
        Button addbtn = new Button("add");
        addbtn.setOnAction(e -> addbtnClicked());
        Button deletebtn = new Button("delete");
        deletebtn.setOnAction(e -> deletebtnClicked());
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(10);
        
        hbox.getChildren().addAll(nameInput,priceInput,quantityInput,addbtn,deletebtn);
        
        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);
        
        VBox layout= new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(table,hbox);
             
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    //get all products
    public ObservableList<Product>getProduct()
    {
        ObservableList<Product>products = FXCollections.observableArrayList();
        products.add(new Product("Laptop ",40000,230));
        products.add(new Product("Desktop",33333,220));
        products.add(new Product("Mobile ",50000,220));
        products.add(new Product("AC ",60000,20));
        products.add(new Product("Camera ",20000,240));
        return products;
        
    }
// add Button
    private void addbtnClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }
// delete button clicked
    private void deletebtnClicked() {
       ObservableList<Product>productSelected,allProducts;
       allProducts = table.getItems();
       productSelected = table.getSelectionModel().getSelectedItems();
       
       productSelected.forEach(allProducts::remove);
       
    }

    
}