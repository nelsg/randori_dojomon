package dojomon;

/**
 * Classe qui rassemble les utilitaires pour la création de monstre
 *
 */
public class MonstreHelper {
	/**
	 * 
	 * @param start
	 * @param end
	 * @return entier entre start (inclus) et end (exclu)
	 */
	public int genValue(int start, int end) {
		return start + (int) (Math.random() * (end - start)) ;
	}
}