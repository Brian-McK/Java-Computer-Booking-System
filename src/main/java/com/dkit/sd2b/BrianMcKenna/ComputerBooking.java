package com.dkit.sd2b.BrianMcKenna;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// TODO: 02/12/2020 - Need to remove the T from the datetime format
// TODO: 03/12/2020 - Add in computer object instead of string assetTag?

public class ComputerBooking
{
    // has to be unique, increment when new booking is made
    private String bookingId;
    private String studentId;
    // what happens if they want multiple computers in the same booking?
    private ArrayList<String> computersOnLoan;
    private LocalDateTime bookingDateTime;
    private LocalDateTime returnDateTime;

    public ComputerBooking(String bookingId, String studentId, ArrayList<String> computersOnLoan, String strBookingDateTime,
                           String strReturnDateTime)
    {
        this.bookingId = bookingId;
        this.studentId = studentId;
        this.computersOnLoan = computersOnLoan;
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

    public ArrayList<String> getComputersOnLoan()
    {
        return computersOnLoan;
    }

    public void setComputersOnLoan(ArrayList<String> computersOnLoan)
    {
        this.computersOnLoan = computersOnLoan;
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
                ", computersOnLoan=" + computersOnLoan +
                ", bookingDateTime=" + bookingDateTime +
                ", returnDateTime=" + returnDateTime +
                '}';
    }
}
