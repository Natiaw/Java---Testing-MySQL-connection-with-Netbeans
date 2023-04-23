
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author cagol
 */
public class TestconnectMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            //Register the connection
            //Get the class driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Get the DB URL
            String url = "jdbc:mysql://localhost:3306/javatest?zeroDateTimeBehavior=CONVERT_TO_NULL";
            //Create a String object of username and password of MySQL Server Connection
            String username = "javauser";
            String password = "javinha";
            //Create a Connection object to regisdter the driver
            Connection conn = DriverManager.getConnection(url, username, password);
            //Create a String object of SQL query
            String sql = "SELECT * FROM user_info";
            //Prepare the SQL Query
            PreparedStatement pst = conn.prepareStatement(sql);
            //Gets the result of SQL Query
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                System.out.println("First Name\t\tLastName");
                System.out.println(rs.getString(2)+ "\t\t" + rs.getString(3) + "\t\t");
                Scanner s = new Scanner(System.in);
                System.out.println("Enter username: ");
                String uname = s.nextLine();
                System.out.println("Enter password: ");
                String upass = s.nextLine();
                /**
                 * Positions 5 and 6 because in the MySql table it's the position of the username and password, respectively. 
                 * username is admin
                 * password is password eheh
                 */
                if(uname.equals(rs.getString(5)) && upass.equals(rs.getString(6))){
                    System.out.println("Login Succesfull");
                }else {
                    System.out.println("Username and/or password is wrong");
                }
              
            }
            
            
        } catch(ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
