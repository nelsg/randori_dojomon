package dojomon;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AreneTest {

	@Test
	public void attaqueTest() {
		// given
		int number = 2;
		MonstreBuilder monstrebuilder = new MonstreBuilder();
		Arene arene = new Arene();
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt())).thenReturn(70).thenReturn(50).thenReturn(0)
				.thenReturn(70).thenReturn(50).thenReturn(0).thenReturn(80).thenReturn(60).thenReturn(0);
		List<Monstre> monstres = monstrebuilder.creationMonstreDifferent(number, mock);
		Monstre monstre1 = monstres.get(0);
		Monstre monstre2 = monstres.get(1);
		int pa_m1 = monstre1.getPA();
		int pv_m2 = monstre2.getPV();

		// when
		arene.attaque(monstre1, monstre2);

		// then
		Assert.assertEquals(pv_m2 - pa_m1, monstre2.getPV());
	}

	@Test
	public void attaqueTest_tueMonstreM2() {
		// given
		int number = 2;
		MonstreBuilder monstrebuilder = new MonstreBuilder();
		Arene arene = new Arene();
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		// @formatter:off
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(70).thenReturn(50).thenReturn(0)
				.thenReturn(49).thenReturn(70).thenReturn(0);
		// @formatter:on
		List<Monstre> monstres = monstrebuilder.creationMonstreDifferent(number, mock);
		Monstre monstre1 = monstres.get(0);
		Monstre monstre2 = monstres.get(1);

		// when
		arene.attaque(monstre1, monstre2);

		// then
		Assert.assertTrue(monstre2.isMort().equals("Monstre mort"));
	}

	@Test
	public void attaqueTest_tueMonstreM2_BorneInf() {
		// given
		int number = 2;
		MonstreBuilder monstrebuilder = new MonstreBuilder();
		Arene arene = new Arene();
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		int m1_pv = 70;
		int m1_pa = 50;
		int m2_pv = 50;
		int m2_pa = 71;
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(m1_pv).thenReturn(m1_pa).thenReturn(0)
				.thenReturn(m2_pv).thenReturn(m2_pa).thenReturn(0);
		List<Monstre> monstres = monstrebuilder.creationMonstreDifferent(number, mock);
		Monstre monstre1 = monstres.get(0);
		Monstre monstre2 = monstres.get(1);

		// when
		arene.attaque(monstre1, monstre2);

		// then
		Assert.assertTrue(monstre2.isMort().equals("Monstre mort"));
		Assert.assertEquals(0, monstre2.getPV());
	}

	@Test
	public void attaqueTest_sansTuerMonstreM2() {
		// given
		int number = 2;
		MonstreBuilder monstrebuilder = new MonstreBuilder();
		Arene arene = new Arene();
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		int m1_pv = 70;
		int m1_pa = 50;
		int m2_pv = 60;
		int m2_pa = 71;
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt())).thenReturn(m1_pv).thenReturn(m1_pa)
				.thenReturn(0).thenReturn(m2_pv).thenReturn(m2_pa).thenReturn(0);
		List<Monstre> monstres = monstrebuilder.creationMonstreDifferent(number, mock);
		Monstre monstre1 = monstres.get(0);
		Monstre monstre2 = monstres.get(1);

		// when
		arene.attaque(monstre1, monstre2);

		// then
		Assert.assertEquals("", monstre2.isMort());
		Assert.assertEquals(10, monstre2.getPV());
	}

	@Test
	public void combattreTest() {
		// given
		int number = 2;
		MonstreBuilder monstrebuilder = new MonstreBuilder();
		Arene arene = new Arene();
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		int m1_pv = 70;
		int m1_pa = 50;
		int m2_pv = 60;
		int m2_pa = 71;
		// @formatter:off
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(m1_pv).thenReturn(m1_pa).thenReturn(0)
				.thenReturn(m2_pv).thenReturn(m2_pa).thenReturn(0);
		// @formatter:on
		List<Monstre> monstres = monstrebuilder.creationMonstreDifferent(number, mock);
		Monstre monstre1 = monstres.get(0);
		Monstre monstre2 = monstres.get(1);

		// when
		arene.combattre(monstre1, monstre2);

		// then
		// Monstre 1
		Assert.assertEquals("Monstre mort", monstre1.isMort());
		Assert.assertEquals(-1, monstre1.getPV());

		// Monstre 2
		Assert.assertEquals("", monstre2.isMort());
		Assert.assertEquals(10, monstre2.getPV());

	}

	@Test
	public void combattreTest2() {
		// given
		int number = 2;
		MonstreBuilder monstrebuilder = new MonstreBuilder();
		Arene arene = new Arene();
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		int m1_pv = 90;
		int m1_pa = 11;
		int m2_pv = 80;
		int m2_pa = 25;
		// @formatter:off
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(m1_pv).thenReturn(m1_pa)
				.thenReturn(0).thenReturn(m2_pv).thenReturn(m2_pa).thenReturn(0);
		// @formatter:on
		List<Monstre> monstres = monstrebuilder.creationMonstreDifferent(number, mock);
		Monstre monstre1 = monstres.get(0);
		Monstre monstre2 = monstres.get(1);

		// when
		arene.combattre(monstre1, monstre2);

		// then
		// Monstre 1
		Assert.assertEquals("Monstre mort", monstre1.isMort());
		Assert.assertEquals(-10, monstre1.getPV());

		// Monstre 2
		Assert.assertEquals("", monstre2.isMort());
		Assert.assertEquals(36, monstre2.getPV());
	}
}
