package test;

import daoimpl.RaavareDAO;
import daointerfaces.DALException;
import daointerfaces.IRaavareDAO;
import dto.RaavareDTO;

public class RaavareTest {
	IRaavareDAO r;
	
	public RaavareTest(){
		r = new RaavareDAO();
	}
	
	public void listTest(){
		try {
			System.out.println("------------------ Liste over råvare: ------------------");			
			for(RaavareDTO rDto : r.getRaavareList()){
				System.out.println(rDto);
			}
			System.out.println("--------------------------------------------------------");
			System.out.println();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}	
}
