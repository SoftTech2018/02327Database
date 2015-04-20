package test;

import java.sql.SQLException;
import connector.Connector;

public class Main {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		OperatoerTest oprTest = new OperatoerTest();
		ProduktBatchTest pbTest = new ProduktBatchTest();
		ProduktBatchKompTest pbkTest = new ProduktBatchKompTest();
		ReceptTest rTest = new ReceptTest();
		ReceptKompTest rkTest = new ReceptKompTest();
		RaavareTest raTest = new RaavareTest();
		RaavareBatchTest rabTest = new RaavareBatchTest();
		oprTest.listTest();
		pbTest.listTest();
		pbkTest.listTest();
		rTest.listTest();
		rkTest.listTest();
		raTest.listTest();
		rabTest.listTest();
	}
}
