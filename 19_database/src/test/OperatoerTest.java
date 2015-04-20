package test;

import daoimpl.OperatoerDAO;
import daointerfaces.DALException;
import daointerfaces.IOperatoerDAO;
import dto.OperatoerDTO;

public class OperatoerTest {	
	IOperatoerDAO opr;
	
	public OperatoerTest(){
		opr = new OperatoerDAO();
	}
	
	public void listTest(){
		try {
			System.out.println("---------------- Liste over operatører: ----------------");			
			for(OperatoerDTO oprDto : opr.getOperatoerList()){
				System.out.println(oprDto);
			}
			System.out.println("--------------------------------------------------------");
			System.out.println();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}
