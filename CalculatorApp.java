import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

   private TextField num1Field;
   private TextField num2Field;
   private Label resultLabel;

   @Override
   public void start(Stage primaryStage) {
      primaryStage.setTitle("Simple Calculator");
   
      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(5);
      grid.setHgap(5);
   
      num1Field = new TextField();
      num1Field.setPromptText("Enter number 1");
      GridPane.setConstraints(num1Field, 0, 0);
   
      num2Field = new TextField();
      num2Field.setPromptText("Enter number 2");
      GridPane.setConstraints(num2Field, 0, 1);
   
      Button addButton = new Button("+");
      addButton.setOnAction(e -> calculate('+'));
      GridPane.setConstraints(addButton, 1, 0);
   
      Button subtractButton = new Button("-");
      subtractButton.setOnAction(e -> calculate('-'));
      GridPane.setConstraints(subtractButton, 1, 1);
   
      Button multiplyButton = new Button("*");
      multiplyButton.setOnAction(e -> calculate('*'));   
      GridPane.setConstraints(multiplyButton, 2, 0);
   
      Button divideButton = new Button("/");
      divideButton.setOnAction(e -> calculate('/'));
      GridPane.setConstraints(divideButton, 2, 1);
   
      resultLabel = new Label("Result:");
      GridPane.setConstraints(resultLabel, 0, 2);
   
      grid.getChildren().addAll(num1Field, num2Field, addButton, subtractButton, multiplyButton, divideButton, resultLabel);
   
      Scene scene = new Scene(grid, 300, 150);
      primaryStage.setScene(scene);
      primaryStage.show();
   }

   private void calculate(char operator) {
      try {
         double num1 = Double.parseDouble(num1Field.getText());
         double num2 = Double.parseDouble(num2Field.getText());
         double result = 0;
      
         switch (operator) {
            case '+':
               result = num1 + num2;
               break;
            case '-':
               result = num1 - num2;
               break;
            case '*':
               result = num1 * num2;
               break;
            case '/':
               if (num2 != 0) {
                  result = num1 / num2;
               } else {
                  resultLabel.setText("Error: Division by zero");
                  return;
               }
               break;
         }
      
         resultLabel.setText("Result: " + result);
      } catch (NumberFormatException e) {
         resultLabel.setText("Error: Invalid input");
      }
   }

   public static void main(String[] args) {
      launch(args);
   }
}
