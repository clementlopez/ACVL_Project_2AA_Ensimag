import java.util.Scanner;

public class Controlleur {
    public Controlleur() {

    }
    public void play(){
        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Créer un nouveau diagramme de classes");
        System.out.println("2- Voir les diagrammes de classes existants");
        System.out.println("3- Modifier les diagrammes de classes existants");
        System.out.println("4- Supprimer les diagrammes de classes existants");


        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        switch (str){
            case "1":
                System.out.println("Vous avez saisi : choix 1");
                createNewDiagrammeDeClasse();
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
            default:
        }
    }
    private void createNewDiagrammeDeClasse(){
        new DiagrammeClasse();
    }
}
