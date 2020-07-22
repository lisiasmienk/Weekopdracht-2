package weekopdracht2;

public class Ladderklimmen extends Attractie implements GokAttractie{
	
	Ladderklimmen(){
		naam = "Ladderklimmen";
		prijs = 5.00;
		kassa = new Kassa();
	}

	public double betaalKansSpelBelasting() {
		return kassa.betaalKansspelBelasting();
	}
}
