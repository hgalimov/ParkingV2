package ru.uennar.esh.beans;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    @Pointcut("execution(* ru.uennar.esh.beans.Parking.addCar(..))")
    public void addCar() {

    }

    @Before("addCar()")
    public void beforeAdviceAddCar() {
        System.out.println("Не парковался.");
    }

    @After("addCar()")
    public void afterAdviceAddCar() {
        System.out.println("Парковался.");
    }

    @AfterReturning(pointcut = "addCar()", returning = "someValue")
    public void afterReturningAdviceAddCar(Object someValue) {
        System.out.println("Value: " + someValue.toString());
    }

    @Pointcut("execution(* ru.uennar.esh.beans.Parking.dltCar(..))")
    public void dltCar() {

    }

    @Before("dltCar()")
    public void beforeAdviceDltCar() {
        System.out.println("Не уехал.");
    }

    @After("dltCar()")
    public void afterAdviceDltCar() {
        System.out.println("Уехал.");
    }

    @AfterReturning(pointcut = "dltCar()", returning = "someValue")
    public void afterReturningAdviceDltCar(Object someValue) {
        System.out.println("Value: " + someValue.toString());
    }
}