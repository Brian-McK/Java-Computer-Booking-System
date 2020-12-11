package com.dkit.sd2b.BrianMcKenna;

/*
 Brian McKenna - SD2B
 Github Repo: https://github.com/Brian-McK/D00197352-CA3
*/

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        App app = new App();
        app.startUserMenu();
    }

    // TODO: 11/12/2020 - add student not duplicate
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

        } while (menuOptionPicked < 1 || menuOptionPicked > 10);

        while (menuOptionPicked != 10)
        {
            if (menuOptionPicked == 1)
            {
                System.out.println("Option 1: Add student chosen");
                addStudentHandler(studentDB);
            }
            else if (menuOptionPicked == 2)
            {
                System.out.println("option 2");
            }
            else if (menuOptionPicked == 3)
            {
                System.out.println("option 3");
            }
            else if (menuOptionPicked == 4)
            {
                System.out.println("option 4");
            }
            else if (menuOptionPicked == 5)
            {
                System.out.println("option 5");
            }
            else if (menuOptionPicked == 6)
            {
                System.out.println("option 6");
            }
            else if (menuOptionPicked == 7)
            {
                System.out.println("option 7");
            }
            else if (menuOptionPicked == 8)
            {
                System.out.println("option 8");
            }
            else
            {
                System.out.println("option 9");
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

        System.out.println("Option 1: Add student"); // need to check if the student already exists?
        System.out.println("Option 2: Delete Student"); // need to check if the student already exists?
        System.out.println("Option 3: Edit Student");
        // need to check if the student already exists and make sure the new data is not used already e.g studentId
        System.out.println("Option 4: Add a booking"); // need to check if the booking already exists?
        System.out.println("Option 5: Print current bookings"); // print all without date returned
        System.out.println("Option 6: Print bookings in date/time order"); // use comparator
        System.out.println("Option 7: Return a Computer"); // update computer booking with returned date?
        System.out.println("Option 8: Display average length of all bookings");
        System.out.println("Option 9: Print statistics (up to you to decide)");
        System.out.println("Option 10: Exit");

        System.out.println("**********************************************");
    }

    public void addStudentHandler(StudentDB studentDB)
    {
        Scanner scan = new Scanner(System.in);
        String regexStudentId = "[D][0][0][0-9]+";

        System.out.println("Enter StudentId:");
        String studentId = scan.nextLine();

        while (!(studentId.matches(regexStudentId)) || studentDB.checkStudentIdExists(studentId))
        {
            System.out.println("Invalid entry, please enter StudentId again: ");
            studentId = scan.nextLine();
        }

        System.out.println(studentId);

        System.out.println("Enter Name:");
        String studentName = scan.nextLine();

        System.out.println(studentName);

        String regexStudentEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        System.out.println("Enter StudentEmail:");
        String studentEmail = scan.nextLine();

        while (!(studentEmail.matches(regexStudentEmail)) || studentDB.checkStudentEmailExists(studentEmail))
        {
            System.out.println("Invalid entry, please enter studentEmail again: ");
            studentEmail = scan.nextLine();
        }

        System.out.println(studentEmail);

        // TODO - FIX REGEX
        String regexStudentTel = "08[3679]";

        System.out.println("Enter studentTel:");
        String studentTel = scan.nextLine();

        while (!studentTel.matches(regexStudentTel))
        {
            System.out.println("Invalid entry, please enter studentTel again: ");
            studentTel = scan.nextLine();
        }

        System.out.println(studentTel);

        // compareTo
        // need to check if the student already exists?
        // need to validate
        studentDB.addStudent(new Student(studentId,studentName,studentEmail,studentTel));

        System.out.println(studentDB);
    }
}


