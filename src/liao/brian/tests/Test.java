package liao.brian.tests;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

import edu.princeton.cs.introcs.BinaryIn;
import uw.io.BitInputStream;
import uw.io.BitOutputStream;

public class Test implements Runnable {

	public void run() {
		try {
			BinaryIn in = new BinaryIn("Hamlet.txt");
			while (!in.isEmpty()) {
				System.out.println(in.readInt(2));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.run();
	}
}
