//package macropassone;

import java.io.*;


public class Main {
	static BufferedWriter writer;
	static BufferedReader reader;
	static PassOne macroPassOne = new PassOne();
	static MacroOutput macroOutput = new MacroOutput();
	public static void main(String []args) throws IOException{
		reader = new BufferedReader(new FileReader("input.asm"));
		macroOutput =  macroPassOne.getOutPut(reader);
		
		writer = new BufferedWriter(new FileWriter("IC.txt"));
		writer.write(macroOutput.getIC());
		System.out.println("IC:\n"+macroOutput.getIC());
		writer.close();
	
	
		writer = new BufferedWriter(new FileWriter("MNT.txt"));
		writer.write(macroOutput.getMNT());
		System.out.println("MNT:\n"+macroOutput.getMNT());
		writer.close();
	
		writer = new BufferedWriter(new FileWriter("MDT.txt"));
		writer.write(macroOutput.getMDT());
		System.out.println("MDT:\n"+macroOutput.getMDT());
		writer.close();
		
		writer = new BufferedWriter(new FileWriter("KPDTAB.txt"));
		writer.write(macroOutput.getKPDTAB());
		System.out.println("KPDTAB:\n"+macroOutput.getKPDTAB());
		writer.close();
	
		writer = new BufferedWriter(new FileWriter("PNTAB.txt"));
		writer.write(macroOutput.getPNTAB());
		System.out.println("PNTAB:\n"+macroOutput.getPNTAB());
		writer.close();
	
	
	}
}
