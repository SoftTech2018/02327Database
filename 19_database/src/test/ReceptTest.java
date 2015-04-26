package test;

import java.io.FileNotFoundException;

import daoimpl.ReceptDAO;
import daoimpl.TextReader;
import daointerfaces.DALException;
import daointerfaces.IReceptDAO;
import dto.ReceptDTO;

public class ReceptTest {
	IReceptDAO r;
	
	public ReceptTest(TextReader txt) throws FileNotFoundException{
		r = new ReceptDAO(txt);
	}
	
	public void listTest(){
		try {
			System.out.println("----------------- Liste over recepter: -----------------");			
			for(ReceptDTO rDto : r.getReceptList()){
				System.out.println(rDto);
			}
			System.out.println("--------------------------------------------------------");
			System.out.println();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}
