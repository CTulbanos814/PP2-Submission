import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PushMe extends Application {
    private TextField pushMeTextField;
    private Label pushMeLabel;

    @Override
    public void start(Stage stage) {
        // create and configure a text field for user entry
        pushMeTextField = new TextField();
        pushMeTextField.setMaxWidth(250);

        // create and configure a label to display the output
        pushMeLabel = new Label();
        pushMeLabel.setTextFill(Color.BLACK);
        pushMeLabel.setFont(Font.font("Arial", 20));

        // create and configure the button to perform the action
        Button pushMeButton = new Button();
        pushMeButton.setText("Start");
        pushMeButton.setOnAction(e -> pushMeLabel.setText(pushMeTextField.getText()));

        // create and configure the button to convert text to upper case
        Button upperCaseButton = new Button();
        upperCaseButton.setText("Convert to Upper Case");
        upperCaseButton.setOnAction(e -> convertToUpperCase());

        // create and configure the button to convert text to lower case
        Button lowerCaseButton = new Button();
        lowerCaseButton.setText("Convert to Lower Case");
        lowerCaseButton.setOnAction(e -> convertToLowerCase());

        // create and configure the button to reset the text field and label
        Button resetButton = new Button();
        resetButton.setText("Reset");
        resetButton.setOnAction(e -> resetFields());

        // create and configure a VBox to hold our components
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        // add the components to the VBox
        root.getChildren().addAll(pushMeTextField, pushMeButton, upperCaseButton, lowerCaseButton, resetButton, pushMeLabel);

        // create a new scene
        Scene scene = new Scene(root, 350, 250);

        // add the scene to the stage, then configure the stage and make it visible
        stage.setScene(scene);
        stage.setTitle("Made by: Charles Tulbanos");
        stage.show();
    }

    // Method to convert text to upper case
    private void convertToUpperCase() {
        String text = pushMeTextField.getText();
        pushMeLabel.setText(text.toUpperCase());
    }

    // Method to convert text to lower case
    private void convertToLowerCase() {
        String text = pushMeTextField.getText();
        pushMeLabel.setText(text.toLowerCase());
    }

    // Method to reset the text field and label to their initial states
    private void resetFields() {
        pushMeTextField.setText(""); // Clear the text field
        pushMeLabel.setText(""); // Clear the label
    }

    public static void main(String[] args) {
        launch(args);
    }
}
