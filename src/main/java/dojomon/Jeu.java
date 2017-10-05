package dojomon;

import java.util.List;

public class Jeu {
	
	private final Joueur joueur1;
	private final Joueur joueur2;
	
	/**
	 * créé un plateau avec 2 joueurs, chacun ayant un monstre différent
	 */
	public Jeu(){
		joueur1 = new Joueur();
		joueur2 = new Joueur();
		MonstreBuilder monstreBuilder = new MonstreBuilder();
		List<Monstre> creationMonstreDifferent = monstreBuilder.creationMonstreDifferent(2, new MonstreHelper());
		joueur1.setMonstre(creationMonstreDifferent.get(0));
		joueur2.setMonstre(creationMonstreDifferent.get(1));
			
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

}
