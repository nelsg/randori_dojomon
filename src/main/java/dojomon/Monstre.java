package dojomon;

public class Monstre {
	private static final int MIN_PA = 10;
	private static final int MAX_PA = 100;
	private static final int MIN_TOTAL = 100;
	private static final int MAX_TOTAL = 150;
	private static final int MIN_PV = 10;
	private static final int MAX_PV = 100;
	private int pv;
	private int pa;

	public Monstre(MonstreHelper utils) {
		this.pv = utils.genValue(MIN_PV, MAX_PV);
		
		this.pa = utils.genValue(Math.max(MIN_TOTAL - this.pv,MIN_PA), Math.min(MAX_TOTAL - this.pv, MAX_PA) );
		checkPv();
		checkPa();
		checkPJTotal();
	}

	public int getPV() {
		return pv;
	}

	public int getPA() {
		return pa;
	}

	private void checkPv() {
		if (pv < MIN_PV || pv > MAX_PV) {
			throw new IllegalStateException("les PV ne sont pas dans les limites");
		}
	}

	private void checkPa() {
		if (pa < MIN_PA || pa > MAX_PA) {
			throw new IllegalStateException("les PA ne sont pas dans les limites");
		}
	}

	private void checkPJTotal() {
		if (getPJTotal() < 100 || getPJTotal() > 150) {
			throw new IllegalStateException("le total des PV et PA  ne sont pas dans les limites");
		}

	}

	private int getPJTotal() {
		return pv + pa;
	}

}
