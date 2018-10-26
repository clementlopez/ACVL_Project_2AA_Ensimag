import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methode {
	String nom;
	String typeRetour = "non defini";
	List<Parametre> listeParametres;

	public Methode(String nom) {
		this.nom = nom;
		listeParametres = new ArrayList<>();
	}
	public void menu() {

		afficherOptionsMenu();

		int choix;
		Scanner sc = new Scanner(System.in);
		choix = sc.nextInt();

		switch (choix) {

			case 1:
				System.out.println("Vous avez saisi : choix 1");
				creerNouveauParametre();
				break;
			case 2:
				System.out.println("Vous avez saisi : choix 2");
				afficherParametres();
				break;
			case 3:
				System.out.println("Vous avez saisi : choix 3");
				choixParametre().menu();
				break;
			case 4:
				System.out.println("Vous avez saisi : choix 4");
				//TODO
				break;
			case 5:
				System.out.println("Vous avez saisi : choix 5");
				break;
			case 6:
				System.out.println("Vous avez saisi : choix 6");
				break;
			case 7:
				System.out.println("Vous avez saisi : choix 7");
				break;
			case 8:
				System.out.println("Vous avez saisi : choix 8");
				break;
			default:
		}
	}
	private void afficherOptionsMenu() {
		System.out.println("** Menu Méthode **");

		System.out.println("Que voulez vous faire ?");
		System.out.println("0- Quitter");
		System.out.println("1- Créer un nouveau paramètre");
		System.out.println("2- Voir les paramètres existants");
		System.out.println("3- Modifier les paramètres existants");
		System.out.println("4- Supprimer un paramètre existant");
		System.out.println("5- Ajouter un type de retour");
		System.out.println("6- Modifier le type de retour existant");
		System.out.println("7- Supprimer le type de retour existant");
		System.out.println("8- Renommer la méthode");//TODO
	}
	private void creerNouveauParametre(){
		System.out.println("Donner un nom à votre attribut");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Parametre p = new Parametre(str);
		this.listeParametres.add(p);
		p.menu(); //todo ça devrait peut être pas être là
	}

	public Parametre choixParametre(){
		System.out.println("** Choix d'une Classe **");
		for (int i=0; i<listeParametres.size(); i++){
			System.out.print(i + " - " + listeParametres.get(i).getNom() );
		}
		int choix;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Lequel voulez vous choisir ?");

			choix = sc.nextInt();
		}while(choix > listeParametres.size());
		System.out.println("Vous avez choisi le parametre " + listeParametres.get(choix).getNom());

		return listeParametres.get(choix);
	}

	public void afficherParametres () {
		System.out.println("** Parametres de la  Methode"+ this.getNom() +"**");
		//TODO
	}


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTypeRetour() {
		return typeRetour;
	}
	public void setTypeRetour(String typeRetour) {
		this.typeRetour = typeRetour;
	}
	public List<Parametre> getListeParametres() {
		return listeParametres;
	}
	public void setListeParametres(List<Parametre> listeParametres) {
		this.listeParametres = new ArrayList<Parametre>(listeParametres);
	}
	
	
}
