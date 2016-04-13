package com.devbugger.jdt;

public class JenkinsDockerTest {

    public static void main(String[] args) {
    System.out.println("Hello from inside an automatically built docker conainer.\n" +
                "Lets find the mid sum of 100 to 5");
        Calc c = new Calc();
        System.out.println(c.calc(100, 5));
    }
}
