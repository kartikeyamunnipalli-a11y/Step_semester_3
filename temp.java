import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/kartik_db"; 
        String user = "root";
        String password = "Kartik@6135"; // Remember to put your password back here!

        try {
            // 1. Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!\n");

            // 2. INSERT DATA (Using PreparedStatement for safety)
            String insertSql = "INSERT INTO me (id, name, marks) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);
            insertStatement.setInt(1, 2);              // Sets the first '?' to ID 2
            insertStatement.setString(2, "Arjun");     // Sets the second '?' to Name 'Arjun'
            insertStatement.setInt(3, 88);             // Sets the third '?' to Marks 88
            
            int rowsAdded = insertStatement.executeUpdate();
            System.out.println("Rows added: " + rowsAdded);

            // 3. READ DATA (Using Statement and ResultSet)
            System.out.println("\n--- Current Data in 'me' Table ---");
            String selectSql = "SELECT * FROM me";
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectSql);

            // Loop through the results and print them
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int marks = resultSet.getInt("marks");
                
                System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
            }

            // 4. Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Database error occurred.");
            e.printStackTrace();
        }
    }
}

