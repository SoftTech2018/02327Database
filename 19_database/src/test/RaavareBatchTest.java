package test;

import daoimpl.RaavareBatchDAO;
import daointerfaces.DALException;
import daointerfaces.IRaavareBatchDAO;
import dto.RaavareBatchDTO;

public class RaavareBatchTest {
	IRaavareBatchDAO rb;
	
	public RaavareBatchTest(){
		rb = new RaavareBatchDAO();
	}
	
	public void listTest(){
		try {
			System.out.println("--------------- Liste over råvarebatches: --------------");			
			for(RaavareBatchDTO rbDto : rb.getRaavareBatchList()){
				System.out.println(rbDto);
			}
			System.out.println("--------------------------------------------------------");
			System.out.println();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}
