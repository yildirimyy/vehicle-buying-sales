package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Araba;
import models.Renk;
import models.VitesTuru;
import models.YakitTuru;
import services.InsertUpdateService;
import services.SelectService;

public class GuiAraba {
	
	private static JFrame frame;
	private static JPanel panel;
	private static JTextField arabaMarka;
	private static JTextField arabaModel;
	private static JComboBox comboVitesTuru;
	private static JComboBox comboYakitTuru;
	private static JComboBox comboRenk;
	private static JButton islemButton;
	
	static void combolariDoldur() {
		
		//butun vitesturlerini al
		Vector<VitesTuru> vitesTurleri = SelectService.vitesTurleriniAl(0);
		for (VitesTuru vitesTuru : vitesTurleri) {
			String comboMetin = vitesTuru.VitesTuruID + "-" + vitesTuru.Vites_Turu;
			comboVitesTuru.addItem(comboMetin);
		}
		
		//butun yakit turlerini al
		Vector<YakitTuru> yakitTurleri = SelectService.yakitTurleriniAl(0);
		for (YakitTuru yakitTuru : yakitTurleri) {
			String comboMetin = yakitTuru.YakitTuruID + "-" + yakitTuru.Yakit_Turu;
			comboYakitTuru.addItem(comboMetin);
		}
		
		//butun renkleri al
		Vector<Renk> renkler = SelectService.renkleriAl(0);
		for (Renk renk : renkler) {
			String comboMetin = renk.RenkID + "-" + renk.Renk;
			comboRenk.addItem(comboMetin);
		}
	}
	
	static void panelOlustur() {
		
		frame = new JFrame("Araba");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel(new GridLayout(0, 1));
		arabaMarka = new JTextField();
		arabaModel = new JTextField();
		comboVitesTuru = new JComboBox();
		comboYakitTuru = new JComboBox();
		comboRenk = new JComboBox();
		
		panel.add(new JLabel("Araba Marka:"));
		panel.add(arabaMarka);
		panel.add(new JLabel("Araba Model:"));
		panel.add(arabaModel);
		panel.add(new JLabel("Vites Turu:"));
		panel.add(comboVitesTuru);
		panel.add(new JLabel("Yakit Turu:"));
		panel.add(comboYakitTuru);
		panel.add(new JLabel("Renk:"));
		panel.add(comboRenk);
		
		islemButton = new JButton("");

		panel.add(new JLabel(" "));
		panel.add(islemButton);
		panel.add(new JLabel(" "));
		
		frame.add(panel);
	}

	static void arabaEkle() {
		
		panelOlustur();
		
		combolariDoldur();
		
		islemButton.setText("Ekle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String marka = arabaMarka.getText();
				String model = arabaModel.getText();
				
				//eksik bilgi kontrolu secili olup olmamasi
				boolean vitesKontrol = comboVitesTuru.getSelectedIndex() >= 0;
				boolean yakitKontrol = comboYakitTuru.getSelectedIndex() >= 0;
				boolean renkKontrol = comboRenk.getSelectedIndex() >= 0;	
				boolean comboKontrol = vitesKontrol && yakitKontrol && renkKontrol;
				
				//kontrolde sorun yoksa kayit servisi cagir
				if(!marka.equals("") && !model.equals("") && comboKontrol) {
					
					String secilenVitesTuru = (String)comboVitesTuru.getSelectedItem();
					String secilenYakitTuru = (String)comboYakitTuru.getSelectedItem();
					String secilenRenk = (String)comboRenk.getSelectedItem();
					
					// id al
					String[] text = secilenVitesTuru.split("-");
					int vitesId = Integer.parseInt(text[0]);
					
					String[] text2 = secilenYakitTuru.split("-");
					int yakitId = Integer.parseInt(text2[0]);
					
					String[] text3 = secilenRenk.split("-");
					int renkId = Integer.parseInt(text3[0]);
					
					//yeni eklenecegi icin id = 0
					Araba kayitEdilecekAraba = new Araba(0, marka, model, vitesId, yakitId, renkId);
					boolean result = InsertUpdateService.arabaEkleGuncelle(kayitEdilecekAraba);
					
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

		int result = JOptionPane.showConfirmDialog(null, panel, "Araba Ekle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}
	
	static void arabaGuncelle(String arabaId) {
		
		panelOlustur();
		
		combolariDoldur();
		
		int secilenId = Integer.parseInt(arabaId);
		Vector<Araba> arabalar = SelectService.arabalariAl(secilenId);
		
		if(arabalar.size() == 1) {
			Araba guncellenecekAraba = arabalar.firstElement();
			
			arabaMarka.setText(guncellenecekAraba.Araba_Marka);
			arabaModel.setText(guncellenecekAraba.Araba_Model);
			
			String vitesTur = Integer.toString(guncellenecekAraba.Araba_VitesTuruID);
			String yakitTur = Integer.toString(guncellenecekAraba.Araba_YakitTuruID);
			String renkS = Integer.toString(guncellenecekAraba.Araba_RenkID);
				
			//veritabanında kayitli olan vites turunu secmek icin
			if(guncellenecekAraba.Araba_VitesTuruID > 0) {
				for (int i = 0; i < comboVitesTuru.getItemCount(); i++) {
					if(comboVitesTuru.getItemAt(i).toString().contains(vitesTur)) {
						comboVitesTuru.setSelectedIndex(i);
						break;
					}
				}
			}		
			
			//veritabanında kayitli olan yakit turunu secmek icin
			if(guncellenecekAraba.Araba_YakitTuruID > 0) {
				for (int i = 0; i < comboYakitTuru.getItemCount(); i++) {
					if(comboYakitTuru.getItemAt(i).toString().contains(yakitTur)) {
						comboYakitTuru.setSelectedIndex(i);
						break;
					}
				}
			}
			
			//veritabanında kayitli olan renk secmek icin
			if(guncellenecekAraba.Araba_RenkID > 0) {
				for (int i = 0; i < comboRenk.getItemCount(); i++) {
					if(comboRenk.getItemAt(i).toString().contains(renkS)) {
						comboRenk.setSelectedIndex(i);
						break;
					}
				}
			}
			
		}
		
		
		islemButton.setText("Guncelle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String marka = arabaMarka.getText();
				String model = arabaModel.getText();
				
				//eksik bilgi kontrolu secili olup olmamasi
				boolean vitesKontrol = comboVitesTuru.getSelectedIndex() >= 0;
				boolean yakitKontrol = comboYakitTuru.getSelectedIndex() >= 0;
				boolean renkKontrol = comboRenk.getSelectedIndex() >= 0;	
				boolean comboKontrol = vitesKontrol && yakitKontrol && renkKontrol;
				
				//kontrolde sorun yoksa kayit servisi cagir
				if(!arabaMarka.getText().equals("") && !arabaModel.getText().equals("") && comboKontrol && arabalar.size() == 1) {
					
					String secilenVitesTuru = (String)comboVitesTuru.getSelectedItem();
					String secilenYakitTuru = (String)comboYakitTuru.getSelectedItem();
					String secilenRenk = (String)comboRenk.getSelectedItem();
					
					// id al
					String[] text = secilenVitesTuru.split("-");
					int vitesId = Integer.parseInt(text[0]);
					
					String[] text2 = secilenYakitTuru.split("-");
					int yakitId = Integer.parseInt(text2[0]);
					
					String[] text3 = secilenRenk.split("-");
					int renkId = Integer.parseInt(text3[0]);
					
					Araba kayitEdilecekAraba = new Araba(secilenId, marka, model, vitesId, yakitId, renkId);
					boolean result = InsertUpdateService.arabaEkleGuncelle(kayitEdilecekAraba);
					
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

		int result = JOptionPane.showConfirmDialog(null, panel, "Araba Guncelle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}

}
