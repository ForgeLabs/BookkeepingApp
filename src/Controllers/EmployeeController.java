package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeController 
{    
    // CreateEmployee Param: Query Param
    
    public boolean CreateEmployee(String firstName, String lastName, int age, float salary)
    {
        boolean result = false;

        try (Connection connection = DriverManager.getConnection(ConnectionController.URL, ConnectionController.USER, ConnectionController.PASSWORD)) 
        {
            String query = "INSERT INTO employees (FirstName, LastName, Age, Salary) VALUES (?, ?, ?, ?)";
 
            PreparedStatement queryBuilder = connection.prepareStatement(query);
            queryBuilder.setString(1, firstName);
            queryBuilder.setString(2, lastName);
            queryBuilder.setInt(3, age);
            queryBuilder.setFloat(4, salary);
            queryBuilder.executeUpdate();
            result = true;
            
            // Close connection after transaction is complete
            connection.close();
        } 
        catch (SQLException e) 
        {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        return result;
    }

    // Deletes employee based on the given Employee ID
    public void DeleteEmployee(int id)
    {
        try (Connection connection = DriverManager.getConnection(ConnectionController.URL, ConnectionController.USER, ConnectionController.PASSWORD)) 
        {
            String query = "DELETE FROM employees WHERE id = ?";

            PreparedStatement queryBuilder = connection.prepareStatement(query);
            queryBuilder.setInt(1, id);
            queryBuilder.executeUpdate();

            // Close connection after transaction is complete
            connection.close();
        } 
        catch (SQLException e) 
        {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    //Updates an employee by id with new entries
    public void UpdateEmployee(int id, String firstName, String lastName, int age, float salary)
    {
        try (Connection connection = DriverManager.getConnection(ConnectionController.URL, ConnectionController.USER, ConnectionController.PASSWORD)) 
        {
            String query = "UPDATE employees SET FirstName = ?, LastName = ?, Age = ?, Salary = ? WHERE id = ?";
        
            PreparedStatement queryBuilder = connection.prepareStatement(query);
            queryBuilder.setString(1, firstName);
            queryBuilder.setString(2, lastName);
            queryBuilder.setInt(3, age);
            queryBuilder.setFloat(4, salary);
            queryBuilder.setInt(5, id);
            queryBuilder.executeUpdate();

            // Close connection after transaction is complete
            connection.close();
        }
        catch (SQLException e) 
        {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}