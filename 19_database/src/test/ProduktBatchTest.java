package test;

import daoimpl.ProduktBatchDAO;
import daointerfaces.DALException;
import daointerfaces.IProduktBatchDAO;
import dto.ProduktBatchDTO;

public class ProduktBatchTest {
	IProduktBatchDAO pb;
	
	public ProduktBatchTest(){
		pb = new ProduktBatchDAO();
	}
	
	public void listTest(){
		try {
			System.out.println("-------------- Liste over produktbatches: --------------");			
			for(ProduktBatchDTO pbDto : pb.getProduktBatchList()){
				System.out.println(pbDto);
			}
			System.out.println("--------------------------------------------------------");
			System.out.println();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}
