import java.io.*;
import java.sql.*;


public class final {
        public static void main(String[] args) throws IOException{

    //Load the PostgreSQL JDBC driver class
                try{
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException cnfe){
                    System.out.println("Could not find the JDBC driver!");
                    System.exit(1);
                }

    //Enter the connection details
    String hostname = "localhost";	// If PostgreSQL is running on some other machine enter the IP address of the machine here
    String username = "postgres"; // Enter your PostgreSQL username
    String password = "varshini98"; // Enter your PostgreSQL password
    String dbName = "dbms"; // Enter the name of the database that has the university tables.
    String connectionUrl = "jdbc:postgresql://" + hostname + "/" + dbName;
    Connection conn = null;

    //Connect to the database
                try {
                    conn = DriverManager.getConnection(connectionUrl,username, password);
                    System.out.println("Connected successfullly");
                } catch (SQLException sqle) {
                       System.out.println("Connection failed");
           System.out.println(sqle);
           // Uncomment the below line for a more detailed stack trace
           // sqle.printStackTrace();
                       System.exit(1);
                }

    //Execute the query and print the results
    try {

                    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter a student id:");
                    String student_id = br.readLine();

                    PreparedStatement pstmt=conn.prepareStatement("select * from takes where id=?");
                    pstmt.setString(1, student_id);
                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next()){
                            String name = rs.getString("course_id");
                            System.out.println(name);
                    }

        }

            catch (SQLException sqle) {
                       System.out.println(sqle);
                       System.exit(1);
                }
        }
}
