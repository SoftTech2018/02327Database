package test;

import daoimpl.ReceptKompDAO;
import daointerfaces.DALException;
import daointerfaces.IReceptKompDAO;
import dto.ReceptKompDTO;

public class ReceptKompTest {
	IReceptKompDAO rk;
	
	public ReceptKompTest(){
		rk = new ReceptKompDAO();
	}
	
	public void listTest(){
		try {
			System.out.println("------------- Liste over receptkomponenter: ------------");			
			for(ReceptKompDTO rkDto : rk.getReceptKompList()){
				System.out.println(rkDto);
			}
			System.out.println("--------------------------------------------------------");
			System.out.println();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}
