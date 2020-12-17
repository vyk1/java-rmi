package jrmi;

import java.rmi.*;
import java.rmi.server.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloServer extends UnicastRemoteObject implements HelloRemoteInterface {
	private static final long serialVersionUID = 1L;

	public HelloServer() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
		try {
			Naming.rebind("//localhost/HS", new HelloServer());
			System.out.println("Servidor pronto");
		} catch (Exception ex) {
			System.err.println("Ops");
			ex.printStackTrace();
		}
	}

	@Override
	public String hello(String name, String message) {
		try {
			System.out.println("Teste");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("' no dia ' dd/MM/yyyy ' às ' HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String concated = name + " disse " + message + dtf.format(now);
			System.out.println(concated);
			return concated;
		} catch (Exception e) {
			System.err.println("Ops");
			e.printStackTrace();
			return "Ocorreu um erro";
		}

	}

}