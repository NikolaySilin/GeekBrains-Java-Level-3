package ru.geekbrains.nikolaysilin.lesson_7;

public class Test_1 {

    @BeforeSuite
    public static void before(){
        System.out.println("Before");
    }


    public static void NotTest(){

        System.out.println("NotTest");
    }


    @Test (priority = 7)
    public static void addTest1(){

        System.out.println("test 1");
    }

    @Test (priority = 10)
    public static void addTest2(){

        System.out.println("test 2");
    }

    @Test (priority = 9)
    public static void addTest3(){

        System.out.println("test 3");
    }

    @Test (priority = 9)
    public static void addTest4(){

        System.out.println("test 3");
    }

    @AfterSuite
    public static void after(){
        System.out.println("After");
    }

}
