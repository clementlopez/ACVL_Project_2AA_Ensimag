import java.util.Scanner;

public class Parametre {
	String nom;
	String type;
	String valInit;
	
	public Parametre(String nom) {
		super();
		this.nom = nom;
	}
	
	public void menu(Scanner sc) {
		int choix = -1;
    	while(choix!=0){
			afficherOptionsMenu();
			choix = sc.nextInt();
	
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
					//TODO
					break;
				case 3:
					System.out.println("Vous avez saisi : choix 3");
					//TODO attention, defini automatiquement le type
					break;
				default:
			}
    	}
	}
	private void afficherOptionsMenu() {
		System.out.println("** Menu Parametre **");

		System.out.println("Que voulez vous faire ?");
		System.out.println("0- Quitter");
		System.out.println("1- Rennomer le parametre");
		System.out.println("2- Definir le type du parametre");
		System.out.println("3- Definir la valeur par defaut du parametre");
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
	
}
