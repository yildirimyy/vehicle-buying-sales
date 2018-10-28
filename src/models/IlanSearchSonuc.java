package models;

public class IlanSearchSonuc {
	
	public int IlanID;
	public String Ilan_Adi;
	public double Ilan_Fiyat;
	public double Ilan_Km;
	public String Ilan_Tarih;
	
	public String Araba_Marka;
	public String Araba_Model;
	
	public String Renk;
	public String Vites_Turu;
	public String Yakit_Turu;
	public String Sehir;
	
	public IlanSearchSonuc(int ilanID, String ilan_Adi, double ilan_Fiyat, double ilan_Km, String ilan_Tarih,
			String araba_Marka, String araba_Model, String renk, String vites_Turu, String yakit_Turu, String sehir) {
		super();
		IlanID = ilanID;
		Ilan_Adi = ilan_Adi;
		Ilan_Fiyat = ilan_Fiyat;
		Ilan_Km = ilan_Km;
		Ilan_Tarih = ilan_Tarih;
		Araba_Marka = araba_Marka;
		Araba_Model = araba_Model;
		Renk = renk;
		Vites_Turu = vites_Turu;
		Yakit_Turu = yakit_Turu;
		Sehir = sehir;
	}

}
