package test;

import daoimpl.ProduktBatchKompDAO;
import daointerfaces.DALException;
import daointerfaces.IProduktBatchKompDAO;
import dto.ProduktBatchKompDTO;

public class ProduktBatchKompTest {
	IProduktBatchKompDAO pbk;
	
	public ProduktBatchKompTest(){
		pbk = new ProduktBatchKompDAO();
	}
	
	public void listTest(){
		try {
			System.out.println("---------- Liste over produktbatchkomponenter: ---------");			
			for(ProduktBatchKompDTO pbkDto : pbk.getProduktBatchKompList()){
				System.out.println(pbkDto);
			}
			System.out.println("--------------------------------------------------------");
			System.out.println();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}
