package com.stackroute.sample;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class SimpleJdbcDemo {

    private Connection connection;
    private  Statement statement;
    private ResultSet resultSet;
    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from Employee");)
        {
            /*Load driver and register with DriverManager*/

            /*Use DriverManager to get Connection*/
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");

//             statement = connection.createStatement();
//
//             resultSet = statement.executeQuery("Select * from employee");

            while (resultSet.next())
            {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)+ " age: "+ resultSet.getInt(3)+ " gender: "+ resultSet.getString(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        finally {
//            try {
//                connection.close();
//                statement.close();
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

    }


    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse()
    {
        System.out.println("\n");
        System.out.println("printing result in Reverse order");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from Employee");)
        {
            resultSet.last();
            resultSet.next();
            while(resultSet.previous())
            {
                System.out.println("eid: "+resultSet.getInt(1)+"ename:"+ resultSet.getString(2));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


        /*Move ResultSet to second row and print in reverse order*/
        public void getEmployeeDetailsFromSecondRowInReverse()
    {
        System.out.println("\n");
        System.out.println("Move ResultSet to second row and print in reverse order");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from Employee");)
        {
            resultSet.absolute(2);
            resultSet.next();
            //Moves the curser to the end of the ResultSet object
            while(resultSet.previous())
            {
                System.out.println("eid: "+resultSet.getInt(1)+"\tename:"+ resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }



    }





    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name,String gender)
    {
        System.out.println("\n");
        System.out.println("Display by name and gender");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             PreparedStatement statement = connection.prepareStatement("select * from Employee where name=? and gender=?")) {

            statement.setString(1, name);
            statement.setString(2, gender);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)+ " age: "+ resultSet.getInt(3)+ " gender: "+ resultSet.getString(4));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }



    }
}



