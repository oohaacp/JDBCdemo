package com.stackroute.sample;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        SimpleJdbcDemo simple=new SimpleJdbcDemo();
        simple.getEmployeeDetails();
        simple.getEmployeeDetailsInReverse();
        simple.getEmployeeDetailsFromSecondRowInReverse();
        simple.getEmployeeDetailsByNameAndGender("ammu","female");

        System.out.println("----------------------------------------------------------");
        DatabaseMetadataDemo databaseMetadataDemo=new DatabaseMetadataDemo();
        System.out.println("----------------------------------------------------------");
        databaseMetadataDemo.databaseMetaData();

        JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();
        System.out.println("----------------------------------------------------------");
        jdbcBatchDemo.jdbcBatch();

        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        System.out.println("----------------------------------------------------------");
       /* try {
            jdbcTransactionDemo.jdbcTransaction();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
*/

        ResultSetDemo resultsetmetadatademo=new ResultSetDemo();
        resultsetmetadatademo.getResultSetMetadata();

        RowSetDemo rowsetdemo=new RowSetDemo();
        rowsetdemo.rowSetDemo();
    }
}


