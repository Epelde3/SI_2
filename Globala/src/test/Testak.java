package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import dataAccess.DataAccessInterface;
import service.BLFacadeImplementation;



@RunWith(MockitoJUnitRunner.class)
public class Testak {
	
	@Mock
	DataAccessInterface dao;
	
	@InjectMocks
	BLFacadeImplementation sut;

	@Test
	public void test() {
	
		Mockito.doReturn(null).when(dao).getBezeroa(Mockito.anyInt());
		assertTrue(dao.getBezeroa(0)==null);
		
	}

}
