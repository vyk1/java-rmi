package jrmi;

import java.rmi.*;

public interface HelloWorld extends Remote {
	public String hello() throws RemoteException;
}