package com.dkit.sd2b.BrianMcKenna;

import java.time.LocalDate;

public class Desktop extends Computer
{
    private String externalMonitor;

    public Desktop(String manufacturer, String processor, String ramSize, String diskSize, double weight,
                   String assetTag, String strPurchaseDate, String externalMonitor)
    {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, strPurchaseDate);

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
}
