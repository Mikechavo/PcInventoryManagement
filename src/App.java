import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private List<Part> inventory = new ArrayList<>();
    private TextField idField;
    private TextField nameField;
    private TextField brandField;
    private TextField quantityField;
    private TextField priceField;
    private TextField imageUrlField;
    private ComboBox<String> componentTypeComboBox;

    @Override
    public void start(Stage primaryStage) {
        // Create the tab pane to manage multiple views/tabs
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        // Create the inventory tab
        Tab inventoryTab = createInventoryTab();
        tabPane.getTabs().add(inventoryTab);
        
        // Create tabs for each component type
        for (String componentType : Part.COMPONENT_TYPES) {
            Tab componentTypeTab = createComponentTypeTab(componentType);
            tabPane.getTabs().add(componentTypeTab);
        }
        
        // Create the create tab
        Tab createTab = createCreateTab(tabPane);
        tabPane.getTabs().add(createTab);
        
        // Create the root layout using a VBox (vertical box) to hold the tab pane
        VBox rootLayout = new VBox(10);
        rootLayout.getChildren().add(tabPane);
        
        // Create the scene and set the root layout
        Scene scene = new Scene(rootLayout, 800, 600);
        
        // Set the scene in the primary stage
        primaryStage.setScene(scene);
        
        // Set the title of the primary stage
        primaryStage.setTitle("PC Part Inventory Management");
        
        // Show the primary stage
        primaryStage.show();
    }


    

    private TableView<Part> createTableView(String componentType) {
        // Create a table view to display components of the specified type
        TableView<Part> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    
        // Define table columns
        TableColumn<Part, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
    
        TableColumn<Part, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
    
        TableColumn<Part, String> brandColumn = new TableColumn<>("Brand");
        brandColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBrand()));
    
        TableColumn<Part, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());
    
        TableColumn<Part, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
    
        // Add columns to the table view
        tableView.getColumns().add(idColumn);
        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(brandColumn);
        tableView.getColumns().add(quantityColumn);
        tableView.getColumns().add(priceColumn);
    
        // Filter the inventory based on the component type
        List<Part> filteredInventory = new ArrayList<>();
        for (Part part : inventory) {
            if (part.getComponentType().equals(componentType)) {
                filteredInventory.add(part);
            }
        }
    
        // Add the filtered inventory to the table view
        tableView.setItems(FXCollections.observableArrayList(filteredInventory));
    
        return tableView;
    }
    private Tab createComponentTypeTab(String componentType) {
        // Create a tab for the given component type
        Tab componentTypeTab = new Tab(componentType);
    
        // Create a table view to display components of the specified type
        TableView<Part> tableView = createTableView(componentType);
    
        // Set the table view as the content of the tab
        componentTypeTab.setContent(tableView);
    
        return componentTypeTab;
    }
    



    private GridPane createCreateForm() {
        // Create labels and text fields for each attribute
        Label idLabel = new Label("ID:");
        idField = new TextField();

        Label nameLabel = new Label("Name:");
        nameField = new TextField();

        Label brandLabel = new Label("Brand:");
        brandField = new TextField();

        Label quantityLabel = new Label("Quantity:");
        quantityField = new TextField();

        Label priceLabel = new Label("Price:");
        priceField = new TextField();

        Label imageUrlLabel = new Label("Image URL:");
        imageUrlField = new TextField();

        // Create a drop-down menu for component type selection
        Label componentTypeLabel = new Label("Component Type:");
        componentTypeComboBox = new ComboBox<>();
        componentTypeComboBox.setItems(FXCollections.observableArrayList(Part.COMPONENT_TYPES));

        // Create the grid pane to layout the UI elements
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.addRow(0, idLabel, idField);
        gridPane.addRow(1, nameLabel, nameField);
        gridPane.addRow(2, brandLabel, brandField);
        gridPane.addRow(3, quantityLabel, quantityField);
        gridPane.addRow(4, priceLabel, priceField);
        gridPane.addRow(5, imageUrlLabel, imageUrlField);
        gridPane.addRow(6, componentTypeLabel, componentTypeComboBox);

        return gridPane;
    }

    private Tab createInventoryTab() {
        // Create a tab to display the inventory
        Tab inventoryTab = new Tab("Inventory");
    
        // Create a tab content with a table view displaying all components
        VBox inventoryContent = new VBox();
        inventoryContent.setSpacing(10);
    
        // Create a table view to display all components
        TableView<Part> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    
        // Define table columns
        TableColumn<Part, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
    
        TableColumn<Part, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
    
        TableColumn<Part, String> brandColumn = new TableColumn<>("Brand");
        brandColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBrand()));
    
        TableColumn<Part, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());
    
        TableColumn<Part, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
    
        // Add columns to the table view
        tableView.getColumns().add(idColumn);
        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(brandColumn);
        tableView.getColumns().add(quantityColumn);
        tableView.getColumns().add(priceColumn);
    
        // Set items in the table view (assuming `inventory` is properly initialized)
        tableView.setItems(FXCollections.observableArrayList(inventory));
    
        // Add the table view to the tab content
        inventoryContent.getChildren().add(tableView);
    
        // Set tab content
        inventoryTab.setContent(inventoryContent);
    
        return inventoryTab;
    }
    private Tab findComponentTypeTab(TabPane tabPane, String componentType) {
        for (Tab tab : tabPane.getTabs()) {
            if (tab.getText().equals(componentType)) {
                return tab;
            }
        }
        return null;
    }
    
    
    private Tab createCreateTab(TabPane tabPane) {
        // Create a tab for creating new components
        Tab createTab = new Tab("Create");
    
        // Create a grid pane for the create form
        GridPane createForm = createCreateForm();
    
        // Create a save button
        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            // Retrieve input values from the form fields
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String brand = brandField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());
            String imageUrl = imageUrlField.getText();
            String componentType = componentTypeComboBox.getValue();
    
            // Create a new Part object with the input values
            Part part = new Part(id, name, brand, quantity, price, imageUrl, componentType);
    
            // Add the new part to the inventory
            inventory.add(part);
    
            // Add the new part to the corresponding component type tab
            Tab componentTypeTab = findComponentTypeTab(tabPane, componentType);
            if (componentTypeTab != null) {
                TableView<Part> tableView = (TableView<Part>) componentTypeTab.getContent();
                tableView.getItems().add(part);
            }
    
            // Clear the form fields
            idField.clear();
            nameField.clear();
            brandField.clear();
            quantityField.clear();
            priceField.clear();
            imageUrlField.clear();
            componentTypeComboBox.getSelectionModel().clearSelection();
        });
    
        // Create a layout for the create tab
        VBox createTabLayout = new VBox(10, createForm, saveButton);
        createTabLayout.setPadding(new Insets(20));
    
        // Set the layout as the content of the create tab
        createTab.setContent(createTabLayout);
    
        return createTab;
    }
    


    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}


