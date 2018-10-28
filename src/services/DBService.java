package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import models.Araba;
import models.Ilan;
import models.IlanSearchSonuc;
import models.Renk;
import models.Sehir;
import models.VitesTuru;
import models.YakitTuru;

public class DBService {
	
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	public static final int INSERT = 1;
	public static final int UPDATE = 2;
	public static final int DELETE = 3;
	public static final int SELECT = 4;
	
	private static String userName = "dbAASKullanici";
	private static String pass = "dbAASKullaniciSifre";
	private static String dbName = "dbAracAlisSatis";	
	private static String host = "localhost";
	private static String port = "3306";
	private static String connString = "jdbc:mysql://"+ host + ":" + port + "/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
	
	public static Vector<Renk> renkler;
	public static Vector<Araba> arabalar;
	public static Vector<VitesTuru> vitesTurleri;
	public static Vector<YakitTuru> yakitTurleri;
	public static Vector<Sehir> sehirler;
	public static Vector<Ilan> ilanlar;
	public static Vector<IlanSearchSonuc> ilanSearchSonuclar;
	
	
	public static ResultSet dbSonuc;
		
	private static Properties getProperties(){
		Properties properties = new Properties();
		
		properties.setProperty("user", userName);
		properties.setProperty("password", pass);
		properties.setProperty("useSSL", "false");
		properties.setProperty("autoReconnect", "true");
		
		return properties;
	}
	
	private static Connection getConnection() {
		Connection connectionContext = null;
		Properties properties = getProperties();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			//return null;
		}
		
		try {	
			connectionContext = DriverManager
			.getConnection(connString, properties);
			
			//System.out.println("Baglanti gerceklesti");
			
			return connectionContext;
		} catch (SQLException e) {
			//System.out.println("Baglanti hatasi");
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * INSERT INTO table_name (column1, column2, column3, ...)
	 * VALUES (value1, value2, value3, ...); 
	 * */
	public static String GetInsertQuery(String tableName, Vector<ColumnValue> colVal) {
	
		String query = "";
		if(colVal.size() <= 0)
			return query;
		
		query += "INSERT INTO " + tableName + " ";
		
		query += "(";
		
		for (ColumnValue itemColVal : colVal) {
			query += itemColVal.col + ",";
		}
		//sondaki virgulu temizlemek icin regex
		query = query.replaceAll("\\,$", "");
		
		query += ") ";
		
		query += "VALUES ";
		
		query += "(";
		
		for (ColumnValue itemColVal : colVal) {
			
			//string ifadeler 'value' seklinde olmali
			if(UtilitiesService.isNumber(itemColVal.val))
				query += itemColVal.val + ",";
			else
				query += "'"+ itemColVal.val + "',";
			
		}
		//sondaki virgulu temizlemek icin regex
		query = query.replaceAll("\\,$", "");
		
		query += ");";	
		
		return query;
	}
	
	/*
	 * UPDATE table_name
	 * SET column1 = value1, column2 = value2, ...
	 * */
	public static String GetUpdateQuery(String tableName, Vector<ColumnValue> colVal) {

		String whereCondition = "";
		return GetUpdateQuery(tableName, colVal, whereCondition);
	}
	
	/*
	 * UPDATE table_name
	 * SET column1 = value1, column2 = value2, ...
	 * WHERE condition;
	 * */
	public static String GetUpdateQuery(String tableName, Vector<ColumnValue> colVal, String whereCondition) {
		
		String query = "";
		if(colVal.size() <= 0)
			return query;
		
		query += "UPDATE " + tableName + " ";
		query += "SET";
		
		//column1 = value1,		
		for (ColumnValue itemColVal : colVal) {
			
			query += " " + itemColVal.col + " = ";
			
			if(UtilitiesService.isNumber(itemColVal.val))
				query += itemColVal.val;
			else
				query += "'" + itemColVal.val + "'";
			
			query += ",";
			
		}
		
		//sondaki virgulu temizlemek icin regex
		query = query.replaceAll("\\,$", "");
		
		if(whereCondition != "")
			query += " WHERE " + whereCondition + ";";
		else
			query += ";";
		
		return query;
	}
	
	/*
	 * DELETE FROM table_name
	 * */
	public static String GetDeleteQuery(String tableName) {
		
		String whereCondition = "";
		return GetDeleteQuery(tableName, whereCondition);
	}
	
	/*
	 * DELETE FROM table_name
	 * WHERE condition;
	 * */
	public static String GetDeleteQuery(String tableName, String whereCondition) {
		
		String query = "";
		
		query += "DELETE FROM " + tableName;
		
		if(whereCondition != "")
			query += " WHERE " + whereCondition + ";";
		else
			query += ";";
		
		return query;
	}
	
	public static String GetSelectQuery(String tableName) {
		
		String whereCondition = "";
		return GetSelectQuery(tableName, whereCondition);
	}
	
	public static String GetSelectQuery(String tableName, String whereCondition) {
				
		String query = "";
		
		query += "SELECT * FROM " + tableName;
		
		if(whereCondition != "")
			query += " WHERE " + whereCondition + ";";
		else
			query += ";";
		
		return query;
	}
	
	
	/*
	 * exec query insert update delete
	 * */
	public static String ExecQuery(String query) {
		
		Connection c = getConnection();
		String result = "";
		
		if(c == null)
			return ERROR;
		
		Statement stmt = null;	
		try {
			c.setAutoCommit(false);
			
			stmt = c.createStatement();
			
			stmt.executeUpdate(query);
			
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			
			//hata varsa sonuca error yaz
			result = ERROR;
		}
		
		//sonucu dondur hata olursa error donecek
		return result;		
	}
	
	/*
	 * exec query select
	 * */
	public static String ExecQuerySelect(String query, String tableName) {
		
		Connection c = getConnection();
		String result = "";
		
		if(c == null)
			return ERROR;
		
		Statement stmt = null;
		ResultSet rs;		
		try {
			c.setAutoCommit(false);
			
			stmt = c.createStatement();
			
			rs = stmt.executeQuery(query);
			
			donenSonuclariListelereDoldur(rs, tableName);
			
			rs.close();
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			
			//hata varsa sonuca error yaz
			result = ERROR;
		}
		
		//sonucu dondur hata olursa error donecek
		return result;		
	}
	
	
	private static void donenSonuclariListelereDoldur(ResultSet resultSet, String tableName) throws SQLException {

		switch (tableName) {
			case UtilitiesService.Tbl_Sehir: {
				
				  sehirler = new Vector<>();
			      while (resultSet.next())
			      {
			        int id = resultSet.getInt("SehirID");
			        String sehir = resultSet.getString("Sehir");
			        
			        sehirler.add(new Sehir(id, sehir));
			      }			
				
				break;
			}
			case UtilitiesService.Tbl_Renk: {
				
				  renkler = new Vector<>();
			      while (resultSet.next())
			      {
			        int id = resultSet.getInt("RenkID");
			        String renk = resultSet.getString("Renk");
			        
			        renkler.add(new Renk(id, renk));
			      }
			      
				break;
			}
			case UtilitiesService.Tbl_VitesTuru: {
				
				  vitesTurleri = new Vector<>();
			      while (resultSet.next())
			      {
			        int id = resultSet.getInt("VitesTuruID");
			        String vitesTur = resultSet.getString("Vites_Turu");
			        
			        vitesTurleri.add(new VitesTuru(id, vitesTur));
			      }
			      
				break;
			}
			case UtilitiesService.Tbl_YakitTuru: {
				  
				yakitTurleri = new Vector<>();
			      while (resultSet.next())
			      {
			        int id = resultSet.getInt("YakitTuruID");
			        String yakitTur = resultSet.getString("Yakit_Turu");
			        
			        yakitTurleri.add(new YakitTuru(id, yakitTur));
			      }
			      
				break;
			}
			case UtilitiesService.Tbl_Ilan: {
				
				ilanlar = new Vector<>();
				
			      while (resultSet.next())
			      {
			        int id = resultSet.getInt("IlanID");
			        String ad = resultSet.getString("Ilan_Adi");
			        String tarih = resultSet.getString("Ilan_Tarih");
			        double fiyat = resultSet.getDouble("Ilan_Fiyat");
			        double km = resultSet.getDouble("Ilan_Km");
			        
			        int arabaId = resultSet.getInt("Ilan_ArabaID");
			        int sehirId = resultSet.getInt("Ilan_SehirID");
			      
			        ilanlar.add(new Ilan(id, ad, fiyat, km, tarih, arabaId, sehirId));
			      }
				
				break;
			}
			case UtilitiesService.Tbl_Araba: {
				
				arabalar = new Vector<>();
				
			      while (resultSet.next())
			      {
			        int id = resultSet.getInt("ArabaID");
			        String marka = resultSet.getString("Araba_Marka");
			        String model = resultSet.getString("Araba_Model");
			        
			        int vitesId = resultSet.getInt("Araba_VitesTuruID");
			        int yakitId = resultSet.getInt("Araba_YakitTuruID");
			        int renkId = resultSet.getInt("Araba_RenkID");
			      
			        arabalar.add(new Araba(id, marka, model, vitesId, yakitId, renkId));
			      }
				
				break;
			}
			case UtilitiesService.IlanSearchSonuc: {
				
				ilanSearchSonuclar = new Vector<>();

				while (resultSet.next()) {
					
					int id = resultSet.getInt("IlanID");
					String ad = resultSet.getString("Ilan_Adi");
					double fiyat = resultSet.getDouble("Ilan_Fiyat");
					double km = resultSet.getDouble("Ilan_Km");
					String tarih = resultSet.getString("Ilan_Tarih");
					String marka = resultSet.getString("Araba_Marka");
					String model = resultSet.getString("Araba_Model");
					String renk = resultSet.getString("Renk");
					String vites = resultSet.getString("Vites_Turu");
					String yakit = resultSet.getString("Yakit_Turu");
					String sehir = resultSet.getString("Sehir");
					
					ilanSearchSonuclar.add(new IlanSearchSonuc(id, ad, fiyat, km, tarih, marka, model, renk, vites, yakit, sehir));
					
				}
				
				break;
			}
			default: {
				break;
			}
		}

	}
	

}
