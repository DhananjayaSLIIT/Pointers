package package_Classes;

public class Wedding {

	private static int bid;
	private String wedDate;
	private String venue;
	private String time;
	private String theme;
	private int paxCount;
	private String dressing;
	private String decoration;
	private String photo;
	private String carRental;
	private String entertain;
	private String poruwaCero;
	private String cakeDesign;
	private String cardDesign;
	private String description;
	private int budget;
	
	

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setWedDate(String wedDate) {
		this.wedDate = wedDate;
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
	
	public void setPaxCount(int paxCount) {
		if(paxCount == 0) {
			this.paxCount = 0;
		}else {
			this.paxCount = paxCount;
		}
	}
	
	public void setTheme(String theme) {
		if(theme == null) {
			this.theme = "None";
		}else{
			this.theme = theme;
		}
	}
	
	public void setDressing(String dressing) {
		
			if(dressing=="None") {
				this.dressing = "None";	
			}else{
				this.dressing = dressing;
			}
			
		
	}
	
	public void setDecoration(String decoration) {

		if(decoration == null) {
			this.decoration = "None";	
		}else if(decoration != null){
			this.decoration = "Yes";
		}
			
		
	}
	
	public void setPhoto(String photo) {
		if(photo == null) {
			this.photo = "None";	
		}else{
			this.photo = "Yes";
		}
		
	}
	
	
	public void setCarRental(String carRental) {
		
		if(carRental == "None") {
			this.carRental = "None";
		}else {
			this.carRental = carRental;
		}
	}
	
	public void setEntertain(String entertain) {
		if(entertain == "None") {
			this.entertain = "None";
		}else {
			this.entertain = entertain;
		}
	}

	public void setPoruwaCero(String poruwaCero) {
		if(poruwaCero == null) {
			this.poruwaCero = "None";
		}else{
			this.poruwaCero = "Yes";
		}
	}
	
	public void setCakeDesign(String cakeDesign) {
		if(cakeDesign == "None") {
			this.cakeDesign = "None";
		}else {
			this.cakeDesign = cakeDesign;
		}
		
	}
	
	public void setCardDesign(String cardDesign) {
		if(cardDesign == "None") {
			this.cardDesign = cardDesign;
		}else {
			this.cardDesign = cardDesign;
		}
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	

	public void setBudget(int budget) {
		this.budget = budget;
	}
//----------
	public int getBid() {
		return bid;
	}
	
	public String getWedDate() {
		
		return wedDate;
	}

	public String getVenue() {
		return venue;
	}

	public String getTime() {
		return time;
	}

	public String getTheme() {
		return theme;
	}

	public int getPaxCount() {
		return paxCount;
	}

	public String getDressing() {
		return dressing;
	}

	public String getDecoration() {
		return decoration;
	}

	public String getPhoto() {
		return photo;
	}

	public String getCarRental() {
		return carRental;
	}

	public String getEntertain() {
		return entertain;
	}

	public String getPoruwaCero() {
		return poruwaCero;
	}

	public String getCakeDesign() {
		return cakeDesign;
	}

	public String getCardDesign() {
		return cardDesign;
	}

	public String getDescription() {
		return description;
	}
	
	public int getBudget() {
		return budget;
	}
	
}
