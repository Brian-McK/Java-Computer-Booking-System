package com.dkit.sd2b.BrianMcKenna;

import java.time.LocalDate;

public class Laptop extends Computer
{
    // inches
    private double laptopScreenSize;
    private double batteryLife;

    public Laptop(String manufacturer, String processor, String ramSize, String diskSize, double weight,
                  String assetTag, String strPurchaseDate, double laptopScreenSize, double batteryLife)
    {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, strPurchaseDate);

        this.laptopScreenSize = laptopScreenSize;
        this.batteryLife = batteryLife;
    }

    public double getLaptopScreenSize()
    {
        return laptopScreenSize;
    }

    public void setLaptopScreenSize(double laptopScreenSize)
    {
        this.laptopScreenSize = laptopScreenSize;
    }

    public double getBatteryLife()
    {
        return batteryLife;
    }

    public void setBatteryLife(double batteryLife)
    {
        this.batteryLife = batteryLife;
    }
}
