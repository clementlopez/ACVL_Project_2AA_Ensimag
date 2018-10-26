import java.util.Scanner;

public class Attribut {
	TypeAttribut type;
    String nom;

    public Attribut(String nom) {
        this.nom = nom;
    }

    public void menu() {

        afficherOptionsMenu();

        int choix;
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();

        switch (choix) {
            case 1:
                System.out.println("Vous avez saisi : choix 1");
                System.out.println("Comment voulez vous appeler cet attribut");
                String str;
                str = sc.nextLine();
                setNom(str);
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
        System.out.println("1- Rennomer l'attribut");
        System.out.println("2- Définir le type de l'attribut");
        System.out.println("3- Définir la valeur par defaut de l'attribut");

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
