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

    public static void question4() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Umuzi",
                "user","password1");

        System.out.println("Question 4" + "\n"
                + "UPDATE the record for CustomerID = 1 on the Customer table so that the name is “Lerato Mabitso”.");
        System.out.println();

        Statement statement = connection.createStatement();
        Statement statement1 = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("UPDATE Customers SET FirstName = 'Lerato', LastName = 'Mabitso'" +
                " WHERE CustomerID = 1;");
        ResultSet resultSet1 = statement1.executeQuery("SELECT FirstName, LastName FROM Customers WHERE CustomerID = 1;");

//        resultSet.next();
        while(resultSet1.next()){
            System.out.println("CustomerID 1 was Updated to Lerato Mabitso"+"\n"
                    +resultSet.getString("FirstName")+", "+resultSet.getString("LastName"));
        }
        System.out.println("________________________________________________________");
    }
}
