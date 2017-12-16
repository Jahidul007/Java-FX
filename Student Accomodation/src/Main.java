import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class Main extends Application {
    Stage window;
    Scene scene ;
    Button btn;
    TableView <Product>table;
    TextField nameInput,addressInput,numberInput,txtField,searchField;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window =primaryStage;
        window.setTitle("Student Accomodation System");
        
        //name coloumn
        TableColumn<Product,String>nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
         
        //price coloumn
        TableColumn<Product,String>addressColumn = new TableColumn<>("Address");
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        
        //Quanatity coloumn
        TableColumn<Product,String>numberColumn = new TableColumn<>("Phone");
        numberColumn.setMinWidth(100);
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        
        //name Input
        nameInput= new TextField();
        nameInput.setPromptText("Name");
        
        
         //Price Input
        addressInput= new TextField();
        addressInput.setPromptText("Address");
        
         //Quantity Input
        numberInput= new TextField();
        numberInput.setPromptText("Phone");
        
        txtField= new TextField();
        txtField.setPromptText("Search");
        
        Button searchBtn = new Button("Search");
        searchBtn.setOnAction(e-> searchButtonClicked());
        
        //button
        Button addbtn = new Button("add");
        addbtn.setOnAction(e -> addbtnClicked());
        Button deletebtn = new Button("delete");
        deletebtn.setOnAction(e -> deletebtnClicked());
        
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e->window.close());
        
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(10);
        
        hbox.getChildren().addAll(nameInput,addressInput,numberInput,addbtn,deletebtn,searchBtn);
        hbox.setBackground(new Background(new BackgroundFill(Color.GRAY,CornerRadii.EMPTY,Insets.EMPTY)));
        table = new TableView<>();
        table.setItems(getProduct());
        table.setBackground(new Background(new BackgroundFill(Color.RED,CornerRadii.EMPTY,Insets.EMPTY)));
        table.getColumns().addAll(nameColumn,addressColumn,numberColumn);
        
        
         
        VBox layout= new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(table,hbox,closeButton);
        layout.setBackground(new Background(new BackgroundFill(Color.GRAY.brighter(),CornerRadii.EMPTY,Insets.EMPTY)));  
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
        products.add(new Product("Fahim","comilla","01721064085"));
        products.add(new Product("Jahid","B.baria","01544446513"));
        products.add(new Product("Sabbir","comilla","01687833220"));
        return products;
        
    }
// add Button
    private void addbtnClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setAddress(addressInput.getText());
        product.setPhone(numberInput.getText());
        table.getItems().add(product);
        nameInput.clear();
        addressInput.clear();
        numberInput.clear();
    }
// delete button clicked
    private void deletebtnClicked() {
       ObservableList<Product>productSelected,allProducts;
       allProducts = table.getItems();
       productSelected = table.getSelectionModel().getSelectedItems();
       
       productSelected.forEach(allProducts::remove);
       
    }

    private void searchButtonClicked() {
        Stage window = new Stage();
        TableView<Product> table;
        
         TableColumn<Product,String>nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
         
        //price coloumn
        TableColumn<Product,String>addressColumn = new TableColumn<>("Address");
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        
        //Quanatity coloumn
        TableColumn<Product,String>numberColumn = new TableColumn<>("Phone");
        numberColumn.setMinWidth(100);
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        table = new TableView<>();
        table.getColumns().addAll(nameColumn, addressColumn, numberColumn);
        TextField searchField = new TextField();
        searchField.setPromptText("Searching key");
        
        Button searchByName, searchByAddress, searchByPhone, closeButton;
        
        searchByName = new Button("Search By Name");
        searchByName.setOnAction(e->{
            searchByName(table,searchField.getText());
        });
        
        searchByAddress = new Button("Search By Address");
        searchByAddress.setOnAction(e->{
            searchByAddress(table,searchField.getText());
           
        });
        
        searchByPhone = new Button("Search By Phone");
        searchByPhone.setOnAction(e->{
            searchByPhone(table,searchField.getText());
        });
        
        closeButton = new Button("Close");
        closeButton.setOnAction(e->window.close());
        
        HBox buttonLayout = new HBox();
        buttonLayout.setPadding(new Insets(10,10,10,10));
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setSpacing(10);
        buttonLayout.getChildren().addAll(searchByName, searchByAddress,searchByPhone);
       
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.getChildren().addAll(searchField, buttonLayout, table, closeButton);
        vbox.setBackground(new Background(new BackgroundFill(Color.BROWN,CornerRadii.EMPTY,Insets.EMPTY)));

        
        Scene scene = new Scene(vbox,516.3,360);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Search");
        window.setScene(scene);
        window.setResizable(true);
        window.showAndWait();
        
        //String str;
        ObservableList<Product> allStudents;
        allStudents = this.table.getItems();
        table.getItems().clear();
        for(Product student:allStudents){
            String str = null;
            if(student.getName().equalsIgnoreCase(str))
            table.getItems().add(student);
        }
    }

    //searchByName
    private void searchByName(TableView<Product> table, String str) {
         ObservableList<Product> allStudents;
        allStudents = this.table.getItems();
        table.getItems().clear();
        for(Product student:allStudents){
            if(student.getName().equalsIgnoreCase(str))
            table.getItems().add(student);             
        }
        
    }

    //searchByAddress
    private void searchByAddress(TableView<Product> table, String str) {
         ObservableList<Product> allStudents;
        allStudents = this.table.getItems();
        table.getItems().clear();
        for(Product student:allStudents){
            if(student.getAddress().equalsIgnoreCase(str))
            table.getItems().add(student);
        }
        
    
    }

    //searchByaddress
    private void searchByPhone(TableView<Product> table, String str) {
         ObservableList<Product> allStudents;
        allStudents = this.table.getItems();
        table.getItems().clear();
        for(Product student:allStudents){
            if(student.getPhone().equalsIgnoreCase(str))
            table.getItems().add(student);
        }
     
    }

    
}