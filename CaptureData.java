import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Files;
import java. util. ArrayList;

/**
 * @author Abdul-Aziz Fuseini 
 *
 */

public class CaptureData{

	/**
	 * Constructor
	 */
	public CaptureData(){

	}

	public static void getStock(String item, int quantity, int price){
		/**
	 	* Writing Text/String to File using PrintWriter and FileOutputStream
	 	* Checks for "FileNotFoundException" in the connection to the file
	 	*/
		PrintWriter printWriter = null;
		    		
    	try {
    		//Note that we are able to append to the file because of the "true" parameter
    		printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));
    		
    	}catch(FileNotFoundException fnfe) {
    		fnfe.getMessage();
    	}
    		
  			printWriter.printf("%s %d GHC %d",item, quantity, price);
  			printWriter.println();
  			
  		    
  		  
  		    //Close Writer
  		    printWriter.close();
	}



	//method to create a backup file for the text file created
	public static void createBackup(String filename)
                        throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(filename));
        //File originalFile = new File(filename);     
        File backupFile = new File("backup_" + filename);

        //originalFile.renameTo(backupFile);
        PrintWriter output = new PrintWriter(backupFile);
        for(String fileData : lines){
            output.println(fileData);
        }
        output.close();
    }
    //method to print out the content of the text file keeping the records
    public static void displayContent(String filename)throws IOException{
    	List<String> lines = Files.readAllLines(Paths.get(filename));
    	System.out.println("The current stock at Essentials enterprise are: ");
    	for (int i =0; i<lines.size(); i++){
    		System.out.println(lines.get(i));
    	}
    	
    }
}