package com.example.test;

import java.util.ArrayList;


public class Details {

    // Creating an object of ArrayList
    static ArrayList<Details> Data
            = new ArrayList<Details>();
    String login, passwd;
    Details(String login, String passwd)
    {
        // This keyword refers to parent instance itself
        this.login = login;
        this.passwd = passwd;
    }
}