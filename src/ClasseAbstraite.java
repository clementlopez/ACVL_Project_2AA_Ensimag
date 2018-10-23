import java.util.Scanner;

public class ClasseAbstraite {
    public void menu(){
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

        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        switch (str){
            case "1":
                System.out.println("Vous avez saisi : choix 1");
                break;
            case "2":
                System.out.println("Vous avez saisi : choix 2");
                break;
            case "3":
                System.out.println("Vous avez saisi : choix 3");
                break;
            case "4":
                System.out.println("Vous avez saisi : choix 4");
                break;
            case "5":
                System.out.println("Vous avez saisi : choix 5");
                break;
            case "6":
                System.out.println("Vous avez saisi : choix 6");
                break;
            case "7":
                System.out.println("Vous avez saisi : choix 7");
                break;
            case "8":
                System.out.println("Vous avez saisi : choix 8");
                break;
            default:
        }
    }
}
