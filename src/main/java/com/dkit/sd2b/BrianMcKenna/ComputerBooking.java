package com.dkit.sd2b.BrianMcKenna;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class ComputerBooking implements Comparable<ComputerBooking>
{
    // has to be unique, increment when new booking is made
    private String bookingId;
    private String studentId;
    private LocalDateTime bookingDateTime;
    private LocalDateTime returnDateTime;
    private ArrayList<String> computersOnLoan;

    public ComputerBooking(String bookingId, String studentId, String strBookingDateTime,
                           String strReturnDateTime, ArrayList<String> computersOnLoan)
    {
        this.bookingId = bookingId;
        this.studentId = studentId;
        this.bookingDateTime = LocalDateTime.parse(strBookingDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.returnDateTime = LocalDateTime.parse(strReturnDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.computersOnLoan = computersOnLoan;
    }

    public ComputerBooking()
    {
        this.bookingId = "";
        this.studentId = "";
        this.bookingDateTime = null;
        this.returnDateTime = null;
        this.computersOnLoan = new ArrayList<>();
    }

    public ComputerBooking(String bookingId, String studentId, String strBookingDateTime, ArrayList<String> computersOnLoan)
    {
        this.bookingId = bookingId;
        this.studentId = studentId;
        this.bookingDateTime = LocalDateTime.parse(strBookingDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.returnDateTime = null;
        this.computersOnLoan = computersOnLoan;
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
        this.bookingDateTime = LocalDateTime.parse(strBookingDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public LocalDateTime getReturnDateTime()
    {
        return returnDateTime;
    }

    public void setReturnDateTime(String strReturnDateTime)
    {
        this.returnDateTime = LocalDateTime.parse(strReturnDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    @Override
    public String toString()
    {
        return "ComputerBooking{" +
                "bookingId='" + bookingId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", bookingDateTime=" + bookingDateTime +
                ", returnDateTime=" + returnDateTime +
                ", computersOnLoan=" + computersOnLoan +
                '}';
    }

    @Override
    public int compareTo(ComputerBooking other)
    {
        if(this.bookingDateTime.isBefore(other.bookingDateTime))
        {
            return -1;
        }
        else if(this.bookingDateTime.isAfter(other.bookingDateTime))
        {
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerBooking that = (ComputerBooking) o;
        return Objects.equals(bookingId, that.bookingId) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(bookingDateTime, that.bookingDateTime) &&
                Objects.equals(returnDateTime, that.returnDateTime) &&
                Objects.equals(computersOnLoan, that.computersOnLoan);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(bookingId, studentId, bookingDateTime, returnDateTime, computersOnLoan);
    }
}
