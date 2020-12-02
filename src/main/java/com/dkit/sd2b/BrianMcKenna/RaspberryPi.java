package com.dkit.sd2b.BrianMcKenna;

public class RaspberryPi extends Computer
{
    private int GPIOPins;
    private String sdCardSize;

    public RaspberryPi(String manufacturer, String processor, String ramSize, double weight,
                       String assetTag, String strPurchaseDate, int GPIOPins, String sdCardSize)
    {
        super(manufacturer, processor, ramSize, weight, assetTag, strPurchaseDate);

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

    public String getSdCardSize()
    {
        return sdCardSize;
    }

    public void setSdCardSize(String sdCardSize)
    {
        this.sdCardSize = sdCardSize;
    }
}
