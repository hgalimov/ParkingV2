package ru.uennar.esh.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.uennar.esh.beans")
@EnableAspectJAutoProxy
public class AppConfig {
}