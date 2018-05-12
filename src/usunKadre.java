import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class usunKadre extends JFrame implements ActionListener {
	String SKraj, STrener;
	JLabel KadraLabel = new JLabel("Kraj:");
	JLabel TrenerLabel = new JLabel("Trener:");
	JTextField Kraj = new JTextField(10);
	JTextField Trener = new JTextField(10);
	JButton usunTo = new JButton("Usun");
	JButton anuluj = new JButton("Anuluj");
	public usunKadre() {
		super("Usuwanie kadry");
		setSize(400,150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.add(KadraLabel);
		pane.add(Kraj);
		pane.add(TrenerLabel);
		pane.add(Trener);
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
		String kr = Kraj.getText();
		String tr = Trener.getText();
		this.dispose();
		baza.Menu.ka.usun(baza.connection, kr, tr);}
		if (source==anuluj) {
			this.dispose();
		}
}

}