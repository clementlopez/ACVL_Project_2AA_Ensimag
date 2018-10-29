import java.util.Scanner;

public class Attribut {
	String type;
    String nom;

    public Attribut(String nom) {
        this.nom = nom;
    }

    public void menu(Scanner sc) {
    	int choix = -1;
        String reponseUser;
        while (choix != 0) {
            afficherOptionsMenu();
            reponseUser = sc.nextLine();
			if(reponseUser.matches("^[0-3]$")){
				choix = Integer.parseInt(reponseUser);
	            switch (choix) {
		            case 1:
		                System.out.println("Vous avez saisi : choix 1");
		                System.out.println("Comment voulez vous appeler cet attribut");
		                renommer(sc);
		                break;
		            case 2:
		                System.out.println("Vous avez saisi : choix 2");
		                break;
		            case 3:
		                System.out.println("Vous avez saisi : choix 3");
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
        System.out.println("** Menu Attribut **");
        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Rennomer l'attribut");
        System.out.println("2- Definir le type de l'attribut");
        System.out.println("3- Definir la valeur par defaut de l'attribut");

    }

    private void renommer(Scanner sc){
    	String str = "";
        while(str.equals("")){
        	str = sc.nextLine();
        }
        setNom(str);
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void afficher(){
    	System.out.print("\t\t\t\t " + getType() + " " + getNom());
    }
}
