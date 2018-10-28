package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import models.Araba;
import models.Ilan;
import models.IlanSearchSonuc;
import models.Renk;
import models.Sehir;
import models.VitesTuru;
import models.YakitTuru;
import services.ComboSiralama;
import services.DBService;
import services.DeleteService;
import services.SelectService;
import services.UtilitiesService;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel_1eft;
	private JPanel panel_right;
	private JPanel panel_table;
	private GroupLayout gl_contentPane;
	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	
	private JComboBox itemComboBox;
	private JButton filtrelemeButton;
	
	private TableModel tableModel;
	private JButton ekleButton;
	private JButton guncelleButton;
	private JButton silButton;
	
	private JComboBox<Sehir> comboSehirSec;
	private JComboBox<YakitTuru> comboYakitTuruSec;
	private JComboBox<VitesTuru> comboVitesTuruSec;
	private JSpinner minFiyatSec;
	private JSpinner maxFiyatSec;
	private JSpinner minKmSec;
	private JSpinner maxKmSec;
	private JComboBox comboTarihSec;
	private JComboBox<Renk> comboRenkSec;
	
	private JButton getirButton;
	private JTextField ilanAd;
	private JComboBox<ComboSiralama> checkIlanAD;
	private JComboBox<ComboSiralama> checkFiyat;
	private JComboBox<ComboSiralama> checkKm;
	private JComboBox<ComboSiralama> checkTarih;
	private JComboBox<ComboSiralama> checkMarka;
	private JComboBox<ComboSiralama> checkModel;
	private JComboBox<ComboSiralama> checkYakit;
	private JComboBox<ComboSiralama> checkVites;
	private JComboBox<ComboSiralama> checkRenk;
	private JComboBox<ComboSiralama> checkSehir;
	
	private JTextField fiyatText;
	private JTextField kmText;
	
	private void silmeYap(String tableSecimId, String comboSecim) {

		boolean sonuc = false;
		try {
			switch (comboSecim) {
				case "Ilan": {
					sonuc = DeleteService.ilanSil(tableSecimId);
					break;
				}
				case "Araba": {
					sonuc = DeleteService.arabaSil(tableSecimId);
					break;
				}
				case "YakitTuru": {
					sonuc = DeleteService.yakitTuruSil(tableSecimId);
					break;
				}
				case "VitesTuru": {
					sonuc = DeleteService.vitesTuruSil(tableSecimId);
					break;
				}
				case "Renk": {
					sonuc = DeleteService.renkSil(tableSecimId);
					break;
				}
				case "Sehir": {
					sonuc = DeleteService.sehirSil(tableSecimId);
					break;
				}
				default: {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(sonuc) {
			JOptionPane.showMessageDialog(null, "Silindi!", "Silme", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Silinmedi!", "Silme", JOptionPane.ERROR_MESSAGE);
		}
			
		//sayfayı yenilemek icin
		itemComboBox.setSelectedIndex(itemComboBox.getSelectedIndex());	
	}
	
	/*
	 * combobox uzerindeki secime gore getirilecek guncelleme ekranlari
	 * */
	private void guncellemeYap(String tableSecimId, String comboSecim) {
		
		try {
			switch (comboSecim) {
				case "Ilan": {
					GuiIlan.ilanGuncelle(tableSecimId);
					break;
				}
				case "Araba": {
	
					GuiAraba.arabaGuncelle(tableSecimId);
					break;
				}
				case "YakitTuru": {
	
					GuiYakitTuru.yakitTuruGuncelle(tableSecimId);
	
					break;
				}
				case "VitesTuru": {
	
					GuiVitesTuru.vitesTuruGuncelle(tableSecimId);
	
					break;
				}
				case "Renk": {
					GuiRenk.renkGuncelle(tableSecimId);
					break;
				}
				case "Sehir": {
	
					GuiSehir.sehirGuncelle(tableSecimId);
	
					break;
				}
				default: {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//sayfayı yenilemek icin
		itemComboBox.setSelectedIndex(itemComboBox.getSelectedIndex());		
	}
	
	/*
	 * combobox uzerindeki secime gore getirilecek ekleme ekranlari
	 * */
	private void eklemeYap(String comboSecim) {
		
		try {
			switch (comboSecim) {
				case "Ilan": {
					
					GuiIlan.ilanEkle();
					
					break;
				}
				case "Araba": {
					
					GuiAraba.arabaEkle();
		
					break;
				}
				case "YakitTuru": {
					
					GuiYakitTuru.yakitTuruEkle();
					
					break;
				}
				case "VitesTuru": {
					
					GuiVitesTuru.vitesTuruEkle();
		
					break;
				}
				case "Renk": {
					
					GuiRenk.renkEkle();
					
					break;
				}
				case "Sehir": {
					
					GuiSehir.sehirEkle();
		
					break;
				}
				default: {
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//sayfayı yenilemek icin
		itemComboBox.setSelectedIndex(itemComboBox.getSelectedIndex());
	
	}
	
	
	//update veya delete butonuna basinca tabloda secili olan id bilgisini almak icin
	private String getTableSecim() {
		
		//secilen satir ve sutunu al
		int secilenSatir = table.getSelectedRow();
		int secilenKolon = table.getSelectedColumn();
		
		String tableSecimString = "";
		//secilen kolon id kolonu degilse uyari goster
		if(secilenKolon == 0) {
			
			//secilen degeri al
			Object tableSecim = tableModel.getValueAt(secilenSatir, secilenKolon);
			tableSecimString = tableSecim != null ? tableSecim.toString() : "";
			
		}else {
			tableSecimString = "Lutfen id secimi yapin!";
			JOptionPane.showMessageDialog(null, tableSecimString, "Guncelleme", JOptionPane.WARNING_MESSAGE);
			tableSecimString = "";
		}
		
		return tableSecimString;
	}
	
	//secime gore sagda olusturulmasi gereken butonlara tiklandigi zaman butonlarin yapacaklari
	private void setButtonActions(String comboSecim) {
		
		ekleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboSecim != "") {
					eklemeYap(comboSecim);
				}
			}
		});

		guncelleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table != null && tableModel != null && tableModel.getColumnCount() > 0) {
					
					String tableSecimId = getTableSecim();
					if(tableSecimId != "") {
						
						//JOptionPane.showMessageDialog(null, tableSecimId, "Guncelleme", JOptionPane.WARNING_MESSAGE);
						guncellemeYap(tableSecimId, comboSecim);	
					}
				}

			}
		});

		silButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table != null && tableModel != null && tableModel.getColumnCount() > 0) {
					
					String tableSecimId = getTableSecim();
					if(tableSecimId != "") {
						//JOptionPane.showMessageDialog(null, tableSecimId, "Guncelleme", JOptionPane.WARNING_MESSAGE);
						silmeYap(tableSecimId, comboSecim);
					}
				}

			}
		});
		
	}

	//secime gore sag tarafa getirilecek table
	private TableModel getTableModel(String comboSecim){
		
		Vector<String> kolonlar= new Vector<>();
		DefaultTableModel customTablemodel = new DefaultTableModel(kolonlar, 0);
		
		switch (comboSecim) {
			case "Ilan": {
				
				kolonlar = UtilitiesService.getKolonIsimleri(Ilan.class);	
				customTablemodel = new DefaultTableModel(kolonlar, 0);
				
				Vector<Ilan> ilanlar = SelectService.ilanlariAl(0);
				for (Ilan ilan : ilanlar) {
					Vector<String> satir = new Vector<>();
					
					satir.add(Integer.toString(ilan.IlanID));
					satir.add(ilan.Ilan_Adi);
					satir.add(Double.toString(ilan.Ilan_Fiyat));
					satir.add(Double.toString(ilan.Ilan_Km));
					satir.add(ilan.Ilan_Tarih);
					satir.add(Integer.toString(ilan.Ilan_ArabaID));
					satir.add(Integer.toString(ilan.Ilan_SehirID));
								
					customTablemodel.addRow(satir);
				}
				
				break;
			}
			case "Araba": {
				kolonlar = UtilitiesService.getKolonIsimleri(Araba.class);
				
				customTablemodel = new DefaultTableModel(kolonlar, 0);
				
				Vector<Araba> arabalar = SelectService.arabalariAl(0);
				for (Araba araba : arabalar) {
					Vector<String> satir = new Vector<>();
					
					satir.add(Integer.toString(araba.ArabaID));
					satir.add(araba.Araba_Marka);
					satir.add(araba.Araba_Model);
					satir.add(Integer.toString(araba.Araba_VitesTuruID));
					satir.add(Integer.toString(araba.Araba_YakitTuruID));
					satir.add(Integer.toString(araba.Araba_RenkID));
								
					customTablemodel.addRow(satir);
				}
				
				break;
			}
			case "YakitTuru": {
				kolonlar = UtilitiesService.getKolonIsimleri(YakitTuru.class);
				
				customTablemodel = new DefaultTableModel(kolonlar, 0);
				
				Vector<YakitTuru> yakitTurleri = SelectService.yakitTurleriniAl(0);
				for (YakitTuru yakitTuru : yakitTurleri) {
					Vector<String> satir = new Vector<>();
					
					satir.add(Integer.toString(yakitTuru.YakitTuruID));
					satir.add(yakitTuru.Yakit_Turu);
					
					customTablemodel.addRow(satir);
				}
				
				
				break;
			}
			case "VitesTuru": {
				kolonlar = UtilitiesService.getKolonIsimleri(VitesTuru.class);
				
				customTablemodel = new DefaultTableModel(kolonlar, 0);
				
				Vector<VitesTuru> vitesTurleri = SelectService.vitesTurleriniAl(0);
				for (VitesTuru vitesTuru : vitesTurleri) {
					Vector<String> satir = new Vector<>();
					
					satir.add(Integer.toString(vitesTuru.VitesTuruID));
					satir.add(vitesTuru.Vites_Turu);
								
					customTablemodel.addRow(satir);
				}
				
				break;
			}
			case "Renk": {
				kolonlar = UtilitiesService.getKolonIsimleri(Renk.class);
				
				customTablemodel = new DefaultTableModel(kolonlar, 0);
				
				Vector<Renk> renkler = SelectService.renkleriAl(0);
				for (Renk renk : renkler) {
					Vector<String> satir = new Vector<>();
					
					satir.add(Integer.toString(renk.RenkID));
					satir.add(renk.Renk);
								
					customTablemodel.addRow(satir);
				}
				
				break;
			}
			case "Sehir": {
				kolonlar = UtilitiesService.getKolonIsimleri(Sehir.class);
				
				customTablemodel = new DefaultTableModel(kolonlar, 0);
				
				Vector<Sehir> sehirler = SelectService.sehirleriAl(0);
				for (Sehir sehir : sehirler) {
					Vector<String> satir = new Vector<>();
					
					satir.add(Integer.toString(sehir.SehirID));
					satir.add(sehir.Sehir);
					
					customTablemodel.addRow(satir);
				}
				
				break;
			}
			default: {
				break;
			}
		}
		
		//table.setEnabled(false);
		//tablonun editlenebilir olmaması icin
		table.setDefaultEditor(Object.class, null);
		
		return customTablemodel;
	}
	
	private void customRightView(String comboSecim, boolean filtrelemeSayfasi) {
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableModel = getTableModel(comboSecim);
        table.setModel(tableModel);
        
        //ekle sil guncelleme sayfasi cagirildiysa butonlari koy
        if(!filtrelemeSayfasi) {
        	
    		ekleButton = new JButton("Ekle");
    		ekleButton.setBackground(Color.GREEN);
    		ekleButton.setBounds(94, 38, 159, 39);
    		panel_right.add(ekleButton);
    		
    		guncelleButton = new JButton("Guncelle");
    		guncelleButton.setBackground(Color.ORANGE);
    		guncelleButton.setBounds(327, 38, 159, 39);
    		panel_right.add(guncelleButton);
    		
    		silButton = new JButton("Sil");
    		silButton.setBackground(Color.RED);
    		silButton.setBounds(543, 38, 159, 39);
    		panel_right.add(silButton);
    		
    		setButtonActions(comboSecim);
        }else {
        	
        	getirButton = new JButton("Getir!");
            getirButton.setBackground(Color.GREEN);
        	getirButton.setBounds(206, 32, 141, 45);
            panel_right.add(getirButton);
            
            ilanAd = new JTextField();
            ilanAd.setColumns(10);
            ilanAd.setBounds(38, 44, 141, 22);
            panel_right.add(ilanAd);
            
            checkIlanAD = new JComboBox<ComboSiralama>();
            checkIlanAD.addItem(new ComboSiralama(0, "Ad", false));
            checkIlanAD.addItem(new ComboSiralama(1, "Duz", true));
            checkIlanAD.addItem(new ComboSiralama(2, "Ters", false));
            checkIlanAD.setBounds(367, 32, 85, 23);
            panel_right.add(checkIlanAD);
            
            checkFiyat = new JComboBox<ComboSiralama>();
            checkFiyat.addItem(new ComboSiralama(0, "Fiyat", false));
            checkFiyat.addItem(new ComboSiralama(1, "Duz", true));
            checkFiyat.addItem(new ComboSiralama(2, "Ters", false));
            checkFiyat.setBounds(367, 59, 85, 23);
            panel_right.add(checkFiyat);
            
            checkKm = new JComboBox<ComboSiralama>();
            checkKm.addItem(new ComboSiralama(0, "Km", false));
            checkKm.addItem(new ComboSiralama(1, "Duz", true));
            checkKm.addItem(new ComboSiralama(2, "Ters", false));
            checkKm.setBounds(367, 86, 85, 23);
            panel_right.add(checkKm);
            
            checkTarih = new JComboBox<ComboSiralama>();
            checkTarih.addItem(new ComboSiralama(0, "Tarih", false));
            checkTarih.addItem(new ComboSiralama(1, "Duz", true));
            checkTarih.addItem(new ComboSiralama(2, "Ters", false));
            checkTarih.setBounds(466, 32, 107, 23);
            panel_right.add(checkTarih);
            
            checkMarka = new JComboBox<ComboSiralama>();
            checkMarka.addItem(new ComboSiralama(0, "Marka", false));
            checkMarka.addItem(new ComboSiralama(1, "Duz", true));
            checkMarka.addItem(new ComboSiralama(2, "Ters", false));
            checkMarka.setBounds(465, 59, 108, 23);
            panel_right.add(checkMarka);
            
            checkModel = new JComboBox<ComboSiralama>();
            checkModel.addItem(new ComboSiralama(0, "Model", false));
            checkModel.addItem(new ComboSiralama(1, "Duz", true));
            checkModel.addItem(new ComboSiralama(2, "Ters", false));
            checkModel.setBounds(466, 86, 107, 23);
            panel_right.add(checkModel);
            
            checkYakit = new JComboBox<ComboSiralama>();
            checkYakit.addItem(new ComboSiralama(0, "Yakit", false));
            checkYakit.addItem(new ComboSiralama(1, "Duz", true));
            checkYakit.addItem(new ComboSiralama(2, "Ters", false));
            checkYakit.setBounds(577, 32, 105, 23);
            panel_right.add(checkYakit);
            
            checkVites = new JComboBox<ComboSiralama>();
            checkVites.addItem(new ComboSiralama(0, "Vites", false));
            checkVites.addItem(new ComboSiralama(1, "Duz", true));
            checkVites.addItem(new ComboSiralama(2, "Ters", false));
            checkVites.setBounds(577, 59, 105, 23);
            panel_right.add(checkVites);
            
            checkRenk = new JComboBox<ComboSiralama>();
            checkRenk.addItem(new ComboSiralama(0, "Renk", false));
            checkRenk.addItem(new ComboSiralama(1, "Duz", true));
            checkRenk.addItem(new ComboSiralama(2, "Ters", false));
            checkRenk.setBounds(698, 32, 105, 23);
            panel_right.add(checkRenk);
            
            checkSehir = new JComboBox<ComboSiralama>();
            checkSehir.addItem(new ComboSiralama(0, "Sehir", false));
            checkSehir.addItem(new ComboSiralama(1, "Duz", true));
            checkSehir.addItem(new ComboSiralama(2, "Ters", false));
            checkSehir.setBounds(577, 86, 105, 23);
            panel_right.add(checkSehir);
        	
            getirButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					String secilenTarih = (String) comboTarihSec.getSelectedItem();
					int tarihGun = 0;
					if(secilenTarih == "24 saat") {
						tarihGun = -24;
					}else if(secilenTarih == "son 1 hafta") {
						tarihGun = -24*7;
					}else if (secilenTarih == "son 1 ay") {
						tarihGun = -24*30;
					}
					
					String arananIlanAd = ilanAd.getText();
					Sehir secilenSehir = (Sehir) comboSehirSec.getSelectedItem();
					YakitTuru secilenYakitTuru = (YakitTuru) comboYakitTuruSec.getSelectedItem();
					VitesTuru secilenVitesTuru = (VitesTuru) comboVitesTuruSec.getSelectedItem();
					Renk secilenRenk = (Renk) comboRenkSec.getSelectedItem();
					
					double minFiyat = (double) minFiyatSec.getValue();
					double maxFiyat = (double) maxFiyatSec.getValue();
					
					double minKm = (double) minKmSec.getValue();
					double maxkm = (double) maxKmSec.getValue();
					
					ComboSiralama adSiralama = (ComboSiralama) checkIlanAD.getSelectedItem();
					ComboSiralama fiyatSiralama =  (ComboSiralama) checkFiyat.getSelectedItem();
					ComboSiralama kmSiralama =  (ComboSiralama) checkKm.getSelectedItem();
					ComboSiralama tarihSiralama =  (ComboSiralama) checkTarih.getSelectedItem();
					ComboSiralama markaSiralama =  (ComboSiralama) checkMarka.getSelectedItem();
					ComboSiralama modelSiralama =  (ComboSiralama) checkModel.getSelectedItem();
					ComboSiralama yakitSiralama =  (ComboSiralama) checkYakit.getSelectedItem();
					ComboSiralama vitesSiralama =  (ComboSiralama) checkVites.getSelectedItem();
					ComboSiralama renkSiralama =  (ComboSiralama) checkRenk.getSelectedItem();
					ComboSiralama sehirSiralama =  (ComboSiralama) checkSehir.getSelectedItem();
					
					Vector<String> kolonIsimleri = UtilitiesService.getKolonIsimleri(IlanSearchSonuc.class);
					DefaultTableModel gosterilecekTable = new DefaultTableModel(kolonIsimleri, 0);
					
					Vector<IlanSearchSonuc> bulunanIlanlar = SelectService.search(arananIlanAd, tarihGun, secilenSehir, 
							secilenYakitTuru, secilenVitesTuru, secilenRenk, minFiyat, maxFiyat, minKm, maxkm,
							adSiralama, fiyatSiralama, kmSiralama, tarihSiralama, markaSiralama, modelSiralama, yakitSiralama, vitesSiralama, renkSiralama, sehirSiralama);
					
					for (IlanSearchSonuc bulunanIlan : bulunanIlanlar) {
						
						Vector<String> satir = new Vector<>();
						
						satir.add(Integer.toString(bulunanIlan.IlanID));
						satir.add(bulunanIlan.Ilan_Adi);
						satir.add(Double.toString(bulunanIlan.Ilan_Fiyat));
						satir.add(Double.toString(bulunanIlan.Ilan_Km));
						satir.add(bulunanIlan.Ilan_Tarih);
						satir.add(bulunanIlan.Araba_Marka);
						satir.add(bulunanIlan.Araba_Model);
						satir.add(bulunanIlan.Renk);
						satir.add(bulunanIlan.Vites_Turu);
						satir.add(bulunanIlan.Yakit_Turu);
						satir.add(bulunanIlan.Sehir);
						
						gosterilecekTable.addRow(satir);
					}
					
					table.setDefaultEditor(Object.class, null);
					tableModel = gosterilecekTable;
			        table.setModel(tableModel);
					
				}
			});
            
        	
        }
        
	}
	
	private void panelRightOlustur(String comboSecim) {
		
		boolean filtrelemeSayfasi = false;
		panelRightOlustur(comboSecim, filtrelemeSayfasi);
		
	}
	
	private void panelRightOlustur(String comboSecim, boolean filtrelemeSayfasi) {

		panel_right = new JPanel();
		
		splitPane.setRightComponent(panel_right);
		panel_right.setLayout(null);
		
		panel_table = new JPanel();
		panel_table.setBounds(27, 113, 872, 392);
		panel_right.add(panel_table);
		panel_table.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 814, 354);
		panel_table.add(scrollPane);
		
		customRightView(comboSecim, filtrelemeSayfasi);
	}
	
	/*
	 * Ilan 
	 * Araba
	 * YakitTuru
	 * VitesTuru
	 * Renk
	 * Sehir
	 * */
	private void comboActionOlustur() {
		
		itemComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboSehirSec.setEnabled(false);		
				comboYakitTuruSec.setEnabled(false);
				comboVitesTuruSec.setEnabled(false);				
				minFiyatSec.setEnabled(false);				
				maxFiyatSec.setEnabled(false);				
				minKmSec.setEnabled(false);				
				maxKmSec.setEnabled(false);				
				comboTarihSec.setEnabled(false);				
				comboRenkSec.setEnabled(false);
				
				String secim = (String) itemComboBox.getSelectedItem();
				
				panel_table.removeAll();
				panel_table.validate();
				panel_table.revalidate();
				panel_table.repaint();
				
				panel_right.removeAll();
				panel_right.validate();
				panel_right.revalidate();
				panel_right.repaint();
				
				panelRightOlustur(secim);
			}
		});
	}
	
	
	//filtreleme butonununa basinca secim combolarini doldurmak icin
	private void secimCombolariniDoldur() {
		
		comboSehirSec.removeAllItems();
		comboSehirSec.validate();
		comboSehirSec.revalidate();
		
		comboYakitTuruSec.removeAllItems();
		comboYakitTuruSec.validate();
		comboYakitTuruSec.revalidate();
		
		comboVitesTuruSec.removeAllItems();
		comboVitesTuruSec.validate();
		comboVitesTuruSec.revalidate();
		
		comboRenkSec.removeAllItems();
		comboRenkSec.validate();
		comboRenkSec.revalidate();
		
		
		comboSehirSec.addItem(new Sehir(0, "sehir sec"));
		comboYakitTuruSec.addItem(new YakitTuru(0, "yakit sec"));
		comboVitesTuruSec.addItem(new VitesTuru(0, "vites sec"));
		comboRenkSec.addItem(new Renk(0, "renk sec"));
		
		Vector<Sehir> sehirler = SelectService.sehirleriAl(0);
		for (Sehir sehir : sehirler) {
			comboSehirSec.addItem(sehir);
		}
		
		Vector<YakitTuru> yakitTurleri = SelectService.yakitTurleriniAl(0);
		for (YakitTuru yakitTuru : yakitTurleri) {
			comboYakitTuruSec.addItem(yakitTuru);
		}
		
		Vector<VitesTuru> vitesTurleri = SelectService.vitesTurleriniAl(0);
		for (VitesTuru vitesTuru : vitesTurleri) {
			comboVitesTuruSec.addItem(vitesTuru);
		}
		
		Vector<Renk> renkler = SelectService.renkleriAl(0);
		for (Renk renk : renkler) {
			comboRenkSec.addItem(renk);
		}
		
		minFiyatSec.setValue(new Double(-1));
		maxFiyatSec.setValue(new Double(-1));
		minKmSec.setValue(new Double(-1));
		maxKmSec.setValue(new Double(-1));
		comboTarihSec.setSelectedIndex(0);
	}
	
	/**
	 * Create the frame.
	 */
	public Gui() {
		initGui();
		

		
		endGui();
	}
	
	/*
	 * gorsel arayuzun sabit kisimalarini baslangicta olusturmak icin
	 * */
	private void initGui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		splitPane = new JSplitPane();
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(splitPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
		);
		
		panel_1eft = new JPanel();
		splitPane.setLeftComponent(panel_1eft);
				
		itemComboBox = new JComboBox();
		itemComboBox.setBackground(Color.PINK);
		itemComboBox.addItem("");
		itemComboBox.addItem("Ilan");
		itemComboBox.addItem("Araba");
		itemComboBox.addItem("YakitTuru");
		itemComboBox.addItem("VitesTuru");
		itemComboBox.addItem("Renk");
		itemComboBox.addItem("Sehir");
		
		comboSehirSec = new JComboBox<Sehir>();
		comboSehirSec.setEnabled(false);
		comboYakitTuruSec = new JComboBox<YakitTuru>();
		comboYakitTuruSec.setEnabled(false);
		comboVitesTuruSec = new JComboBox<VitesTuru>();
		comboVitesTuruSec.setEnabled(false);
		minFiyatSec = new JSpinner();
		minFiyatSec.setModel(new SpinnerNumberModel(new Double(-1), new Double(-1), new Double(1000000), new Double(100)));
		minFiyatSec.setEnabled(false);
		maxFiyatSec = new JSpinner();
		maxFiyatSec.setEnabled(false);
		maxFiyatSec.setModel(new SpinnerNumberModel(new Double(-1), new Double(-1), new Double(1000000), new Double(100)));
		minKmSec = new JSpinner();
		minKmSec.setModel(new SpinnerNumberModel(new Double(-1), new Double(-1), new Double(1000000), new Double(100)));
		minKmSec.setEnabled(false);
		maxKmSec = new JSpinner();
		maxKmSec.setModel(new SpinnerNumberModel(new Double(-1), new Double(-1), new Double(1000000), new Double(100)));
		maxKmSec.setEnabled(false);
		comboTarihSec = new JComboBox();
		comboTarihSec.addItem("tarih sec");
		comboTarihSec.addItem("24 saat");
		comboTarihSec.addItem("son 1 hafta");
		comboTarihSec.addItem("son 1 ay");
		comboTarihSec.setEnabled(false);
		
		comboRenkSec = new JComboBox<Renk>();
		comboRenkSec.setEnabled(false);

		fiyatText = new JTextField("min : Fiyat : max");
		fiyatText.setHorizontalAlignment(JLabel.CENTER);
		fiyatText.setEditable(false);
		fiyatText.setBackground(getBackground());
		fiyatText.setColumns(10);
		
		kmText = new JTextField("min : Km : max");
		kmText.setHorizontalAlignment(JLabel.CENTER);
		kmText.setEditable(false);
		kmText.setBackground(getBackground());
		kmText.setColumns(10);
		
		panelRightOlustur("");
		comboActionOlustur();
		
		filtrelemeButton = new JButton("Filtreleme");
		filtrelemeButton.setBackground(Color.MAGENTA);
		filtrelemeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				itemComboBox.setSelectedIndex(0);
				panelRightOlustur("", true);
				
				comboSehirSec.setEnabled(true);		
				
				
				comboYakitTuruSec.setEnabled(true);
				
				comboVitesTuruSec.setEnabled(true);				
				
				minFiyatSec.setEnabled(true);				
				maxFiyatSec.setEnabled(true);				
				
				minKmSec.setEnabled(true);				
				maxKmSec.setEnabled(true);				
				
				comboTarihSec.setEnabled(true);				
				
				comboRenkSec.setEnabled(true);
				
				secimCombolariniDoldur();
				
				getirButton.doClick();
				
			}
		});
		
	}
	
	/*
	 * gorsel arayuzde gostermeden once son olusturmalar icin
	 * */
	private void endGui() {
			
		GroupLayout gl_panel_1 = new GroupLayout(panel_1eft);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(itemComboBox, 0, 141, Short.MAX_VALUE)
						.addComponent(filtrelemeButton, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(minFiyatSec, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(maxFiyatSec, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboSehirSec, Alignment.TRAILING, 0, 141, Short.MAX_VALUE)
						.addComponent(comboYakitTuruSec, Alignment.TRAILING, 0, 141, Short.MAX_VALUE)
						.addComponent(comboVitesTuruSec, Alignment.TRAILING, 0, 141, Short.MAX_VALUE)
						.addComponent(comboRenkSec, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(fiyatText, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addComponent(comboTarihSec, 0, 141, Short.MAX_VALUE)
						.addComponent(kmText, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(minKmSec, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(maxKmSec, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(29)
					.addComponent(itemComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(filtrelemeButton)
					.addGap(30)
					.addComponent(comboTarihSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboSehirSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboYakitTuruSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboVitesTuruSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboRenkSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(fiyatText, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(minFiyatSec, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(maxFiyatSec, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(kmText, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(minKmSec, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(maxKmSec, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		panel_1eft.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
	
}
