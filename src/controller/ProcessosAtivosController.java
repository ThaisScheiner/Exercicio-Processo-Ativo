package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosAtivosController 
{
	 public ProcessosAtivosController()
	 {
		 super();
	 }
	 
	public String os()
	{
		String os = System.getProperty("os.name");
		
		return os;
	}
	
	@SuppressWarnings("unused")
	public void killProcess(String param)
	{
		String cmdPid = "TASKKILL /PID";
		String cmdNome = "TASKKILL /IM";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		try
		{
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
		}
		catch(NumberFormatException e)
		{
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		}
		callProcess(buffer.toString());
		
	}
	
	
	

	public void readProcess(String processo)
	{
		try
		{
			Process p = Runtime.getRuntime().exec(processo); 
			InputStream fluxo = p.getInputStream(); 
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine(); 
			
			while(linha != null)
			{
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void callProcess(String processo)
	{
		try
		{
			Runtime.getRuntime().exec(processo);
		}
		catch(IOException e)
		{
			String erro = e.getMessage();
			if(erro.contains("2"))
			{
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(processo);
				
				try{
					Runtime.getRuntime().exec(buffer.toString());
				}catch(IOException e1){
					e1.printStackTrace();
				}
				
			}
			else
			{
				e.printStackTrace();
			}
			
			
		}
	
	}
	 
}
