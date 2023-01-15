package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // Informacja, że nasza klasa jest kontrolerem
public class DataBaseConnection {
    @Autowired  // Aumatyczne dowiązanie klasy
    CustomProperties cm;
    public void doConnection()
    {
        System.out.println( cm.toString());
    }
}
