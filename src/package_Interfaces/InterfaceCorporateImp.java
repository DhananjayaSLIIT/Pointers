package package_Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import package_Classes.Corporate;
import package_Classes.Party;
import package_Common.DBconnection;
import sun.font.CreatedFontTracker;

public class InterfaceCorporateImp implements InterfaceCorporate{

	Corporate c = new Corporate();

	@Override
	public void addEvent(Corporate c) {
		
		try {
			Connection conn;
			conn = DBconnection.getConnection();
			String sql = "INSERT into corporate(eid,date,etype,venue,time,pcount,f_rental,description,budget)VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, c.getEid());
			ps.setString(2, c.getDate());
			ps.setString(3, c.getEtype());
			ps.setString(4, c.getVenue());
			ps.setString(5, c.getTime());
			ps.setInt(6, c.getPcount());
			ps.setString(7, c.getF_rental());
			ps.setString(8, c.getDescrition());
			ps.setInt(9, c.getBudget());
			ps.execute();
			
		} catch (SQLException |NullPointerException |NumberFormatException |ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int calBudget(Corporate c) {
		int total = 0;
		try {
			Connection conn;
			conn = DBconnection.getConnection();
			Statement s =(Statement) conn.createStatement();
			
			if(c.getVenue().equals("None")) {
				total = total + 0;
			}else {
				String venue = c.getVenue();
				String sql = "SELECT item_rate FROM venues WHERE item_name = '"+venue+"'";
				ResultSet rs = s.executeQuery(sql);
				
				while(rs.next()) {
					int rate = rs.getInt("item_rate");
					total = total + rate;	
				}
			}
			
			if(c.getF_rental().equals("None")) {
				total = total + 0;
			}else {
				int pcount = c.getPcount();
				String sql = "SELECT item_rate FROM otheritem WHERE item_name = 'furniture'";
				ResultSet rs = s.executeQuery(sql);
				
				while(rs.next()) {
					int rate = rs.getInt("item_rate");
					total = total + (rate*pcount);	
				}
			}
			
			
		} catch (SQLException | ClassNotFoundException | NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		
		return total;
	}
	
	

	@Override
	public void getEvent(Corporate c) {
		
		try {
			Connection conn;
			Statement s;
			int eid = c.getEid();
			conn = DBconnection.getConnection();
			String sql = "SELECT * FROM corporate WHERE eid = '"+eid+"'";
			s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				c.setDate(rs.getString("date"));
				c.setEtype(rs.getString("etype"));
				c.setVenue(rs.getString("venue"));
				c.setTime(rs.getString("time"));
				c.setPcount(rs.getInt("pcount"));
				c.setF_rental(rs.getString("f_rental"));
				c.setDescrition(rs.getString("description"));
				
			}
			
			
		} catch (SQLException | ClassNotFoundException |NullPointerException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEvent(Corporate c) {
	
		try {
			int eid = c.getEid();
			Connection conn;
			conn = DBconnection.getConnection();
			String sql = "UPDATE corporate SET date = ?, etype = ?, venue = ?, time = ?, pcount = ?, f_rental = ?, description = ?, budget = ? WHERE eid = "+eid+"";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, c.getDate());
			ps.setString(2, c.getEtype());
			ps.setString(3, c.getVenue());
			ps.setString(4, c.getTime());
			ps.setInt(5, c.getPcount());
			ps.setString(6, c.getF_rental());
			ps.setString(7, c.getDescrition());
			ps.setInt(8, c.getBudget());
			ps.execute();
		} catch (SQLException | ClassNotFoundException | NullPointerException  e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEvent(Corporate c) {
	
		try {
			
			Connection conn; 
			conn = DBconnection.getConnection();
			int eid = c.getEid();
			
			String sql = "DELETE FROM corporate WHERE eid = "+eid+"";
			
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.executeUpdate();
			
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int genEID() {
		
		Connection conn;
		Statement s;
		int count = 0;
		try {
			conn = DBconnection.getConnection();
			String query = "SELECT eid FROM corporate ORDER BY eid DESC LIMIT 1";
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

	
	
	

}
