package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Araba;
import models.Ilan;
import models.Sehir;
import services.InsertUpdateService;
import services.SelectService;

public class GuiIlan {
	
	private static JFrame frame;
	private static JPanel panel;
	private static JButton islemButton;
	private static DateFormat tarihformat;
	
	private static JTextField ilanAdi;
	private static JTextField ilanFiyat;
	private static JTextField ilanKm;
	private static JFormattedTextField ilanTarih;	
	private static JComboBox ilanArabaID;
	private static JComboBox ilanSehirID;
	
	static void combolariDoldur() {
		
		//butun vitesturlerini al
		Vector<Araba> arabalar = SelectService.arabalariAl(0);
		for (Araba araba : arabalar) {
			String comboMetin = araba.ArabaID + "-" + araba.Araba_Marka + "-" + araba.Araba_Model;
			ilanArabaID.addItem(comboMetin);
		}
		
		//butun sehirleri al
		Vector<Sehir> sehirler = SelectService.sehirleriAl(0);
		for (Sehir sehir : sehirler) {
			String comboMetin = sehir.SehirID + "-" + sehir.Sehir;
			ilanSehirID.addItem(comboMetin);
		}
	}
	
	static void panelOlustur() {
		
		frame = new JFrame("Ilan");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tarihformat = new SimpleDateFormat("yyyy-MM-dd");
		
		panel = new JPanel(new GridLayout(0, 1));
		ilanAdi = new JTextField();
		ilanFiyat = new JTextField();
		ilanKm = new JTextField();
		ilanTarih = new JFormattedTextField(tarihformat);
		ilanArabaID = new JComboBox();
		ilanSehirID = new JComboBox();
		
		panel.add(new JLabel("Ilan Adi:"));
		panel.add(ilanAdi);
		panel.add(new JLabel("Ilan Fiyat:"));
		panel.add(ilanFiyat);
		panel.add(new JLabel("Ilan Km:"));
		panel.add(ilanKm);
		panel.add(new JLabel("Ilan Tarih:"));
		panel.add(ilanTarih);
		panel.add(new JLabel("Ilan Araba ID:"));
		panel.add(ilanArabaID);
		panel.add(new JLabel("Ilan Sehir ID:"));
		panel.add(ilanSehirID);
		
		islemButton = new JButton("");

		panel.add(new JLabel(" "));
		panel.add(islemButton);
		panel.add(new JLabel(" "));
		
		frame.add(panel);
	}

	static void ilanEkle() {
		
		panelOlustur();
		ilanTarih.setText("2018-05-21");
		
		combolariDoldur();
		
		islemButton.setText("Ekle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ad = ilanAdi.getText();
				String km = ilanKm.getText();
				String tarih = ilanTarih.getText();
				String fiyat = ilanFiyat.getText();
				double kmDouble = 0;
				double fiyatDouble = 0;
				
				boolean kmKontrol = !km.equals("");
				boolean tarihKontrol = !tarih.equals("");
				boolean fiyatKontrol = !fiyat.equals("");
						
				boolean arabaIdCombo = ilanArabaID.getSelectedIndex() >= 0;
				boolean sehirIdCombo = ilanSehirID.getSelectedIndex() >= 0;
				boolean kontrolSonuc = arabaIdCombo && sehirIdCombo && kmKontrol && tarihKontrol && fiyatKontrol;
				
				boolean parseKontrol = true;
				try {
					kmDouble = Double.parseDouble(km);
					fiyatDouble = Double.parseDouble(fiyat);
				} catch (Exception e2) {
					parseKontrol = false;
				}
					
				//kontrolde sorun yoksa kayit servisi cagir
				if(!ad.equals("") && kontrolSonuc && parseKontrol) {
					
					String secilenAraba = (String)ilanArabaID.getSelectedItem();
					String secilenSehir = (String)ilanSehirID.getSelectedItem();
					
					// id al
					String[] text = secilenAraba.split("-");
					int arabaId = Integer.parseInt(text[0]);
					
					String[] text2 = secilenSehir.split("-");
					int sehirId = Integer.parseInt(text2[0]);
					
					Ilan kayitEdilecekIlan = new Ilan(0, ad, fiyatDouble, kmDouble, tarih, arabaId, sehirId);
					boolean result = InsertUpdateService.ilanEkleGuncelle(kayitEdilecekIlan);
					
					if(result) {
						JOptionPane.showMessageDialog(
								null, "Ekleme Basarili!", "Ekleme", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(
								null, "Ekleme Basarisiz!", "Ekleme", JOptionPane.ERROR_MESSAGE);
					}
					
				}else {
					JOptionPane.showMessageDialog(
							null, "Eksik Bilgiler Var", "Eksik Bilgi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		int result = JOptionPane.showConfirmDialog(null, panel, "Ilan Ekle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}
	
	static void ilanGuncelle(String ilanId) {
		
		panelOlustur();
		
		combolariDoldur();
		
		int secilenId = Integer.parseInt(ilanId);
		Vector<Ilan> ilanlar = SelectService.ilanlariAl(secilenId);
		
		if(ilanlar.size() == 1) {
			Ilan dbItem = ilanlar.firstElement();
			
			ilanAdi.setText(dbItem.Ilan_Adi);
			ilanFiyat.setText(Double.toString(dbItem.Ilan_Fiyat));
			ilanKm.setText(Double.toString(dbItem.Ilan_Km));
			ilanTarih.setText(dbItem.Ilan_Tarih);
			
			String arabaId = Integer.toString(dbItem.Ilan_ArabaID);
			String sehirId = Integer.toString(dbItem.Ilan_SehirID);
					
			//veritabanında kayitli olan araba bilgisini secmek icin
			if(dbItem.Ilan_ArabaID > 0) {
				for (int i = 0; i < ilanArabaID.getItemCount(); i++) {
					if(ilanArabaID.getItemAt(i).toString().contains(arabaId)) {
						ilanArabaID.setSelectedIndex(i);
						break;
					}
				}
			}
			
			// veritabanında kayitli olan sehir bilgisini secmek icin
			if(dbItem.Ilan_SehirID > 0) {
				for (int i = 0; i < ilanSehirID.getItemCount(); i++) {
					if(ilanSehirID.getItemAt(i).toString().contains(sehirId)) {
						ilanSehirID.setSelectedIndex(i);
						break;
					}
				}
			}
			
		}		
		
		islemButton.setText("Ekle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ad = ilanAdi.getText();
				String km = ilanKm.getText();
				String tarih = ilanTarih.getText();
				String fiyat = ilanFiyat.getText();
				double kmDouble = 0;
				double fiyatDouble = 0;
				
				boolean kmKontrol = !km.equals("");
				boolean tarihKontrol = !tarih.equals("");
				boolean fiyatKontrol = !fiyat.equals("");
						
				boolean arabaIdCombo = ilanArabaID.getSelectedIndex() >= 0;
				boolean sehirIdCombo = ilanSehirID.getSelectedIndex() >= 0;
				boolean kontrolSonuc = arabaIdCombo && sehirIdCombo && kmKontrol && tarihKontrol && fiyatKontrol;
				
				boolean parseKontrol = true;
				try {
					kmDouble = Double.parseDouble(km);
					fiyatDouble = Double.parseDouble(fiyat);
				} catch (Exception e2) {
					parseKontrol = false;
				}
					
				//kontrolde sorun yoksa kayit servisi cagir
				if(!ad.equals("") && kontrolSonuc && parseKontrol) {
					
					String secilenAraba = (String)ilanArabaID.getSelectedItem();
					String secilenSehir = (String)ilanSehirID.getSelectedItem();
					
					// id al
					String[] text = secilenAraba.split("-");
					int arabaId = Integer.parseInt(text[0]);
					
					String[] text2 = secilenSehir.split("-");
					int sehirId = Integer.parseInt(text2[0]);
					
					Ilan kayitEdilecekIlan = new Ilan(secilenId, ad, fiyatDouble, kmDouble, tarih, arabaId, sehirId);
					boolean result = InsertUpdateService.ilanEkleGuncelle(kayitEdilecekIlan);
					
					if(result) {
						JOptionPane.showMessageDialog(
								null, "Ekleme Basarili!", "Ekleme", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(
								null, "Ekleme Basarisiz!", "Ekleme", JOptionPane.ERROR_MESSAGE);
					}
					
				}else {
					JOptionPane.showMessageDialog(
							null, "Eksik Bilgiler Var", "Eksik Bilgi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		int result = JOptionPane.showConfirmDialog(null, panel, "Ilan Guncelle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}

}
