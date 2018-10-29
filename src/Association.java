import java.util.Scanner;

public class Association {
    private String nom;
    Classe origine;
    Classe extremite;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
    }

    public void menu(Scanner sc) {
        int choix = -1;
        while (choix != 0) {
            afficherOptionsMenu();
            choix = Integer.parseInt(sc.nextLine());
            switch (choix) {
            case 1:
                System.out.println("Vous avez saisi : choix 1");
                System.out.println("Comment voulez vous appeler cette association");
                renommer(sc);
                break;
            case 2:
                System.out.println("Vous avez saisi : choix 2");
                break;
            case 3:
                System.out.println("Vous avez saisi : choix 3");
                break;
            default:
                break;
            }
        }
    }

    void afficherOptionsMenu() {
        System.out.println("** Menu Association **");
        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Rennomer l'association");
        System.out.println("2- Modifier la navigabilite de l'association");
        System.out.println("3- Modifier la multiplicite de l'association");
    }

    private void renommer(Scanner sc) {
        String str = "";
        while (str.equals("")) {
            str = sc.nextLine();
        }
        setNom(str);
    }

    public void afficher() {
        System.out.println("\t\t- " + getNom());
        System.out.println("\t\t\tEntre " + getOrigine().getNom());
        System.out.println("\t\t\tEt " + getExtremite().getNom());
    }
}
