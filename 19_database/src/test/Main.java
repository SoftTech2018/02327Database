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
		
		// Basal test af TextReader.java
//		try {
//			OperatoerDTO opr = new OperatoerDTO(10, "Jens Peter", "JPE", "012345-6789", "02324it!");
//			TextReader txt = new TextReader();
//			System.out.println("createOperatoer: " + txt.createOperatoer(opr));
//			System.out.println("getOperatoer: " + txt.getOperatoer(10));
//			System.out.println("updateOperatoer: " + txt.updateOperatoer(opr));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
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
