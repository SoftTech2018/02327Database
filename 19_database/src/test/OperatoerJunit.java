package test;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import connector.Connector;
import daoimpl.OperatoerDAO;
import daoimpl.ReceptKompDAO;
import daoimpl.TextReader;
import daointerfaces.DALException;
import daointerfaces.IOperatoerDAO;
import daointerfaces.IReceptKompDAO;
import dto.OperatoerDTO;

public class OperatoerJunit {
	
	IOperatoerDAO oprDAO;
	
	
	IReceptKompDAO receptKDAO;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		TextReader txt = new TextReader();
		oprDAO = new OperatoerDAO(txt);
		
		
		receptKDAO = new ReceptKompDAO(txt);
		
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void getOperatoerTest() {
		try {
			int oprID = oprDAO.getOperatoer(1).getOprId();
			assertEquals(1,oprID);
		} catch (DALException e) {e.printStackTrace();}		
	}
	
	@Test
	public void opretOperatoerTest() {
		int oprID = 0, temp = 0;
		try {
			for(OperatoerDTO oprDto : oprDAO.getOperatoerList()){
				temp = oprDto.getOprId();
				if (temp>oprID){
					oprID = temp;	
				}				
			}
			oprID++;
			oprDAO.createOperatoer(new OperatoerDTO(oprID, "test"+oprID, "test"+oprID, "test"+oprID, "test"+oprID, true, true, true));
			assertEquals("test"+oprID, oprDAO.getOperatoer(oprID).getOprNavn());
		} catch (DALException e) {e.printStackTrace();}		
	}
	
	@Test
	public void updateOperatoerTest() {
		int oprID = 0;
		try {
			for(OperatoerDTO oprDto : oprDAO.getOperatoerList()){
				if (oprDto.getOprNavn().startsWith("test")){
					oprID = oprDto.getOprId();
					break;
				}				
			}
			oprDAO.updateOperatoer(new OperatoerDTO(oprID, "update test"+oprID, "update test"+oprID, "update test"+oprID, "update test"+oprID, true, true, true));
			assertEquals("update test"+oprID, oprDAO.getOperatoer(oprID).getOprNavn());
		} catch (DALException e) {e.printStackTrace();}		
	}

}
