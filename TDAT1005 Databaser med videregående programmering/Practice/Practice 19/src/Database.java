import java.sql.*;

public class Database {
    private Connection con;
    private Statement stmt;


    public Database(String databasedriver, String brukernavn, String passord) {
        String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/mikaek?user="+brukernavn+"&password=" + passord;

        try(Connection con = DriverManager.getConnection(url)) {
            Statement stmt = con.createStatement();;
        }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void lukkForbindelse() {
        try {
            stmt.close();
            con.close();
        }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void regNyBok(Bok nyBok) {
        try {
            ResultSet resBok = stmt.executeQuery("INSERT INTO boktittel(isbn, forfatter, tittel) values("+nyBok.getIsbn()+","+nyBok.getForfatter()+","+nyBok.getTittel());
            ResultSet resEks = stmt.executeQuery("insert into eksemplar(isbn, eks_nr) values ("+nyBok.getIsbn()+", 1)");
        }
        catch(SQLException e) { e.printStackTrace(); }
    }
}
