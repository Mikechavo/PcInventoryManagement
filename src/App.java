import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Part part= new Part(1, "Processor", "Intel", 10, 199.99);
        primaryStage.setTitle("PC Part Inventory Management");

        // Create labels to display part details
        Label idLabel = new Label("ID: " + part.getId());
        Label nameLabel = new Label("Name: " + part.getName());
        Label brandLabel = new Label("Brand: " + part.getBrand());
        Label quantityLabel = new Label("Quantity: " + part.getQuantity());
        Label priceLabel = new Label("Price: $" + part.getPrice());

        // Create the root layout using a VBox (vertical box)
        VBox rootLayout = new VBox();
        rootLayout.getChildren().addAll(
            idLabel, 
            nameLabel, 
            brandLabel, 
            quantityLabel, 
            priceLabel
        );

        // Create the scene and set the root layout
        Scene scene = new Scene(rootLayout, 800, 600);

        // Set the scene in the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}

