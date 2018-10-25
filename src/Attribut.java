import java.util.Scanner;

public class Attribut {
	TypeAttribut type;
	String nom;

    public Attribut(String nom) {
        this.nom = nom;
    }

    public void menu() {

        int choix;
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();

        switch (choix) {
            case 1:
                System.out.println("Vous avez saisi : choix 1");
                break;
            case 2:
                System.out.println("Vous avez saisi : choix 2");
                break;
            case 3:
                System.out.println("Vous avez saisi : choix 3");
                break;
            case 4:
                System.out.println("Vous avez saisi : choix 4");
                break;
          default:
        }
    }
    private void afficherOptionsMenu() {
        System.out.println("** Menu Attribut **");

        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Créer un nouvel attribut");
        System.out.println("2- Voir les attributs existants");
        System.out.println("3- Modifier les attributs existants");

    }

    public String getNom() {
        return nom;
    }
}
