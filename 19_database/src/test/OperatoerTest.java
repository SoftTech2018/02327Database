package test;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

import daoimpl.OperatoerDAO;
import daointerfaces.DALException;
import daointerfaces.IOperatoerDAO;
import dto.OperatoerDTO;

public class OperatoerTest {	
	IOperatoerDAO opr;
	ResultSet rs;
	int temp = 0;
	
	public OperatoerTest() throws FileNotFoundException, DALException{
		opr = new OperatoerDAO();		
	}
	
	public void listTest() throws DALException{
		try {
			System.out.println("---------------- Liste over operatører: ----------------");			
			for(OperatoerDTO oprDto : opr.getOperatoerList()){
				System.out.println(oprDto);
				if(oprDto.getOprId()>temp){
					temp = oprDto.getOprId();
				}
			}
			System.out.println("--------------------------------------------------------");
			System.out.println();
			System.out.println("-------------------- Operatør view: --------------------");
			temp++;
			opr.createOperatoer(new OperatoerDTO(temp, "test"+temp, "test"+temp, "test"+temp, "test"+temp));
			rs = opr.getView();
			while(rs.next()){
				System.out.println(rs.getInt("opr_id")+"\t"+rs.getString("opr_navn")+"   \t"+rs.getString("ini"));
			}
			System.out.println("--------------------------------------------------------");
			System.out.println();
		} catch (DALException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			opr.dropView();
			opr.dropTrigger();
		}
	}
	
}
