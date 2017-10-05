package dojomon;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MonstrebuilderTest {

	@Test
	public void creationMonstreDifferent() {
		// given
		int number = 2;
		MonstreBuilder monstrebuilder = new MonstreBuilder();
		MonstreHelper help = new MonstreHelper();

		// when
		List<Monstre> monstres = monstrebuilder.creationMonstreDifferent(number, help);
		// then
		Assert.assertTrue(monstres.size() == 2);
		Assert.assertTrue(monstres.get(0).getPA() != monstres.get(1).getPA());
		Assert.assertTrue(monstres.get(0).getPV() != monstres.get(1).getPV());
		Assert.assertTrue(monstres.get(0).getPJTotal() != monstres.get(1).getPJTotal());

	}

	@Test
	public void creationMonstreDifferent_identiquemonster() {
		// given
		int number = 2;
		MonstreBuilder monstrebuilder = new MonstreBuilder();
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		// @formatter:off
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(70).thenReturn(50).thenReturn(0).thenReturn(0)
				.thenReturn(70).thenReturn(50).thenReturn(0).thenReturn(0)
				.thenReturn(80).thenReturn(60).thenReturn(0).thenReturn(0);
		// @formatter:on
		// when
		List<Monstre> monstres = monstrebuilder.creationMonstreDifferent(number, mock);

		// then
		Assert.assertTrue(monstres.size() == 2);
		Assert.assertTrue(monstres.get(0).getPA() != monstres.get(1).getPA());
		Assert.assertTrue(monstres.get(0).getPV() != monstres.get(1).getPV());
		Assert.assertTrue(monstres.get(0).getPJTotal() != monstres.get(1).getPJTotal());
		Mockito.verify(mock, Mockito.times(12)).genValue(Mockito.anyInt(), Mockito.anyInt());

	}



}
