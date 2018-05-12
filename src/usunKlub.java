import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class usunKlub extends JFrame implements ActionListener {
	String SNazwa;
	JLabel NazwaLabel = new JLabel("Nazwa:");
	JTextField Nazwa = new JTextField(10);
	JButton usunTo = new JButton("Usun");
	JButton anuluj = new JButton("Anuluj");
	public usunKlub() {
		super("Usuwanie klubu");
		setSize(400,150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.add(NazwaLabel);
		pane.add(Nazwa);
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
		String na = Nazwa.getText();
		this.dispose();
		baza.Menu.k.usun(baza.connection, na);}
		if (source==anuluj) {
			this.dispose();
		}
}

}