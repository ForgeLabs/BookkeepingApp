package Entities;

public class business 
{
    // Member variable declarations
    String name;
    float networth;
    int employeeCount;

    // Constructor
    public business (String name, float networth, int employeeCount)
    {
        this.name = name;
        this.networth = networth;
        this.employeeCount = employeeCount;
    }

    // Geters
    public String getName()
    {
        return name;
    }
    public float getNetWorth()
    {
        return networth;
    }
    public int getEmployeeCount()

    {
        return employeeCount;
    }

    // Setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setNetWorth(float networth)
    {
        this.networth = networth;
    }
    public void setEmployeeCount(int employeeCount)
    {
        this.employeeCount = employeeCount;
    }
}
