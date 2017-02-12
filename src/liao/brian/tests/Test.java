package liao.brian.tests;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

import uw.io.BitInputStream;
import uw.io.BitOutputStream;

public class Test implements Runnable {

	public void run() {
		try {
			BitInputStream in = new BitInputStream("Video.mp4");
			BitOutputStream out = new BitOutputStream(new PrintStream("VideoOut.mp4"), false);
			int bit;
			while ((bit = in.readBit()) != -1) {
				out.writeBit(bit);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.run();
	}
}
