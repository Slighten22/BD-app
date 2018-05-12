import java.sql.*;
import javax.swing.*;

public class baza {
	public static InterMenu Menu;
	public static Connection connection;
	public static void main(String[] argv) {
	        System.out.println("-------- Oracle JDBC Connection Testing ------");

	        try {

	            Class.forName("oracle.jdbc.driver.OracleDriver");

	        } catch (ClassNotFoundException e) {

	            System.out.println("Where is your Oracle JDBC Driver?");
	            e.printStackTrace();
	            return;

	        }

	        System.out.println("Oracle JDBC Driver Registered!");

	        connection = null;

	        try {

	            connection = DriverManager.getConnection(
	                    "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf", "pkryszto", "pkryszto");

	        } catch (SQLException e) {

	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	            return;

	        }

	        if (connection != null) {
	            System.out.println("You made it, take control your database now!");
	        } else {
	            System.out.println("Failed to make connection!");
	        }
	        //Pilkarz p = new Pilkarz();
	       
	        //p.dodaj(connection, "Luis2", "Armweak2", "25", "P", "1807", "Anglia", "Villareal", "Nike", "9003");
	        //p.usun(connection, 1807);
	        //p.usun(connection, 1901);
	        //p.usun(connection, "Luis", "Armweak");
	        //p.wypisz(connection);
	        Menu = new InterMenu();
	        Menu.pack();
	    }
}

