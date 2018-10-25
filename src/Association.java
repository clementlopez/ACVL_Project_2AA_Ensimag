import java.util.Scanner;

public class Association {
    private String name;

    public String getName() {
        return name;
    }

    public Association() {
        this.name = "Anonyme";
    }

    public void menu() {

        //TODO
        afficherOptionsMenu();

        int choix;
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();

        switch (choix) {
            case 1:
                System.out.println("Vous avez saisi : choix 1");
                break;
            default:
                break;
        }
    }
    void afficherOptionsMenu(){

        System.out.println("** Menu Association **");

        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Rennomer l'association");
        System.out.println("3- Modifier la navigabilité de l'association");
        System.out.println("4- Modifier la multiplicité de l'association");
    };

}
