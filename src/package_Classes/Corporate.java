package package_Classes;

public class Corporate {

	static int eid;
	String date;
	String etype;
	String venue;
	String time;
	int pcount;
	String f_rental;
	String descrition;
	int budget;
	
	
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setEtype(String etype) {
		this.etype = etype;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public void setTime(String time) {
		if(time == null) {
			this.time = "None";
		}else {
			this.time = time;
		}	
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	public void setF_rental(String f_rental) {
		if(f_rental != null){
			this.f_rental = "Yes";
		}else if(f_rental == null){
			this.f_rental = "None";
		}
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	
	public int getEid() {
		return eid;
	}
	public String getDate() {
		return date;
	}
	public String getEtype() {
		return etype;
	}
	public String getVenue() {
		return venue;
	}
	public String getTime() {
		return time;
	}
	public int getPcount() {
		return pcount;
	}
	public String getF_rental() {
		return f_rental;
	}
	public String getDescrition() {
		return descrition;
	}
	public int getBudget() {
		return budget;
	}
	
	
	
}
