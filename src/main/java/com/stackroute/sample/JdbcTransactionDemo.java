package com.stackroute.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTransactionDemo
{
    //Declaration
    private Connection connection;
    private Statement statement;


    public void jdbcTransaction() throws SQLException
    {
        Connection connection=null;
        try {
            // Loading and Registering with Drivermanager
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "Root@123");
            Statement statement = connection.createStatement();
            // Implementing transaction
            statement.executeUpdate("insert into Employee values(7,'XYZ',30,'Male')");
            System.out.println("\n--------JDBC Transaction Commited----------");
            connection.commit();

        } catch (SQLException exception) {

            System.out.println(exception.getMessage());

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

