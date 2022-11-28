import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXPasswordGenerator extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    protected BufferedWriter output;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Passcode Generator");
        Button btn = new Button();
        btn.setText("Generate Passcode");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                Text t = new Text (100, 200, "This is a text sample");
                t.setText("Your new Passcode is" + Password());
                try {
                    output = new BufferedWriter(new FileWriter("Passcodes.txt", true));
                    output.append(Password());
                    output.newLine();
                    output.close();
            
                  } catch (IOException e) {
                    System.out.println("An error occurred.");
                }
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }


    
    public String Password() {
        Random random = new Random();
        StringBuilder s = new StringBuilder();

        for(int i = 0; i<5; i++) {
            int x = random.nextInt(10);
            s.append(x);
        } 

        String res = s.toString();  
        return res; 
    }
}





