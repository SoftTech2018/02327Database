package daoimpl;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import connector.Connector;
import daointerfaces.DALException;
import daointerfaces.IOperatoerDAO;
import dto.OperatoerDTO;

public class OperatoerDAO implements IOperatoerDAO {
	
	TextReader txt;
	
	public OperatoerDAO() throws FileNotFoundException{
		txt = new TextReader();
	}
	
	public OperatoerDTO getOperatoer(int oprId) throws DALException {
		ResultSet rs = Connector.doQuery(txt.getOperatoer(oprId));
	    try {
	    	if (!rs.first()) throw new DALException("Operatoeren " + oprId + " findes ikke");
	    	return new OperatoerDTO (rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}
	
	public void createOperatoer(OperatoerDTO opr) throws DALException {		
			Connector.doUpdate(txt.createOperatoer(opr));
	}
	
	public void updateOperatoer(OperatoerDTO opr) throws DALException {
		Connector.doUpdate(txt.updateOperatoer(opr));
	}
	
	public List<OperatoerDTO> getOperatoerList() throws DALException {
		List<OperatoerDTO> list = new ArrayList<OperatoerDTO>();
		ResultSet rs = Connector.doQuery(txt.getCommand(4));
		try
		{
			while (rs.next()) 
			{
				list.add(new OperatoerDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
		
		
}
	
