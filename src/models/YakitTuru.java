package models;

public class YakitTuru {
	
	public int YakitTuruID;
	public String Yakit_Turu;
	
	public YakitTuru(int yakitTuruID, String yakit_Turu) {
		super();
		YakitTuruID = yakitTuruID;
		Yakit_Turu = yakit_Turu;
	}
	
    @Override
    public String toString() {
        return this.Yakit_Turu;
    }
}
