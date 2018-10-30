import java.util.List;
import java.util.Scanner;

public class Attribut {
	String type;
    String nom;
    String visibilite;
    String valInit;

    public Attribut(String nom) {
        this.nom = nom;
        this.visibilite = "public";
        this.valInit = "";
        this.type = "";
    }

    public void menu(Scanner sc, List<String> listeTypes) {
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
		                System.out.println("Comment voulez vous appeler cet attribut");
		                renommer(sc);
		                break;
		            case 2:
		                System.out.println("Vous avez saisi : choix 2");
		                definirType(sc, listeTypes);
		                break;
		            case 3:
		                System.out.println("Vous avez saisi : choix 3");
		                definirVisibilite(sc);
		                break;
		            case 4:
		            	if(getType().equals("String")||getType().equals("int")||getType().equals("float")||getType().equals("boolean")) {
							System.out.println("Vous avez saisi : choix 4");
							donnerValInit(sc);
						}
						else {
							System.out.println("Merci de saisir un choix du menu");
						}
		            	break;
		          default:
		        }
			}
			else {
				System.out.println("Merci de saisir un choix du menu");
			}
    	}
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

	private void afficherOptionsMenu() {
		System.out.println("########################");
        System.out.println("** Menu Attribut **");
        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Rennomer l'attribut");
        System.out.println("2- Definir le type de l'attribut");
        System.out.println("3- Definir la visibilite de l'attribut");
        if(getType().equals("String")||getType().equals("int")||getType().equals("float")||getType().equals("boolean")) {
        	System.out.println("4- Definir la valeur par defaut de l'attribut");
		}
    }
    
    private void definirType(Scanner sc, List<String> listeTypes) {
    	System.out.println("Quel Type voulez-vous donner à cet attribut ?");
    	for(int i=0; i < listeTypes.size(); i++) {
    		System.out.println(i + "- " + listeTypes.get(i));
    	}
    	int choix;
        do {
            System.out.println("Lequel voulez vous choisir ?");
            choix = Integer.parseInt(sc.nextLine());
        } while (choix >= listeTypes.size());
        setType(listeTypes.get(choix));
        setValInit("");
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
    public String getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(String visibilite) {
		this.visibilite = visibilite;
	}

	public String getValInit() {
		return valInit;
	}

	public void setValInit(String valInit) {
		this.valInit = valInit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void afficher(){
    	System.out.print("\t\t\t\t " + getVisibilite() + " " + getType() + " " + getNom());
    	if(!getValInit().equals("")) {
    		System.out.println(" = " + getValInit());
    	}
    	else {
    		System.out.println();
    	}
    }
	
	private void donnerValInit(Scanner sc) {
		boolean bonType = false;
		String str = "";
		while(!bonType) {
			System.out.println("Quelle valeur voulez-vous donner ?");
			str = sc.nextLine();
			if(getType().equals("String")) {
				setValInit(str);
				bonType = true;
			}
			else if(getType().equals("int")) {
				if(str.matches("^(-|\\+)?[0-9]+$")) {
					setValInit(str);
					bonType = true;
				}
			}
			else if(getType().equals("float")) {
				if(str.matches("^(-|\\+)?[0-9]+(\\.[0-9]+)?$")) {
					setValInit(str);
					bonType = true;
				}
			}
			else if(getType().equals("boolean")) {
				if(str.equals("true")||str.equals("false")) {
					setValInit(str);
					bonType = true;
				}
			}
			if(!bonType) {
				System.out.println("La valeur donnée n'est pas du type " + getType() + " du paramètre");
			}
		}
	}
}
