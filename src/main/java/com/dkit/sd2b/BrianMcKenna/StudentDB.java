package com.dkit.sd2b.BrianMcKenna;

import java.util.ArrayList;

public class StudentDB
{
    ArrayList<Student> students;

    public StudentDB(ArrayList<Student> students)
    {
        this.students = students;
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
        // need to validate if null
        this.students.add(student);
    }

    public void removeStudent(Student student)
    {
        // need to validate if null
        this.students.remove(student);
    }
}
