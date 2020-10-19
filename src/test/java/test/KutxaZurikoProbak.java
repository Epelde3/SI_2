package test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dataAccess.DataAccess;
import domain.Dibisa;
import domain.SukurtsalDibisa;
import service.BLFacadeImplementation;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import dataAccess.*;
import service.*;


public class KutxaZurikoProbak { 


	// kutxa txuriko probak.
	@Test
	public void test1() {
		int bezeroID = 2;
		DataAccess data = new DataAccess();
		BLFacadeImplementation bl = new BLFacadeImplementation(data);
		Dibisa erostekodibisa = bl.getSukurtsala("Donostia").getDibisak().get(0).getDibisa();
		int kopurua = 10;
		double prezioa = 20;
		String deskripzioa = "proba test1";
		String mota = "Erosi";
		String helbidea = "Donostia";

		try {
			bl.erosketaGauzatu(bezeroID, erostekodibisa, kopurua, prezioa, deskripzioa, mota, helbidea);
			// bezeroak bere baitan badu "proba test1" deskripzio moduan duen eragiketa bat
			// esan dezakegu testa ondo exekutatu dela

			if (bl.getBezero(bezeroID).getEragiketaList().get(0).getDeskripzioa().equals(deskripzioa)) {
				assertTrue(true);
			} else {
				fail("Errorea");
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception");
		}

	}

	@Test
	public void test2() {
		int bezeroID = 2;
		DataAccess data = new DataAccess();
		BLFacadeImplementation bl = new BLFacadeImplementation(data);
		Dibisa erostekodibisa = bl.getSukurtsala("Donostia").getDibisak().get(0).getDibisa();
		int kopurua = 10;
		double prezioa = 20;
		String deskripzioa = "Salketa proba test2";
		String mota = "Salketa";
		String helbidea = "Donostia";

		try {
			bl.erosketaGauzatu(bezeroID, erostekodibisa, kopurua, prezioa, deskripzioa, mota, helbidea);
			// bezeroak bere baitan badu "Salketa proba test2" deskripzio moduan duen
			// eragiketa bat
			// esan dezakegu testa ondo exekutatu dela
			if (bl.getBezero(bezeroID).getEragiketaList().get(1).getDeskripzioa().equals(deskripzioa)) {
				assertTrue(true);
			} else {
				fail("Errorea");
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception");
		}
		

	}
	@Test
	public void test3() {
		int bezeroID = 2;
		DataAccess data = new DataAccess();
		BLFacadeImplementation bl = new BLFacadeImplementation(data);
		Dibisa erostekodibisa = bl.getSukurtsala("Donostia").getDibisak().get(0).getDibisa();
		int kopurua = 10;
		double prezioa = 20;
		String deskripzioa = "Salketa proba test2";
		String mota = "beste eragiketa bat";
		String helbidea = "Donostia";
		
		try {
			bl.erosketaGauzatu(bezeroID, erostekodibisa, kopurua, prezioa, deskripzioa, mota, helbidea);
			fail("Errorea");
		}catch (Exception e) {
			assertTrue(true);
					
		}
	}

}
