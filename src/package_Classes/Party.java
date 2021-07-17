package package_Classes;

public class Party {

	private static int pid;
	private String pdate;
	private String ptype;
	private String venue;
	private String time;
	private int pcount;
	private String decoration;
	private String photo;
	private String entertain;
	private String description;
	private int budget;
	
	
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public void setPtype(String ptype) {
		if(ptype != null) {
			this.ptype = ptype;
		}else if(ptype == null) {
			this.ptype = "None";
		}
	}
	public void setVenue(String venue) {
		if(venue != null){
			this.venue = venue;
		}else if(venue == null) {
			this.venue = "None";
		}
		
	}
	public void setTime(String time) {
		if(time != null) {
			this.time = time;
		}else if(time == null) {
			this.time = "None";
		}
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;	
	}
	public void setDecoration(String decoration) {
		if(decoration != null) {
			this.decoration = decoration;
		}else if(decoration == null) {
			this.decoration = "None";
		}	
	}
	public void setPhoto(String photo) {
		if(photo != null) {
			this.photo = photo;
		}else if(photo == null) {
			this.photo = "None";
		}	
	}
	public void setEntertain(String entertain) {
		if(entertain != null) {
			this.entertain = entertain;
		}else if(entertain == null) {
			this.entertain = "None";
		}
	}
	public void setDescription(String description) {	
			this.description = description;
	}
	
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public int getBudget() {
		return budget;
	}
	
	public int getPid() {
		return pid;
	}
	public String getPdate() {
		return pdate;
	}
	public String getPtype() {
		return ptype;
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
	public String getDecoration() {
		return decoration;
	}
	public String getPhoto() {
		return photo;
	}
	public String getEntertain() {
		return entertain;
	}
	public String getDescription() {
		return description;
	}
	
	
	
	
	
	
	
}
