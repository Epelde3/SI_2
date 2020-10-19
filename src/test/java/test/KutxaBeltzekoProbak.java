package test;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import dataAccess.DataAccess;
import domain.Dibisa;
import domain.Eragiketa;
import domain.Kontua;
import domain.SukurtsalDibisa;
import domain.Sukurtsala;
import service.BLFacadeImplementation;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class KutxaBeltzekoProbak {
	DataAccess dao = Mockito.mock(DataAccess.class);

	@InjectMocks
	BLFacadeImplementation sut;

	@Test
	public void test1() {
		
		Kontua kontua = new Kontua("Alex", 999, 24);

		Dibisa dibisa = new Dibisa("Libra Esterlinak", 0.25);
		SukurtsalDibisa sukDibisa = new SukurtsalDibisa(dibisa, 5000, 0.15, "Libra Esterlinak");
		ArrayList<SukurtsalDibisa> list = new ArrayList<SukurtsalDibisa>();

		Eragiketa erag = new Eragiketa("Erosi", "MockitoProba1", 100);

		Sukurtsala suk = new Sukurtsala(list, "Gazteiz");

		
		Mockito.doNothing().when(dao).eragiketaGehitu(Mockito.eq(erag), Mockito.anyInt(), Mockito.anyDouble());

		try {
			sut.erosketaGauzatu(kontua.getId(), dibisa, 10, 25, "MockitoProba1", "Erosi", "Gazteiz");
			if (kontua.getEragiketaList().get(0).getDeskripzioa().equals("MockitoProba1")) {
				assertTrue(true);
			} else {
				fail("Errorea");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Exception");
		}

	}

	@Test
	public void test2() {
		Kontua kontua = new Kontua("Alex", 999, 24);

		Dibisa dibisa = new Dibisa("Libra Esterlinak", 0.25);
		SukurtsalDibisa sukDibisa = new SukurtsalDibisa(dibisa, 5000, 0.15, "Libra Esterlinak");
		ArrayList<SukurtsalDibisa> list = new ArrayList<SukurtsalDibisa>();

		Eragiketa erag = new Eragiketa("Erosi", "MockitoProba1", 100);

		Sukurtsala suk = new Sukurtsala(list, "Gazteiz");

		
		Mockito.doNothing().when(dao).eragiketaGehitu(Mockito.eq(erag), Mockito.anyInt(), Mockito.anyDouble());

		try {
			sut.erosketaGauzatu(kontua.getId(), dibisa, 10, 25, "MockitoProba1", "Salketa", "Gazteiz");
			if (kontua.getEragiketaList().get(0).getDeskripzioa().equals("MockitoProba1")) {
				assertTrue(true);
			} else {
				fail("Errorea");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Exception");
		}
	}

	@Test
	public void test3() {
		Kontua kontua = new Kontua("Alex", 999, 24);

		Eragiketa erag = new Eragiketa("Erosi", "MockitoProba1", 100);
		
		Mockito.doReturn(null).when(dao).dibisakGehitu(Mockito.any(Dibisa.class), Mockito.anyFloat(), Mockito.anyString());
		try {
			sut.erosketaGauzatu(kontua.getId(), null, 10, 25, "MockitoProba1", "Erosi", "Gazteiz");
			fail();
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(true);
		}
	}

	@Test
	public void test4() {
		Kontua kontua = new Kontua("Alex", 999, 24);

		Dibisa dibisa = new Dibisa("Libra Esterlinak", 0.25);
		SukurtsalDibisa sukDibisa = new SukurtsalDibisa(dibisa, 5000, 0.15, "Libra Esterlinak");
		ArrayList<SukurtsalDibisa> list = new ArrayList<SukurtsalDibisa>();

		Eragiketa erag = new Eragiketa("Erosi", "MockitoProba1", 100);

		Sukurtsala suk = new Sukurtsala(list, "Gazteiz");
		try {
			sut.erosketaGauzatu(kontua.getId(), dibisa, 10, 25, "MockitoProba1", "Ezer ez", "Gazteiz");
			fail("Errorea");
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(true);
		}
	}

	@Test
	public void test5() {
		Kontua kontua = new Kontua("Alex", 999, 24);
		try {
			Dibisa dibisa = new Dibisa("Libra Esterlinak", 0.25);
			Mockito.doReturn(kontua).when(dao).getBezeroa(Mockito.anyInt());
			
			sut.erosketaGauzatu(1, dibisa, 10, 25, "MockitoProba1", "Erosi", "Gazteiz");

			fail();
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(true);
		}
	}


}
