import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class KD1 {
	
	static String os = System.getProperty("os.name") + " " + System.getProperty("os.arch") + " " + System.getProperty("os.version");
	static String jv = System.getProperty("java.vendor") + " " + System.getProperty("java.version");
	
	public static String GetOSType() {
		if (System.getProperty("os.name").contains("Windows")) {
			return "windows";
		}
		if (System.getProperty("os.name").contains("Linux")) {
			return "linux";
		} else {
			return "unknown/other";
		}
	}
	
	static String osType = GetOSType();	// Dabūnam OS tipu, un tas tiek piešķirts statiskam mainīgajam, lai nav jāizsauc funkcija vairākkārt
	
	public static void PrintLogo() {
		if (osType == "linux") {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("--Noteiktā integrāļa aptuvenās vērtības aprēķināšana ar taisnstūra metodi--");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Operētājsistēma: " + os);
			System.out.println("Java versija: " + jv);
		} else {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("--Noteikta integrala aptuvenas vertibas aprekinasana ar taisnstura metodi--");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Operetajsistema: " + os);
			System.out.println("Java versija: " + jv);
		}
	}

	public static void main(String[] args) throws IOException {
		PrintLogo();
		int k = 0;						// Iterācijas numurs pēc kārtas
		int n = 2;						// intervālu skaits
		int funNum = 1;					// izmantotās funkcijas skaitlis
		double a, b;					// argumentu intervāls
		double i1 = 0;					// iepriekšējais integrālis
		double i2;						// tekošais integrālis
		double w;						// intervāla platums
		double eps, defeps = 0.01;		// precizitāte
		
		InputStreamReader iStream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(iStream);
		String input = "";
		
		try {
			do {
				if (osType == "linux") {
					System.out.println("\nSākuma un beigu vērtībām jābūt atšķirīgām!");
					System.out.println("Ievadiet sākuma vērtību:");
				} else {
					System.out.println("\nSakuma un beigu vertibam jabut atskirigam!");
					System.out.println("Ievadiet sakuma vertibu:");
				}
				
				input = reader.readLine();
				a = Double.parseDouble(input);
				if (osType == "linux") {
					System.out.println("Ievadiet beigu vērtību:");
				} else {
					System.out.println("Ievadiet beigu vertibu:");
				}
				
				input = reader.readLine();
				b = Double.parseDouble(input);
				if (osType == "linux") {
					System.out.println("Ievadiet precizitāti (vismaz 0.01):");
				} else {
					System.out.println("Ievadiet precizitati (vismaz 0.01):");
				}
				
				input = reader.readLine();
				eps = Double.parseDouble(input);
				if (eps > 0.01 || eps == 0) {		// jāpārbauda arī vai ir nulle, jo uz nulles uzkārās programma.
					eps = defeps;
					if (osType == "linux") {
						System.out.println("Izmantojam noklusēto precizitāti: " + eps + "\n");
					} else {
						System.out.println("Izmantojam nokluseto precizitāti: " + eps + "\n");
					}
					
				}
			} while ((a == b));						// Datu ievade tiek prasīta kamēr a un b ir vienādi.
		} finally {
			//reader.close();
		}
		
		String htmlfile = "index.html";	// Fails uz kura tiek ierakstīts rezultāts
		File myfile = new File((System.getProperty("user.dir") ) + File.separator + htmlfile);
		FileWriter data = new FileWriter(htmlfile);
		try {
			data.write("<!DOCTYPE html>\n");
			data.write("<html>\n");
			data.write("<head>\n");
			data.write("<title>Integrēšana</title>\n");
			if (osType == "linux") {
				//data.write("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">\n");
				data.write("<meta charset=UTF-8\">\n");
			} else {
				//data.write("<meta http-equiv=\"content-type\" content=\"text/html;charset=Windows-1257\">\n");
				data.write("<meta charset=Windows-1257\">\n");
			}
			//* Style block
			//data.write("<style type=\"text/css\">\n"); // HTML5 šo vairs nevajag
			data.write("<style>\n");
			data.write("h1, h4, p, table { font-family: Verdana; text-shadow: 2px 2px 2px darkblue; }\n");
			data.write("table, td { border: 1px solid black; border-collapse:collapse; margin: auto 15px; padding-right: 50px; text-align:left; }\n");
			data.write("th { background-color:darkblue; color:white; text-shadow: 1px 1px 1px lightblue; text-align:center; }\n");
			data.write(".center { border: 1px solid black; border-collapse:collapse; margin:auto; display:table; text-align:center; background-color:lightblue; }\n");
			data.write("</style>\n");
			//*/
			data.write("</head>\n");
			data.write("<body>\n");
			data.write("<div class=\"center\">\n");
			data.write("<h1>Integrēšana</h1>");
			data.write("<h4>Autors: Edgars Liepiņš</h4>");
			data.write("<p>" + "Integrāļa aptuvenā vērtība, kad robeža ir no <b>" + a + "</b> līdz <b>" + b + "</b></p>\n");
			data.write("<p>" + "Precizitāte ir <b>" + eps + "</b></p>\n");
			data.write("<table>\n");
			data.write("<tr>\n");
			data.write("<th align=\"center\">Funkcija</th>\n");
			data.write("<th align=\"center\">Rezultāts</th>\n");
			data.write("<th align=\"center\">Iterāciju skaits</th>\n");
			data.write("</tr>\n");
			
			
			for (int i = 0; i < Fxs.GetNumOfFxs(); ++i) {
				data.write("<tr>");
				funNum = i;		// Funkcijas numurs
				// Galvenais algoritms
				i1 = 0;
				n = 2;			// Intervālu skaits, sākumā vismaz 2
				data.write("<td>" + Fxs.StrFx(funNum) + "</td>\n");
				i2 = (b-a) * ( (Fxs.Fx(funNum, (a)) + Fxs.Fx(funNum, (b)) ) ) / 2;	// Tā aprēķina integrāļa tuvinājumu
				
				while ( Math.abs(i2-i1) > eps ) {	// Salīdzina funkcijas summas tekošās vērtības precizitāti ar eps vērtību
					n *= 2;					// Palielina intervālu skaitu divas reizes
					w = (b-a) / n;			// nosaka intervāla platuma vērtību
					i1 = i2;				// saglabā tekošo vērtību mainīgajā i1
					i2 = 0;					// un tekošā vērtība tiek nonullēta
					
					for (k = 0; k < n; k++) {
						// ir dažādi algoritmi, es izmantoju viduspunkta taisnstūra metodi.
						i2 = i2 + w * Fxs.Fx(funNum, (a + (k + 0.5) * w)); // Summa no visiem laukumiņiem dod integrāļa tuvināto vērtību
					}
				}
				
				if (osType == "linux") {
					System.out.println("Funkcijas " + Fxs.StrFx(funNum) + " integrāļa aptuvenā vērtība ir: " + i2);
					System.out.println("Veikto iterāciju skaits ir: " + Math.log(k) / Math.log(2));	// log(k) / log(2) = log2(k) jo tika dubultots, tāpēc jāizmanto logaritmi
				} else {
					System.out.println("Funkcijas " + Fxs.StrFx(funNum) + " integrala aptuvena vertiba ir: " + i2);
					System.out.println("Veikto iteraciju skaits ir: " + Math.log(k) / Math.log(2));	// log(k) / log(2) = log2(k) jo tika dubultots, tāpēc jāizmanto logaritmi
				}
				// Galvenais algoritms beidzas
				data.write("<td>" + i2 + "</td>\n");
				data.write("<td>" + (int)(Math.log(k) / Math.log(2)) + "</td>\n");
				System.out.println();
				data.write("</tr>");
			}
			data.write("</table>\n");
			data.write("<p>" + "Operētājsistēma: <b>" + os + "</b></p>\n");
			data.write("<p>" + "Java versija: <b>" + jv + "</b></p>\n");
			data.write("</div>\n");
			data.write("</body>\n");
			data.write("</html>\n");
		} finally {
			data.close();		// aizveram failu, lai to var izmantot citas programmas.
			
			if (osType == "linux") {
				System.out.println("Fails \"" + myfile.toString() + "\" veiksmīgi izveidots!");
				System.out.println("Vai vēlaties atvērt \"" + myfile.getName() + "\" savā interneta pārlūkā?! (y/n)");
			} else {
				System.out.println("Fails \"" + myfile.toString() + "\" veiksmigi izveidots!");
				System.out.println("Vai velaties atvert \"" + myfile.getName() + "\" sava interneta parluka?! (y/n)");
			}
			
			try {
				input = reader.readLine();
				
				if (input.equalsIgnoreCase("y")) {
					if (osType == "linux") {
						System.out.println("Tiek atvērts fails \"" + myfile.toString() + "\"");
					} else {
						System.out.println("Tiek atverts fails \"" + myfile.toString() + "\"");
					}
					
					Desktop.getDesktop().open(myfile);
				} else {
					if (osType == "linux") {
						System.out.println("Fails netiek atvērts!");
					} else {
						System.out.println("Fails netiek atverts!");
					}
				}
			} finally {
				reader.close();
				System.out.println("Programma beidz darbu.");
			}
		}
	}
}
