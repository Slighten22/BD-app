import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Agent extends JPanel implements ActionListener {
	static JTable jt;
	static JButton DodajAgenta;
	static JButton UsunAgenta;
	static JButton SzukajAgenta;
	static JButton OdswiezAgenta;
	public static int TabSize;
	public static Object[][] data;
		
	public Agent() {
			setLayout(new BorderLayout());
			String[] Kolumny = {"Imie", "Nazwisko", "Wiek", "ID"};
			data= odswiez(baza.connection);
			jt = new JTable(data, Kolumny);
			JScrollPane AgentScroll = new JScrollPane(jt);
			add(AgentScroll);
			jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
			jt.setFillsViewportHeight(true);
			DodajAgenta = new JButton("Dodaj");
			UsunAgenta = new JButton("Usun");
			OdswiezAgenta = new JButton("Odswiez");
			SzukajAgenta = new JButton("Szukaj");
			
			DodajAgenta.addActionListener(this);
			OdswiezAgenta.addActionListener(this);
			UsunAgenta.addActionListener(this);
			SzukajAgenta.addActionListener(this);

			add(DodajAgenta, BorderLayout.EAST);
			add(UsunAgenta, BorderLayout.WEST);
			add(OdswiezAgenta, BorderLayout.NORTH);
			add(SzukajAgenta, BorderLayout.SOUTH);
			
	}
	
		
	public Agent(JTable newJT) {
		setLayout(new BorderLayout());
		jt=newJT;
		JScrollPane AgentScroll = new JScrollPane(jt);
		add(AgentScroll);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
		jt.setFillsViewportHeight(true);
		DodajAgenta = new JButton("Dodaj");
		UsunAgenta = new JButton("Usun");
		OdswiezAgenta = new JButton("Odswiez");
		SzukajAgenta = new JButton("Szukaj");
		
		DodajAgenta.addActionListener(this);
		OdswiezAgenta.addActionListener(this);
		UsunAgenta.addActionListener(this);
		SzukajAgenta.addActionListener(this);

		add(DodajAgenta, BorderLayout.EAST);
		add(UsunAgenta, BorderLayout.WEST);
		add(OdswiezAgenta, BorderLayout.NORTH);
		add(SzukajAgenta, BorderLayout.SOUTH);
		
}
		

	
	public Object[][] szukaj (Connection connection, String Imie, String Nazwisko, String ID, String Wiek) {
		String formula= "select * from Agent where 1=1";
		if (Imie.length()!=0) formula+="AND Imie='"+Imie+"'";
		if (Nazwisko.length()!=0) formula+="AND Nazwisko='"+Nazwisko+"'";
		if (ID.length()!=0) formula+="AND ID='"+ID+"'";
		if (Wiek.length()!=0) formula+="AND Wiek='"+Wiek+"'";
		try {
        	Statement st = connection.createStatement();
        	ResultSet pom = st.executeQuery("select count (*) from Agent");
        	pom.next();
        	TabSize=pom.getInt(1)+1;
        	ResultSet rec = st.executeQuery(formula);
        	Object[][] ToReturn = new Object[TabSize][4];
        	int i=0;
        	while (rec.next()) {
        		ToReturn[i][0] =rec.getString(1);
        		ToReturn[i][1] =rec.getString(2);
        		ToReturn[i][2] =rec.getString(3);
        		ToReturn[i][3] =rec.getString(4);
        		i++;
        	}
        	st.close();
        	return ToReturn;}
		catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            Object[][] ExReturn = new Object[1][4];
            ExReturn[0][0]= "Error";
            ExReturn[0][1]= "Error";
            ExReturn[0][2]= "Error";
            ExReturn[0][3]= "Error";
            return ExReturn;
        }}
	
	public static Object[][] odswiez(Connection connection) {
		try {
        	Statement st = connection.createStatement();
        	ResultSet pom = st.executeQuery("select count (*) from Agent");
        	pom.next();
        	TabSize=pom.getInt(1)+1;
        	ResultSet rec = st.executeQuery("select * from Agent order by Nazwisko");
        	Object[][] ToReturn = new Object[TabSize][4];
        	int i=0;
        	while (rec.next()) {
        		ToReturn[i][0] =rec.getString(1);
        		ToReturn[i][1] =rec.getString(2);
        		ToReturn[i][2] =rec.getString(3);
        		ToReturn[i][3] =rec.getString(4);
        		i++;
        	}
        	st.close();
        	return ToReturn;
        }
        catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            Object[][] ExReturn = new Object[1][4];
            ExReturn[0][0]= "Error";
            ExReturn[0][1]= "Error";
            ExReturn[0][2]= "Error";
            ExReturn[0][3]= "Error";
            return ExReturn;
        }
	}
	
	void odswiez2() {
		String[] Kolumny = {"Imie", "Nazwisko", "Wiek","ID"};
		Object[][] data = odswiez(baza.connection);
		jt= new JTable(data, Kolumny);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
		jt.setFillsViewportHeight(true);
	}
	
	void szukaj2(String Imie, String Nazwisko, String ID, String Wiek) {
		String[] Kolumny = {"Imie", "Nazwisko", "Wiek", "ID"};
		Object[][] data = szukaj(baza.connection, Imie, Nazwisko, ID, Wiek);
		jt= new JTable(data, Kolumny);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 600)); // DZIALA
		jt.setFillsViewportHeight(true);
		baza.Menu.odswiezAgentow2(jt);
	}
	
	public void dodaj(Connection connection, String Imie, String Nazwisko, String Wiek, String ID) {
		try {
			String polecenie = "insert into Agent values ('";
			polecenie=polecenie+Imie + "', '" + Nazwisko + "', ";
			if (Wiek!=null) polecenie=polecenie+"'"+Wiek+"', '";
			else polecenie=polecenie+"null, '";
			polecenie=polecenie+ ID + "')";
        	Statement st = connection.createStatement();
        	System.out.println(polecenie);
        	st.executeQuery(polecenie);
        	st.close();
        	baza.Menu.odswiezAgentow();
        	
        }
        catch(SQLException e) {
        	System.out.println("Error Agent");
            e.printStackTrace();
            return;
	}}

	
	
	
	public void usun(Connection connection, String imie, String nazwisko, String id) {
		try {
			
			String query = "";
        	Statement st = connection.createStatement();
        	
        	if(id.length()!=0)
        	query = "delete from Agent where ID=" + id;
        	else if(imie.length()!=0 && nazwisko.length()!=0 && id.length()==0)
        	query = "delete from Agent where Imie='" + imie + "' AND Nazwisko='" + nazwisko + "'";
        	else if(imie.length()!=0 && nazwisko.length()==0 && id.length()==0)
        	query = "delete from Agent where Imie='" + imie +"'";
        	else if(imie.length()==0 && nazwisko.length()!=0 && id.length()==0)
        	query = "delete from Agent where Nazwisko='" + nazwisko + "'";
        	else return;
        	System.out.println(query);
        	st.executeQuery(query);
        	st.close();
        	baza.Menu.odswiezAgentow();
        }
        catch(SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
            return;
	}
	}

	
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source==DodajAgenta) {
			String[] dane = new String[4];
			for(int i=0; i<4; i++) {
			dane[i]=(String) data[TabSize-1][i];
			System.out.println(dane[i]);}
			this.dodaj(baza.connection, dane[0], dane[1], dane[2], dane[3]);}
		if (source==OdswiezAgenta) {
			baza.Menu.odswiezAgentow();
		}
		if (source==UsunAgenta) {
			usunAgenta usunto = new usunAgenta();
		}
		if (source==SzukajAgenta) {
			szukajAgenta szukajGo = new szukajAgenta();
		}
		
	}


	
}
