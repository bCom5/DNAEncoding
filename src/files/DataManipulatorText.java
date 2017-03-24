package files;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import edu.princeton.cs.introcs.BinaryIn;
import edu.princeton.cs.introcs.BinaryOut;

public class DataManipulatorText implements DataManipulator {

	@Override
	public void encode(String inFileName, String outFileName) {
		PrintWriter writer = null;
		try {
			BinaryIn in = new BinaryIn(inFileName);
			writer = new PrintWriter(outFileName, "UTF-8");
			
			while (!in.isEmpty()) {
				int bits = in.readInt(2);
				if (bits == 0) {
					writer.write("T");
				} else if (bits == 1) {
					writer.write("C");
				} else if (bits == 2) {
					writer.write("A");
				} else if (bits == 3) {
					writer.write("G");
				} else {
					throw new IllegalStateException("Missing a bit? Bits recieved:" + bits);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

	@Override
	public void decode(String inFileName, String outFileName) {
		Scanner fileScanner = null;
		try {
			BinaryOut out = new BinaryOut(outFileName);
			fileScanner = new Scanner((new File(inFileName)));
			String line = fileScanner.nextLine();
			for (Character c : line.toCharArray()) {
				if (c.equals('T')) {
					out.write(false);
					out.write(false);
				} else if (c.equals('C')) {
					out.write(false);
					out.write(true);
				} else if (c.equals('A')) {
					out.write(true);
					out.write(false);
				} else if (c.equals('G')) {
					out.write(true);
					out.write(true);
				} else {
					throw new IllegalStateException("Incorrect character: use only 'A', 'C', 'G', or 'T.'");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fileScanner.close();
		}
	}
}
