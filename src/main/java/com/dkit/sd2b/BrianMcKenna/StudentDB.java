package com.dkit.sd2b.BrianMcKenna;

import java.util.ArrayList;

public class StudentDB
{
    ArrayList<Student> students;

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
        this.students.add(student);
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
}
