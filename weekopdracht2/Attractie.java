package weekopdracht2;

abstract public class Attractie{
	String naam;
	double prijs;
	double oppervlakte;
	Kassa kassa;

	void draaien() {
		kassa.verkoopKaartje(prijs);
		System.out.println("De attractie " + naam + " draait");
	}
}
