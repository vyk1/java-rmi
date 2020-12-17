package jrmi;

import java.rmi.*;

public interface HelloRemoteInterface extends Remote {
	public String hello(String name, String message) throws RemoteException;
}