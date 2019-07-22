package com.stackroute.sample;

import java.sql.*;

public class JdbcBatchDemo
{
    // Declaration
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public void jdbcBatch() {

        try {
            // Loading the driver and registering
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "Root@123");
             Statement statement = connection.createStatement();
        ) {
            // Enabling autocommit
            connection.setAutoCommit(false);
            // Inserting multiple queries to batch
            statement.addBatch("insert into Employee values(5,'siva',23,'Male')");
            statement.addBatch("insert into Employee values(6,'honey',25,'Male')");
            // Executing multiple queries with single batch command
            statement.executeBatch();
            // PrimaryKey Constraint is satisfied it commits otherwise it rollbacks
            connection.commit();
            System.out.println("\n Batch processing is done");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } catch (Exception ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
