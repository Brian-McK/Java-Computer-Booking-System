package com.dkit.sd2b.BrianMcKenna;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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

    // could put in studentID and assetTag instead?
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

    @Override
    public String toString()
    {
        return "ComputerBookingDB{" +
                "computerBookings=" + computerBookings +
                '}';
    }

    public void loadBookingsFromFile(String fileName)
    {
        File inputFile = new File(fileName);

        try (Scanner scan = new Scanner(inputFile))
        {
            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
                String [] data = line.split(",");

                String bookingId = data[0];
                String studentId = data[1];
                String bookingDateTime = data[2];

                if(data.length == 4)
                {
                    ArrayList <String> computersOnLoan = new ArrayList<>();
                    for (int i = 3; i < data.length; i++)
                    {
                        computersOnLoan.add((data[i]));
                    }
                    ComputerBooking computerBooking = new ComputerBooking(bookingId,studentId,bookingDateTime,computersOnLoan);
                    computerBookings.add(computerBooking);
                }
                else {
                    String returnDateTime = data[3];

                    ArrayList <String> computersOnLoan = new ArrayList<>();
                    for (int i = 4; i < data.length; i++)
                    {
                        computersOnLoan.add((data[i]));
                    }
                    ComputerBooking computerBooking = new ComputerBooking(bookingId,studentId,bookingDateTime,returnDateTime,computersOnLoan);
                    computerBookings.add(computerBooking);
                }
            }

        } catch ( FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught." + exception);
        } catch (InputMismatchException exception)
        {
            System.out.println("InputMismatchexception caught." + exception);
        }

//        displayData(computerBookings);
    }

    public static void displayData(ArrayList<ComputerBooking> computerBookings)
    {
        for(ComputerBooking computerBooking:computerBookings)
        {
            System.out.println(computerBooking);
        }
    }

    public boolean checkBookingIdExists(String bookingId)
    {
        return findBookingById(bookingId) != null;
    }

    public boolean checkValidBookingDateTime(String newBookingDateTime)
    {
        boolean isValidDateToBook = false;

        LocalDateTime dateTimeCurrent = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime newBookingDateTimeFormatted = LocalDateTime.parse(newBookingDateTime, formatter);

        if(newBookingDateTimeFormatted.toLocalDate().isEqual(dateTimeCurrent.toLocalDate()) ||
                newBookingDateTimeFormatted.toLocalDate().isAfter(dateTimeCurrent.toLocalDate()))
        {
            isValidDateToBook = true;
        }

        return isValidDateToBook;
    }
}
