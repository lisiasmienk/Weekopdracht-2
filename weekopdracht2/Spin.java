package weekopdracht2;

public class Spin extends RisicoRijkeAttractie implements GokAttractie{
	
	Spin(){
		super("Spin", 5);
		prijs = 2.25;
		kassa = new Kassa();
	}
	
	public double betaalKansSpelBelasting() {
		return kassa.betaalKansspelBelasting();
	}
}
