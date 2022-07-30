package Entities;

public class employee 
{
    // Member variable declarations
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private float salary;

    // Constructor
    public employee (String firstName, String lastName, int age, float salary, int id)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.id = id;
    }

    // Getters
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public int getAge()
    {
        return age;
    }
    public float getSalary()
    {
        return salary;
    }
    public int getId()
    {
        return id;
    }

    // Setters
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setSalary(float salary)
    {
        this.salary = salary;
    }
    public void setId(int id)
    {
        this.id = id;
    }
}
