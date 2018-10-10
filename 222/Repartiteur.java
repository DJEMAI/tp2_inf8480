import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Repartiteur { 
	private String[][] hostnames;
	private String file="hostnames.txt";
	public static void main(String[] args) {
		String file =arg[0];
		Repartiteur repartiteur=New Repartiteur();
		//a verifier, comment recuperer la capacite et addrr IP de chaque serveur
		String[] hostnames=repartiteur.hostnames(file);
		int[] capacites_hosts=repartiteur.decouper(file, )
		foreach server in hostnames{
			 
			 (new A(server)).start();
		}
		
	}
	//retourne la taille de la charge donnee a chaque serveur 
	private int[] decouper(String file, int capacite_host) {
		
	}
	
	public Repartiteur(String file) {
		
	}
	private String[] hostnames() {
		
	}
	private ServerInterface loadserverstub(String hostname) {
		
	}
	
	
}
class A implements Runnable {
	int server_capacite;
	A(int server_capacite) {
		this.server_capacite = server_capacite;
	}
	public void run() {
		
	}
	
	private ServerInterface loadServerStub(String hostname) {
		ServerInterface stub = null;

		try {
			Registry registry = LocateRegistry.getRegistry(hostname);
			stub = (ServerInterface) registry.lookup("server");
		} catch (NotBoundException e) {
			System.out.println("Erreur: Le nom '" + e.getMessage()
					+ "' n'est pas défini dans le registre.");
		} catch (AccessException e) {
			System.out.println("Erreur: " + e.getMessage());
		} catch (RemoteException e) {
			System.out.println("Erreur: " + e.getMessage());
		}

		return stub;
	}

}