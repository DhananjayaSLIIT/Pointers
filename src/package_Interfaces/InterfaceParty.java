package package_Interfaces;

import package_Classes.Party;

public interface InterfaceParty {


	public void addParty(Party p);
	public int calBudget(Party p);
	public void getParty(Party p);
	public void updateParty(Party p);
	public void deleteParty(Party p);
	public int genPID();
}
