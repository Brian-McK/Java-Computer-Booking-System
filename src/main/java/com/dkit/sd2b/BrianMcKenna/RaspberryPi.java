package com.dkit.sd2b.BrianMcKenna;

import java.time.LocalDate;

public class RaspberryPi extends Computer
{
    private int GPIOPins;
    private int sdCardSize;

    public RaspberryPi(String manufacturer, String processor, String ramSize, String diskSize, double weight,
                       String assetTag, LocalDate purchaseDate, int GPIOPins, int sdCardSize)
    {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate);

        this.GPIOPins = GPIOPins;
        this.sdCardSize = sdCardSize;
    }

    public int getGPIOPins()
    {
        return GPIOPins;
    }

    public void setGPIOPins(int GPIOPins)
    {
        this.GPIOPins = GPIOPins;
    }

    public int getSdCardSize()
    {
        return sdCardSize;
    }

    public void setSdCardSize(int sdCardSize)
    {
        this.sdCardSize = sdCardSize;
    }
}
