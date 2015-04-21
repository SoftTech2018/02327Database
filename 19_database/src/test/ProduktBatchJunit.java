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
import daoimpl.ProduktBatchDAO;
import daointerfaces.DALException;
import daointerfaces.IProduktBatchDAO;
import dto.OperatoerDTO;
import dto.ProduktBatchDTO;

public class ProduktBatchJunit {
	
	IProduktBatchDAO produktBDAO;

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
		
		produktBDAO = new ProduktBatchDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getProduktBatchTest() {
		try {
			int pbID = produktBDAO.getProduktBatch(1).getPbId();
			assertEquals(1,pbID);
		} catch (DALException e) {e.printStackTrace();}		
	}
	
	@Test
	public void opretProduktBatchTest() {
		int pbID = 0, temp = 0;
		try {
			for(ProduktBatchDTO pbDto : produktBDAO.getProduktBatchList()){
				temp = pbDto.getPbId();
				if (temp>pbID){
					pbID = temp;
				}				
			}
			pbID++;
			produktBDAO.createProduktBatch(new ProduktBatchDTO(pbID, 100+pbID, produktBDAO.getProduktBatch(temp).getReceptId()));
			assertEquals(100+pbID, produktBDAO.getProduktBatch(pbID).getStatus());
		} catch (DALException e) {e.printStackTrace();}		
	}
	
	@Test
	public void updateProduktBatchTest() {
		int pbID = 0;
		try {
			for(ProduktBatchDTO pbDto : produktBDAO.getProduktBatchList()){
				if (String.valueOf(pbDto.getStatus()).startsWith("10")){
					pbID = pbDto.getPbId();
					break;
				}				
			}
			produktBDAO.updateProduktBatch(new ProduktBatchDTO(pbID, 500+pbID, produktBDAO.getProduktBatch(pbID).getReceptId()));
			assertEquals(500+pbID, produktBDAO.getProduktBatch(pbID).getStatus());
		} catch (DALException e) {e.printStackTrace();}		
	}

}
