package weekopdracht2;

public class Ladderklimmen extends Attractie implements GokAttractie{
	
	Ladderklimmen(){
		naam = "Ladderklimmen";
		prijs = 5.00;
		kassa = new Kassa();
	}

	@Override
	public double betaalKansSpelBelasting() {
		return kassa.betaalKansspelBelasting();
	}
}
