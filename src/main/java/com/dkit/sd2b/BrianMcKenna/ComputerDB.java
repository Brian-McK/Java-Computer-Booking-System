package com.dkit.sd2b.BrianMcKenna;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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

    public void removeComputerByAssetTag(String assetTag)
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

    public void loadComputersFromFile(String fileName)
    {
        File inputFile = new File(fileName);

        try (Scanner scan = new Scanner(inputFile))
        {
            while (scan.hasNextLine())
            {
                Computer comp = null;
                String line = scan.nextLine();
                String [] data = line.split(",");
                String assetTag = data[0];
                String manufacturer = data[1];
                String processor = data[2];
                String ramSize = data[3];

                if(assetTag.endsWith("D"))
                {
                    String diskSize = data[4];
                    double weight= Double.parseDouble(data[5]);
                    String purchaseDate = data[6];
                    String externalMonitor = data[7];
                    comp = new Desktop(assetTag,manufacturer,processor,ramSize,diskSize,weight,purchaseDate,
                            externalMonitor);
                }
                else if(assetTag.endsWith("L"))
                {
                    String diskSize = data[4];
                    double weight= Double.parseDouble(data[5]);
                    String purchaseDate = data[6];
                    double laptopScreenSize = Double.parseDouble(data[7]);
                    double batteryLife = Double.parseDouble(data[8]);
                    comp = new Laptop(assetTag,manufacturer,processor,ramSize,diskSize,weight,purchaseDate,
                            laptopScreenSize,batteryLife);
                }
                else if(assetTag.endsWith("RP"))
                {
                    double weight= Double.parseDouble(data[4]);
                    String purchaseDate = data[5];
                    int GPIOPins = Integer.parseInt(data[6]);
                    String sdCardSize = data[7];
                    comp = new RaspberryPi(assetTag,manufacturer,processor,ramSize,weight,purchaseDate,
                            GPIOPins,sdCardSize);
                }

//                Computer computer = new Computer(manufacturer,processor,ramSize,diskSize,weight,assetTag,purchaseDate);
                computers.add(comp);
            }

        } catch ( FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught." + exception);
        } catch (InputMismatchException exception)
        {
            System.out.println("InputMismatchexception caught." + exception);
        }

        displayData(computers);
    }

    public static void displayData(ArrayList<Computer> computersList)
    {
        for(Computer computer:computersList)
        {
            System.out.println(computer);
        }
    }
}
