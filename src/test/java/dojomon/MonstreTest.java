package dojomon;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;


public class MonstreTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void creationmontre(){
		//GIVEN
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt())).thenReturn(70).thenReturn(60);

		//WHEN
		Monstre monstre = new Monstre(mock);

		//THEN
		Assert.assertTrue(monstre.getPV() == 70);
		Assert.assertTrue(monstre.getPA() == 60);		
		Mockito.verify(mock, Mockito.times(1)).genValue(Mockito.eq(10), Mockito.eq(100));
		Mockito.verify(mock, Mockito.times(1)).genValue(Mockito.eq(30), Mockito.eq(80));
	}
	
	@Test
	public void creationMonstreWithLowPv(){
		
		//GIVEN
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		int pv = 10;
		//le PJ minimum est 100
		int minPA = 100-pv;
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt())).thenReturn(pv).thenReturn(minPA);

		//WHEN
		Monstre monstre = new Monstre(mock);

		//THEN
		Assert.assertTrue(monstre.getPV() == 10);
		Assert.assertTrue(monstre.getPA() == 90);		
		Mockito.verify(mock, Mockito.times(1)).genValue(Mockito.eq(10), Mockito.eq(100));
		Mockito.verify(mock, Mockito.times(1)).genValue(Mockito.eq(90), Mockito.eq(100));
	}
	
	@Test
	public void creationMonstreWithHighPv(){
		
		//GIVEN
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		int pv = 100;
		//le PJ maximum est 150
		int maxPA = 150-pv;
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt())).thenReturn(pv).thenReturn(maxPA);

		//WHEN
		Monstre monstre = new Monstre(mock);

		//THEN
		Assert.assertTrue(monstre.getPV() == pv);
		Assert.assertTrue(monstre.getPA() == maxPA);		
		Mockito.verify(mock, Mockito.times(1)).genValue(Mockito.eq(10), Mockito.eq(100));
		Mockito.verify(mock, Mockito.times(1)).genValue(Mockito.eq(10), Mockito.eq(maxPA));
	}
	
	@Test(expected=IllegalStateException.class)	
	public void checkPv_BorneInf() {
		// GIVEN
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt())).thenReturn(9);
		
		//WHEN
		new Monstre(mock);
		
		Assert.fail();
	}
	
	@Test(expected=IllegalStateException.class)	
	public void checkPv_BorneSup() {
		// GIVEN
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt())).thenReturn(101);
		
		new Monstre(mock);
		
		Assert.fail();
	}
	
	@Test
	public void checkPa_BorneInf() {
		
		// GIVEN
		expectedEx.expect(IllegalStateException.class);
		expectedEx.expectMessage("les PA ne sont pas dans les limites");
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt())).thenReturn(11).thenReturn(9);
		
		//WHEN
		new Monstre(mock);
		
		Assert.fail();
	}
	
	@Test
	public void checkPTotal_BorneInf() {
		
		// GIVEN
		expectedEx.expect(IllegalStateException.class);
		expectedEx.expectMessage("le total des PV et PA  ne sont pas dans les limites");
		MonstreHelper mock = Mockito.mock(MonstreHelper.class);
		Mockito.when(mock.genValue(Mockito.anyInt(), Mockito.anyInt())).thenReturn(11).thenReturn(10);
		
		//WHEN
		new Monstre(mock);
		
		Assert.fail();
	}
}
