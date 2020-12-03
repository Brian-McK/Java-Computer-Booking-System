package com.dkit.sd2b.BrianMcKenna;

/*
 Brian McKenna - SD2B
 Github Repo: https://github.com/Brian-McK/D00197352-CA3
*/

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

        System.out.println("\n--------------------------");

        // Without arraylist of computers on loan
        Student student1 = new Student("Brian McKenna","323912","brianm@dkit.ie","0876525362");

        System.out.println(student1);

        // yyyy-MM-dd HH:mm:ss" is the format I want
        ComputerBooking booking1 = new ComputerBooking("1","1234","2016-11-09 10:55:00", "2016-11-15 10:55:00");

        System.out.println(booking1);
    }
}
