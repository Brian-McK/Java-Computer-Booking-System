package com.dkit.sd2b.BrianMcKenna;

import java.time.LocalDate;
import java.util.Objects;

public class Computer
{
    private String assetTag; // ends with reference to type of computer
    private String manufacturer;
    private String processor;
    private String ramSize;
    private String diskSize;
    private double weight; // Kg
    private LocalDate purchaseDate;

    public Computer(String assetTag, String manufacturer, String processor, String ramSize, String diskSize, double weight,String strPurchaseDate)
    {
        this.assetTag = assetTag;
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.weight = weight;
        this.purchaseDate = LocalDate.parse(strPurchaseDate);
    }

    public Computer(String assetTag,String manufacturer, String processor, String ramSize, double weight, String strPurchaseDate)
    {
        this.assetTag = assetTag;
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = null;
        this.weight = weight;
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
                "assetTag='" + assetTag + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", processor='" + processor + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", diskSize='" + diskSize + '\'' +
                ", weight=" + weight +
                ", purchaseDate=" + purchaseDate +
                '}';
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(assetTag, manufacturer);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Double.compare(computer.weight, weight) == 0 &&
                Objects.equals(assetTag, computer.assetTag) &&
                Objects.equals(manufacturer, computer.manufacturer) &&
                Objects.equals(processor, computer.processor) &&
                Objects.equals(ramSize, computer.ramSize) &&
                Objects.equals(diskSize, computer.diskSize) &&
                Objects.equals(purchaseDate, computer.purchaseDate);
    }
}
