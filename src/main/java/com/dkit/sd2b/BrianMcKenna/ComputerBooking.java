package com.dkit.sd2b.BrianMcKenna;

import java.time.LocalDateTime;

// TODO: 02/12/2020 - Need to format dateTime using DateTimeFormatter

public class ComputerBooking
{
    // has to be unique, increment when new booking is made
    private int bookingId;
    private int studentId;
    private LocalDateTime bookingDateTime;
    private LocalDateTime returnDateTime;

    public ComputerBooking(int bookingId, int studentId, String strBookingDateTime, String strReturnDateTime)
    {
        this.bookingId = bookingId;
        this.studentId = studentId;
        this.bookingDateTime = LocalDateTime.parse(strBookingDateTime);
        this.returnDateTime = LocalDateTime.parse(strReturnDateTime);
    }

    public int getBookingId()
    {
        return bookingId;
    }

    public void setBookingId(int bookingId)
    {
        this.bookingId = bookingId;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public LocalDateTime getBookingDateTime()
    {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime)
    {
        this.bookingDateTime = bookingDateTime;
    }

    public LocalDateTime getReturnDateTime()
    {
        return returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime)
    {
        this.returnDateTime = returnDateTime;
    }

    @Override
    public String toString()
    {
        return "ComputerBooking{" +
                "bookingId=" + bookingId +
                ", studentId=" + studentId +
                ", bookingDateTime=" + bookingDateTime +
                ", returnDateTime=" + returnDateTime +
                '}';
    }
}
