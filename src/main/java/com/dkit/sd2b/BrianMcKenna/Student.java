package com.dkit.sd2b.BrianMcKenna;

import java.util.ArrayList;

public class Student
{
    private String name;
    private int id;
    private String email;
    private String telephone;
    private ArrayList<Computer> computersOnLoan;

    public Student(String name, int id, String email, String telephone, ArrayList<Computer> computersOnLoan)
    {
        this.name = name;
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.computersOnLoan = computersOnLoan;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public ArrayList<Computer> getComputersOnLoan()
    {
        return computersOnLoan;
    }

    public void setComputersOnLoan(ArrayList<Computer> computersOnLoan)
    {
        this.computersOnLoan = computersOnLoan;
    }
}
