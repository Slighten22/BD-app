import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class szukajTrenera extends JFrame implements ActionListener {
	String SImie, SNazwisko, SID, SWiek;
	JLabel ImieLabel = new JLabel("Imie:");
	JLabel NazwiskoLabel = new JLabel("Nazwisko:");
	JLabel IDLabel = new JLabel("ID:");
	JLabel WiekLabel = new JLabel("Wiek");
	JTextField Imie = new JTextField(10);
	JTextField Nazwisko = new JTextField(10);
	JTextField ID = new JTextField(10);
	JTextField Wiek = new JTextField(10);
	JButton szukaj = new JButton("Szukaj");
	JButton anuluj = new JButton("Anuluj");
	public szukajTrenera() {
		super("Szukanie trenera");
		setSize(400,150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.add(ImieLabel);
		pane.add(Imie);
		pane.add(NazwiskoLabel);
		pane.add(Nazwisko);
		pane.add(IDLabel);
		pane.add(ID);
		pane.add(WiekLabel);
		pane.add(Wiek);

		pane.add(szukaj);
		pane.add(anuluj);
		szukaj.addActionListener(this);
		anuluj.addActionListener(this);
		add(pane);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source==szukaj) {
		String id = ID.getText();
		String im = Imie.getText();
		String na = Nazwisko.getText();
		String wi = Wiek.getText();
		baza.Menu.tr.szukaj2(im, na, id, wi);
		this.dispose();}
		if (source==anuluj) {
			this.dispose();
		}
}

}