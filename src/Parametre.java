import java.util.List;
import java.util.Scanner;

public class Parametre {
	String nom;
	String type;
	String valInit;

	public Parametre(String nom) {
		super();
		this.nom = nom;
		this.valInit = "";
		this.type = "";
	}

	public void menu(Scanner sc, List<String> listeTypes) {
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
						System.out.println("Comment voulez vous appeler ce parametre");
						String str;
						str = sc.nextLine();
						setNom(str);
						break;
					case 2:
						System.out.println("Vous avez saisi : choix 2");
						definirType(sc, listeTypes);
						break;
					case 3:
						if(getType().equals("String")||getType().equals("int")||getType().equals("float")||getType().equals("boolean")) {
							System.out.println("Vous avez saisi : choix 3");
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

	private void afficherOptionsMenu() {
		System.out.println("########################");
		System.out.println("** Menu Parametre **");

		System.out.println("Que voulez vous faire ?");
		System.out.println("0- Quitter");
		System.out.println("1- Rennomer le parametre");
		System.out.println("2- Definir le type du parametre");
		if(getType().equals("String")||getType().equals("int")||getType().equals("float")||getType().equals("boolean")) {
			System.out.println("3- Definir la valeur par defaut du parametre");
		}
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

	public String getValInit() {
		return valInit;
	}

	public void setValInit(String valInit) {
		this.valInit = valInit;
	}

	public void afficher() {
		System.out.println(getType() + " " + getNom());
		if(!getValInit().equals("")) {
    		System.out.print(" = " + getValInit());
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
