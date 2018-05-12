import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class usunTrenera extends JFrame implements ActionListener {
	String SImie, SNazwisko, SID;
	JLabel ImieLabel = new JLabel("Imie:");
	JLabel NazwiskoLabel = new JLabel("Nazwisko:");
	JLabel IDLabel = new JLabel("ID:");
	JTextField Imie = new JTextField(10);
	JTextField Nazwisko = new JTextField(10);
	JTextField ID = new JTextField(10);
	JButton usunTo = new JButton("Usun");
	JButton anuluj = new JButton("Anuluj");
	public usunTrenera() {
		super("Usuwanie Trenera");
		setSize(400,150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.add(ImieLabel);
		pane.add(Imie);
		pane.add(NazwiskoLabel);
		pane.add(Nazwisko);
		pane.add(IDLabel);
		pane.add(ID);
		pane.add(usunTo);
		pane.add(anuluj);
		usunTo.addActionListener(this);
		anuluj.addActionListener(this);
		add(pane);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source==usunTo) {
		String id = ID.getText();
		String im = Imie.getText();
		String na = Nazwisko.getText();
		this.dispose();
		baza.Menu.tr.usun(baza.connection, im, na, id);}
		if (source==anuluj) {
			this.dispose();
		}
}

}