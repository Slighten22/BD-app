import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Klub extends JPanel implements ActionListener {
	static JTable jt;
	static JButton DodajKlub;
	static JButton UsunKlub;
	static JButton SzukajKlubu;
	static JButton OdswiezKlub;
	public static int TabSize;
	public static Object[][] data;
		
	public Klub() {
			setLayout(new BorderLayout());
			String[] Kolumny = {"Nazwa", "Rok powstania", "Budzet", "Sponsor", "Trener"};
			data= odswiez(baza.connection);
			jt = new JTable(data, Kolumny);
			JScrollPane KlubScroll = new JScrollPane(jt);
			add(KlubScroll);
			jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
			jt.setFillsViewportHeight(true);
			DodajKlub = new JButton("Dodaj");
			UsunKlub = new JButton("Usun");
			OdswiezKlub = new JButton("Odswiez");
			SzukajKlubu = new JButton("Szukaj");
			
			DodajKlub.addActionListener(this);
			OdswiezKlub.addActionListener(this);
			UsunKlub.addActionListener(this);
			SzukajKlubu.addActionListener(this);

			add(DodajKlub, BorderLayout.EAST);
			add(UsunKlub, BorderLayout.WEST);
			add(OdswiezKlub, BorderLayout.NORTH);
			add(SzukajKlubu, BorderLayout.SOUTH);
			
	}
	
	public Klub(JTable newJT) {
		setLayout(new BorderLayout());
		jt=newJT;
		JScrollPane KlubScroll = new JScrollPane(jt);
		add(KlubScroll);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
		jt.setFillsViewportHeight(true);
		DodajKlub = new JButton("Dodaj");
		UsunKlub = new JButton("Usun");
		OdswiezKlub = new JButton("Odswiez");
		SzukajKlubu = new JButton("Szukaj");
		
		DodajKlub.addActionListener(this);
		OdswiezKlub.addActionListener(this);
		UsunKlub.addActionListener(this);
		SzukajKlubu.addActionListener(this);

		add(DodajKlub, BorderLayout.EAST);
		add(UsunKlub, BorderLayout.WEST);
		add(OdswiezKlub, BorderLayout.NORTH);
		add(SzukajKlubu, BorderLayout.SOUTH);
		
}	

	
	public Object[][] szukaj (Connection connection, String Nazwa, String Budzet, String Sponsor) {
		String formula= "select * from Klub where 1=1";
		if (Nazwa.length()!=0) formula+="AND Nazwa='"+Nazwa+"'";
		if (Budzet.length()!=0) formula+="AND Budzet='"+Budzet+"'";
		if (Sponsor.length()!=0) formula+="AND Sponsor_nazwa='"+Sponsor+"'";
		try {
        	Statement st = connection.createStatement();
        	ResultSet pom = st.executeQuery("select count (*) from Klub");
        	pom.next();
        	TabSize=pom.getInt(1)+1;
        	ResultSet rec = st.executeQuery(formula);
        	Object[][] ToReturn = new Object[TabSize][5];
        	int i=0;
        	while (rec.next()) {
        		ToReturn[i][0] =rec.getString(1);
        		ToReturn[i][1] =rec.getString(2);
        		ToReturn[i][2] =rec.getString(3);
        		ToReturn[i][3] =rec.getString(4);
        		ToReturn[i][4] =rec.getString(5);
        		i++;
        	}
        	st.close();
        	return ToReturn;}
		catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            Object[][] ExReturn = new Object[1][5];
            ExReturn[0][0]= "Error";
            ExReturn[0][1]= "Error";
            ExReturn[0][2]= "Error";
            ExReturn[0][3]= "Error";
            ExReturn[0][4]= "Error";
            return ExReturn;
        }}
	
	public static Object[][] odswiez(Connection connection) {
		try {
        	Statement st = connection.createStatement();
        	ResultSet pom = st.executeQuery("select count (*) from Klub");
        	pom.next();
        	TabSize=pom.getInt(1)+1;
        	ResultSet rec = st.executeQuery("select * from Klub order by Nazwa");
        	Object[][] ToReturn = new Object[TabSize][5];
        	int i=0;
        	while (rec.next()) {
        		ToReturn[i][0] =rec.getString(1);
        		ToReturn[i][1] =rec.getString(2);
        		ToReturn[i][2] =rec.getString(3);
        		ToReturn[i][3] =rec.getString(4);
        		ToReturn[i][4] =rec.getString(5);
        		i++;
        	}
        	st.close();
        	return ToReturn;
        }
        catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            Object[][] ExReturn = new Object[1][5];
            ExReturn[0][0]= "Error";
            ExReturn[0][1]= "Error";
            ExReturn[0][2]= "Error";
            ExReturn[0][3]= "Error";
            ExReturn[0][4]= "Error";
            return ExReturn;
        }
	}
	
	void odswiez2() {
		String[] Kolumny = {"Nazwa", "Rok powstania", "Budzet", "Sponsor", "Trener"};
		Object[][] data = odswiez(baza.connection);
		jt= new JTable(data, Kolumny);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
		jt.setFillsViewportHeight(true);
	}
	
	void szukaj2(String Nazwa, String Budzet, String Sponsor) {
		String[] Kolumny = {"Nazwa", "Rok powstania", "Budzet", "Sponsor", "Trener"};
		Object[][] data = szukaj(baza.connection, Nazwa, Budzet, Sponsor);
		jt= new JTable(data, Kolumny);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
		jt.setFillsViewportHeight(true);
		baza.Menu.odswiezKluby2(jt);
	}
	
	public void dodaj(Connection connection, String Nazwa, String Rok, String Budzet, String Sponsor, String Trener) {
		try {
			String polecenie = "insert into Klub values ('";
			polecenie=polecenie+Nazwa + "', '" + Rok + "', '" + Budzet + "', '" + Sponsor + "', '" + Trener + "') ";
        	Statement st = connection.createStatement();
        	System.out.println(polecenie);
        	st.executeQuery(polecenie);
        	st.close();
        	baza.Menu.odswiezKluby();
        	
        }
        catch(SQLException e) {
        	System.out.println("Error klub");
            e.printStackTrace();
            return;
	}}

	
	
	
	public void usun(Connection connection, String Nazwa) {
		try {
			
			String query = "";
        	Statement st = connection.createStatement();
        	
        	if(Nazwa.length()!=0)
        	query = "delete from Klub where Nazwa=" + Nazwa;
        	else return;
        	System.out.println(query);
        	st.executeQuery(query);
        	st.close();
        	baza.Menu.odswiezKluby();
        }
        catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            return;
	}
	}

	
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source==DodajKlub) {
			String[] dane = new String[5];
			for(int i=0; i<5; i++) {
			dane[i]=(String) data[TabSize-1][i];
			System.out.println(dane[i]);}
			this.dodaj(baza.connection, dane[0], dane[1], dane[2], dane[3], dane[4]);}
		if (source==OdswiezKlub) {
			baza.Menu.odswiezKluby();
		}
		if (source==UsunKlub) {
			usunKlub usunto = new usunKlub();
		}
		if (source==SzukajKlubu) {
			szukajKlubu szukajGo = new szukajKlubu();
		}
		
	}


	
}
