/**
 * 
 */
package com.umes.olimpiadas.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author elioth010
 *
 */
public class ReadingFiles {

	public static String PATH_FILES = "/home/elioth010/pruebafiles/";

	/**
	 * 
	 */
	public ReadingFiles() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//File folder = new File(PATH_FILES);
		File folder = new File(ReadingFiles.class.getProtectionDomain().getCodeSource().getLocation().getFile());
		if (folder.exists()) {
			folder.mkdirs();
		}
		
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Escriba el nombre del archivo de entrada: ");
		String nombre = inputScanner.nextLine();
		inputScanner.close();
		File file = new File(folder.getAbsoluteFile() + "/" +nombre);
		if (!file.exists()) {
			System.out.println("Archivo no existe se crea nuevo archivo: "+nombre);
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
				return;
			}
		}

		ReadingFiles reader = new ReadingFiles();
		StringBuffer br = new StringBuffer();
		br.append("Line 1 \n");
		br.append("Line 2 \n");
		br.append("Line 3 \n");
		br.append("Line 4 \n");
		br.append("Line 5 \n");
		// reader.writeFiles(br, file, false);
		// reader.fileOutputWriter(br, file, false);
		reader.writeFiles(br, file, false);
		reader.fileWriter(br, file, false);
		reader.fileOutputWriter(br, file, false);
		
		reader.readBufferFiles(file);
		reader.readFileInputStrem(file);
		reader.readFileReader(file);
		reader.readStremFiles(file);
	}

	public void writeFiles(StringBuffer br, File file, Boolean appendInFile) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath(), appendInFile))) {
			bw.write(br.toString());
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} 
		/*
		 * finally { 
		 * 	cleanupFile(bw); 
		 * 	//TODO se puede omitir ya que al declarar el try como esta arriba automaticamente el llama al finally haciendo un bw.close() al archivo 
		 * }
		 */

	}

	public void fileOutputWriter(StringBuffer br, File file, Boolean appendInFile) {
		try (FileOutputStream fos = new FileOutputStream(file.getAbsolutePath(), appendInFile)) {
			fos.write(br.toString().getBytes());
		} catch (FileNotFoundException e) {
			// Manejado en el main
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileWriter(StringBuffer br, File file, Boolean appendInFile) {
		try (FileWriter fw = new FileWriter(file, appendInFile)) {
			fw.write(br.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doStuffs(String readLine) {
		System.out.println("Doing Stuffs with: " + readLine);
	}

	public void readBufferFiles(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
			String readLine;
			while (null != (readLine = br.readLine())) {
				doStuffs(readLine);
			}
		} catch (FileNotFoundException e) {
			// Manejado en el main
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFileReader(File file){
		System.out.println("Usando FileReader");
		try (FileReader fr = new FileReader(file)) {
			int r;
			while ((r = fr.read()) != -1) {
				System.out.print((char) r);
			}
		} catch (FileNotFoundException e) {
			// Manejado en el main
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFileInputStrem(File file) {
		System.out.println("File Input Stream");
		try (FileInputStream fis = new FileInputStream(file.getAbsoluteFile())) {
			System.out.println("Total file size to read (in bytes) : " + fis.available());
			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				System.out.print((char) content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void readStremFiles(File file) {
		try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
			stream.forEach(element -> System.out.println("lambda printing: "+ element));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * private void cleanupFile(Closeable bw){ if(null != bw){ try { bw.close();
	 * } catch (IOException e) { e.printStackTrace(); } } }
	 */

}
