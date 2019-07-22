package com.stackroute.sample;

import java.sql.*;

public class ResultSetDemo
{
    // Declaration
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public void getResultSetMetadata() {

        System.out.println("\n------ResultSetMetadataDemo-----------\n");

        try {
            // Loading and Registering drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             PreparedStatement statement = connection.prepareStatement("select * from Employee");
             ResultSet resultSet = statement.executeQuery();)
        {
            // Retrieving metadata from resultset (Column name,Type,columns count)
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            System.out.println("No of columns: " + resultSetMetaData.getColumnCount() + "  Column Name: " + resultSetMetaData.getColumnName(2) + "  ColumnType:  " + resultSetMetaData.getColumnTypeName(2));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}


