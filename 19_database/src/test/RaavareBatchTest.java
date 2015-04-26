package test;

import java.io.FileNotFoundException;

import daoimpl.RaavareBatchDAO;
import daoimpl.TextReader;
import daointerfaces.DALException;
import daointerfaces.IRaavareBatchDAO;
import dto.RaavareBatchDTO;

public class RaavareBatchTest {
	IRaavareBatchDAO rb;
	
	public RaavareBatchTest(TextReader txt) throws FileNotFoundException{
		rb = new RaavareBatchDAO(txt);
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
