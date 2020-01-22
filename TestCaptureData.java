import java.util.Scanner;
import java.io.IOException;


public class TestCaptureData{

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main (String[] args){

		// Creating an instance of the CaptureData class
		CaptureData myStock = new CaptureData();

		/** Accepting inputs from the user and inserting it to the 
		*	getStock method
		*/
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
			myStock.getStock(item, quantity, price);
		}
		try {
			//Creating the backup file
			myStock.createBackup("essentials_stock.txt");
		}catch(IOException e){
			e.printStackTrace();
		}
		try {
			//Displaying the content of 
			myStock.displayContent("essentials_stock.txt");
		}catch(IOException e){
			e.printStackTrace();
		}
				
	}
}