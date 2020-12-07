package com.dkit.sd2b.BrianMcKenna;

/*
 Brian McKenna - SD2B
 Github Repo: https://github.com/Brian-McK/D00197352-CA3
*/

// TODO: 07/12/2020 - LOAD DATA FROM FILE

public class App 
{
    public static void main( String[] args )
    {
        Computer computer1 = new Computer("Dell","Intel Core i5 9th Gen","8GB","1TB",3.5,"DKIT-24105","2020-02-19");

        System.out.println(computer1);

        Desktop desktop1 = new Desktop("HP","Intel Core i7 8th Gen", "16GB","2TB",8,"DKIT-24500D","2020-06-20",
                "Samsung 21 Inch");

        System.out.println(desktop1);

        Laptop laptop1 = new Laptop("Apple","Intel Core i9","16GB","1TB",2.5,"DKIT-24501L","2019-02-11",15,10.5);

        System.out.println(laptop1);

        RaspberryPi pi1 = new RaspberryPi("Raspberry Pi","Quad-Core Arm Cortex-A72","4GB", 0.1,"DKIT-24502RP","2019" +
                "-03-05",40,"32GB");

        System.out.println(pi1);

        System.out.println("\n------------------");

        // Without arraylist of computers on loan
        Student student1 = new Student("Brian McKenna","323912","brianm@dkit.ie","0876525362");

        System.out.println(student1);

        // yyyy-MM-dd HH:mm:ss" is the format I want
        ComputerBooking booking1 = new ComputerBooking("1","1234", "DKIT-24500D","2016-11-09 10:55:00", "2016-11-15 10:55:00");

        System.out.println(booking1);

        System.out.println("\n------TESTING COMP DB---------");

        ComputerDB computerDB1 = new ComputerDB();
        computerDB1.addComputer(desktop1);
        computerDB1.addComputer(laptop1);
        computerDB1.addComputer(pi1);

        System.out.println(computerDB1);

        computerDB1.removeComputer(pi1);

        System.out.println(computerDB1);

        Computer referenceToAFoundComp = computerDB1.findComputerByAssetTag("DKIT-24500D");

        System.out.println(referenceToAFoundComp);

        computerDB1.removeComputerById("DKIT-24500D");

        System.out.println(computerDB1);

        System.out.println("\n------TESTING STUDENT DB---------");

        System.out.println();

        StudentDB studentDB1 = new StudentDB();
        studentDB1.addStudent(student1);
        Student student2 = new Student("Frankie McGeogh","323122","frankiemgm@dkit.ie","0876525315");
        Student student3 = new Student("David McGuire","343182","davidm@dkit.ie","0836905310");
        studentDB1.addStudent(student2);
        studentDB1.addStudent(student3);

        System.out.println(studentDB1);

        studentDB1.removeStudent(student1);

        System.out.println(studentDB1);

        Student referenceToAFoundStudent = studentDB1.findStudentById("343182");

        System.out.println(referenceToAFoundStudent);

        studentDB1.removeStudentById("343182");

        System.out.println(studentDB1);

        System.out.println("\n------TESTING BOOKING DB---------");

        ComputerBookingDB computerBookingDB1 = new ComputerBookingDB();
        computerBookingDB1.addBookingRecord(booking1);
        ComputerBooking booking2 = new ComputerBooking("2","1254", "DKIT-24210R","2017-12-05 10:55:00", "2018-01-01 " +
                "10:55:00");
        ComputerBooking booking3 = new ComputerBooking("3","1294", "DKIT-24630L","2020-07-10 10:55:00", "2020-08-01 " +
                "10:55:00");
        computerBookingDB1.addBookingRecord(booking2);
        computerBookingDB1.addBookingRecord(booking3);

        System.out.println(computerBookingDB1);

        computerBookingDB1.removeBookingById("3");

        System.out.println(computerBookingDB1);

        ComputerBooking referenceToAFoundCompBooking = computerBookingDB1.findBookingById("2");

        System.out.println(referenceToAFoundCompBooking);

        computerBookingDB1.removeBookingRecord(booking2);

        System.out.println(computerBookingDB1);





    }
}
