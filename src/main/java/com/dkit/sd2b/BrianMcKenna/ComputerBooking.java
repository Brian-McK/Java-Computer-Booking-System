package com.dkit.sd2b.BrianMcKenna;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// TODO: 02/12/2020 - Need to remove the T from the datetime format
// TODO: 03/12/2020 - Add in computer data type? 

public class ComputerBooking
{
    // has to be unique, increment when new booking is made
    private String bookingId;
    private String studentId;
    // what happens if they want multiple computers in the same booking?
    private String assetTag;
    private LocalDateTime bookingDateTime;
    private LocalDateTime returnDateTime;

    public ComputerBooking(String bookingId, String studentId, String assetTag, String strBookingDateTime,
                           String strReturnDateTime)
    {
        this.bookingId = bookingId;
        this.studentId = studentId;
        this.assetTag = assetTag;
        this.bookingDateTime = LocalDateTime.parse(strBookingDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd " +
                "HH:mm:ss"));
        this.returnDateTime = LocalDateTime.parse(strReturnDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getBookingId()
    {
        return bookingId;
    }

    public void setBookingId(String bookingId)
    {
        this.bookingId = bookingId;
    }

    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    public String getAssetTag()
    {
        return assetTag;
    }

    public void setAssetTag(String assetTag)
    {
        this.assetTag = assetTag;
    }

    public LocalDateTime getBookingDateTime()
    {
        return bookingDateTime;
    }

    public void setBookingDateTime(String strBookingDateTime)
    {
        this.bookingDateTime = LocalDateTime.parse(strBookingDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd " +
                "HH:mm:ss"));;
    }

    public LocalDateTime getReturnDateTime()
    {
        return returnDateTime;
    }

    public void setReturnDateTime(String strReturnDateTime)
    {
        this.returnDateTime = LocalDateTime.parse(strReturnDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString()
    {
        return "ComputerBooking{" +
                "bookingId='" + bookingId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", assetTag='" + assetTag + '\'' +
                ", bookingDateTime=" + bookingDateTime +
                ", returnDateTime=" + returnDateTime +
                '}';
    }
}
