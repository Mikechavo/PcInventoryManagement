import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Part part = new Part(1, "Ryzen 9 7900X3D", "AMD", 1, 599.99);
        primaryStage.setTitle("PC Part Inventory Management");

        // Create labels to display part details
        Label idLabel = new Label("ID: " + part.getId());
        Label nameLabel = new Label("Name: " + part.getName());
        Label brandLabel = new Label("Brand: " + part.getBrand());
        Label quantityLabel = new Label("Quantity: " + part.getQuantity());
        Label priceLabel = new Label("Price: $" + part.getPrice());

        // Load and display image
        ImageView imageView = new ImageView(new Image("images/ryzen97900x3d.jpg")); // Replace "processor.jpg" with the path to your image file
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        // Create a layout to hold the image and part details
        HBox imageAndDetailsLayout = new HBox(10);
        imageAndDetailsLayout.getChildren().addAll(imageView, new VBox(5, idLabel, nameLabel, brandLabel, quantityLabel, priceLabel));

        // Create the root layout using a VBox (vertical box)
        VBox rootLayout = new VBox(10); // Set spacing between components
        rootLayout.setStyle("-fx-padding: 20px; -fx-background-color: #f0f0f0;"); // Apply background color and padding
        rootLayout.getChildren().addAll(new Label("PC Part Details"), imageAndDetailsLayout);

        // Create the scene and set the root layout
        Scene scene = new Scene(rootLayout, 600, 400);

        // Set the scene in the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}


