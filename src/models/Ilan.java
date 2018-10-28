package models;

public class Ilan {
	
	public int IlanID;
	public String Ilan_Adi;
	public double Ilan_Fiyat;
	public double Ilan_Km;
	public String Ilan_Tarih;
	public int Ilan_ArabaID;
	public int Ilan_SehirID;
	
	public Ilan(int ilanID, String ilan_Adi, double ilan_Fiyat, double ilan_Km, String ilan_Tarih, int ilan_ArabaID,
			int ilan_SehirID) {
		super();
		IlanID = ilanID;
		Ilan_Adi = ilan_Adi;
		Ilan_Fiyat = ilan_Fiyat;
		Ilan_Km = ilan_Km;
		Ilan_Tarih = ilan_Tarih;
		Ilan_ArabaID = ilan_ArabaID;
		Ilan_SehirID = ilan_SehirID;
	}
	

}
