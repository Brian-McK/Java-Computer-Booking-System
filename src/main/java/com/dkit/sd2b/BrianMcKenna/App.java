package com.dkit.sd2b.BrianMcKenna;

/*
 Brian McKenna - SD2B
 Github Repo: https://github.com/Brian-McK/D00197352-CA3
*/

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    String REGEX_STUDENT_ID = "[D][0][0][0-9]+";
    String REGEX_STUDENT_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String REGEX_STUDENT_PHONE = "08[3679]";

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

        System.out.println("Option 1: Add student"); // I made sure by checking the id and email first
        System.out.println("Option 2: Delete Student"); // need to check if the student already exists?
        System.out.println("Option 3: Edit Student");
        System.out.println("Option 4: Print Student Details");
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

        // TODO: 11/12/2020 - could add in a skip feature if user wants to skip the edit of a field

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
        studentForEdit.setTelephone(updatedStudentEmail);

        studentForEdit.printStudentDetails();
    }
}


