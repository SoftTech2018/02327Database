package test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import connector.Connector;
import daoimpl.TextReader;
import daointerfaces.DALException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, DALException {
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
		
		TextReader txt = new TextReader();
		
		OperatoerTest oprTest = new OperatoerTest(txt);
		ProduktBatchTest pbTest = new ProduktBatchTest(txt);
		ProduktBatchKompTest pbkTest = new ProduktBatchKompTest(txt);
		ReceptTest rTest = new ReceptTest(txt);
		ReceptKompTest rkTest = new ReceptKompTest(txt);
		RaavareTest raTest = new RaavareTest(txt);
		RaavareBatchTest rabTest = new RaavareBatchTest(txt);
		oprTest.listTest();
		pbTest.listTest();
		pbkTest.listTest();
		rTest.listTest();
		rkTest.listTest();
		raTest.listTest();
		rabTest.listTest();
	}
}
