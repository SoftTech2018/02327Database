package daointerfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dto.OperatoerDTO;

public interface IOperatoerDAO {
	OperatoerDTO getOperatoer(int oprId) throws DALException;
	List<OperatoerDTO> getOperatoerList() throws DALException;
	void createOperatoer(OperatoerDTO opr) throws DALException;
	void updateOperatoer(OperatoerDTO opr) throws DALException;
	public ResultSet getView() throws DALException;
	public void callProcedure() throws DALException;
	public void setFunction() throws DALException;
	public String getFunction(int id) throws DALException, SQLException;
	public void dropAll() throws DALException;	
}
