package com.exchange.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.exchange.conf.ApplicationContextTest;
import com.exchange.model.sistemaSolar.SistemaSolar;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationContextTest.class)
public class SistemaSolarRepositoryTest {
	
	@Autowired
	private SistemaSolarRepository repository;
	
	@Test
	public void sistemaSolarRepositoryIsInitialicedRihtTest() {
		assertNotNull(repository);
	}
	
	@Test
	public void sistemaSolarRepositoryGetDataRightTest() {
		SistemaSolar viaLactea = repository.findById(Integer.valueOf(1)).get();
		assertTrue(viaLactea.getId().equals(Integer.valueOf(1)));
		assertTrue(viaLactea.getDay().equals(Long.valueOf(1)));
		assertTrue(viaLactea.getName().equals("via lactea"));
	}
}
