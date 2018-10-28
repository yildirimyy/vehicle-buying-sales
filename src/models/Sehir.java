package models;

public class Sehir {

	public int SehirID;
	public String Sehir;
	
	public Sehir(int sehirID, String sehir) {
		super();
		SehirID = sehirID;
		Sehir = sehir;
	}
	
    @Override
    public String toString() {
        return this.Sehir;
    }

}
