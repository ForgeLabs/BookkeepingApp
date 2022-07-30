import java.sql.Connection;
import java.sql.PreparedStatement;
import Controllers.EmployeeController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application
{
    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args)
    {
        // connenction_configuration.initConnection();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // window = primaryStage;
        // Label label1 = new Label("Welcome to first scene");
        // Button button1 = new Button("Go to scene 2");
        // button1.setOnAction(e -> window.setScene(scene2));

        VBox layout = new VBox();
        VBox layout2 = new VBox();
        layout.setAlignment(Pos.CENTER);
     
        Scene scene = new Scene(layout, 300, 300);
        Scene scene2 = new Scene(layout2, 300, 300);
         
        Label label1 = new Label("This is the First Scene");
        Label label2 = new Label("This is the Second Scene");
         
        Button button = new Button("Forward");
        button.setOnAction(e -> {
            primaryStage.setScene(scene2);
        });

        SplitPane splitPane = new SplitPane();
        splitPane.setMaxWidth(200);

        // Setup Text Fields
        TextField lastNameTextField = new TextField();
        lastNameTextField.setMaxWidth(200);
        lastNameTextField.setAlignment(Pos.BASELINE_LEFT);
        lastNameTextField.setPromptText("Enter last name");

        TextField firstNameTextField = new TextField();
        firstNameTextField.setMaxWidth(200);
        firstNameTextField.setAlignment(Pos.BASELINE_LEFT);
        firstNameTextField.setPromptText("Enter first name");

        TextField ageTextField = new TextField();
        ageTextField.setMaxWidth(200);
        ageTextField.setAlignment(Pos.BASELINE_LEFT);
        ageTextField.setPromptText("Enter age");

        TextField salaryTextField = new TextField();
        salaryTextField.setMaxWidth(200);
        salaryTextField.setAlignment(Pos.BASELINE_LEFT);
        salaryTextField.setPromptText("Enter salary");

        Button button2 = new Button("Query");
        button2.setOnAction(e -> 
        {
            EmployeeController employeeController = new EmployeeController();

            employeeController.CreateEmployee(lastNameTextField.getText(), firstNameTextField.getText(), Integer.parseInt(ageTextField.getText()), Float.parseFloat(salaryTextField.getText()));
        });
         
        layout.getChildren().addAll(label1, button);

        layout2.getChildren().addAll(label2, button2, lastNameTextField, firstNameTextField, ageTextField, salaryTextField, splitPane);
        
        // Show View
        primaryStage.setTitle("BookkeepingApp");
        primaryStage.setScene(scene);   
        primaryStage.show();
    }
}