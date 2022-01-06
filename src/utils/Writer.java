package utils;
/** Writer.java
*
* Class that contains a string list to be written in a log file.
*
* @author: Tanja
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
	private ArrayList<String> list;
	
	/** Instantiates the writer class.
	 *
	 */
	public Writer() {
		list = new ArrayList<String>();
	}

	/** Accepts a string to add to the string list in the writer class.
	 *
	 * @param: a line string to write into the log
	 */
	public void add(String line) {
		list.add(line);
	}
	
	/** Writes the string list into a log file.
	 *
	 * @param: a string filename
	 */
	public void writeFile(String filename) {
		try{
       	FileWriter fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);
		
			for(int i = 0; i < list.size(); i++) {
				bw.write(list.get(i));
				bw.newLine();
				bw.flush();
			}

			bw.close();
       } catch (IOException e) {
       	System.out.println("Writing failed");
       }
		
	}
}

