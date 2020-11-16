package ru.uennar.esh;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.uennar.esh.beans.Parking;
import ru.uennar.esh.main.AppConfig;

import static org.junit.Assert.assertEquals;

public class Testing {
    @Test
    public void test() {
        System.out.println("testing");
    }
    @Test
    public void test2() {
        Parking parking = new Parking();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Parking parking2 = context.getBean("parking", Parking.class);
        assertEquals(parking, parking2);
    }
}
