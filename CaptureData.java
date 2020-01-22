import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;




public class CaptureData{
	public CaptureData(){

	}

	public static void getStock(String item, int quantity, int price){
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
	}

}