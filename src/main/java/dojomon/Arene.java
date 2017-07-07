package dojomon;

public class Arene {

	public void attaque(Monstre monstre1, Monstre monstre2) {
		monstre2.setPV(monstre2.getPV() - monstre1.getPA());
	}

	public void combattre(Monstre monstre1, Monstre monstre2) {
		String monstreMort = "Non";
		while (!"Monstre mort".equals(monstreMort)) {
			attaque(monstre1, monstre2);
			monstreMort = monstre2.isMort();
			if (!"Monstre mort".equals(monstreMort)) {
				attaque(monstre2, monstre1);
				monstreMort = monstre1.isMort();
			}
		}

	}

}
