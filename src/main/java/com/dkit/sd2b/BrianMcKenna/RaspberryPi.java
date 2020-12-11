package com.dkit.sd2b.BrianMcKenna;

public class RaspberryPi extends Computer
{
    private int GPIOPins;
    private String sdCardSize;

    public RaspberryPi(String assetTag, String manufacturer, String processor, String ramSize, double weight,
                        String strPurchaseDate, int GPIOPins, String sdCardSize)
    {
        super(assetTag,manufacturer, processor, ramSize, weight,strPurchaseDate);

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
