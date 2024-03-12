import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PC Part Inventory Management");

        // Create a label to display a welcome message
        Label welcomeLabel = new Label("Welcome to PC Part Inventory Management!");

        // Create the root layout using a VBox (vertical box)
        VBox rootLayout = new VBox();
        rootLayout.getChildren().add(welcomeLabel); // Add the welcome label to the layout

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
