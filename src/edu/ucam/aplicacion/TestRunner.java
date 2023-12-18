package edu.ucam.aplicacion;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestReino.class);
    	//Result result = JUnitCore.runClasses(TestReino3.class, TestReino.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Éxito: " + result.wasSuccessful());
    }
}