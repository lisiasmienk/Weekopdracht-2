package weekopdracht2;

import java.util.Scanner;

public class Kermis {
	Attractie[] attracties = new Attractie[6];
	Belastinginspecteur bi = new Belastinginspecteur();

	Kermis() {
		// Opbouwen van de kermisattracties
		attracties[0] = new Botsautos();
		attracties[1] = new Spin();
		attracties[2] = new Spiegelpaleis();
		attracties[3] = new Spookhuis();
		attracties[4] = new Hawaii();
		attracties[5] = new Ladderklimmen();
	}

	public void toonGebruikersHandleiding() {
		System.out.println("\nVoer het getal (1-6) van de attractie in waarvoor je een kaartje wilt kopen.");
		System.out.println("    1: Botsauto's");
		System.out.println("    2: Spin");
		System.out.println("    3: Spiegelpaleis");
		System.out.println("    4: Spookhuis");
		System.out.println("    5: Hawaii");
		System.out.println("    6: Ladderklimmen");
		System.out.println("Of kies:");
		System.out.println("    'o' voor het inzien van de omzet");
		System.out.println("    'k' voor het aantal verkochte kaartjes");
		System.out.println("    'b' voor een bezoek van de belastinginspecteur\n");
	}

	public void draaiKermis(Scanner scanner) {
		while (true) {
			if (scanner.hasNextInt()) {
				int getal = scanner.nextInt();
				if (getal > 0 && getal < 7) {
					attracties[getal - 1].draaien();
				} else {
					System.out.println("Er bestaat geen attractie met deze waarde, voer een getal (1-6) in");
				}
			} else {
				char character = scanner.next().charAt(0);
				switch (character) {
				case 'o':
					toonOmzet(scanner);
					break;
				case 'k':
					toonKaartjes(scanner);
					break;
				case 'b':
					bi.inBelasting(this);
					break;
				case 'm':
					monteurBezoek();
					break;
				default: System.out.println("Dit commando is niet bekend, probeer nog eens.");
				}
			}
		}
	}

	private void toonOmzet(Scanner scanner) {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Van welke attractie wil je de huidige omzet zien?");
		System.out.println("Geef een getal 1-6 voor een attractie of 0 voor de totale kermis omzet.");
		if (scanner.hasNextInt()) {
			int getal = scanner.nextInt();
			if(getal>0) {
				System.out.printf("De omzet van de attractie '%s' is €%.2f.\n", attracties[getal-1].naam, attracties[getal-1].kassa.getOmzet());
			} else {
				System.out.printf("De totale omzet van de kermis is €.2f.\n", Kassa.getKermisOmzet());
			}
		}
		System.out.println("-----------------------------------------------------------------------");
	}

	private void toonKaartjes(Scanner scanner) {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Van welke attractie wil je het aantal verkochte kaartjes zien?");
		System.out.println("Geef een getal 1-6 voor een attractie of 0 voor het kermistotaal.");
		if (scanner.hasNextInt()) {
			int getal = scanner.nextInt();
			if(getal>0) {
				System.out.printf("Het aantal verkochte kaartjes van de attractie '%s' is %d.\n", attracties[getal-1].naam, attracties[getal-1].kassa.getAantalKaartjesVerkocht());
			} else {
				System.out.printf("Het totale aantal verkochte kaartjes op de kermis is %d.\n", Kassa.getAantalKermisKaartjes());
			}
		}
		System.out.println("-----------------------------------------------------------------------");
	}

	private void monteurBezoek() {
		System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
		System.out.println("Je hebt een monteur opgeroepen.");
		for (Attractie a : attracties) {
			try {
				((RisicoRijkeAttractie) a).onderhoudsbeurt();
			}
			catch(Exception e) {}
		}
		System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Kermis k = new Kermis();
		k.toonGebruikersHandleiding();
		k.draaiKermis(scanner);
		scanner.close();
	}
}
