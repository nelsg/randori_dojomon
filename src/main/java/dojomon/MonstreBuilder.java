package dojomon;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui permet de construire un monstre
 *
 */
public class MonstreBuilder {
	
	/**
	 * Crée un nouveau monstre qui est différent de celui passé en paramètre. Pour les différencier, voir {@link #isIdentical(Monstre, Monstre)}
	 * @param number totalement inutile pour le moment. Sera utilisé pour définir un nombre de monstres à créer.
	 * @param help
	 * @return une liste de monstres. Pour le moment, un seul élément.
	 */
	public List<Monstre> creationMonstreDifferent(int number, MonstreHelper help) {
		// TODO Améliorer la méthode avec une liste de monstres plutôt qu'un seul
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
