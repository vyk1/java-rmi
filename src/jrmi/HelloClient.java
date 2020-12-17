package jrmi;

import java.rmi.Naming;

import javax.swing.JOptionPane;

public class HelloClient {
	private static HelloRemoteInterface look_up;

	public static void main(String[] args) {
		try {
			// Obtém uma referência para o registro do RMI
			look_up = (HelloRemoteInterface) Naming.lookup("//localhost/HS");
			
			String name = JOptionPane.showInputDialog("Um nome");

			String message = JOptionPane.showInputDialog("Uma mensagem");

			String response = look_up.hello(name, message);
			System.out.println(response);
			JOptionPane.showMessageDialog(null, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}