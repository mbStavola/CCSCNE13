/*
 * untitled.java
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

public class DiamondNumbers {
	
	public static void main (String args[]) {
		try{
			DiamondNumbers dn = new DiamondNumbers();
			System.out.println(dn.calculateDiamondSize(Integer.valueOf(args[0])));
		}
		catch(Exception e){
			System.out.println("Format: java DiamondNumbers <positive integer>");
		}
	}
	
	public String calculateDiamondSize(int generation){
		if(generation <= 0){
			return "Number must be greater than 0";
		}
		int sum = 0;
		int diamondRow = generation + (generation - 1); //Gets the middle diamond row
		
		sum += diamondRow;
		diamondRow -=2; //Size of the middle+1 and middle-1 rows
		
		while(diamondRow > 0){
			sum += 2 * diamondRow; //Adds the current row to the sum twice since it's symmetric
			diamondRow -= 2;
		}
		return Integer.toString(sum);
	}
}

