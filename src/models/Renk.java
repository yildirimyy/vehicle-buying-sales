package models;

public class Renk {
	
	public int RenkID;
	public String Renk;
	
	public Renk(int renkID, String renk) {
		super();
		RenkID = renkID;
		Renk = renk;
	}
	
    @Override
    public String toString() {
        return this.Renk;
    }
}
