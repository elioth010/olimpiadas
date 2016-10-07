/**
 * 
 */
package com.umes.olimpiadas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javafx.collections.ArrayChangeListener;

/**
 * @author elioth010 created: Oct 7, 2016 
 * Using Eclipse IDE with Spring Framework
 *
 */
public class UniversoParalelo {
	
	private List<String> universeElements;
	private List<String> opuestos;
	private List<String> combinados;
	private String pivote = "F";
	private String combinado = "T";


	/**
	 * 
	 */
	public UniversoParalelo() {
		//{"Q", "W", "E", "R", "A", "S", "D", "F"}
		universeElements = new ArrayList<String>();
		universeElements.add("Q");
		universeElements.add("W");
		universeElements.add("E");
		universeElements.add("R");
		universeElements.add("A");
		universeElements.add("S");
		universeElements.add("D");
		universeElements.add("F");
		// TODO Auto-generated constructor stub
		opuestos = new ArrayList<String>();
		
		combinados = new ArrayList<String>();
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniversoParalelo up = new UniversoParalelo();
		File archivoDatos = up.getInputFile();
		System.out.println(up.getElementPosition("E"));
	}
	
	public void readFile(File file){
		try(BufferedReader br = new BufferedReader(new FileReader(file.getAbsoluteFile()))){
			String line;
			while(null!=(line = br.readLine())){
				leerElementos(line);
			}
		} catch (FileNotFoundException e) {
			//ya manejado
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> removeElements(List<String>source, Integer starts, Integer ends){
		List<String> copy = new ArrayList<String>();
		Collections.copy(copy, source);
		for(int i = starts; i<source.size() && i<ends; i++){
			copy.remove(source.get(i));
		}
		return copy;
	}
	
	public void writeFile(StringBuffer bf, File path){
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path.getAbsoluteFile()))){
			bw.write(bf.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void leerElementos(String line){
		
	}
	
	public File getInputFile(){
		File folder = new File(UniversoParalelo.class.getProtectionDomain().getCodeSource().getLocation().getFile());
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escriba el nombre del archivo de entrada con su extesion txt: ");
		String nombre = scanner.nextLine();
		scanner.close();
		File file = new File(folder.getAbsoluteFile()+"/"+nombre);
		if(!file.exists()){
			try {
				file.createNewFile();
				System.out.println("Archivo no existe, se creo el nuevo archivo, coloque los datos de entrada \n y corra de nuevo el programa.");
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	public int getElementPosition(String element){
		return universeElements.indexOf(element);
	}

}
