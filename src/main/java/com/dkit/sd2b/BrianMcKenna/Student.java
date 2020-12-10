package com.dkit.sd2b.BrianMcKenna;

import java.util.ArrayList;

public class Student
{
    private String studentId;
    private String name;
    private String email;
    private String telephone;
    private ArrayList<String> computersOnLoan;

    public Student(String studentId, String name, String email, String telephone, ArrayList<String> computersOnLoan)
    {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.computersOnLoan = computersOnLoan;
    }

    public Student(String studentId, String name, String email, String telephone)
    {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.computersOnLoan = new ArrayList<>();
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

    public ArrayList<String> getComputersOnLoan()
    {
        return computersOnLoan;
    }

    public void setComputersOnLoan(ArrayList<String> computersOnLoan)
    {
        this.computersOnLoan = computersOnLoan;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", computersOnLoan=" + computersOnLoan +
                '}';
    }
}
