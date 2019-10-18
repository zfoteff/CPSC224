package com.example.cpsc224; // must be first line of non comment code

//  import statements here ...

//  package is a group of related types
//  - class objects
//  - interfaces
//  Examples
//  - java.awt
//  - java.swing

//  Why use packages?
//  - project structure
//  - namespace management
//  - access control

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        //  helps you determine what package an object belongs to
        System.out.println(String.class.getPackageName());
        System.out.println(Main.class.getPackageName());

        //  list interface
        //  from collections frameword
        //  two implementations:
        //  - ArrayList
        //  - LinkedList
        List<String> myHalloweenWords; //   parameterized type

    }
}
