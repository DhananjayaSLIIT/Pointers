package package_Interfaces;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.WeekFields;
import java.io.IOException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import package_Classes.Wedding;
import package_Common.DBconnection;
import package_Common.SQL_Query;
import sun.font.CreatedFontTracker;

public class InterfacesWedImpl implements InterfaceWedding{
	
	Wedding w = new Wedding();

	@Override
	public int getBID() {
		int count = 0;
		Connection conn;
		Statement s;
		
		try {
			conn = DBconnection.getConnection();
			
			String query = "SELECT bid FROM wedding_bookings ORDER BY bid DESC LIMIT 1";
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
		
		String sql1 = "DROP TABLE wedding_bookings";
		String sql2 = "CREATE TABLE wedding_bookings(\r\n" + 
				"	bid varchar(5) not null PRIMARY KEY,\r\n" + 
				"	date date not null,\r\n" + 
				"    	venue varchar(20),\r\n" + 
				"	time varchar(10),\r\n" + 
				"	p_count int,\r\n" + 
				"    	theme varchar(20),\r\n" + 
				"    	dressing varchar(5),\r\n" + 
				"	decoration varchar(5),\r\n" + 
				"    	photo varchar(5),\r\n" + 
				"    	car_rental varchar(5),\r\n" + 
				"    	entertain varchar(5),\r\n" + 
				"   	pCeremony varchar(5),\r\n" + 
				"    	cake_design varchar(10),\r\n" + 
				"    	card_design varchar(10),\r\n" + 
				"    	descripton varchar(5000)\r\n" + 
				")";
		
		try {
			Connection conn = DBconnection.getConnection();
			Statement state = (Statement) conn.createStatement();
			
			DatabaseMetaData dmd = (DatabaseMetaData) conn.getMetaData();
			ResultSet rset = dmd.getTables(null, null, "wedding_bookings", null);
			if(rset.next()) {
				state.executeUpdate(sql1);
				System.out.println("Droped");
				state.executeUpdate(sql2);
				System.out.println("Created");
			}
			
		} catch (SQLException |ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
	}
		
	@Override
	public void addWedding(Wedding w) {
		
			
		try {
			
			Connection conn = DBconnection.getConnection();
			PreparedStatement ps;
			String sql = "INSERT INTO wedding_bookings(bid,date,venue,time,p_count,theme,dressing,decoration,photo,car_rental,entertain,pCeremony,cake_design,card_design,descripton,budget)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setInt(1,w.getBid());
			ps.setString(2, w.getWedDate());
			ps.setString(3, w.getVenue());
			ps.setString(4, w.getTime());
			ps.setInt(5, w.getPaxCount());
			ps.setString(6, w.getTheme());
			ps.setString(7, w.getDressing());
			ps.setString(8, w.getDecoration());
			ps.setString(9, w.getPhoto());
			ps.setString(10, w.getCarRental());
			ps.setString(11, w.getEntertain());
			ps.setString(12, w.getPoruwaCero());
			ps.setString(13, w.getCakeDesign());
			ps.setString(14, w.getCardDesign());
			ps.setString(15, w.getDescription());
			ps.setLong(16, w.getBudget());
			ps.execute();
			
		
		
			}catch(SQLException | ClassNotFoundException | NullPointerException sqle){
				
				sqle.printStackTrace();
			}
	}

	@Override
	public int calBudget(Wedding w) {
	
		int total  = 0;
		
		try {
			Connection conn = DBconnection.getConnection();
			Statement s;
			s = (Statement) conn.createStatement();
			
			if(w.getVenue().equals("None")) {
				total = total + 0;
			}else{
				String venue = w.getVenue();
				String sql = "SELECT item_rate FROM venues WHERE item_name = '"+venue+"'";
				ResultSet rset = s.executeQuery(sql);
				
				while(rset.next()) {
					int rate = rset.getInt("item_rate");
					total = total + rate;
				}
			}
			
			
			if(w.getDressing().equals("None")) {
				total = total + 0;
			}else{
				
				String sql = "SELECT item_rate FROM otheritem WHERE item_name = 'Bride & Groom'";
				ResultSet rset = s.executeQuery(sql);
				while(rset.next()) {
				int rate = rset.getInt("item_rate");
				total = total + rate;
				}	
			}
			
			if(w.getDecoration().equals("None")) {
				total = total + 0;
			}else{
				
				String sql = "SELECT item_rate FROM otheritem WHERE item_name = 'Flower decoration'";
				ResultSet rset = s.executeQuery(sql);
				while(rset.next()) {
				int rate = rset.getInt("item_rate");
				total = total + rate;
				}
				
			}
			
			if(w.getPhoto().equals("None")) {
				total = total + 0;
			}else{
				
				String sql = "SELECT item_rate FROM otheritem WHERE item_name = 'Photography'";
				
				ResultSet rset = s.executeQuery(sql);
				while(rset.next()){
				int rate = rset.getInt("item_rate");
				total = total + rate;
				}
				
			}
			
			
			if(w.getCarRental().equals("None")) {
				total = total + 0;
			}else{
				String car = w.getCarRental();
				String sql = "SELECT price FROM car_rental WHERE name = '"+car+"'";
				ResultSet rset = s.executeQuery(sql);
				while(rset.next()) {
				int rate = rset.getInt("price");
				
				total = total + rate;
				}
				
			}
			
			
			if(w.getEntertain().equals("None")) {
				total = total + 0;
			}else{
				String entertain = w.getEntertain();
				String sql = "SELECT item_rate FROM otheritem WHERE item_name = '"+entertain+"'";
				ResultSet rset = s.executeQuery(sql);
				while(rset.next()) {
				int rate = rset.getInt("item_rate");
				total = total + rate;
				}
				
			}
			
			if(w.getPoruwaCero().equals("None")) {
				total = total + 0;
			}else{
				String sql = "SELECT item_rate FROM otheritem WHERE item_name = 'Poruwa ceremony'";
				ResultSet rset = s.executeQuery(sql);
				while(rset.next()) {
				int rate = rset.getInt("item_rate");
				total = total + rate;
				}
			}
			
			if(w.getCakeDesign().equals("None")) {
				total = total + 0;
			}else{
				String cake = w.getCakeDesign();
				String sql = "SELECT ck_price FROM cake_design WHERE ck_name = '"+cake+"'";
				ResultSet rset = s.executeQuery(sql);
				while(rset.next()) {
				int rate = rset.getInt("ck_price");
				total = total + rate;
				}
			}
			
			
			if(w.getCardDesign().equals("None")) {
				total = total + 0;
			}else{
				String card = w.getCardDesign();
				String sql = "SELECT cr_price FROM card_design WHERE cr_name = '"+card+"'";
				ResultSet rset = s.executeQuery(sql);
				while(rset.next()) {
				int rate = rset.getInt("cr_price");
				total = total + rate;
				}
				
			}
			
		
			
		} catch (NumberFormatException | SQLException |ClassNotFoundException e) {
			e.printStackTrace();
			
		}
	
		return total;
	}
	
	//Need to check

	@Override
	public void getBookings(Wedding w) {
		
		Connection conn;
		Statement state;
		
		try {
			
			conn = DBconnection.getConnection();
			int bid = w.getBid();
			String sql = "SELECT * FROM wedding_bookings where bid = "+bid+"";
			state = (Statement) conn.createStatement();
			ResultSet rset = state.executeQuery(sql);
			
			while(rset.next()) {
				w.setWedDate(rset.getString("date"));
				w.setVenue(rset.getString("venue")); 
				w.setTime(rset.getString("time"));
				w.setPaxCount(rset.getInt("p_count"));
				w.setTheme(rset.getString("theme"));
				w.setDressing(rset.getString("dressing"));
				w.setDecoration(rset.getString("decoration"));
				w.setPhoto(rset.getString("photo"));
				w.setCarRental(rset.getString("car_rental"));
				w.setEntertain(rset.getString("entertain"));
				w.setPoruwaCero(rset.getString("pCeremony"));
				w.setCakeDesign(rset.getString("cake_design"));
				w.setCardDesign(rset.getString("card_design"));
				w.setDescription(rset.getString("descripton"));
				
				
			}
			
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateWedding(Wedding w) {
		
		Connection conn;
		PreparedStatement ps;
		
		try {
			int bid = w.getBid();
			conn = DBconnection.getConnection();
			String sql = "UPDATE wedding_bookings SET date=?, venue=?,time=?,p_count=?,theme=?,dressing=?,decoration=?,photo=?,car_rental=?,entertain=?,pCeremony=?,cake_design=?,card_design=?,descripton=?,budget=?  WHERE bid ="+bid+"";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, w.getWedDate());
			ps.setString(2, w.getVenue());
			ps.setString(3, w.getTime());
			ps.setInt(4, w.getPaxCount());
			ps.setString(5, w.getTheme());
			ps.setString(6, w.getDressing());
			ps.setString(7, w.getDecoration());
			ps.setString(8, w.getPhoto());
			ps.setString(9, w.getCarRental());
			ps.setString(10, w.getEntertain());
			ps.setString(11, w.getPoruwaCero());
			ps.setString(12, w.getCakeDesign());
			ps.setString(13, w.getCardDesign());
			ps.setString(14, w.getDescription());
			ps.setLong(15, w.getBudget());
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException |NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteWedding(Wedding w)  {
		try {
			Connection conn;
			PreparedStatement ps;
			int bid = w.getBid();
			String sql = "DELETE FROM wedding_bookings WHERE bid ="+bid+"";
			conn = DBconnection.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.execute();
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
		
		
}

	
	


