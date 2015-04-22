package test;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import connector.Connector;
import daoimpl.OperatoerDAO;
import daoimpl.ProduktBatchKompDAO;
import daoimpl.RaavareBatchDAO;
import daoimpl.RaavareDAO;
import daoimpl.ReceptDAO;
import daoimpl.ReceptKompDAO;
import daointerfaces.DALException;
import daointerfaces.IOperatoerDAO;
import daointerfaces.IProduktBatchKompDAO;
import daointerfaces.IRaavareBatchDAO;
import daointerfaces.IRaavareDAO;
import daointerfaces.IReceptDAO;
import daointerfaces.IReceptKompDAO;
import dto.OperatoerDTO;
import dto.ProduktBatchKompDTO;
import dto.RaavareBatchDTO;
import dto.RaavareDTO;
import dto.ReceptDTO;
import dto.ReceptKompDTO;

public class OperatoerJunit {
	
	IOperatoerDAO oprDAO;
	
	IReceptDAO receptDAO;
	IReceptKompDAO receptKDAO;
	IRaavareDAO raavareDAO;
	IRaavareBatchDAO raavareBDAO;
	
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
		
		oprDAO = new OperatoerDAO();
		
		receptDAO = new ReceptDAO();
		receptKDAO = new ReceptKompDAO();
		raavareDAO = new RaavareDAO();
		raavareBDAO = new RaavareBatchDAO();
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
			oprDAO.createOperatoer(new OperatoerDTO(oprID, "test"+oprID, "test"+oprID, "test"+oprID, "test"+oprID));
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
			oprDAO.updateOperatoer(new OperatoerDTO(oprID, "update test"+oprID, "update test"+oprID, "update test"+oprID, "update test"+oprID));
			assertEquals("update test"+oprID, oprDAO.getOperatoer(oprID).getOprNavn());
		} catch (DALException e) {e.printStackTrace();}		
	}

}
