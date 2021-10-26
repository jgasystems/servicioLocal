package com.jgasystems.serverlocal.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class PowerShellTest {
	
	
	private PowerShell  powerShell = new PowerShell();

	@Test
	public void testRunCommand() {
		//powerShell.runCommand("$PSVersionTable.PSVersion");
		powerShell.runCommand("ipconfig|FINDSTR 'Dirección IPv4'");
	}

	@Test
	public void testRunCommandFile() {
		//fail("Not yet implemented");
	}

}
