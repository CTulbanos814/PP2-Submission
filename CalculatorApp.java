import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class T505Calcu extends Application {

   private TextField Num1;
   private TextField Num2;
   private Label Results;

   @Override
   public void start(Stage primaryStage) {
      primaryStage.setTitle("Simp Cal");
   
      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(5);
      grid.setHgap(5);
   
      Num1 = new TextField();
      Num1.setPromptText("Enter number 1");
      GridPane.setConstraints(Num1, 0, 0);
   
      Num2 = new TextField();
      Num2.setPromptText("Enter number 2");
      GridPane.setConstraints(Num2, 0, 1);
   
      Button Add = new Button("+");
      Add.setOnAction(e -> calculate('+'));
      GridPane.setConstraints(Add, 1, 0);
   
      Button Sub = new Button("-");
      Sub.setOnAction(e -> calculate('-'));
      GridPane.setConstraints(Sub, 1, 1);
   
      Button Multi = new Button("*");
      Multi.setOnAction(e -> calculate('*'));   
      GridPane.setConstraints(Multi, 2, 0);
   
      Button Divide = new Button("/");
      Divide.setOnAction(e -> calculate('/'));
      GridPane.setConstraints(Divide, 2, 1);
   
      Results = new Label("Result:");
      GridPane.setConstraints(Results, 0, 2);
   
      grid.getChildren().addAll(Num1, Num2, Add, Sub, Multi, Divide, Results);
   
      Scene scene = new Scene(grid, 300, 150);
      primaryStage.setScene(scene);
      primaryStage.show();
   }

   private void calculate(char Ope) {
      try {
         double num1 = Double.parseDouble(Num1.getText());
         double num2 = Double.parseDouble(Num2.getText());
         double result = 0;
      
         switch (Ope) {
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
                  Results.setText("Error: Division by zero");
                  return;
               }
               break;
         }
      
         Results.setText("Result: " + result);
      } catch (NumberFormatException e) {
         Results.setText("Error: Invalid input");
      }
   }

   public static void main(String[] args) {
      launch(args);
   }
}
