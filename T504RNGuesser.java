import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class T504RNGuesser extends Application {

    private final int MAX = 100;
    private int RandomNum;
    private int attempts;

    private Label guessLabel;
    private TextField guessTextField;
    private Label Results;
    private Button Guesser;
    private Button Resetter;
    private Label Attempts;

    @Override
    public void start(Stage primaryStage) {
        // Generate a random number
        Random random = new Random();
        RandomNum = random.nextInt(MAX) + 1;

        // Initialize attempts
        attempts = 0;

        // Create UI components
        guessLabel = new Label("Enter your guess (1-100):");
        guessTextField = new TextField();
        Results = new Label();
        Guesser = new Button("Guess");
        Resetter = new Button("Reset");
        Attempts = new Label("Attempts: " + attempts);

        // Set event handlers
        Guesser.setOnAction(e -> checkGuess());
        Resetter.setOnAction(e -> resetGame());

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(guessLabel, guessTextField, Results, Guesser, Resetter, Attempts);

        // Scene
        Scene scene = new Scene(root, 300, 200);

        // Stage
        primaryStage.setTitle("RNGuesser");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessTextField.getText());
            if (guess < 1 || guess > MAX) {
                Results.setText("Please enter a valid guess (1-" + MAX + ")");
            } else {
                attempts++;
                Attempts.setText("Attempts: " + attempts);
                if (guess == RandomNum) {
                    Results.setText("Congratulations! You guessed the correct number.");
                    Guesser.setDisable(true);
                } else if (guess < RandomNum) {
                    Results.setText("Try a higher number.");
                } else {
                    Results.setText("Try a lower number.");
                }
            }
        } catch (NumberFormatException e) {
            Results.setText("Please enter a valid number.");
        }
    }

    private void resetGame() {
        Random random = new Random();
        RandomNum = random.nextInt(MAX) + 1;
        attempts = 0;
        Results.setText("");
        guessTextField.clear();
        Attempts.setText("Attempts: " + attempts);
        Guesser.setDisable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}