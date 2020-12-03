package com.dkit.sd2b.BrianMcKenna;

import java.util.ArrayList;

public class Student
{
    private String name;
    private String studentId;
    private String email;
    private String telephone;
    private ArrayList<Computer> computersOnLoan;
    // could be strings too

    public Student(String name, String studentId, String email, String telephone, ArrayList<Computer> computersOnLoan)
    {
        this.name = name;
        this.studentId = studentId;
        this.email = email;
        this.telephone = telephone;
        this.computersOnLoan = computersOnLoan;
    }

    public Student(String name, String studentId, String email, String telephone)
    {
        this.name = name;
        this.studentId = studentId;
        this.email = email;
        this.telephone = telephone;
        this.computersOnLoan = null;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return studentId;
    }

    public void setId(String studentId)
    {
        this.studentId = studentId;
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

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", computersOnLoan=" + computersOnLoan +
                '}';
    }
}
