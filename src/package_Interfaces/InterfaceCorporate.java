package package_Interfaces;

import package_Classes.Corporate;

public interface InterfaceCorporate {

	public void addEvent(Corporate c);
	public int calBudget(Corporate c);
	public void getEvent(Corporate c);
	public void updateEvent(Corporate c);
	public void deleteEvent(Corporate c);
	public int genEID();
}
