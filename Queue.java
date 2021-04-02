import java.util.InputMismatchException;
import java.util.Scanner;

public class Queue {
	public static int[] queue= new int[6];
	public static int max = queue.length;
	public static int rear= 0;
	
	//isi sebagai pembatas ketika data telah mencapai batas
	public static boolean isi() {
		if(rear < max) {
			return true;
		}else {
			return false;
		}
	}

		//--------------------------------------------------------------
	public static void enQueue() { // memasukkan data di bagian paling belakang dari antrian
		int j = -1;
		int loopX = 0;
		while(loopX == 0) {
			System.out.print("Masukkan Data (angka): ");
			Scanner inp = new Scanner(System.in);
		try {
		    j = inp.nextInt();
		    loopX = 1;
        }

		catch(InputMismatchException e) {
			System.out.println("Maaf Input Harus Berupa Angka");
			loopX = 0;
		}
		}
		
		queue[rear] = j; // masukkan data
		rear++; // increment rear
	}
		//--------------------------------------------------------------
	public static void deQueue() { // ambil data di bagian depan dari queue
		System.out.println("Mengeluarkan Data Paling Atas : | "+queue[0]+" |");
		for(int i=0; i<rear; i++) {
			queue[i]=queue[i+1];
			rear--;
			
		}
	}
		//--------------------------------------------------------------
	public static void peek() { // melihat data di bagian paling depan dari queue
		System.out.println("Menampilkan Data Paling Atas : | "+ queue[0]+" |");
	}
	//--------------------------------------------------------------
	//Menampilkan Isi Keseluruhan
	private static void displayFull() {
		int n= rear-1;
		if(n < 0){
			System.out.println("Data Stack tidak ada" );
		}else{
			System.out.println("Data dalam Stack: " );
			System.out.println("  | |  " );
			System.out.println(" |. .| " );
			System.out.println("|     |" );
			System.out.println(" | "+ queue[0]+" | => TUmpukan paLIng ataS" );
			for(int i = 1; i < rear; i++) {
				System.out.println(" | "+queue[i]+" |" );
			}
				System.out.println("");
			}
		}
		//--------------------------------------------------------------
	public static void clear() {
		while(isi()== false) // hapus data sampai kosong
			deQueue();
	}
	
	//--------------------------------------------------------------
	private static void quit() {
		String quitss = "y";
		System.out.print("Keluar dari Program? (Y/T): ");
		quitss = new Scanner(System.in).nextLine();
		if(quitss.equalsIgnoreCase("y")) {
			System.exit(0);
		}
		else {
			menuProgram();
		}
	}
	
	public static void menuChooser(int choosenMenu) {
		switch(choosenMenu) {
			case 1:
				boolean check = isi();
				if(check) {
					enQueue();
				}
				else {
					System.out.println("Stack Telah Penuh, mohon kosongkan satu data atau reset stack terlebih dahulu");
				}
				break;
			case 2:
				deQueue();
				break;
			case 3:
				peek();
				break;
			case 4:
				displayFull();
				break;
			case 5:
				clear();
				break;
			case 6:
				quit();
				break;
		}
		menuProgram();
	}
	
	private static void menuProgram() {
		int loopX = 0;
		int choosenMenu = 0;
		while(loopX == 0) {
			System.out.println("\nContoh Program QUEUEyey dengan Java");
			System.out.println("Menu: ");
			System.out.println("1. Tambah Data");
			System.out.println("2. Ambil Data");
			System.out.println("3. lihat Data Paling Atas");
			System.out.println("4. Lihat Semua Isi Data Stack");
			System.out.println("5. Buat Stack Baru (Clear Data)");
			System.out.println("6. Keluar dari Program");
			System.out.print("Pilihan Anda : ");
			Scanner menuOption = new Scanner(System.in);
			try {
				choosenMenu = menuOption.nextInt();
				loopX = 1;
			}catch(InputMismatchException e) {
				System.out.println("Masukan harus Angka");
			}
		}
		System.out.println("");
		menuChooser(choosenMenu);
	}

	public static void main(String[] args) {
		menuProgram();
	}
	
}
