package dojomon;

import java.util.ArrayList;
import java.util.List;

public class MonstreBuilder {

	public List<Monstre> creationMonstreDifferent(int number, MonstreHelper help) {
		List<Monstre> monstres = new ArrayList<Monstre>();
		Monstre monstre1 = new Monstre(help);
		Monstre monstre2 = new Monstre(help);
		while (isIdentical(monstre1, monstre2)) {
			monstre2 = new Monstre(help);
		}
		monstres.add(monstre1);
		monstres.add(monstre2);

		return monstres;
	}

	/**
	 * cette methode renvoie vrai si une des valeurs est identique
	 * @param monstre1
	 * @param monstre2
	 * @return
	 */
	private boolean isIdentical(Monstre monstre1, Monstre monstre2) {
		return ((monstre1.getPA() == monstre2.getPA()) || (monstre1.getPV() == monstre2.getPV())
				|| (monstre1.getPJTotal() == monstre2.getPJTotal()));
	}

}
