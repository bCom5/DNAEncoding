package files;

public interface DataManipulator {
	
	public void encode(String inFileName, String outFileName);
	
	public void decode(String outFileName, String inFileName);
	
}
