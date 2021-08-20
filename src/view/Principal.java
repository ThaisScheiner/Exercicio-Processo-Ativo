package view;

import controller.ProcessosAtivosController;

public class Principal 
{

	public static void main(String[] args) 
	{
		ProcessosAtivosController pCont = new ProcessosAtivosController();
		
		String os = pCont.os();
		System.out.println("Sistema Operacional: " + os);
		
		//String process = "notepad.exe";
		//pCont.callProcess(process);
		
		//String processLer = "TASKLIST /FO TABLE";
		//pCont.readProcess(processLer);
		
		//pega o ping do servidor do uol
		String process = "ping -4 -n 10 www.google.com.br";
		pCont.readProcess(process);
		
		//Rota dos ips dos servidores da maquina local ate o do uol
		//String process = "tracert www.uol.com.br";
		//pCont.readProcess(process);
		
		//String param = "notepad.exe";
		//pCont.killProcessPID(param);
		
		//String param = "16048";
		//pCont.killProcess(param);

	}

}
