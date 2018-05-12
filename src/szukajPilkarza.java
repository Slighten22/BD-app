import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class szukajPilkarza extends JFrame implements ActionListener {
	String SImie, SNazwisko, SID, SKlub, SWiek, SAgent, SSponsor;
	JLabel ImieLabel = new JLabel("Imie:");
	JLabel NazwiskoLabel = new JLabel("Nazwisko:");
	JLabel IDLabel = new JLabel("ID:");
	JLabel KlubLabel = new JLabel("Klub:");
	JLabel WiekLabel = new JLabel("Wiek");
	JLabel AgentLabel = new JLabel("Agent");
	JLabel SponsorLabel = new JLabel("Sponsor");
	JTextField Imie = new JTextField(10);
	JTextField Nazwisko = new JTextField(10);
	JTextField ID = new JTextField(10);
	JTextField Klub = new JTextField(10);
	JTextField Wiek = new JTextField(10);
	JTextField Agent = new JTextField(10);
	JTextField Sponsor = new JTextField(10);
	JButton szukaj = new JButton("Szukaj");
	JButton anuluj = new JButton("Anuluj");
	public szukajPilkarza() {
		super("Szukanie pilkarza");
		setSize(400,150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.add(ImieLabel);
		pane.add(Imie);
		pane.add(NazwiskoLabel);
		pane.add(Nazwisko);
		pane.add(IDLabel);
		pane.add(ID);
		pane.add(KlubLabel);
		pane.add(Klub);
		pane.add(WiekLabel);
		pane.add(Wiek);
		pane.add(AgentLabel);
		pane.add(Agent);
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
		String id = ID.getText();
		String im = Imie.getText();
		String na = Nazwisko.getText();
		String kl = Klub.getText();
		String wi = Wiek.getText();
		String sp = Sponsor.getText();
		String ag = Agent.getText();
		baza.Menu.p.szukaj2(im, na, id, kl, wi, ag, sp);
		this.dispose();}
		if (source==anuluj) {
			this.dispose();
		}
}

}