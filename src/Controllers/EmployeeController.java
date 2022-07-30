package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Constants.SystemConstants;

public class EmployeeController 
{    
    // CreateEmployee Param: Query Param
    
    public void CreateEmployee(String lastName, String firstName, int age, float salary)
    {
        try (Connection connection = DriverManager.getConnection(SystemConstants.URL, SystemConstants.USERNAME, SystemConstants.PASSWORD)) 
        {
            String query = "INSERT INTO employees (LastName, FirstName, Age, Salary) VALUES (?, ?, ?, ?)";
 
            PreparedStatement queryBuilder = connection.prepareStatement(query);
            queryBuilder.setString(1, lastName);
            queryBuilder.setString(2, firstName);
            queryBuilder.setInt(3, age);
            queryBuilder.setFloat(4, salary);
            queryBuilder.executeUpdate();
            
            // Close connection after transaction is complete
            connection.close();
        } 
        catch (SQLException e) 
        {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    // Deletes employee based on the given Employee ID
    public void DeleteEmployee(int id)
    {
        try (Connection connection = DriverManager.getConnection(SystemConstants.URL, SystemConstants.USERNAME, SystemConstants.PASSWORD)) 
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
    public void UpdateEmployee(int id, String lastName, String firstName, int age, float salary)
    {
        try (Connection connection = DriverManager.getConnection(SystemConstants.URL, SystemConstants.USERNAME, SystemConstants.PASSWORD))
        {
            String query = "UPDATE employees SET LastName = ?, FirstName = ?, Age = ?, Salary = ? WHERE id = ?";
        
            PreparedStatement queryBuilder = connection.prepareStatement(query);
            queryBuilder.setString(1, lastName);
            queryBuilder.setString(2, firstName);
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