package com.dkit.sd2b.BrianMcKenna;

import java.util.ArrayList;

public class ComputerDB
{
    ArrayList<Computer> computers;

    public ComputerDB(ArrayList<Computer> computers)
    {
        this.computers = computers;
    }

    public ComputerDB()
    {
        this.computers = new ArrayList<>();
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

    public Computer findComputerByAssetTag(String assetTag)
    {
        for (int i = 0; i < computers.size(); i++)
        {
            if (computers.get(i).getAssetTag().equals(assetTag))
            {
                return computers.get(i);
            }
        }
        return null;
    }

    public void removeComputerById(String assetTag)
    {
        Computer computer = findComputerByAssetTag(assetTag);

        if(computer != null)
        {
            computers.remove(computer);
        }
    }

    @Override
    public String toString()
    {
        return "ComputerDB{" +
                "computers=" + computers +
                '}';
    }
}
