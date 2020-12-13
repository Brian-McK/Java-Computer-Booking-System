package com.dkit.sd2b.BrianMcKenna;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
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

    ArrayList<String> getAvailableComputers()
    {
        ArrayList<String> availableComputers = new ArrayList<>();

        for (int i = 0; i < this.computerBookings.size(); i++)
        {
            if(this.computerBookings.get(i).getReturnDateTime() != null)
            {
                availableComputers.addAll(this.computerBookings.get(i).getComputersOnLoan());
            }
        }
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(availableComputers);

        return new ArrayList<>(hashSet);
    }

    public boolean checkComputerIsAvailable(String computerAssetTag, ComputerDB computerDB,
                                            ComputerBookingDB compBookingDB)
    {
        boolean isAvailable = false;

        // check if the computer actually exists
        Computer comp = computerDB.findComputerByAssetTag(computerAssetTag);

        ArrayList<String> availableComputers = compBookingDB.getAvailableComputers();

        if(comp != null)
        {
            // check if the computer is available
            for (int i = 0; i < availableComputers.size(); i++)
            {
                if(comp.getAssetTag().equals(availableComputers.get(i)))
                {
                    isAvailable = true;
                }
            }
        }
        return isAvailable;

        // available if it actually exists ie the college is renting it
        // available if nobody else has it it booked
        // if the computer has been returned i.e not null then its available
    }

    public void printCurrentBookings()
    {
        for (int i = 0; i < computerBookings.size(); i++)
        {
            if(computerBookings.get(i).getReturnDateTime() == null)
            {
                System.out.println(computerBookings.get(i));
            }
        }
    }
}
