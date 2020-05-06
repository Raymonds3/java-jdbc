import java.sql.*;

public class SqlQueries {

    public static void question1() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Umuzi",
                "user","password1");
        System.out.println("Question 1" + "\n"
                + "SELECT ALL records from table Customers.");
        System.out.println();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Customers;");

        while(resultSet.next()){
            System.out.println(resultSet.getString("CustomerID")+", "
                    +resultSet.getString("FirstName")+", "+resultSet.getString("LastName")+", "
                    +resultSet.getString("Gender")+", "+resultSet.getString("Address")+", "
                    +resultSet.getString("Phone")+", "+resultSet.getString("Email")+", "
                    +resultSet.getString("City")+", "+resultSet.getString("country"));
        }
        System.out.println("________________________________________________________");
    }

    public static void question2() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Umuzi",
                "user","password1");
        System.out.println("Question 2" + "\n"
                + "SELECT records only from the name column in the Customers table.");
        System.out.println();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT FirstName FROM Customers;");

        while(resultSet.next()){
            System.out.println(resultSet.getString("FirstName"));
        }
        System.out.println("________________________________________________________");
    }

    public static void question3() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Umuzi",
                "user","password1");
        System.out.println("Question 3" + "\n"
                + "Show the name of the Customer whose CustomerID is 1.");
        System.out.println();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT FirstName FROM Customers WHERE CustomerID = 1;");

        while(resultSet.next()){
            System.out.println(resultSet.getString("FirstName"));
        }
        System.out.println("________________________________________________________");
    }

    public static void question4() {
        String resultSet = "UPDATE Customers SET FirstName = 'Lerato', LastName = 'Mabitso' WHERE CustomerID = 1;";
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Umuzi",
                "user","password1");
        Statement statement = connection.createStatement();) {

            System.out.println("Question 4" + "\n"
                    + "UPDATE the record for CustomerID = 1 on the Customer table so that the name is Lerato Mabitso.");
            System.out.println();
            System.out.println("CustomerID 1 was Updated to Lerato Mabitso");
            System.out.println("________________________________________________________");

            statement.executeQuery(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void question5() {
        String resultSet = "DELETE FROM Customers WHERE CustomerID = 2;";
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Umuzi",
                "user","password1");
        Statement statement = connection.createStatement();) {
            System.out.println("Question 5" + "\n"
                    + "DELETE the record from the Customers table for customer 2 (CustomerID = 2)");
            System.out.println();
            System.out.println("CustomerID 2 was DELETED");
            System.out.println("________________________________________________________");
            statement.executeQuery(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void question6() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Umuzi",
                "user","password1");
        System.out.println("Question 6" + "\n"
                + "Select all unique statuses from the Orders table and get a count of the number of orders for each unique status.");
        System.out.println();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT COUNT(Status) FROM Orders WHERE Status = 'Not shipped';");

        Statement statement1 = connection.createStatement();

        ResultSet resultSet1 = statement1.executeQuery("SELECT COUNT(Status) FROM Orders WHERE Status = 'Shipped';");

        while(resultSet.next() && resultSet1.next()){
            System.out.println("The number of Not Shipped Orders is = "+resultSet.getString("COUNT"));

            System.out.println("The number of Shipped Orders is = "+resultSet1.getString("COUNT"));
        }

        System.out.println("________________________________________________________");
    }

    public static void question7() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Umuzi",
                "user","password1");
        System.out.println("Question 7" + "\n"
                + "Return the MAXIMUM payment made on the PAYMENTS table.");
        System.out.println();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT MAX(Amount) AS LargestAmount FROM Payments;");

        while(resultSet.next()){
            System.out.println("The largest Amount is = "+resultSet.getString("LargestAmount"));
        }
        System.out.println("________________________________________________________");
    }
}
