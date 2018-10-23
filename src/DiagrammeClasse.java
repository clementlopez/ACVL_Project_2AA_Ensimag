import java.util.ArrayList;
import java.util.Scanner;

public class DiagrammeClasse {
    String name;
    ArrayList<ClasseAbstraite> classes;

    public DiagrammeClasse() {
        Scanner sc = new Scanner(System.in);
        this.name = sc.nextLine();
    }

    public void menu(){


        int choix;
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();

        switch (choix){
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
    private void creerNouvelleClasse(){
        Classe c = new Classe();
        c.menu();
    }
    private void afficherOptionsMenu() {
        System.out.println("** Menu Classe **");

        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Créer une nouvelle classe");
        System.out.println("2- Voir les classes existantes");
        System.out.println("3- Modifier les classes existantes");
        System.out.println("4- Supprimer une classe existante");
        System.out.println("5- Créer une nouvelle association");
        System.out.println("6- Voir les associations existantes");
        System.out.println("7- Modifier les associations existantes");
        System.out.println("8- Supprimer une association existante");

    }

    public String getName() {
        return name;
    }

    public void afficher () {
        System.out.println("** Diagramme de Classes"+ this.getName() +"**");
        //TODO
    }

}

