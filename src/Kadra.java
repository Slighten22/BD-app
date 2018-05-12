import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Kadra extends JPanel implements ActionListener {
	static JTable jt;
	static JButton DodajKadre;
	static JButton UsunKadre;
	static JButton SzukajKadry;
	static JButton OdswiezKadre;
	public static int TabSize;
	public static Object[][] data;
		public Kadra() {
			setLayout(new BorderLayout());
			String[] Kolumny = {"Kraj", "Trener"};
			data= odswiez(baza.connection);
			jt = new JTable(data, Kolumny);
			JScrollPane KadraScroll = new JScrollPane(jt);
			add(KadraScroll);
			jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
			jt.setFillsViewportHeight(true);
			DodajKadre = new JButton("Dodaj");
			UsunKadre = new JButton("Usun");
			OdswiezKadre = new JButton("Odswiez");
			SzukajKadry = new JButton("Szukaj");
			
			DodajKadre.addActionListener(this);
			OdswiezKadre.addActionListener(this);
			UsunKadre.addActionListener(this);
			SzukajKadry.addActionListener(this);
			//add(ButtonsPilkarz);
			/*
			ButtonsPilkarz.add(DodajPilkarza);
			ButtonsPilkarz.add(UsunPilkarza);
			ButtonsPilkarz.add(OdswiezPilkarza);
			ButtonsPilkarz.add(SzukajPilkarza);*/
			add(DodajKadre, BorderLayout.EAST);
			add(UsunKadre, BorderLayout.WEST);
			add(OdswiezKadre, BorderLayout.NORTH);
			add(SzukajKadry, BorderLayout.SOUTH);
	}
	
		
		public Kadra(JTable newJt) {
			setLayout(new BorderLayout());
			jt = newJt;
			JScrollPane KadraScroll = new JScrollPane(jt);
			add(KadraScroll);
			jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
			jt.setFillsViewportHeight(true);
			DodajKadre = new JButton("Dodaj");
			UsunKadre = new JButton("Usun");
			OdswiezKadre = new JButton("Odswiez");
			SzukajKadry = new JButton("Szukaj");
			
			DodajKadre.addActionListener(this);
			OdswiezKadre.addActionListener(this);
			UsunKadre.addActionListener(this);
			SzukajKadry.addActionListener(this);
			//add(ButtonsPilkarz);
			/*
			ButtonsPilkarz.add(DodajPilkarza);
			ButtonsPilkarz.add(UsunPilkarza);
			ButtonsPilkarz.add(OdswiezPilkarza);
			ButtonsPilkarz.add(SzukajPilkarza);*/
			add(DodajKadre, BorderLayout.EAST);
			add(UsunKadre, BorderLayout.WEST);
			add(OdswiezKadre, BorderLayout.NORTH);
			add(SzukajKadry, BorderLayout.SOUTH);
			
	}
		
	public void wypisz(Connection connection) {
		try {
        	Statement st = connection.createStatement();
        	ResultSet rec = st.executeQuery("select * " + "from Kadra_Narodowa " + "order by Kraj");
        	while (rec.next()) {
        		System.out.println("Kraj:\t\t" + rec.getString(1));
        		System.out.println("Trener:\t" + rec.getString(2));
        		System.out.println();
        	}
        	st.close();
        }
        catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            return;
        }
	}
	
	public Object[][] szukaj (Connection connection, String Kraj, String Trener) {
		String formula= "select * from Kadra_Narodowa where 1=1";
		if (Kraj.length()!=0) formula+="AND Kraj='"+Kraj+"'";
		if (Trener.length()!=0) formula+="AND Trener_ID='"+Trener+"'";
		try {
        	Statement st = connection.createStatement();
        	ResultSet pom = st.executeQuery("select count (*) from Kadra_Narodowa");
        	pom.next();
        	TabSize=pom.getInt(1)+1;
        	ResultSet rec = st.executeQuery(formula);
        	Object[][] ToReturn = new Object[TabSize][2];
        	int i=0;
        	while (rec.next()) {
        		ToReturn[i][0] =rec.getString(1);
        		ToReturn[i][1] =rec.getString(2);
        		i++;
        	}
        	st.close();
        	return ToReturn;}
		catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            Object[][] ExReturn = new Object[1][2];
            ExReturn[0][0]= "Error";
            ExReturn[0][1]= "Error";
            return ExReturn;
        }}
	
	public static Object[][] odswiez(Connection connection) {
		try {
        	Statement st = connection.createStatement();
        	ResultSet pom = st.executeQuery("select count (*) from Kadra_Narodowa");
        	pom.next();
        	TabSize=pom.getInt(1)+1;
        	ResultSet rec = st.executeQuery("select * " + "from Kadra_Narodowa " + "order by Kraj");
        	Object[][] ToReturn = new Object[TabSize][2];
        	int i=0;
        	while (rec.next()) {
        		ToReturn[i][0] =rec.getString(1);
        		ToReturn[i][1] =rec.getString(2);
        		i++;
        	}
        	st.close();
        	return ToReturn;
        }
        catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            Object[][] ExReturn = new Object[1][2];
            ExReturn[0][0]= "Error";
            ExReturn[0][1]= "Error";
            return ExReturn;
        }
	}
	
	void odswiez2() {
		String[] Kolumny = {"Kraj", "Trener"};
		Object[][] data = odswiez(baza.connection);
		jt= new JTable(data, Kolumny);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
		jt.setFillsViewportHeight(true);
	}
	
	void szukaj2(String Kraj, String Trener) {
		String[] Kolumny = {"Kraj", "Trener"};
		Object[][] data = szukaj(baza.connection, Kraj, Trener);
		jt= new JTable(data, Kolumny);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
		jt.setFillsViewportHeight(true);
		baza.Menu.odswiezKadry2(jt);
	}
	
	public void dodaj(Connection connection, String Kraj, String Trener) {
		try {
			String polecenie = "insert into Kadra_Narodowa values ('";
			polecenie=polecenie+Kraj + "', '" + Trener + "')";
        	Statement st = connection.createStatement();
        	System.out.println(polecenie);
        	st.executeQuery(polecenie);
        	st.close();
        	baza.Menu.odswiezKadre();
        	
        }
        catch(SQLException e) {
        	System.out.println("Error pilkarz");
            e.printStackTrace();
            return;
	}}

	
	
	
	public void usun(Connection connection, String Kraj, String Trener) {
		try {
			
			String query = "";
        	Statement st = connection.createStatement();
        	
        	if(Kraj.length()!=0 && Trener.length()==0)
        	query = "delete from Kadra_Narodowa where Kraj='" + Kraj+"'";
        	else if(Trener.length()!=0 && Kraj.length()==0)
        	query = "delete from Kadra_Narodowa where Trener_ID='" + Trener + "'";
        	else if(Kraj.length()!=0 && Trener.length()!=0)
        	query = "delete from Kadra_Narodowa where Trener_ID='" + Trener + "' AND Kraj='"+Kraj+"'";
        	else return;
        	System.out.println(query);
        	st.executeQuery(query);
        	st.close();
        	baza.Menu.odswiezKadre();
        }
        catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            return;
	}
	}

	
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source==DodajKadre) {
			String[] dane = new String[2];
			for(int i=0; i<2; i++) {
			dane[i]=(String) data[TabSize-1][i];
			System.out.println(dane[i]);}
			this.dodaj(baza.connection, dane[0], dane[1]);}
		if (source==OdswiezKadre) {
			baza.Menu.odswiezKadre();
		}
		if (source==UsunKadre) {
			usunKadre usunto = new usunKadre();
		}
		if (source==SzukajKadry) {
			szukajKadry szukajGo = new szukajKadry();
		}
		
	}


	
}
