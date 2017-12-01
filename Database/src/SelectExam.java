import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExam {
	
	public static void main(String[] args) {
		ResultSet rs=null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			
		}catch(ClassNotFoundException ee) {
			System.err.println("연결 드라이버가 없음");
		} 
		
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/test5?useSSL=false";
		String id ="root";
		String pw = "jebon0722";
		try {
			conn = DriverManager.getConnection(url, id, pw);
		}catch(SQLException ee) {
			System.err.println("서버 연결 실패 !");
			
		}
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
		}catch(SQLException ee) {
			System.err.println("작업처리 객체생성 실패!");
			
		}
		
		try {
			rs = stmt.executeQuery("select * from t1");
			while(rs.next()) {
				System.out.println(rs.getString("name")+"  "+rs.getString("month")+"."+rs.getString("day"));
			}
			
		}catch(SQLException ee) {
			System.err.println("명령어 접속 실패!");
		}
		
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee) {
			System.err.println("접속 종료 실패!"+ee.toString());
		}
	}//main

}
