package liao.brian.files;

import java.util.Scanner;

/**
 * @author btl78
 *
 */
public class UserInterfaceText implements UserInterface, Runnable  {
	private Scanner sc;
	private DataManipulatorText manipulator;

	public UserInterfaceText() {
		sc = new Scanner(System.in);
		manipulator = new DataManipulatorText();
	}

	public void run() {
		System.out.println("Would you like to encode or decode a file?");
		String operation = sc.nextLine();
		if (!operation.equals("encode") && !operation.equals("decode")) {
			throw new IllegalArgumentException("Please state \"encode\" or \"decode\" as your answer.");
		}
		System.out.println("Enter the input file name.");
		String inFileName = sc.nextLine();
		System.out.println("Enter the output file name.");
		String outFileName = sc.nextLine();
		if (operation.equals("encode")) {
			manipulator.encode(inFileName, outFileName);
		} else if (operation.equals("decode")) {
			manipulator.decode(inFileName, outFileName);
		}
		System.out.println("Operation was successful.");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserInterfaceText ui = new UserInterfaceText();
		ui.run();
	}

}
