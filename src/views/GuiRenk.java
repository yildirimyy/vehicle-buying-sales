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

public class GuiRenk {
	private static JFrame frame;
	private static JPanel panel;
	private static JButton islemButton;

	private static JTextField renk;

	static void panelOlustur() {

		frame = new JFrame("Renk");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new JPanel(new GridLayout(0, 1));
		renk = new JTextField();

		panel.add(new JLabel("Renk:"));
		panel.add(renk);
		islemButton = new JButton("");

		panel.add(new JLabel(" "));
		panel.add(islemButton);
		panel.add(new JLabel(" "));

		frame.add(panel);
	}

	static void renkEkle() {

		panelOlustur();

		islemButton.setText("Ekle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = renk.getText();
				
				//kontrolde sorun yoksa kayit servisi cagir
				if(!text.equals("")) {
					
					//yeni eklenecegi icin id = 0
					Renk yeniRenk = new Renk(0, text);
					boolean result = InsertUpdateService.renkEkleGuncelle(yeniRenk);
					
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

		int result = JOptionPane.showConfirmDialog(null, panel, "Renk Ekle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}

	static void renkGuncelle(String renkId) {

		panelOlustur();

		int secilenId = Integer.parseInt(renkId);
		Vector<Renk> guncellenecekVeri = SelectService.renkleriAl(secilenId);
		
		//id gonderildigi icin bir tane gelmis olmasi gerek
		if(guncellenecekVeri.size() == 1) {
			Renk dbItem = guncellenecekVeri.firstElement();
			renk.setText(dbItem.Renk);
		}

		islemButton.setText("Guncelle");
		islemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = renk.getText();
				
				//kontrolde sorun yoksa kayit servisi cagir
				if(!text.equals("") && guncellenecekVeri.size() == 1) {
					
					Renk guncellenecekRenk = new Renk(secilenId, text);
					boolean result = InsertUpdateService.renkEkleGuncelle(guncellenecekRenk);
					
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

		int result = JOptionPane.showConfirmDialog(null, panel, "Renk Guncelle", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

		} else {

		}

	}

}
