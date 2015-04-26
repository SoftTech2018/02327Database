package test;

import java.io.FileNotFoundException;

import daoimpl.ReceptKompDAO;
import daoimpl.TextReader;
import daointerfaces.DALException;
import daointerfaces.IReceptKompDAO;
import dto.ReceptKompDTO;

public class ReceptKompTest {
	IReceptKompDAO rk;
	
	public ReceptKompTest(TextReader txt) throws FileNotFoundException{
		rk = new ReceptKompDAO(txt);
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
