package liao.brian.files;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import uw.io.BitInputStream;
import uw.io.BitOutputStream;

public class DataManipulatorText implements DataManipulator {

	@Override
	public void encode(String inFileName, String outFileName) {
		PrintWriter writer = null;
		try {
			BitInputStream in = new BitInputStream(inFileName);
			writer = new PrintWriter(outFileName, "UTF-8");
			int a = -1;
			int b = -1;
			while ((a = in.readBit()) != -1 && (b = in.readBit()) != -1) {
				int bits = 10 * a + b;
				if (bits == 0) {
					writer.write("A");
				} else if (bits == 1) {
					writer.write("C");
				} else if (bits == 10) {
					writer.write("G");
				} else if (bits == 11) {
					writer.write("T");
				} else {
					throw new IllegalStateException("Missing a bit? Bits recieved:" + bits);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

	@Override
	public void decode(String inFileName, String outFileName) {
		Scanner fileScanner = null;
		try {
			BitOutputStream out = new BitOutputStream(new PrintStream(outFileName), false);
			fileScanner = new Scanner((new File(inFileName)));
			String line = fileScanner.nextLine();
			for (Character c : line.toCharArray()) {
				if (c.equals('A')) {
					out.writeBit(0);
					out.writeBit(0);
				} else if (c.equals('C')) {
					out.writeBit(0);
					out.writeBit(1);
				} else if (c.equals('G')) {
					out.writeBit(1);
					out.writeBit(0);
				} else if (c.equals('T')) {
					out.writeBit(1);
					out.writeBit(1);
				} else {
					throw new IllegalStateException("Incorrect character: use only 'A', 'C', 'G', or 'T.'");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fileScanner.close();
		}
	}
}
