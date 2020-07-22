package weekopdracht2;

public class Kassa {
	private static double kermisOmzet;
	private static int aantalKermisKaartjes;
	
	private double omzet;
	private int aantalKaartjesVerkocht;
	
	private double omzetLaatsteBezoek; //Over dit bedrag is al belasting afgedragen (hulpvariabele)
	
	void verkoopKaartje(double prijs) {
		kermisOmzet = kermisOmzet + prijs;
		aantalKermisKaartjes = aantalKermisKaartjes + 1;
		omzet += prijs;
		aantalKaartjesVerkocht ++;
	}
	
	double betaalKansspelBelasting() {
		double belasting = 0.3*(omzet-omzetLaatsteBezoek);
		omzet -= belasting;
		kermisOmzet -= belasting;
		omzetLaatsteBezoek = omzet;
		return belasting;
	}
		
	double getOmzet() {
		return omzet;
	}
	
	static double getKermisOmzet() {
		return kermisOmzet;
	}
	
	int getAantalKaartjesVerkocht() {
		return aantalKaartjesVerkocht;
	}

	static int getAantalKermisKaartjes() {
		return aantalKermisKaartjes;
	}
}
