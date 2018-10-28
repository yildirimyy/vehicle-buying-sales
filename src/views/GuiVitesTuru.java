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

import models.Sehir;
import models.VitesTuru;
import models.YakitTuru;
import services.InsertUpdateService;
import services.SelectService;

public class GuiVitesTuru {
	private static JFrame frame;
	private static JPanel panel;
	private static JButton islemButton;

	private static JTextField vitesTuru;

	static void panelOlustur() {

		frame = new JFrame("Vites");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new JPanel(new GridLayout(0, 1));
		vitesTuru = new JTextField();

		panel.add(new JLabel("Vites Turu:"));
		panel.add(vitesTuru);
		islemButton = new JButton("");

		panel.add(new JLabel(" "));
		panel.add(islemButton);
		panel.add(new JLabel(" "));

		frame.add(panel);
	}

	static void vitesTuruEkle() {

		panelOlustur();

		islemButton.setText("Ekle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = vitesTuru.getText();
				
				//kontrolde sorun yoksa kayit servisi cagir
				if(!text.equals("")) {
					
					//yeni eklenecegi icin id = 0
					VitesTuru yeniVitesTuru = new VitesTuru(0, text);
					boolean result = InsertUpdateService.vitesTuruEkleGuncelle(yeniVitesTuru);
					
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

		int result = JOptionPane.showConfirmDialog(null, panel, "Vites Turu Ekle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}

	static void vitesTuruGuncelle(String vitesTuruId) {

		panelOlustur();

		int secilenId = Integer.parseInt(vitesTuruId);
		Vector<VitesTuru> guncellenecekVeri = SelectService.vitesTurleriniAl(secilenId);
		
		//id gonderildigi icin bir tane gelmis olmasi gerek
		if(guncellenecekVeri.size() == 1) {
			VitesTuru dbItem = guncellenecekVeri.firstElement();
			vitesTuru.setText(dbItem.Vites_Turu);
		}

		islemButton.setText("Guncelle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = vitesTuru.getText();
				
				//kontrolde sorun yoksa kayit servisi cagir
				if(!text.equals("") && guncellenecekVeri.size() == 1) {
					
					VitesTuru guncellenecekVitesTuru = new VitesTuru(secilenId, text);
					boolean result = InsertUpdateService.vitesTuruEkleGuncelle(guncellenecekVitesTuru);
					
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

		int result = JOptionPane.showConfirmDialog(null, panel, "Vites Turu Guncelle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}

}
