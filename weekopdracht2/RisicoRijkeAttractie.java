package weekopdracht2;

abstract class RisicoRijkeAttractie extends Attractie{
	private final int draaiLimiet; //moet dit final zijn?
	private int aantalKeerGedraaid;

	RisicoRijkeAttractie(String naam, int draaiLimiet){
		this.naam = naam;
		this.draaiLimiet = draaiLimiet;
		opstellingsKeuring();
	}

	void opstellingsKeuring(){
		System.out.println("Er vind een opstellingskeuring plaats voor de attractie '" + naam + "'.");
	}

	void onderhoudsbeurt() {
		aantalKeerGedraaid = 0;
		System.out.println("Er is een onderhoudsbeurt uitgevoerd op de attractie '" + naam +"'.");
	}

	@Override
	void draaien(){
		try {
			if(aantalKeerGedraaid == draaiLimiet) {
				throw new Exception(naam + "  heeft zijn draailimiet bereikt, voer een onderhoudsbeurt uit!");
			} else {
				kassa.verkoopKaartje(prijs);
				aantalKeerGedraaid ++;
				System.out.println("De attractie " + naam + " draait");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
