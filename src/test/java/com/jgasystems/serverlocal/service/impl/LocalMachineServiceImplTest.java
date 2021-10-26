package com.jgasystems.serverlocal.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.jgasystems.serverlocal.service.LocalMachineService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalMachineServiceImplTest {
	
	@Autowired
	private LocalMachineService localMachineService;

	@Test
	public void testGetIp() {
		localMachineService.getIp();
	}

	@Test
	public void testGetVDIIp() {
		localMachineService.getVDIIp();
	}

	@Test
	public void testGetUser() {
		localMachineService.getUser();
	}

	@Test
	public void testIsVDI() {
		System.err.println("Is VDI?"+ localMachineService.isVDI());
	}

}
