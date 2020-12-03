package com.dkit.sd2b.BrianMcKenna;

import java.util.ArrayList;

public class ComputerDB
{
    ArrayList<Computer> computers;

    public ComputerDB(ArrayList<Computer> computers)
    {
        this.computers = computers;
    }

    public ArrayList<Computer> getComputer()
    {
        return computers;
    }

    public void setComputer(ArrayList<Computer> computers)
    {
        this.computers = computers;
    }

    public void addComputer(Computer computer)
    {
        // need to validate if null
        this.computers.add(computer);
    }

    public void removeComputer(Computer computer)
    {
        // need to validate if null
        this.computers.remove(computer);
    }
}