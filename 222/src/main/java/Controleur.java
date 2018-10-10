
public class Controleur {
	
	public static void main(String args[]) {
		String file="";
		if(args.length>0) {
		//recupere la requete du client
			file=args[0];
		//recupere les capacites et IP des serveurs
			RepertoireNoms repertoireNoms= new RepertoireNoms();
			repertoireNoms.ajouterRepartiteur("repartiteur","tp2");
			int nombreServeurs=repertoireNoms.getNombreServeurs();
			String[] IpServeurs=new String[nombreServeurs];
			IpServeurs=repertoireNoms.getIpServeurs();
			int[] CapaciteServeurs=new int[nombreServeurs];
			CapaciteServeurs=repertoireNoms.getCapaciteServeurs();
			
		//diviser le travail selon la capacite des serveurs
			Travail travail=new Travail(file);
			String[] fichiersEnvoyesAuxServeurs= new String[nombreServeurs];
			fichiersEnvoyesAuxServeurs=travail.diviser(CapaciteServeurs);//retourne les noms des fichiers crees, cad un tableau de strings
			
		//communique avec les serveurs(donnee le travail a faire)
			Communication communication=new Communication(IpServeurs, fichiersEnvoyesAuxServeurs);//cet objet est responsable pour cree les threads
			int result= communication.getResult();
			
		}
		else {
			System.out.println("Vous devez donner le fichier de donnees comme argument.");
		}
	}
}
