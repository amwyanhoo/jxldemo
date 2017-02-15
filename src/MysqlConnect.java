import java.sql.*;

public class MysqlConnect {
//	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DBURL = "jdbc:oracle:thin:@192.168.8.253:1521:orcl11";;
	private static final String DBUSER = "KMS";
	private static final String DBPASSWORD = "KMS";
//	private static final String A = "jdbc:mysql://localhost:3306/mysql?user=root&password=root&useUnicode=true&characterEncoding=utf8";
	private Connection conn = null;

	public MysqlConnect() throws Exception {
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnect() {
		return this.conn;
	}

	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}