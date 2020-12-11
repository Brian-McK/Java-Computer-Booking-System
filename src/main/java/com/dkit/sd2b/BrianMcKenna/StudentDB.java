package com.dkit.sd2b.BrianMcKenna;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDB
{
    ArrayList<Student> students;
    private String studentId;

    public StudentDB(ArrayList<Student> students)
    {
        this.students = students;
    }

    public StudentDB()
    {
        this.students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents()
    {
        return students;
    }

    public void setStudents(ArrayList<Student> students)
    {
        this.students = students;
    }

    public void addStudent(Student student)
    {
        // need to check if already exists
        if(student != null)
        {
            this.students.add(student);
        }
    }

    public void removeStudent(Student student)
    {
        // need to validate if null
        this.students.remove(student);
    }

    public Student findStudentById(String studentId)
    {
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getId().equals(studentId))
            {
                return students.get(i);
            }
        }
        return null;
    }

    public Student findStudentByEmail(String studentEmail)
    {
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getEmail().equals(studentEmail))
            {
                return students.get(i);
            }
        }
        return null;
    }

    public void removeStudentById(String studentId)
    {
        Student student = findStudentById(studentId);

        if(student != null)
        {
            students.remove(student);
        }
    }

    @Override
    public String toString()
    {
        return "StudentDB{" +
                "students=" + students +
                '}';
    }

    public void loadStudentsFromFile(String fileName)
    {

        File inputFile = new File(fileName);

        try (Scanner scan = new Scanner(inputFile))
        {
            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
                String [] data = line.split(",");

                String studentId = data[0];
                String name = data[1];
                String email = data[2];
                String telephone = data[3];

                ArrayList <String> computersOnLoan = new ArrayList<>();
                for (int i = 4; i < data.length; i++)
                {
                    computersOnLoan.add((data[i]));
                }
                Student student = new Student(studentId,name,email,telephone,computersOnLoan);
                students.add(student);
            }

        } catch ( FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught." + exception);
        } catch (InputMismatchException exception)
        {
            System.out.println("InputMismatchexception caught." + exception);
        }

//        displayData(studentList);
    }

    public static void displayData(ArrayList<Student> studentList)
    {
        for(Student s:studentList)
        {
            System.out.println(s);
        }
    }

    public boolean checkStudentIdExists(String studentId)
    {
        return findStudentById(studentId) != null;
    }

    public boolean checkStudentEmailExists(String studentEmail)
    {
        return findStudentByEmail(studentEmail) != null;
    }

}
