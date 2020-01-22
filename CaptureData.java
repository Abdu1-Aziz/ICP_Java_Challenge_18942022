import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Files;
import java. util. ArrayList;




public class CaptureData{
	public CaptureData(){

	}

	public static void getStock(String item, int quantity, int price){
		PrintWriter printWriter = null;
		//PrintWriter printWritten = null;
    		
    	try {
    		//Note that we are able to append to the file because of the "true" parameter
    		printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));
    		//printWritten = new PrintWriter(new FileOutputStream("essentials_stock_backup.txt", true));
    	}catch(FileNotFoundException fnfe) {
    		fnfe.getMessage();
    	}
    		
  			printWriter.printf("%s %d GHC %d",item, quantity, price);
  			printWriter.println();

  			//printWritten.printf("%s %d GHC %d", item, quantity, price);
  			//printWritten.println();

  			
  		    
  		  
  		  
  		    //Close Writer
  		    printWriter.close();
  		    //printWritten.close();
	}




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

    public static void displayContent(String filename)throws IOException{
    	List<String> lines = Files.readAllLines(Paths.get(filename));
    	for (int i =0; i<lines.size(); i++){
    		System.out.println(lines.get(i));
    	}
    	
    }




	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("how many stock are we entering today?: ");
		int number = input.nextInt();

		for (int i = 0; i<number; i++){
			Scanner input1 = new Scanner(System.in);
			System.out.print("Enter item name: ");
			String item = input1.nextLine();

			Scanner input2 = new Scanner(System.in);
			System.out.print("Enter quantity: ");
			int quantity = input2.nextInt();

			Scanner input3 = new Scanner(System.in);
			System.out.print("Enter item price: ");
			int price = input3.nextInt();
			getStock(item, quantity, price);
		}
		try {
			createBackup("essentials_stock.txt");
		}catch(IOException e){
			e.printStackTrace();
		}
		try {
			displayContent("essentials_stock.txt");
		}catch(IOException e){
			e.printStackTrace();
		}
				
	}

}