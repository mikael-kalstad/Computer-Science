import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySqlCon {
    public static void main(String args[]) throws Exception{
        System.out.println("Starter opp..");

        Scanner s = new Scanner(System.in);
        System.out.println("Brukernavn: ");
        String username = s.nextLine();
        System.out.println("Passord: ");
        String password = s.nextLine();
        s.close();

        String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/mikaek?user="+username+"&password=" + password;

        try(Connection con = DriverManager.getConnection(url);) {

            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM boktittel");

            while (res.next()) {
                System.out.println("Personnr = " + res.getString("tittel"));
            }
        }catch(SQLException sq){
            System.out.println("SQL-feil " + sq);
        }
    }

}