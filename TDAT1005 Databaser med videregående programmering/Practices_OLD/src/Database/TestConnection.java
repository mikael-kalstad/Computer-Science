import java

class TestConnection {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String password = s.nextLine();

		String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/?user=mikaek&password=" + password.trim();
		Connection con = DriverManager.getConnection(url);

		Statement stmt = con.createStatement();
	}
}