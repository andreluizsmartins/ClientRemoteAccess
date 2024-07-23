package br.com.sankhya.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DataBaseFactory {

	static final String JDBC_DRIVER = "org.h2.Driver";   
	static final String DB_URL = "jdbc:h2:~/home/public/remote-access";
	static final String USER = "sa"; 
	static final String PASS = ""; 
	public DataBaseFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() {
		Connection conn = null; 
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	     
		return conn;
	}
	public static void dropTables() {
		
		Connection c =DataBaseFactory.getConnection();
		Statement stmt = null;
		String sql = "drop table connections";
		try {
			stmt = c.createStatement();
			c.setAutoCommit(true);
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				c.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
		
	public static void setTables() {
	
		Connection c =DataBaseFactory.getConnection();
		Statement stmt = null;
		String sql = "create table if not exists connections (id bigint auto_increment, hash varchar, title varchar)";
		try {
			stmt = c.createStatement();
			c.setAutoCommit(true);
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				c.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	public static ArrayList<String> getHash(){
		
		ArrayList<String> list = new ArrayList<String>();
		Connection c =DataBaseFactory.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		
		String sql3 = "select * from connections";
		try {
			stmt = c.createStatement();
			c.setAutoCommit(true);
			rs =stmt.executeQuery(sql3);
			while(rs.next()){
				System.out.println(rs.getInt("id")+"::"+rs.getString("hash")+"::"+rs.getString("title"));
				list.add(rs.getString("title")+"::"+rs.getString("hash"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				c.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	public static boolean setHash(String hash, String title){
		Connection c =DataBaseFactory.getConnection();
		Statement stmt = null;
		String sql2 = "insert into connections (hash,title) values ('"+hash+"','"+title+"')";
		
		try {
			stmt = c.createStatement();
			c.setAutoCommit(true);
			
			stmt.execute(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				c.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return true;
	}
	public static boolean deleteHash(String hash){
		Connection c =DataBaseFactory.getConnection();
		Statement stmt = null;
		String sql = "delete from connections where hash = '"+hash+"'";
		
		try {
			stmt = c.createStatement();
			c.setAutoCommit(true);
			
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				c.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return true;
	}
}
