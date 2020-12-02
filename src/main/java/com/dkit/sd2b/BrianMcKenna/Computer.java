package com.dkit.sd2b.BrianMcKenna;

import java.time.LocalDate;

public class Computer
{
    private String manufacturer;
    private String processor;
    private String ramSize;
    private String diskSize;
    private double weight; // Kg
    private String assetTag;
    private LocalDate purchaseDate;

    public Computer(String manufacturer, String processor, String ramSize, String diskSize, double weight,
                    String assetTag, String strPurchaseDate)
    {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.weight = weight;
        this.assetTag = assetTag;
        this.purchaseDate = LocalDate.parse(strPurchaseDate);
    }

    public Computer(String manufacturer, String processor, String ramSize, double weight, String assetTag, String strPurchaseDate)
    {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = null;
        this.weight = weight;
        this.assetTag = assetTag;
        this.purchaseDate = LocalDate.parse(strPurchaseDate);
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getProcessor()
    {
        return processor;
    }

    public void setProcessor(String processor)
    {
        this.processor = processor;
    }

    public String getRamSize()
    {
        return ramSize;
    }

    public void setRamSize(String ramSize)
    {
        this.ramSize = ramSize;
    }

    public String getDiskSize()
    {
        return diskSize;
    }

    public void setDiskSize(String diskSize)
    {
        this.diskSize = diskSize;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public String getAssetTag()
    {
        return assetTag;
    }

    public void setAssetTag(String assetTag)
    {
        this.assetTag = assetTag;
    }

    public LocalDate getPurchaseDate()
    {
        return purchaseDate;
    }

    public void setPurchaseDate(String strPurchaseDate)
    {
        this.purchaseDate = LocalDate.parse(strPurchaseDate);
    }

    @Override
    public String toString()
    {
        return "Computer{" +
                "manufacturer='" + manufacturer + '\'' +
                ", processor='" + processor + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", diskSize='" + diskSize + '\'' +
                ", weight=" + weight +
                ", assetTag='" + assetTag + '\'' +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
