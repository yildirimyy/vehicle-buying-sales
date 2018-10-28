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

import models.Renk;
import models.Sehir;
import models.VitesTuru;
import services.InsertUpdateService;
import services.SelectService;

public class GuiSehir {
	private static JFrame frame;
	private static JPanel panel;
	private static JButton islemButton;

	private static JTextField sehir;

	static void panelOlustur() {

		frame = new JFrame("Sehir");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new JPanel(new GridLayout(0, 1));
		sehir = new JTextField();

		panel.add(new JLabel("Sehir:"));
		panel.add(sehir);
		islemButton = new JButton("");

		panel.add(new JLabel(" "));
		panel.add(islemButton);
		panel.add(new JLabel(" "));

		frame.add(panel);
	}

	static void sehirEkle() {

		panelOlustur();

		islemButton.setText("Ekle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = sehir.getText();
				
				//kontrolde sorun yoksa kayit servisi cagir
				if(!text.equals("")) {
					
					//yeni eklenecegi icin id = 0
					Sehir yeniSehir = new Sehir(0, text);
					boolean result = InsertUpdateService.sehirEkleGuncelle(yeniSehir);
					
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

		int result = JOptionPane.showConfirmDialog(null, panel, "Sehir Ekle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}

	static void sehirGuncelle(String sehirId) {

		panelOlustur();

		int secilenId = Integer.parseInt(sehirId);
		Vector<Sehir> guncellenecekVeri = SelectService.sehirleriAl(secilenId);
		
		//id gonderildigi icin bir tane gelmis olmasi gerek
		if(guncellenecekVeri.size() == 1) {
			Sehir dbItem = guncellenecekVeri.firstElement();
			sehir.setText(dbItem.Sehir);
		}

		islemButton.setText("Guncelle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = sehir.getText();
				
				//kontrolde sorun yoksa kayit servisi cagir
				if(!text.equals("") && guncellenecekVeri.size() == 1) {
					
					Sehir guncellenecekSehir = new Sehir(secilenId, text);
					boolean result = InsertUpdateService.sehirEkleGuncelle(guncellenecekSehir);
					
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

		int result = JOptionPane.showConfirmDialog(null, panel, "Sehir Guncelle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}
}
