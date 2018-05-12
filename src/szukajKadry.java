import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class szukajKadry extends JFrame implements ActionListener {
	String SKraj, STrener;
	JLabel KrajLabel = new JLabel("Kraj:");
	JLabel TrenerLabel = new JLabel("Trener:");
	JTextField Kraj = new JTextField(10);
	JTextField Trener = new JTextField(10);
	JButton szukaj = new JButton("Szukaj");
	JButton anuluj = new JButton("Anuluj");
	public szukajKadry() {
		super("Szukanie kadry");
		setSize(400,150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.add(KrajLabel);
		pane.add(Kraj);
		pane.add(TrenerLabel);
		pane.add(Trener);
		
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
		String kr = Kraj.getText();
		String tr = Trener.getText();
		baza.Menu.ka.szukaj2(kr, tr);
		this.dispose();}
		if (source==anuluj) {
			this.dispose();
		}
}

}