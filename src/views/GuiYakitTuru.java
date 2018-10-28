package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.VitesTuru;
import models.YakitTuru;
import services.InsertUpdateService;
import services.SelectService;

public class GuiYakitTuru {
	private static JFrame frame;
	private static JPanel panel;
	private static JButton islemButton;

	private static JTextField yakitTuru;

	static void panelOlustur() {

		frame = new JFrame("Yakit");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new JPanel(new GridLayout(0, 1));
		yakitTuru = new JTextField();

		panel.add(new JLabel("Yakit Turu:"));
		panel.add(yakitTuru);
		islemButton = new JButton("");

		panel.add(new JLabel(" "));
		panel.add(islemButton);
		panel.add(new JLabel(" "));

		frame.add(panel);
	}

	static void yakitTuruEkle() {

		panelOlustur();

		islemButton.setText("Ekle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = yakitTuru.getText();
				
				//kontrolde sorun yoksa kayit servisi cagir
				if(!text.equals("")) {
					
					//yeni ekleneceği icin id = 0
					YakitTuru yeniYakitTuru = new YakitTuru(0, text);
					boolean result = InsertUpdateService.yakitTuruEkleGuncelle(yeniYakitTuru);
					
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

		int result = JOptionPane.showConfirmDialog(null, panel, "Yakit Turu Ekle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}

	static void yakitTuruGuncelle(String yakitTuruId) {

		panelOlustur();
		
		int secilenId = Integer.parseInt(yakitTuruId);
		Vector<YakitTuru> guncellenecekVeri = SelectService.yakitTurleriniAl(secilenId);
		
		//id gonderildigi icin bir tane gelmis olmasi gerek
		if(guncellenecekVeri.size() == 1) {
			YakitTuru dbItem = guncellenecekVeri.firstElement();
			yakitTuru.setText(dbItem.Yakit_Turu);
		}

		islemButton.setText("Guncelle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = yakitTuru.getText();
				
				//kontrolde sorun yoksa kayit servisi cagir
				if(!text.equals("") && guncellenecekVeri.size() == 1) {
					
					YakitTuru guncellenecekYakitTuru = new YakitTuru(secilenId, text);
					boolean result = InsertUpdateService.yakitTuruEkleGuncelle(guncellenecekYakitTuru);
					
					if(result) {
						JOptionPane.showMessageDialog(
								null, "Guncelleme Basarili!", "Guncelleme", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(
								null, "Guncelleme Basarisiz!", "Guncelleme", JOptionPane.ERROR_MESSAGE);
					}
					
				}else {
					JOptionPane.showMessageDialog(
							null, "Eksik Bilgiler Var", "Eksik Bilgi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		int result = JOptionPane.showConfirmDialog(null, panel, "Yakit Turu Guncelle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}

}
