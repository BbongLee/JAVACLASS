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
			System.err.println("���� ����̹��� ����");
		} 
		
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/test5?useSSL=false";
		String id ="root";
		String pw = "jebon0722";
		try {
			conn = DriverManager.getConnection(url, id, pw);
		}catch(SQLException ee) {
			System.err.println("���� ���� ���� !");
			
		}
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
		}catch(SQLException ee) {
			System.err.println("�۾�ó�� ��ü���� ����!");
			
		}
		
		try {
			rs = stmt.executeQuery("select * from t1");
			while(rs.next()) {
				System.out.println(rs.getString("name")+"  "+rs.getString("month")+"."+rs.getString("day"));
			}
			
		}catch(SQLException ee) {
			System.err.println("��ɾ� ���� ����!");
		}
		
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee) {
			System.err.println("���� ���� ����!"+ee.toString());
		}
	}//main

}
