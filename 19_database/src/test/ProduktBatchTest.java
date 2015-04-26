package test;

import java.io.FileNotFoundException;

import daoimpl.ProduktBatchDAO;
import daoimpl.TextReader;
import daointerfaces.DALException;
import daointerfaces.IProduktBatchDAO;
import dto.ProduktBatchDTO;

public class ProduktBatchTest {
	IProduktBatchDAO pb;
	
	public ProduktBatchTest(TextReader txt) throws FileNotFoundException{
		pb = new ProduktBatchDAO(txt);
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
