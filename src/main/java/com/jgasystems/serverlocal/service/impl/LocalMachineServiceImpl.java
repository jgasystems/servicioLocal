package com.jgasystems.serverlocal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgasystems.serverlocal.service.LocalMachineService;
import com.jgasystems.serverlocal.util.PowerShell;

@Service
public class LocalMachineServiceImpl implements LocalMachineService {
	
	//Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private PowerShell powerShell;

	@Override
	public String getIp() {
		
		String ip = "";
		String result  = powerShell.runCommand("ipconfig|FINDSTR 'Dirección IPv4'");
		String[] valores = result.split(":");
		
		if (valores.length > 1) {
			ip = valores[1];
			System.err.println("JGA::IP:*" + ip + "*");
		}
		
		return ip.trim();
	}

	@Override
	public String getVDIIp() {
		String ipVdi = "";
		ipVdi = powerShell.runCommand("$session = Get-WmiObject -Namespace ROOT\\CITRIX\\EUEM -Class Citrix_Euem_ClientConnect; $clientIpAddress = $session.ClientMachineIP; echo $clientIpAddress ");
		
		System.err.println("JGA::IPVDI:*" + ipVdi + "*");
		return ipVdi.trim();
	}

	@Override
	public String getUser() {
		String user = "";
		String result  = powerShell.runCommand("whoami");
		String[] valores = result.split("\\\\");
		
		if (valores.length > 1) {
			user = valores[1];
			System.err.println("JGA::user:*" + user + "*");
		}
		
		return user.trim();
	}

	@Override
	public boolean isVDI() {
		String ipVdi = "";
		ipVdi = powerShell.runCommand("$session = Get-WmiObject -Namespace ROOT\\CITRIX\\EUEM -Class Citrix_Euem_ClientConnect; $clientIpAddress = $session.ClientMachineIP; echo $clientIpAddress ");
		System.err.println("JGA::IPVDI:*" + ipVdi + "*");
		
		if("".equals(ipVdi)) {
			return false;
		}else {
			return true;
		}
		
	}

}
