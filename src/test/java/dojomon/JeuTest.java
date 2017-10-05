package dojomon;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author dojo
 * Classe qui teste l'affectation de monstres à des joueurs
 *
 */
public class JeuTest {

	@Test
	public void creationJeuTest(){
		//given
	
	
		//when
		Jeu jeu = new Jeu();
	
		//then
		Assert.assertNotNull(jeu.getJoueur1());
		Assert.assertNotNull(jeu.getJoueur2());
		Assert.assertNotNull(jeu.getJoueur1().getMonstre());
		Assert.assertNotNull(jeu.getJoueur2().getMonstre());
		Assert.assertNotEquals(jeu.getJoueur1().getMonstre(), jeu.getJoueur2().getMonstre());
	}
}
