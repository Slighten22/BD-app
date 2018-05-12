import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class szukajKlubu extends JFrame implements ActionListener {
	String SNazwa, SBudzet, SSponsor;
	JLabel NazwaLabel = new JLabel("Nazwa:");
	JLabel BudzetLabel = new JLabel("Budzet:");
	JLabel SponsorLabel = new JLabel("Sponsor:");
	JTextField Nazwa = new JTextField(10);
	JTextField Budzet = new JTextField(10);
	JTextField Sponsor = new JTextField(10);
	JButton szukaj = new JButton("Szukaj");
	JButton anuluj = new JButton("Anuluj");
	public szukajKlubu() {
		super("Szukanie klubu");
		setSize(400,150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.add(NazwaLabel);
		pane.add(Nazwa);
		pane.add(BudzetLabel);
		pane.add(Budzet);
		pane.add(SponsorLabel);
		pane.add(Sponsor);

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
		String na = Nazwa.getText();
		String bd = Budzet.getText();
		String sp = Sponsor.getText();
		baza.Menu.k.szukaj2(na, bd, sp);
		this.dispose();}
		if (source==anuluj) {
			this.dispose();
		}
}

}