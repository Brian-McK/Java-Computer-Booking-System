package com.dkit.sd2b.BrianMcKenna;

public class Laptop extends Computer
{
    private double laptopScreenSize;
    private double batteryLife;

    public Laptop(String assetTag,String manufacturer, String processor, String ramSize, String diskSize, double weight,
                   String strPurchaseDate, double laptopScreenSize, double batteryLife)
    {
        super(assetTag,manufacturer, processor, ramSize, diskSize, weight, strPurchaseDate);

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

    @Override
    public String toString()
    {
        return  super.toString() +
                "Laptop{" +
                "laptopScreenSize=" + laptopScreenSize +
                ", batteryLife=" + batteryLife +
                '}';
    }
}
