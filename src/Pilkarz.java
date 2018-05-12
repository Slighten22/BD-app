import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Pilkarz extends JPanel implements ActionListener {
	static JTable jt;
	static JButton DodajPilkarza;
	static JButton UsunPilkarza;
	static JButton SzukajPilkarza;
	static JButton OdswiezPilkarza;
	public static int TabSize;
	public static Object[][] data;
		public Pilkarz() {
			setLayout(new BorderLayout());
			String[] Kolumny = {"Imie", "Nazwisko", "Wiek", "Noga", "ID", "Kadra", "Klub", "Sponsor", "Agent"};
			data= odswiez(baza.connection);
			jt = new JTable(data, Kolumny);
			JScrollPane PilkarzScroll = new JScrollPane(jt);
			add(PilkarzScroll);
			jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
			jt.setFillsViewportHeight(true);
			DodajPilkarza = new JButton("Dodaj");
			UsunPilkarza = new JButton("Usun");
			OdswiezPilkarza = new JButton("Odswiez");
			SzukajPilkarza = new JButton("Szukaj");
			
			DodajPilkarza.addActionListener(this);
			OdswiezPilkarza.addActionListener(this);
			UsunPilkarza.addActionListener(this);
			SzukajPilkarza.addActionListener(this);
			//add(ButtonsPilkarz);
			/*
			ButtonsPilkarz.add(DodajPilkarza);
			ButtonsPilkarz.add(UsunPilkarza);
			ButtonsPilkarz.add(OdswiezPilkarza);
			ButtonsPilkarz.add(SzukajPilkarza);*/
			add(DodajPilkarza, BorderLayout.EAST);
			add(UsunPilkarza, BorderLayout.WEST);
			add(OdswiezPilkarza, BorderLayout.NORTH);
			add(SzukajPilkarza, BorderLayout.SOUTH);
			
	}
	
		
		public Pilkarz(JTable newJt) {
			setLayout(new BorderLayout());
			jt = newJt;
			JScrollPane PilkarzScroll = new JScrollPane(jt);
			add(PilkarzScroll);
			jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
			jt.setFillsViewportHeight(true);
			DodajPilkarza = new JButton("Dodaj");
			UsunPilkarza = new JButton("Usun");
			OdswiezPilkarza = new JButton("Odswiez");
			SzukajPilkarza = new JButton("Szukaj");
			
			DodajPilkarza.addActionListener(this);
			OdswiezPilkarza.addActionListener(this);
			UsunPilkarza.addActionListener(this);
			SzukajPilkarza.addActionListener(this);
			//add(ButtonsPilkarz);
			/*
			ButtonsPilkarz.add(DodajPilkarza);
			ButtonsPilkarz.add(UsunPilkarza);
			ButtonsPilkarz.add(OdswiezPilkarza);
			ButtonsPilkarz.add(SzukajPilkarza);*/
			add(DodajPilkarza, BorderLayout.EAST);
			add(UsunPilkarza, BorderLayout.WEST);
			add(OdswiezPilkarza, BorderLayout.NORTH);
			add(SzukajPilkarza, BorderLayout.SOUTH);
			
	}
		
	public void wypisz(Connection connection) {
		try {
        	Statement st = connection.createStatement();
        	ResultSet rec = st.executeQuery("select Imie, Nazwisko " + "from Pilkarz " + "order by Nazwisko");
        	while (rec.next()) {
        		System.out.println("NAME:\t\t" + rec.getString(1));
        		System.out.println("SURNAME:\t" + rec.getString(2));
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
	
	public Object[][] szukaj (Connection connection, String Imie, String Nazwisko, String ID, String Klub, String Wiek, String Agent, String Sponsor ) {
		String formula= "select * from Pilkarz where 1=1";
		if (Imie.length()!=0) formula+="AND Imie='"+Imie+"'";
		if (Nazwisko.length()!=0) formula+="AND Nazwisko='"+Nazwisko+"'";
		if (ID.length()!=0) formula+="AND ID='"+ID+"'";
		if (Klub.length()!=0) formula+="AND Klub_nazwa='"+Klub+"'";
		if (Wiek.length()!=0) formula+="AND Wiek='"+Wiek+"'";
		if (Agent.length()!=0) formula+="AND Agent_ID2='"+Agent+"'";
		if (Sponsor.length()!=0) formula+="AND Sponsor_nazwa='"+Sponsor+"'";
		try {
        	Statement st = connection.createStatement();
        	ResultSet pom = st.executeQuery("select count (*) from Pilkarz");
        	pom.next();
        	TabSize=pom.getInt(1)+1;
        	ResultSet rec = st.executeQuery(formula);
        	Object[][] ToReturn = new Object[TabSize][9];
        	int i=0;
        	while (rec.next()) {
        		ToReturn[i][0] =rec.getString(1);
        		ToReturn[i][1] =rec.getString(2);
        		ToReturn[i][2] =rec.getString(3);
        		ToReturn[i][3] =rec.getString(4);
        		ToReturn[i][4] =rec.getString(5);
        		ToReturn[i][5] =rec.getString(6);
        		ToReturn[i][6] =rec.getString(7);
        		ToReturn[i][7] =rec.getString(8);
        		ToReturn[i][8] =rec.getString(9);
        		i++;
        	}
        	st.close();
        	return ToReturn;}
		catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            Object[][] ExReturn = new Object[1][9];
            ExReturn[0][0]= "Error";
            ExReturn[0][1]= "Error";
            ExReturn[0][2]= "Error";
            ExReturn[0][3]= "Error";
            ExReturn[0][4]= "Error";
            ExReturn[0][5]= "Error";
            ExReturn[0][6]= "Error";
            ExReturn[0][7]= "Error";
            ExReturn[0][8]= "Error";
            return ExReturn;
        }}
	
	public static Object[][] odswiez(Connection connection) {
		try {
        	Statement st = connection.createStatement();
        	ResultSet pom = st.executeQuery("select count (*) from Pilkarz");
        	pom.next();
        	TabSize=pom.getInt(1)+1;
        	ResultSet rec = st.executeQuery("select Imie, Nazwisko, Wiek, Noga, ID, Kadra_Narodowa, Klub_Nazwa, Sponsor_Nazwa, Agent_ID2 " + "from Pilkarz " + "order by Nazwisko");
        	Object[][] ToReturn = new Object[TabSize][9];
        	int i=0;
        	while (rec.next()) {
        		ToReturn[i][0] =rec.getString(1);
        		ToReturn[i][1] =rec.getString(2);
        		ToReturn[i][2] =rec.getString(3);
        		ToReturn[i][3] =rec.getString(4);
        		ToReturn[i][4] =rec.getString(5);
        		ToReturn[i][5] =rec.getString(6);
        		ToReturn[i][6] =rec.getString(7);
        		ToReturn[i][7] =rec.getString(8);
        		ToReturn[i][8] =rec.getString(9);
        		i++;
        	}
        	st.close();
        	return ToReturn;
        }
        catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            Object[][] ExReturn = new Object[1][9];
            ExReturn[0][0]= "Error";
            ExReturn[0][1]= "Error";
            ExReturn[0][2]= "Error";
            ExReturn[0][3]= "Error";
            ExReturn[0][4]= "Error";
            ExReturn[0][5]= "Error";
            ExReturn[0][6]= "Error";
            ExReturn[0][7]= "Error";
            ExReturn[0][8]= "Error";
            return ExReturn;
        }
	}
	
	void odswiez2() {
		String[] Kolumny = {"Imie", "Nazwisko", "Wiek", "Noga", "ID", "Kadra", "Klub", "Sponsor", "Agent"};
		Object[][] data = odswiez(baza.connection);
		jt= new JTable(data, Kolumny);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
		jt.setFillsViewportHeight(true);
	}
	
	void szukaj2(String Imie, String Nazwisko, String ID, String Klub, String Wiek, String Agent, String Sponsor) {
		String[] Kolumny = {"Imie", "Nazwisko", "Wiek", "Noga", "ID", "Kadra", "Klub", "Sponsor", "Agent"};
		Object[][] data = szukaj(baza.connection, Imie, Nazwisko, ID, Klub, Wiek, Agent, Sponsor);
		jt= new JTable(data, Kolumny);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
		jt.setFillsViewportHeight(true);
		baza.Menu.odswiezPilkarzy2(jt);
	}
	
	public void dodaj(Connection connection, String Imie, String Nazwisko, String Wiek, String Noga, String ID, String Kadra, String Klub, String Sponsor, String Agent) {
		try {
			int realWiek= Integer.parseInt(Wiek);
			String polecenie = "insert into Pilkarz values ('";
			polecenie=polecenie+Imie + "', '" + Nazwisko + "', '" + realWiek + "', '" + Noga + "', '" + ID + "', ";
			if (Kadra!=null) polecenie=polecenie+"'"+Kadra+"', '";
			else polecenie=polecenie+"null, '";
			polecenie=polecenie+ Klub + "', ";
			if (Sponsor!=null) polecenie=polecenie+"'"+Sponsor+"', '";
			else polecenie=polecenie+"null, '";
			polecenie=polecenie+Agent+"')";
        	Statement st = connection.createStatement();
        	System.out.println(polecenie);
        	st.executeQuery(polecenie);
        	st.close();
        	baza.Menu.odswiezPilkarzy();
        	
        }
        catch(SQLException e) {
        	System.out.println("Error pilkarz");
            e.printStackTrace();
            return;
	}}

	
	
	
	public void usun(Connection connection, String imie, String nazwisko, String id) {
		try {
			
			String query = "";
        	Statement st = connection.createStatement();
        	
        	if(id.length()!=0)
        	query = "delete from Pilkarz where ID=" + id;
        	else if(imie.length()!=0 && nazwisko.length()!=0 && id.length()==0)
        	query = "delete from Pilkarz where Imie='" + imie + "' AND Nazwisko='" + nazwisko + "'";
        	else if(imie.length()!=0 && nazwisko.length()==0 && id.length()==0)
        	query = "delete from Pilkarz where Imie='" + imie +"'";
        	else if(imie.length()==0 && nazwisko.length()!=0 && id.length()==0)
        	query = "delete from Pilkarz where Nazwisko='" + nazwisko + "'";
        	else return;
        	System.out.println(query);
        	st.executeQuery(query);
        	st.close();
        	baza.Menu.odswiezPilkarzy();
        }
        catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            return;
	}
	}

	
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source==DodajPilkarza) {
			String[] dane = new String[9];
			for(int i=0; i<9; i++) {
			dane[i]=(String) data[TabSize-1][i];
			System.out.println(dane[i]);}
			this.dodaj(baza.connection, dane[0], dane[1], dane[2], dane[3], dane[4], dane[5], dane[6], dane[7], dane[8]);}
		if (source==OdswiezPilkarza) {
			baza.Menu.odswiezPilkarzy();
		}
		if (source==UsunPilkarza) {
			usunPilkarza usunto = new usunPilkarza();
		}
		if (source==SzukajPilkarza) {
			szukajPilkarza szukajGo = new szukajPilkarza();
		}
		
	}


	
}
