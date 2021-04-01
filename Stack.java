/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.struktur.data;
    import java.util.InputMismatchException;
    import java.util.Scanner;  

/**
 *
 * @author Asus
 */
    public class TugasStrukturDataStack {
     /**
     * @param args the command line arguments
     */
    // TODO code application logic here

    //Mengatur Stack maksimal ke 10
 	private static int[] stack = new int[10];
	private static int counters = 0;
	private static boolean storage() {
        if(counters < stack.length) {
        return true;
        }
        else {
        return false;
        }
	}

    // Menambah Data
	private static void create() {
        int loopX = 0;
        int alpha = 0;
        while(loopX == 0) {
    		System.out.print("Masukkan Data (angka): ");
	    	Scanner alphaX = new Scanner(System.in);
		try {
		    alpha = alphaX.nextInt();
		    loopX = 1;
            }

		catch(InputMismatchException e) {
		System.out.println("Maaf Input Harus Berupa Angka");
		loopX = 0;
		}
            }
            stack[counters] = alpha;
            counters++;
            }
	
    //Mengambil Data
	private static void removeStack() {
        	int n=counters-1;
		if (n < 0) {
			System.out.println("Data Stack tidak ada" );
		} else {
			System.out.println("Mengeluarkan Data Paling Atas : | "+stack[n]+" |");
			counters--; 
			System.out.println("Data paling atas dalam stack sudah dikeluarkan");
		}

	}
	
    //Menampilkan Data Paling Atas
    private static void showUp() {
    	int n=counters-1;
    	if(n < 0){
		System.out.println("Data Stack tidak ada" );
	}else{
		System.out.println("Menampilkan Data Paling Atas : | "+stack[n]+" |");
	}
    }

    //Menampilkan Isi Keseluruhan
	private static void displayFull() {
                int n=counters-1;
                int m=counters-2;
		if(n < 0){
			System.out.println("Data Stack tidak ada" );
		}else{
			System.out.println("Data dalam Stack: " );
			System.out.println("| "+stack[n]+" | => Data Pertama" );
			for(int i = m; i > -1; i--) {
				System.out.println("| "+stack[i]+" |" );
			}
			System.out.println("");
		}
	}
	
    //Menghapus Isi Stack
	private static void cleanSkuy() {
		counters = 0;
	}
	
    //keluar Program
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
	
	private static void menuChooser(int choosenMenu) {
		switch(choosenMenu) {
			case 1:
				boolean check = storage();
				if(check) {
					create();
				}
				else {
					System.out.println("Stack Telah Penuh, mohon kosongkan satu data atau reset stack terlebih dahulu");
				}
				break;
			case 2:
				removeStack();
				break;
			case 3:
				showUp();
				break;
			case 4:
				displayFull();
				break;
			case 5:
				cleanSkuy();
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
			System.out.println("\nContoh Program Stack dengan Java");
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
