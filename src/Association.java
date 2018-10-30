import java.util.Scanner;

public class Association {
    private String nom;
    Classe origine;
    Classe extremite;
    boolean estNavigable;
    String typeAssociation;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeAssociation() {
		return typeAssociation;
	}

	public void setTypeAssociation(String typeAssociation) {
		this.typeAssociation = typeAssociation;
	}

	public boolean isEstNavigable() {
		return estNavigable;
	}

	public void setEstNavigable(boolean estNavigable) {
		this.estNavigable = estNavigable;
	}

	public Classe getOrigine() {
        return origine;
    }

    public Classe getExtremite() {
        return extremite;
    }

    public Association(Classe mOrigine, Classe mExtremite) {
        this.nom = "Anonyme";
        this.origine = mOrigine;
        this.extremite = mExtremite;
        this.estNavigable = true;
        this.typeAssociation = "Association";
    }

    public void menu(Scanner sc) {
    	int choix = -1;
        String reponseUser;
        while (choix != 0) {
            afficherOptionsMenu();
            reponseUser = sc.nextLine();
			if(reponseUser.matches("^[0-4]$")){
				choix = Integer.parseInt(reponseUser);
	            switch (choix) {
		            case 1:
		                System.out.println("Vous avez saisi : choix 1");
		                System.out.println("Comment voulez vous appeler cette association");
		                renommer(sc);
		                break;
		            case 2:
		                System.out.println("Vous avez saisi : choix 2");
		                changeNavigabilite();
		                break;
		            case 3:
		                System.out.println("Vous avez saisi : choix 3");
		                System.out.println("Non implemente");
		                break;
		            case 4:
		                System.out.println("Vous avez saisi : choix 4");
		                changerTypeAsso(sc);
		                break;
		            default:
		                break;
	            }
			}
			else {
				System.out.println("Merci de saisir un choix du menu");
			}
        }
    }

    void afficherOptionsMenu() {
    	System.out.println("########################");
        System.out.println("** Menu Association **");
        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Rennomer l'association");
        if(isEstNavigable()) {
        	System.out.println("2- Rendre l'association navigable en sens unique");
        }
        else {
        	System.out.println("2- Rendre l'association navigable en double sens");
        }
        System.out.println("3- Modifier la multiplicite de l'association");
        System.out.println("4- Modifier le type d'association");
    }

    private void renommer(Scanner sc) {
        String str = "";
        while (str.equals("")) {
            str = sc.nextLine();
        }
        setNom(str);
    }

    public void afficher() {
        System.out.println("\t\t- " + getNom() + " est une " + getTypeAssociation());
        if (isEstNavigable()) {
            System.out.println("\t\tNavigable en double sens");
        } else {
            System.out.println("\t\tNavigable en sens unique");
        }
        System.out.println("\t\t\tEntre " + getOrigine().getNom());
        System.out.println("\t\t\tEt " + getExtremite().getNom());
    }
    
    private void changeNavigabilite() {
        setEstNavigable(!isEstNavigable());
        if (isEstNavigable()) {
            System.out.println("L'association " + getNom() + " est desormais navigable en double sens");
        } else {
            System.out.println("L'association " + getNom() + " n'est desormais navigable qu'en sens unique");
        }
    }
    
    private void changerTypeAsso(Scanner sc) {
    	System.out.println("Quel type voulez-vous ?");
    	System.out.println("0- Association");
    	System.out.println("1- Aggregation");
    	System.out.println("2- Composition");
    	int choix = -1;
        String reponseUser;
        while (choix == -1) {
            reponseUser = sc.nextLine();
            System.out.println(reponseUser);
			if(reponseUser.matches("^[0-2]$")){
				choix = Integer.parseInt(reponseUser);
				switch(choix) {
				case 0:
					setTypeAssociation("Association");
					break;
				case 1:
					setTypeAssociation("Aggregation");
					break;
				case 2:
					setTypeAssociation("Composition");
					break;
				}
			}
			else {
				System.out.println("Veuillez selectionner un des 3 types d'association");
			}
        }
        System.out.println("Le type d'association a bien ete modifie");
    }
}
