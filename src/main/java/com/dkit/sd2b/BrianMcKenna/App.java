package com.dkit.sd2b.BrianMcKenna;

/*
 Brian McKenna - SD2B
 Github Repo: https://github.com/Brian-McK/D00197352-CA3
*/

import java.util.*;

public class App
{
    final String REGEX_STUDENT_ID = "[D][0][0][0-9]+";
    final String REGEX_STUDENT_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    final String REGEX_STUDENT_PHONE = "08[3679]";
    final String REGEX_BOOKING_ID = "[B][0-9]+";
    final String REGEX_BOOKING_DATE_TIME = "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]";

    public static void main( String[] args )
    {
        App app = new App();
        app.startUserMenu();
    }

    // TODO: 11/12/2020 - use CompareTo?
    // TODO: 11/12/2020 - Comparable
    // TODO: 11/12/2020 - increment booking id when new booking is made 

    void startUserMenu()
    {
        StudentDB studentDB = new StudentDB();
        studentDB.loadStudentsFromFile("students.txt");

        ComputerBookingDB compBookingDB = new ComputerBookingDB();
        compBookingDB.loadBookingsFromFile("bookings.txt");

        ComputerDB computerDB = new ComputerDB();
        computerDB.loadComputersFromFile("computers.txt");

        Scanner scan = new Scanner(System.in);
        int menuOptionPicked;
        printMenuOptions();

        do {
            System.out.println("Please enter a valid option:");

            while (!scan.hasNextInt())
            {
                String input = scan.next();
                System.out.printf("%s is not a valid number.\n", input);
            }
            menuOptionPicked = scan.nextInt();

        } while (menuOptionPicked < 1 || menuOptionPicked > 11);

        while (menuOptionPicked != 11)
        {
            if (menuOptionPicked == 1)
            {
                System.out.println("Option 1: Add student chosen");
                addStudentHandler(studentDB);
            }
            else if (menuOptionPicked == 2)
            {
                System.out.println("Option 2: Delete Student chosen");
                deleteStudentHandler(studentDB);
            }
            else if (menuOptionPicked == 3)
            {
                System.out.println("Option 3: Edit Student chosen");
                editStudentHandler(studentDB);
            }
            else if (menuOptionPicked == 4)
            {
                Scanner input = new Scanner(System.in);

                System.out.println("Option 4: Print Student Details chosen");
                System.out.println("Enter studentId to print details: ");
                String studentId = input.nextLine();

                while (!(studentId.matches(REGEX_STUDENT_ID)) || !studentDB.checkStudentIdExists(studentId))
                {
                    System.out.println("Invalid entry, please enter StudentId again: ");
                    studentId = input.nextLine();
                }
                studentDB.findStudentById(studentId).printStudentDetails();
            }
            else if (menuOptionPicked == 5)
            {
                System.out.println("Option 5: Add a booking chosen");
                addComputerBookingHandler(compBookingDB,studentDB,computerDB);
            }
            else if (menuOptionPicked == 6)
            {
                System.out.println("option 6: Print current bookings");
                compBookingDB.printCurrentBookings();
            }
            else if (menuOptionPicked == 7)
            {
                System.out.println("option 7: Print bookings in date/time order");
                Collections.sort(compBookingDB.computerBookings);
                compBookingDB.printCurrentBookings();
            }
            else if (menuOptionPicked == 8)
            {
                System.out.println("option 8: Return a Computer");
                // TODO: 13/12/2020 - unfinished
            }
            else if(menuOptionPicked == 9)
            {
                System.out.println("option 9");
                // TODO: 13/12/2020 - unfinished
            }
            else
            {
                System.out.println("option 10");
                // TODO: 13/12/2020 - unfinished
            }

            printMenuOptions();
            System.out.print("Please enter option:");
            menuOptionPicked = scan.nextInt();
        }
        System.out.println("\nProgram ended");
    }

    void printMenuOptions()
    {
        System.out.println("********** WELCOME ***********");

        System.out.println("Option 1: Add student"); // I made sure by checking the id and email first
        System.out.println("Option 2: Delete Student"); // need to check if the student already exists?
        System.out.println("Option 3: Edit Student");
        System.out.println("Option 4: Print Student Details");
        // need to check if the student already exists and make sure the new data is not used already e.g studentId
        System.out.println("Option 5: Add a booking"); // need to check if the booking already exists?
        System.out.println("Option 6: Print current bookings"); // print all without date returned
        System.out.println("Option 7: Print bookings in date/time order"); // use comparator
        System.out.println("Option 8: Return a Computer"); // update computer booking with returned date?
        System.out.println("Option 9: Display average length of all bookings");
        System.out.println("Option 10: Print statistics (up to you to decide)");
        System.out.println("Option 11: Exit");

        System.out.println("**********************************************");
    }

    public void addStudentHandler(StudentDB studentDB)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter StudentId:");
        String studentId = scan.nextLine();

        while (!(studentId.matches(REGEX_STUDENT_ID)) || studentDB.checkStudentIdExists(studentId))
        {
            System.out.println("Invalid entry, please enter StudentId again: ");
            studentId = scan.nextLine();
        }
        System.out.println(studentId);

        System.out.println("Enter Name:");
        String studentName = scan.nextLine();

        System.out.println(studentName);

        System.out.println("Enter StudentEmail:");
        String studentEmail = scan.nextLine();

        while (!(studentEmail.matches(REGEX_STUDENT_EMAIL)) || studentDB.checkStudentEmailExists(studentEmail))
        {
            System.out.println("Invalid entry, please enter studentEmail again: ");
            studentEmail = scan.nextLine();
        }
        System.out.println(studentEmail);

        System.out.println("Enter studentTel:");
        String studentTel = scan.nextLine();

        while (!studentTel.matches(REGEX_STUDENT_PHONE))
        {
            System.out.println("Invalid entry, please enter studentTel again: ");
            studentTel = scan.nextLine();
        }
        System.out.println(studentTel);

        studentDB.addStudent(new Student(studentId,studentName,studentEmail,studentTel));
        System.out.println(studentDB);

        // TODO: 13/12/2020 - ADD COMPUTERS CURRENTLY BOOKED BY STUDENT
    }

    public void deleteStudentHandler(StudentDB studentDB)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter studentId to delete student: ");
        String studentToBeDeletedId = scan.nextLine();

        while (!(studentToBeDeletedId.matches(REGEX_STUDENT_ID)) || !studentDB.checkStudentIdExists(studentToBeDeletedId))
        {
            System.out.println("Invalid entry, please enter StudentId again: ");
            studentToBeDeletedId = scan.nextLine();
        }
        studentDB.removeStudentById(studentToBeDeletedId);
        System.out.println("REMOVED: " + studentToBeDeletedId);

        System.out.println(studentDB);
    }

    public void editStudentHandler(StudentDB studentDB)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter studentId to edit student: ");
        String studentToBeEditedId = scan.nextLine();

        while (!(studentToBeEditedId.matches(REGEX_STUDENT_ID)) || !studentDB.checkStudentIdExists(studentToBeEditedId))
        {
            System.out.println("Invalid entry, please enter StudentId again: ");
            studentToBeEditedId = scan.nextLine();
        }
        Student studentForEdit = studentDB.findStudentById(studentToBeEditedId); // make new student instead?
        studentForEdit.printStudentDetails();

        System.out.println("Edit StudentId: " + studentForEdit.getId());
        String updatedStudentId = scan.nextLine();

        while (!(updatedStudentId.matches(REGEX_STUDENT_ID)) || !studentDB.checkStudentIdExists(studentForEdit.getId()))
        {
            System.out.println("Invalid entry, please enter StudentId again: ");
            updatedStudentId = scan.nextLine();
        }
        studentForEdit.setId(updatedStudentId);

        studentForEdit.printStudentDetails();

        System.out.println("Edit StudentName: " + studentForEdit.getName());
        String updatedStudentName = scan.nextLine();
        studentForEdit.setName(updatedStudentName);

        studentForEdit.printStudentDetails();

        System.out.println("Edit StudentEmail: " + studentForEdit.getEmail());
        String updatedStudentEmail = scan.nextLine();

        while (!(updatedStudentEmail.matches(REGEX_STUDENT_EMAIL)) || studentDB.checkStudentEmailExists(studentForEdit.getId()))
        {
            System.out.println("Invalid entry, please enter studentEmail again: ");
            updatedStudentEmail = scan.nextLine();
        }
        studentForEdit.setEmail(updatedStudentEmail);

        studentForEdit.printStudentDetails();

        System.out.println("Edit studentTel:" + studentForEdit.getTelephone());
        String updatedStudentTel = scan.nextLine();

        while (!updatedStudentTel.matches(REGEX_STUDENT_PHONE))
        {
            System.out.println("Invalid entry, please enter studentTel again: ");
            updatedStudentTel = scan.nextLine();
        }
        studentForEdit.setTelephone(updatedStudentTel);

        studentForEdit.printStudentDetails();

        System.out.println(studentDB);
    }

    public void addComputerBookingHandler(ComputerBookingDB compBookingDB,StudentDB studentDB, ComputerDB computerDB)
    {
        Scanner scan = new Scanner(System.in);
        ComputerBooking newCompBooking = new ComputerBooking();

        System.out.println("Enter BookingId:");
        String newBookingId = scan.nextLine();

        while (!(newBookingId.matches(REGEX_BOOKING_ID)) || compBookingDB.checkBookingIdExists(newBookingId))
        {
            System.out.println("Invalid entry, please enter newBookingId again: ");
            newBookingId = scan.nextLine();
        }
        newCompBooking.setBookingId(newBookingId);

        System.out.println(newCompBooking);

        System.out.println("Enter StudentId:");
        String studentId = scan.nextLine();

        // check student exists
        while (!(studentId.matches(REGEX_STUDENT_ID)) || !studentDB.checkStudentIdExists(studentId))
        {
            System.out.println("Invalid entry, please enter StudentId again: ");
            studentId = scan.nextLine();
        }
        newCompBooking.setStudentId(studentId);

        System.out.println(newCompBooking);

        System.out.println("Enter Booking Date:");
        String newBookingDateTime = scan.nextLine();

        while (!(newBookingDateTime.matches(REGEX_BOOKING_DATE_TIME)) || !compBookingDB.checkValidBookingDateTime(newBookingDateTime))
        {
            System.out.println("Invalid entry, please enter newBookingDate again: ");
            newBookingDateTime = scan.nextLine();
        }
        newCompBooking.setBookingDateTime(newBookingDateTime);

        System.out.println(newCompBooking);

        System.out.println("AVAILABLE BEFORE: " + compBookingDB.getAvailableComputers());

        System.out.println("Enter computerAssetTag To Book:");
        String computerAssetTag = scan.nextLine();

        ArrayList<String> computersToBeBooked = new ArrayList<>();

        while (!checkComputerIsAvailable(computerAssetTag,computerDB, compBookingDB))
        {
            System.out.println("Invalid entry, please enter computerAssetTag again: ");
            computerAssetTag = scan.nextLine();
        }
        computersToBeBooked.add(computerAssetTag);
        newCompBooking.setComputersOnLoan(computersToBeBooked);
        compBookingDB.addBookingRecord(newCompBooking);

        System.out.println("AVAILABLE AFTER: " + compBookingDB.getAvailableComputers());
        System.out.println(compBookingDB);

    }

    // TODO: 13/12/2020 - unfinished
    public void returnComputerHandler(String computerAssetTag, ComputerDB computerDB, ComputerBookingDB compBookingDB)
    {
        // check if its booked, if it is then set the return date
        Computer comp = computerDB.findComputerByAssetTag(computerAssetTag);

        ArrayList<ComputerBooking> currentBookings = getCurrentBookings(compBookingDB);
    }

    public ArrayList<ComputerBooking> getCurrentBookings(ComputerBookingDB compBookingDB)
    {
        ArrayList<ComputerBooking> currentBookings = new ArrayList<>();

        for (int i = 0; i < compBookingDB.computerBookings.size(); i++)
        {
            if(compBookingDB.computerBookings.get(i).getReturnDateTime() == null)
            {
                currentBookings.add(compBookingDB.computerBookings.get(i));
            }
        }

        return currentBookings;
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
}


