package test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;




import org.junit.Test;


import dataAccess.DataAccess;

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



@RunWith(MockitoJUnitRunner.class)
public class Testeo {
	
	DataAccess dao=Mockito.mock(DataAccess.class);
	
	@InjectMocks
	BLFacadeImplementation sut;

	@Test
	public void test() {
//		Mocito lortu behar da
		Mockito.doReturn(null).when(dao).getBezeroa(Mockito.anyInt());
		assertTrue(dao.getBezeroa(0)==null);
		fail();
		
	}

}
