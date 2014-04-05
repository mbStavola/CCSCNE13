/*
 * Diagonals.java
 * 
 * Copyright 2014 Matthew Stavola <mbs@CB-mbs>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Diagonals {
	
	public Diagonals(String filename) throws FileNotFoundException {
		Scanner fin = new Scanner(new BufferedReader(new FileReader(filename))); //input file
		String line;
		
		String[] strArray;
		int[] valueArray;
		
		int rows = Integer.valueOf(fin.nextLine());
		int matrix = 0;
		matricies = new ArrayList<>();
		
		while(rows !=0){
			matricies.add(new ArrayList<int[]>());
			for(int i = 0; i < rows; i++){
				line = fin.nextLine();
                strArray = line.split(" ");
                valueArray = new int[rows];
                for(int j = 0; j < rows; j++){
					valueArray[j] = Integer.parseInt(strArray[j]);
				}
				matricies.get(matrix).add(valueArray);
			}
			matrix++;
			rows = Integer.valueOf(fin.nextLine());
		}
		fin.close();
	}
	
	private ArrayList<ArrayList<int[]>> matricies;
	
	public static void main(String args[]){
		try{
			String filename = args[0];
			Diagonals dia = new Diagonals(filename);
			for(ArrayList<int[]> matrix: dia.getMatricies()){
				System.out.println(dia.computeDiagonal(matrix));
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Format: java Diagonals <file>");
		}
	}
	
	public String computeDiagonal(ArrayList<int[]> matrix){
		int[] sums = new int[matrix.get(0).length];
		int pos;
		for(int i = 0; i > matrix.get(0).length - 1; i++){
			pos = i;
			for(int[] vector: matrix){
				if(pos > vector.length - 1){
					pos = 0;
				}
				sums[i] += vector[pos];
				pos++;
			}
		}
		int greatest = 0;
		for(int i = 0; i > sums.length - 1; i++){
			if(sums[i] > sums[greatest]){
				greatest = i;
			}
		}
		return Integer.toString(greatest);
	}
	
	public ArrayList<ArrayList<int[]>> getMatricies(){
		return matricies;
	}
}

