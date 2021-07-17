package package_Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import package_Classes.Party;
import package_Common.DBconnection;

public class InterfacePartyImp implements InterfaceParty{
	Party p = new Party();
	
	//public static int pid = genPID();
	@Override
	public int genPID() {
		Connection conn;
		Statement s;
		int count = 0;
		try {
			conn = DBconnection.getConnection();
			String query = "SELECT pid FROM party ORDER BY pid DESC LIMIT 1";
			s = (Statement) conn.createStatement();
			ResultSet rset = s.executeQuery(query);
			if(!rset.next()) {
				count = 0;
			}else {
				count = rset.getInt(1) + 1;
			}
			
		} catch (SQLException| ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static void createTable() {
		
		String sql1 = "DROP TABLE party";
		String sql2 = "CREATE TABLE party(\r\n" + 
				"	pid int PRIMARY KEY not null,\r\n" + 
				"	pdate varchar(8),\r\n" + 
				"	ptype varchar(30),\r\n" + 
				"	venue varchar(30),\r\n" + 
				"	time varchar(30),\r\n" + 
				"	pcount int,\r\n" + 
				"	decoration varchar(5),\r\n" + 
				"	photo varchar(5),\r\n" + 
				"	entertain varchar(30),\r\n" + 
				"	description varchar(5000),\r\n" + 
				"    budget int\r\n" + 
				"\r\n" + 
				")";
		
		try {
			Connection conn = DBconnection.getConnection();
			Statement s;
			DatabaseMetaData dmd = (DatabaseMetaData) conn.getMetaData();
			ResultSet rs = dmd.getTables(null, null, "party", null);
			
			if(rs.next()) {
				s = (Statement) conn.createStatement();
				s.executeUpdate(sql1);
				
			}else {
				s = (Statement) conn.createStatement();
				s.executeUpdate(sql2);
			}
			
		} catch (Exception e) {
			
		}
		
		
	}

	@Override
	public void addParty(Party p) {
		
		try {
			Connection conn = DBconnection.getConnection();
			String sql1 = "INSERT INTO party (pid,pdate,ptype,venue,time,pcount,decoration,photo,entertain,description,budget)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql1);
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getPdate());
			ps.setString(3, p.getPtype());
			ps.setString(4, p.getVenue());
			ps.setString(5, p.getTime());
			ps.setInt(6, p.getPcount());
			ps.setString(7, p.getDecoration());
			ps.setString(8, p.getPhoto());
			ps.setString(9, p.getEntertain());
			ps.setString(10, p.getDescription());
			ps.setInt(11, p.getBudget());
			ps.execute();
			
		} catch (SQLException | ClassNotFoundException | NumberFormatException |NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int calBudget(Party p) {
		int total = 0;
		
		try {
			Connection conn;
			conn = DBconnection.getConnection();
			Statement s = (Statement) conn.createStatement();
			
			
			if(p.getVenue().equals("None")) {
				total = total + 0;
				
			}else {
				String venue = p.getVenue();
				String sql = "SELECT item_rate FROM venues WHERE item_name = '"+venue+"'";
				ResultSet rs = s.executeQuery(sql);
				
				while(rs.next()) {
					int rate = rs.getInt("item_rate");
					total = total + rate;	
				}
			}
			
			
			if(p.getDecoration().equals("None")) {
				total = total + 0;
			}else{
				
				String sql = "SELECT item_rate FROM otheritem WHERE item_name = 'Flower decoration'";
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()) {
					int rate = rs.getInt("item_rate");
					total = total + rate;
				}
			}
			
			
			if(p.getPhoto().equals("None")) {
				total = total + 0;
			}else if(p.getPhoto().equals("Yes")) {
				String sql = "SELECT item_rate FROM otheritem WHERE item_name = 'Photography'";
				
				ResultSet rset = s.executeQuery(sql);
				while(rset.next()){
					int rate = rset.getInt("item_rate");
					total = total + rate;
					
				}
				
				
			}
			
			
			
			if(p.getEntertain().equals("None")) {
				total = total + 0;
			}
			else{
				
				String entertain = p.getEntertain();
				String sql = "SELECT item_rate FROM otheritem WHERE item_name = '"+entertain+"'";
				ResultSet rset = s.executeQuery(sql);
				while(rset.next()) {
					int rate = rset.getInt("item_rate");
					total = total + rate;
				}
				
			}
			
		} catch (SQLException|ClassNotFoundException|NullPointerException|NumberFormatException e) {
			e.printStackTrace();
		}
		
		return total;
	}

	@Override
	public void getParty(Party p) {
		try {
			
			Connection conn;
			Statement s;
			int pid = p.getPid();
			String sql1 = "SELECT * FROM party WHERE pid = "+pid+"";
			conn = DBconnection.getConnection();
			s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery(sql1);
			
			while(rs.next()) {
				p.setPdate(rs.getString("pdate"));
				p.setPtype(rs.getString("ptype"));
				p.setVenue(rs.getString("venue"));
				p.setTime(rs.getString("time"));
				p.setPcount(rs.getInt("pcount"));
				p.setDecoration(rs.getString("decoration"));
				p.setPhoto(rs.getString("photo"));
				p.setEntertain(rs.getString("entertain"));
				p.setDescription(rs.getString("description"));
			}
			
		} catch (SQLException | ClassNotFoundException  e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateParty(Party p) {
		try {
			int pid = p.getPid();
			Connection conn = DBconnection.getConnection();
			String sql1 = "UPDATE party SET pdate = ?, ptype = ?, venue = ?, time = ?, pcount = ?, decoration = ?, photo = ?, entertain = ?, description = ?, budget = ? WHERE pid = "+pid+"";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql1);
			//ps.setInt(1, p.getPid());
			ps.setString(1, p.getPdate());
			ps.setString(2, p.getPtype());
			ps.setString(3, p.getVenue());
			ps.setString(4, p.getTime());
			ps.setInt(5, p.getPcount());
			ps.setString(6, p.getDecoration());
			ps.setString(7, p.getPhoto());
			ps.setString(8, p.getEntertain());  
			ps.setString(9, p.getDescription());
			ps.setInt(10, p.getBudget());
			ps.execute();
			
			
			
		} catch (SQLException | ClassNotFoundException | NumberFormatException |NullPointerException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteParty(Party p) {
		try {
			
			Connection conn; 
			conn = DBconnection.getConnection();
			int pid = p.getPid();
			
			String sql = "DELETE FROM party WHERE pid = "+pid+"";
			
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.executeUpdate();
			
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
