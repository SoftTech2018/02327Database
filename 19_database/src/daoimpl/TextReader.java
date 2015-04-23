package daoimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.OperatoerDTO;

public class TextReader {
	
	private File sqlFileCommands;
	private String[] sqlCommands;
	
	public TextReader() throws FileNotFoundException{
		sqlFileCommands = new File("files/sqlCommands.txt");
		sqlCommands = readFile(sqlFileCommands);
	}
	
	private String[] readFile(File fil) throws FileNotFoundException{
		List<String> data = new ArrayList<String>();
		String linje = null;
		try (BufferedReader br = new BufferedReader(new FileReader(fil));){
			while ((linje = br.readLine()) != null){
				data.add(linje);
			}
		} catch (IOException e) {
			throw new FileNotFoundException();
		}
		return data.toArray(new String[data.size()]);
	}
	
	/**
	 * Returnerer den kommando der svarer til teksten på linje-nummeret i filen "files/sqlCommands.txt". 
	 * @param cmd Linjenummeret der skal returneres
	 * @return Teksten på linjenummeret
	 */
	public String getCommand(int cmd){
		return sqlCommands[cmd-1];
	}
	
	public String getOperatoer(int oprID){
		String output = sqlCommands[0];
		output.replaceAll("1", Integer.toString(oprID));
		return output;
	}
	
	public String createOperatoer(OperatoerDTO opr){
		String output = sqlCommands[1];
		output.replaceAll("1", Integer.toString(opr.getOprId())); // OprID
		output.replaceAll("2", opr.getOprNavn());
		output.replaceAll("3", opr.getIni());
		output.replaceAll("4", opr.getCpr());
		output.replaceAll("5", opr.getPassword());
		return output;
	}
	
	public String updateOperatoer(OperatoerDTO opr){
		String output = sqlCommands[2];
		output.replaceAll("1", opr.getOprNavn());
		output.replaceAll("2", opr.getIni());
		output.replaceAll("3", opr.getCpr());
		output.replaceAll("4", opr.getPassword());
		output.replaceAll("5", Integer.toString(opr.getOprId())); // OprID
		return output;
	}

}
