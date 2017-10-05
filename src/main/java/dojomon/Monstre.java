package dojomon;

/**
 * Classe qui définit un monstre, qui a des attributs de jeu et d'attaque
 *
 */
public class Monstre {
	private static final int MIN_PA = 10;
	private static final int MAX_PA = 100;
	private static final int MIN_TOTAL = 100;
	private static final int MAX_TOTAL = 150;
	private static final int MIN_PV = 10;
	private static final int MAX_PV = 100;
	private int pv;
	private int pa;
	private final Element force;
	private final Element faiblesse;

	/**
	 * Constructeur de la classe monstre
	 * @param utils
	 */
	public Monstre(MonstreHelper utils) {
		this.pv = utils.genValue(MIN_PV, MAX_PV);
		
		this.pa = utils.genValue(Math.max(MIN_TOTAL - this.pv,MIN_PA), Math.min(MAX_TOTAL - this.pv, MAX_PA) );
		checkPv();
		checkPa();
		checkPJTotal();
		this.force = Element.values()[utils.genValue(0, Element.values().length)];
		Element tmpFaiblesse = Element.values()[utils.genValue(0, Element.values().length)];
		
		int i=0;
		while(i++ < 100 && this.getForce() == tmpFaiblesse){
			if(this.getForce() == Element.AUCUN){
				break;
			} else if(tmpFaiblesse == Element.AUCUN){
				break;
			}
			tmpFaiblesse = Element.values()[utils.genValue(0, Element.values().length)];
		}
		if (i == 100) {
			tmpFaiblesse = Element.AUCUN;
		}
		this.faiblesse = tmpFaiblesse;
		
	}

	/**
	 * @deprecated Utiliser le constructeur: {@link #Monstre(MonstreHelper)}
	 * 
	 * @param help
	 * @param element
	 * @param faiblesse
	 */
	@Deprecated
	public Monstre(MonstreHelper help, Element element, Element faiblesse) {
		this.pv = help.genValue(MIN_PV, MAX_PV);
		this.force = element;
		this.faiblesse = faiblesse;
	}

	public int getPV() {
		return pv;
	}

	public int getPA() {
		return pa;
	}

	/**
	 * Vérifie que les points de vie ne sont pas en dehors des limites. Sinon, balance une exception
	 */
	private void checkPv() {
		if (pv < MIN_PV || pv > MAX_PV) {
			throw new IllegalStateException("les PV ne sont pas dans les limites");
		}
	}

	/**
	 * Vérifie que les points d'attaque ne sont pas en dehors des limites. Sinon, balance une exception
	 */
	private void checkPa() {
		if (pa < MIN_PA || pa > MAX_PA) {
			throw new IllegalStateException("les PA ne sont pas dans les limites");
		}
	}
	
	/**
	 * Vérifie que les points de jeu ne sont pas en dehors des limites. Sinon, balance une exception
	 */
	private void checkPJTotal() {
		if (getPJTotal() < 100 || getPJTotal() > 150) {
			throw new IllegalStateException("le total des PV et PA  ne sont pas dans les limites");
		}

	}

	public int getPJTotal() {
		return pv + pa;
	}

	public void setPV(int i) {
		pv = i;
	}

	/**
	 * Vérifie si le monstre est mort ou pas
	 * @return true si mort
	 */
	public String isMort() {
		if(getPV()<=0){
			return "Monstre mort";
		}
		return "";
	}

	public Object getForce() {
		return force;
	}

	public Object getFaiblesse() {
		return faiblesse;
	}

}
