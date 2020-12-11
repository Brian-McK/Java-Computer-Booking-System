package com.dkit.sd2b.BrianMcKenna;

public class Desktop extends Computer
{
    private String externalMonitor;

    public Desktop(String assetTag,String manufacturer, String processor, String ramSize, String diskSize, double weight,
                   String strPurchaseDate, String externalMonitor)
    {
        super(assetTag,manufacturer, processor, ramSize, diskSize, weight, strPurchaseDate);

        this.externalMonitor = externalMonitor;
    }

    public String getExternalMonitor()
    {
        return externalMonitor;
    }

    public void setExternalMonitor(String externalMonitor)
    {
        this.externalMonitor = externalMonitor;
    }

    @Override
    public String toString()
    {
        return super.toString() +
                "Desktop{" +
                "externalMonitor='" + externalMonitor + '\'' +
                '}';
    }
}
