package dojomon;

/**
 * Classe qui représente une arène dans laquelle les monstres vont combattre
 *
 */
public class Arene {

	/**
	 * Simule une attaque entre 2 monstres
	 * @param monstre1
	 * @param monstre2
	 */
	public void attaque(Monstre monstre1, Monstre monstre2) {
		monstre2.setPV(monstre2.getPV() - monstre1.getPA());
	}

	/**
	 * Simule un combat (attaque jusqu'à la mort d'un des 2 monstres)
	 * @param monstre1
	 * @param monstre2
	 */
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
