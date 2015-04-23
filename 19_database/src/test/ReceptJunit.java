package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import connector.Connector;
import daoimpl.ReceptDAO;
import daointerfaces.DALException;
import daointerfaces.IReceptDAO;
import dto.ReceptDTO;

public class ReceptJunit {
	
	IReceptDAO receptDAO;

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
		
		receptDAO = new ReceptDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getOperatoerTest() {
		try {
			int rcpID = receptDAO.getRecept(1).getReceptId();
			assertEquals(1,rcpID);
		} catch (DALException e) {e.printStackTrace();}		
	}
	
	@Test
	public void opretReceptTest() {
		int rcpID = 0, temp = 0;
		try {
			for(ReceptDTO rcpDto : receptDAO.getReceptList()){
				temp = rcpDto.getReceptId();
				if (temp>rcpID){
					rcpID = temp;	
				}				
			}
			rcpID++;
			String test = "test"+rcpID;
			receptDAO.createRecept(new ReceptDTO(rcpID, test));
			assertEquals(test, receptDAO.getRecept(rcpID).getReceptNavn());
		} catch (DALException e) {e.printStackTrace();}		
	}
	
	@Test
	public void updateReceptTest() {
		int rcpID = 0;
		try {
			for(ReceptDTO rcpDto : receptDAO.getReceptList()){
				if (rcpDto.getReceptNavn().startsWith("test")){
					rcpID = rcpDto.getReceptId();
					break;
				}				
			}
			receptDAO.updateRecept(new ReceptDTO(rcpID, "update "+receptDAO.getRecept(rcpID).getReceptNavn()));
			assertEquals("update test"+rcpID, receptDAO.getRecept(rcpID).getReceptNavn());
		} catch (DALException e) {e.printStackTrace();}		
	}

}
