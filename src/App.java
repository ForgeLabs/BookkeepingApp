import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Controllers.ConnectionController;
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
     
        //LOGIN SCREEN SCENE
        Scene login = new Scene(layout, 300, 300);
        // Setup Text Fields
        TextField url_box = new TextField();
        url_box.setPromptText("Enter url");
        url_box.setMaxWidth(200);
        url_box.setAlignment(Pos.BASELINE_CENTER);
        TextField user_box = new TextField();
        user_box.setPromptText("Enter user");
        user_box.setMaxWidth(200);
        user_box.setAlignment(Pos.BASELINE_CENTER);
        TextField password_box = new TextField();
        password_box.setPromptText("Enter password");
        password_box.setMaxWidth(200);
        password_box.setAlignment(Pos.BASELINE_CENTER);

        Scene scene2 = new Scene(layout2, 300, 300);
         
        Label label1 = new Label("Enter db connection info:");
        Label label2 = new Label("This is the Second Scene");
        Label userCreatedLabel = new Label();
         
        Button connect_button = new Button("Connect");
        connect_button.setOnAction(e -> {
            ConnectionController.URL = url_box.getText();
            ConnectionController.USER = user_box.getText();
            ConnectionController.PASSWORD = password_box.getText();
            try (Connection connection = DriverManager.getConnection(ConnectionController.URL, ConnectionController.USER, ConnectionController.PASSWORD)) 
            {
                primaryStage.setScene(scene2);
                connection.close();
            } 
            catch (SQLException exception) 
            {
                throw new IllegalStateException("Cannot connect the database!", exception);
            }  
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

            if (employeeController.CreateEmployee(lastNameTextField.getText(), firstNameTextField.getText(), Integer.parseInt(ageTextField.getText()), Float.parseFloat(salaryTextField.getText())))
            {
                userCreatedLabel.setText("User created succesfully!");
            }
        });
         
        layout.getChildren().addAll(label1, url_box, user_box, password_box, connect_button);

        layout2.getChildren().addAll(label2, button2, lastNameTextField, firstNameTextField, ageTextField, salaryTextField, splitPane, userCreatedLabel);
        
        // Show View
        primaryStage.setTitle("BookkeepingApp");
        primaryStage.setScene(login);   
        primaryStage.show();
    }
}