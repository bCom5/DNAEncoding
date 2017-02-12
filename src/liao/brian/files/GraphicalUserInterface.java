/**
 * 
 */
package liao.brian.files;

import javax.swing.JOptionPane;

/**
 * @author btl78
 *
 */
public class GraphicalUserInterface implements Runnable {
	
	public void run() {
		DataManipulatorText manipulator = new DataManipulatorText();
		String operation = JOptionPane.showInputDialog("Would you like to encode or decode a file?");
		if (!operation.equals("encode") && !operation.equals("decode")) {
			JOptionPane.showMessageDialog(null, "Please state \"encode\" or \"decode\" as your answer.");
		}
		String inFileName = JOptionPane.showInputDialog("Enter the input file name.");
		String outFileName = JOptionPane.showInputDialog("Enter the output file name.");
		if (operation.equals("encode")) {
			manipulator.encode(inFileName, outFileName);
		} else if (operation.equals("decode")) {
			manipulator.decode(inFileName, outFileName);
		}
		JOptionPane.showMessageDialog(null, "Operation was successful!");
	}
	
	public static void main(String[] args) {
		GraphicalUserInterface gui = new GraphicalUserInterface();
		gui.run();		
	}
}