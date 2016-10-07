/**
 * 
 */
package com.umes.olimpiadas.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author elioth010 created: Oct 7, 2016 
 * Using Eclipse IDE with Spring Framework
 *
 */
public class ArraysAndVectors {

	/**
	 * 
	 */
	public ArraysAndVectors() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArraysAndVectors arraysAndVectors = new ArraysAndVectors();
		arraysAndVectors.createMapStringsAndFetch();
		arraysAndVectors.createMultiDimentionalMapAndFetch();
		arraysAndVectors.staticMatrixStings();
	}
	
	public void createMapStringsAndFetch(){
		Map<String, String>map = new HashMap<>();
		map.put("Key1", "Val1");
		map.put("Key2", "Val2");
		map.put("Key3", "Val3");
		map.put("Key4", "Val4");
		map.put("Key5", "Val5");
		
		//Print values
		System.out.println(map.get("Key1"));
		System.out.println(map.get("Key2"));
		System.out.println(map.get("Key3"));
		System.out.println(map.get("Key4"));
		System.out.println(map.get("Key5"));
		//Obtener las claves
		List<String> keys = new ArrayList<>(map.keySet());
		//Ordernar alfabeticamente 
		Collections.sort(keys, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		//Imprimir valor y clave
		for(String key : keys){
			System.out.println("ket: "+key + " value: " +map.get(key));
		}
		
		for ( Map.Entry<String, String> entry : map.entrySet()) {
		    String key = entry.getKey();
		    String val = entry.getValue();
		    System.out.println("ket: "+key + " value: " +val);
		}
		
	}
	
	public void createMultiDimentionalMapAndFetch(){
		Map<String, List<String>> multidimenMap = new HashMap<>();
		List<String> lista1 = new ArrayList<>();
		lista1.add("Valor 1 K1");
		lista1.add("Valor 2 K1");
		lista1.add("Valor 3 K1");
		lista1.add("Valor 4 K1");
		multidimenMap.put("Key1", lista1);
		
		List<String> lista2 = new ArrayList<>();
		lista2.add("Valor 1 K2");
		lista2.add("Valor 2 K2");
		lista2.add("Valor 3 K2");
		lista2.add("Valor 4 K2");
		multidimenMap.put("Key2", lista2);
		
		List<String> lista3 = new ArrayList<>();
		lista3.add("Valor 1 K3");
		lista3.add("Valor 2 K3");
		lista3.add("Valor 3 K3");
		lista3.add("Valor 4 K3");
		multidimenMap.put("Key3", lista3);
		
		//Obtener las claves
		List<String> keys = new ArrayList<>(multidimenMap.keySet());
		//Ordernar alfabeticamente 
		Collections.sort(keys, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		//Imprimir valor y clave
		for(String key : keys){
			System.out.println("key: "+key + " values:");
			System.out.println("[");
			for(String val : multidimenMap.get(key)){
				System.out.println(val);
			}
			System.out.println("]");
		}
		
		for ( Map.Entry<String, List<String>> entry : multidimenMap.entrySet()) {
		    String key = entry.getKey();
		    List<String> val = entry.getValue();
		    System.out.println("ket: "+key + " value: " +val.toString());
		}
	}
	
	public void staticMatrixStings(){
		String [][] string = new String[4][8];
		for(int i = 0; i<string.length ; i++){
			for(int j = 0; j<string[i].length; j++){
				string[i][j] = getRandomString();
			}
		}
		System.out.println("-----------------");
		for(int i = 0; i<string.length ; i++){
			System.out.print("|");
			for(int j = 0; j<string[i].length; j++){
				System.out.print(string[i][j]+ "|");
			}
			System.out.println();
			System.out.println("-----------------");
		}
	}
	
	protected String getRandomString() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while (random.length() < 1) {
            int index = (int) (rnd.nextFloat() * CHARS.length());
            random.append(CHARS.charAt(index));
        }
        String str = random.toString();
        return str;

    }


}
