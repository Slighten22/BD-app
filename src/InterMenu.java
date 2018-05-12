import java.awt.*;
import javax.swing.*;

import javax.swing.*;
public class InterMenu extends JFrame {
	static Pilkarz p;
	static JPanel Pilkarze;
	static Kadra ka;
	static JPanel Kadry;
	static Klub k;
	static JPanel Kluby;
	static Trener tr;
	static JPanel Trenerzy;
	static Agent ag;
	static JPanel Agenci;
	
	public InterMenu() {
		super("Baza danych");
		p= new Pilkarz();
		ka= new Kadra();
		k= new Klub();
		tr= new Trener();
		ag= new Agent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS); // 
		getContentPane().setLayout(boxLayout);
		FlowLayout boxLayout2 = new FlowLayout();
		getContentPane().setLayout(boxLayout2);
		setSize(1000, 700); // 
		Pilkarze = new JPanel();
		Kadry = new JPanel();
		Kluby = new JPanel();
		Trenerzy = new JPanel();
		Agenci = new JPanel();
		JTabbedPane Baza = new JTabbedPane();
		Pilkarze.add(p);
		Kadry.add(ka);
		Kluby.add(k);
		Trenerzy.add(tr);
		Agenci.add(ag);

		getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		Baza.add("Pilkarze", Pilkarze);
		Baza.addTab("Kluby", Kluby);
		Baza.addTab("Trenerzy", Trenerzy);
		Baza.addTab("Agenci", Agenci);
		Baza.addTab("Kadry Narodowe", Kadry);
		getContentPane().add(Baza);
		setVisible(true);
	}


public void odswiezPilkarzy() {
	if(Pilkarze!=null) {
		Pilkarze.remove(p);
		p=new Pilkarz();
		Pilkarze.add(p);
		repaint();
	}
}
public void odswiezPilkarzy2(JTable newJt) {
	if(Pilkarze!=null) {
		Pilkarze.remove(p);
		p=new Pilkarz(newJt);
		Pilkarze.add(p);
		repaint();
	}
}

public void odswiezKadre() {
	if(Kadry!=null) {
		Kadry.remove(ka);
		ka=new Kadra();
		Kadry.add(ka);
		repaint();
	}
}
public void odswiezKadry2(JTable newJt) {
	if(Kadry!=null) {
		Kadry.remove(ka);
		ka=new Kadra(newJt);
		Kadry.add(ka);
		repaint();
	}
}

public void odswiezKluby() {
	if(Kluby!=null) {
		Kluby.remove(k);
		k=new Klub();
		Kluby.add(k);
		repaint();
	}
}
public void odswiezKluby2(JTable newJt) {
	if(Kluby!=null) {
		Kluby.remove(k);
		k=new Klub(newJt);
		Kluby.add(k);
		repaint();
	}
}

public void odswiezTrenerow() {
	if(Trenerzy!=null) {
		Trenerzy.remove(tr);
		tr=new Trener();
		Trenerzy.add(tr);
		repaint();
	}
}
public void odswiezTrenerow2(JTable newJt) {
	if(Trenerzy!=null) {
		Trenerzy.remove(tr);
		tr=new Trener(newJt);
		Trenerzy.add(tr);
		repaint();
	}
}

public void odswiezAgentow() {
	if(Agenci!=null) {
		Agenci.remove(ag);
		ag=new Agent();
		Agenci.add(ag);
		repaint();
	}
}
public void odswiezAgentow2(JTable newJt) {
	if(Agenci!=null) {
		Agenci.remove(ag);
		ag=new Agent(newJt);
		Agenci.add(ag);
		repaint();
	}
}

}