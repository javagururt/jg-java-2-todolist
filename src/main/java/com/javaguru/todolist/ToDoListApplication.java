package com.javaguru.todolist;

import com.javaguru.todolist.config.SpringApplicationConfig;
import com.javaguru.todolist.console.ConsoleUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ToDoListApplication {

    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);

        ConsoleUI consoleApplication = context.getBean(ConsoleUI.class);
        consoleApplication.execute();
    }
}
