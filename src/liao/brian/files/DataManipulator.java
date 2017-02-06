package liao.brian.files;

/**
 * @author btl78
 *
 */
public interface DataManipulator {
	
	public void encode(String inFileName, String outFileName);
	
	public void decode(String outFileName, String inFileName);
	
}
