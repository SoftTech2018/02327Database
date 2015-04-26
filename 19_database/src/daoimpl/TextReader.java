package daoimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.OperatoerDTO;
import dto.ProduktBatchDTO;
import dto.ProduktBatchKompDTO;

public class TextReader {
	
	private File sqlFileCommands;
	private String[] sqlCommands;
	private String illegalString;
	
	public TextReader() throws FileNotFoundException{
		sqlFileCommands = new File("files/sqlCommands.txt");
		sqlCommands = readFile(sqlFileCommands);
		illegalString = "#";
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
		output = output.replaceFirst(illegalString + "1", Integer.toString(oprID));
		return output;
	}
	
	public String createOperatoer(OperatoerDTO opr){
		String output = sqlCommands[1];
		output = output.replaceFirst(illegalString + "1", Integer.toString(opr.getOprId()));
		output = output.replaceFirst(illegalString + "2", opr.getOprNavn());
		output = output.replaceFirst(illegalString + "3", opr.getIni());
		output = output.replaceFirst(illegalString + "4", opr.getCpr());
		output = output.replaceFirst(illegalString + "5", opr.getPassword());
		return output;
	}
	
	public String updateOperatoer(OperatoerDTO opr){
		String output = sqlCommands[2];
		output = output.replaceFirst(illegalString + "1", opr.getOprNavn());
		output = output.replaceFirst(illegalString + "2", opr.getIni());
		output = output.replaceFirst(illegalString + "3", opr.getCpr());
		output = output.replaceFirst(illegalString + "4", opr.getPassword());
		output = output.replaceFirst(illegalString + "5", Integer.toString(opr.getOprId()));
		return output;
	}
	
	public String getProductBatch(int pbID){
		String output = sqlCommands[5];
		output = output.replaceFirst(illegalString + "1", Integer.toString(pbID));
		return output;
	}
	
	public String createProductBatch(ProduktBatchDTO produktbatch){
		String output = sqlCommands[7];
		output = output.replaceFirst(illegalString + "1", Integer.toString(produktbatch.getPbId()));
		output = output.replaceFirst(illegalString + "2", Integer.toString(produktbatch.getStatus()));
		output = output.replaceFirst(illegalString + "3", Integer.toString(produktbatch.getReceptId()));
		return output;
	}
	
	public String updateProduktBatch(ProduktBatchDTO produktbatch){
		String output = sqlCommands[8];
		output = output.replaceFirst(illegalString + "1", Integer.toString(produktbatch.getStatus()));
		output = output.replaceFirst(illegalString + "2", Integer.toString(produktbatch.getReceptId()));
		output = output.replaceFirst(illegalString + "3", Integer.toString(produktbatch.getPbId()));
		return output;
	}
	
	public String getProduktBatchKomp(int pbId, int rbId){
		String output = sqlCommands[9];
		output = output.replaceFirst(illegalString + "1", Integer.toString(pbId));
		output = output.replaceFirst(illegalString + "2", Integer.toString(rbId));
		return output;
		}
	
	public String getProduktBatchKompList(int pbId){
		String output = sqlCommands[10];
		output = output.replaceFirst(illegalString + "1", Integer.toString(pbId));
		return output;
	}
	
	public String createProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent){
		String output = sqlCommands[12];
		output = output.replaceFirst(illegalString + "1", Integer.toString(produktbatchkomponent.getPbId()));
		output = output.replaceFirst(illegalString + "2", Integer.toString(produktbatchkomponent.getRbId()));
		output = output.replaceFirst(illegalString + "3", Double.toString(produktbatchkomponent.getTara()));
		output = output.replaceFirst(illegalString + "4", Double.toString(produktbatchkomponent.getNetto()));
		output = output.replaceFirst(illegalString + "5", Integer.toString(produktbatchkomponent.getOprId()));
		return output;
	}
	
	public String updateProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent){
		String output = sqlCommands[13];
		output = output.replaceFirst(illegalString + "1", Double.toString(produktbatchkomponent.getTara()));
		output = output.replaceFirst(illegalString + "2", Double.toString(produktbatchkomponent.getNetto()));
		output = output.replaceFirst(illegalString + "3", Integer.toString(produktbatchkomponent.getOprId()));
		output = output.replaceFirst(illegalString + "4", Integer.toString(produktbatchkomponent.getPbId()));
		output = output.replaceFirst(illegalString + "5", Integer.toString(produktbatchkomponent.getRbId()));
		return output;
	}

}
