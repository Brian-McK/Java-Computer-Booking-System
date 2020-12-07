package com.dkit.sd2b.BrianMcKenna;

import java.util.ArrayList;

public class ComputerBookingDB
{
    ArrayList<ComputerBooking> computerBookings;

    public ComputerBookingDB(ArrayList<ComputerBooking> computerBookings)
    {
        this.computerBookings = computerBookings;
    }

    public ComputerBookingDB()
    {
        this.computerBookings = new ArrayList<>();
    }

    public ArrayList<ComputerBooking> getComputerBookings()
    {
        return computerBookings;
    }

    public void setComputerBookings(ArrayList<ComputerBooking> computerBookings)
    {
        this.computerBookings = computerBookings;
    }

    public void addBookingRecord(ComputerBooking compBooking)
    {
        // need to check if already exists
        this.computerBookings.add(compBooking);
    }

    public void removeBookingRecord(ComputerBooking compBooking)
    {
        // need to validate if null
        this.computerBookings.remove(compBooking);
    }

    public ComputerBooking findBookingById(String compBookingId)
    {
        for (int i = 0; i < computerBookings.size(); i++)
        {
            if (computerBookings.get(i).getBookingId().equals(compBookingId))
            {
                return computerBookings.get(i);
            }
        }
        return null;
    }

    public void removeBookingById(String compBookingId)
    {
        ComputerBooking compBooking = findBookingById(compBookingId);

        if(compBooking != null)
        {
            computerBookings.remove(compBooking);
        }
    }
}
