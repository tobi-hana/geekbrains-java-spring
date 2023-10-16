package ru.geekbrains;



public class FirstClass {
    @AfterSuite
    public void someMethod(){
        System.out.println("After suite");
    }
//    @AfterSuite
//    public void someSMethod(){
//        System.out.println("After suite");
//    }
    @Test
    public void fMethod(){
        System.out.println("Five!");
    }
    @BeforeSuite
    public void firstMethod(){
        System.out.println("Before suite");
    }
    @Test(order = 1)
    public void sectMethod(){
        System.out.println("One");
    }
    @Test(order = 10)
    public void fiMethod(){
        System.out.println("Five");
    }



}
