import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methode {
	String nom;
	String typeRetour = "non defini";
	List<Parametre> listeParametres;
	String visibilite;

	public Methode(String nom) {
		this.nom = nom;
		listeParametres = new ArrayList<>();
		this.visibilite = "public";
	}

	public void menu(Scanner sc, List<String> listeTypes) {
		int choix = -1;
        String reponseUser;
        while (choix != 0) {
            afficherOptionsMenu();
            reponseUser = sc.nextLine();
			if(reponseUser.matches("^[0-8]$")){
				choix = Integer.parseInt(reponseUser);

				switch (choix) {
					case 1:
						System.out.println("Vous avez saisi : choix 1");
						creerNouveauParametre(sc, listeTypes);
						break;
					case 2:
						System.out.println("Vous avez saisi : choix 2");
						afficherParametres();
						break;
					case 3:
						System.out.println("Vous avez saisi : choix 3");
						if(listeParametres.size() >= 1){
							choixParametre(sc).menu(sc, listeTypes);
						}else {
							System.out.println("Aucune methode");
						}
						break;
					case 4:
						System.out.println("Vous avez saisi : choix 4");
						if(listeParametres.size() >= 1){
							supprimerParametre(sc);
						}else {
							System.out.println("Aucune methode");
						}
						break;
					case 5:
						System.out.println("Vous avez saisi : choix 5");
						definirTypeRetour(sc, listeTypes);
						break;
					case 6:
						System.out.println("Vous avez saisi : choix 6");
						setTypeRetour("non d�fini");
						System.out.println("Cette methode n'a plus de type de retour");
						break;
					case 7:
						System.out.println("Vous avez saisi : choix 7");
						renommer(sc);
						break;
					case 8:
						System.out.println("Vous avez saisi : choix 8");
						definirVisibilite(sc);
						break;
					default:
				}
			}
			else {
				System.out.println("Merci de saisir un choix du menu");
			}
		}
	}

	private void afficherOptionsMenu() {
		System.out.println("########################");
		System.out.println("** Menu Methode **");

		System.out.println("Que voulez vous faire ?");
		System.out.println("0- Quitter");
		System.out.println("1- Creer un nouveau parametre");
		System.out.println("2- Voir les parametres existants");
		System.out.println("3- Modifier les parametres existants");
		System.out.println("4- Supprimer un parametre existant");
		System.out.println("5- Modifier le type de retour");
		System.out.println("6- Supprimer le type de retour");
		System.out.println("7- Renommer la methode");
		System.out.println("8- Definir la visibilite de la methode");
	}

	private void creerNouveauParametre(Scanner sc, List<String> listeTypes) {
		System.out.println("Donner un nom a votre parametre");
		String str = sc.nextLine();
		Parametre p = new Parametre(str);
		this.listeParametres.add(p);
		p.menu(sc, listeTypes);
	}

	public Parametre choixParametre(Scanner sc) {
		System.out.println("** Choix d'un Parametre **");
		for (int i = 0; i < listeParametres.size(); i++) {
			System.out.println(i + " - " + listeParametres.get(i).getNom());
		}
		int choix;
		do {
			System.out.println("Lequel voulez vous choisir ?");

			choix = Integer.parseInt(sc.nextLine());
		} while (choix > listeParametres.size());
		System.out.println("Vous avez choisi le parametre " + listeParametres.get(choix).getNom());

		return listeParametres.get(choix);
	}

	public void afficherParametres() {
		System.out.println("** Parametres de la  Methode " + this.getNom() + " **");
		for (Parametre param : listeParametres) {
			param.afficher();
		}
	}
	
	private void definirTypeRetour(Scanner sc, List<String> listeTypes) {
    	System.out.println("Quel Type voulez-vous donner � cet attribut ?");
    	for(int i=0; i < listeTypes.size(); i++) {
    		System.out.println(i + "- " + listeTypes.get(i));
    	}
    	int choix;
        do {
            System.out.println("Lequel voulez vous choisir ?");
            choix = Integer.parseInt(sc.nextLine());
        } while (choix >= listeTypes.size());
        setTypeRetour(listeTypes.get(choix));
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(String visibilite) {
		this.visibilite = visibilite;
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

	private void supprimerParametre(Scanner sc) {
		Parametre param = choixParametre(sc);
		listeParametres.remove(param);
		System.out.println("Le parametre " + param.getNom() + " a bien ete supprime");
	}

	public void afficher() {
		System.out.print("\t\t\t\t " + getVisibilite() + " " + getNom() + "(");
		for (int i = 0; i < listeParametres.size(); i++) {
			System.out.print(listeParametres.get(i).getNom());
			if (i < listeParametres.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.print(")");
		if (!typeRetour.equals("non defini")) {
			System.out.println(" : " + typeRetour);
		}
	}
	
	public void repercuterModifNomClasse(String ancienNomClasse, String nouveauNomClasse) {
    	if(getTypeRetour().equals(ancienNomClasse)) {
    		setTypeRetour(nouveauNomClasse);
    	}
        for (Parametre param : listeParametres) {
        	if(param.getType().equals(ancienNomClasse)) {
        		param.setType(nouveauNomClasse);
        	}
        }
    }

	private void renommer(Scanner sc) {
		String str = "";
		while (str.equals("")) {
			str = sc.nextLine();
		}
		setNom(str);
	}
	
	private void definirVisibilite(Scanner sc) {
    	System.out.println("Quel visibilite voulez-vous ?");
    	System.out.println("0- public");
    	System.out.println("1- private");
    	System.out.println("2- protected");
    	int choix = -1;
        String reponseUser;
        while (choix == -1) {
            reponseUser = sc.nextLine();
            System.out.println(reponseUser);
			if(reponseUser.matches("^[0-2]$")){
				choix = Integer.parseInt(reponseUser);
				switch(choix) {
				case 0:
					setVisibilite("public");
					break;
				case 1:
					setVisibilite("private");
					break;
				case 2:
					setVisibilite("protected");
					break;
				}
			}
			else {
				System.out.println("Veuillez selectionner un des 3 types de visibilite");
			}
        }
        System.out.println("Le type de visibilite a bien ete modifie");
	}
}
