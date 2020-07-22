package weekopdracht2;

public class Belastinginspecteur {
	int aantalBezoeken;
	
	void inBelasting(Kermis k) {
		System.out.println(".  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .");
		System.out.println("De belastinginspecteur heeft de kermis bezocht.");
		aantalBezoeken ++;
		for(Attractie a : k.attracties) {
			try {
				double belasting = ((GokAttractie)a).betaalKansSpelBelasting();
				System.out.printf("Er is €%.2f belasting betaald over de attractie '%s'.\n", belasting,a.naam) ;
			}
			catch(Exception e) {
				//Doe niets
			}
		}
		System.out.println(".  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .");
	}
}
