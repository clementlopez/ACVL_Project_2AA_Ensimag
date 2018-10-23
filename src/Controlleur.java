import java.util.Scanner;
import java.util.ArrayList;

public class Controlleur {
    private ArrayList<DiagrammeClasse>  listeDiagrammeClasse;

    public Controlleur() {

    }
    public void play(){
       afficherOptionsMenu();


        int choix;
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();

        switch (choix){
            case 1:
                System.out.println("Vous avez saisi : choix 1");
                crerNouveauDiagrammeDeClasse();
                break;
            case 2:
                System.out.println("Vous avez saisi : choix 2");
                afficherDiagrammes();
                break;
            case 3:
                System.out.println("Vous avez saisi : choix 3");
                choixDiagrammeDeClasse().menu();
                break;
            case 4:
                System.out.println("Vous avez saisi : choix 4");
                //TODO
                break;
            default:
        }
    }
    private void crerNouveauDiagrammeDeClasse(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        DiagrammeClasse d = new DiagrammeClasse(str);
        this.listeDiagrammeClasse.add(d);
        d.menu();
    }
    private void afficherOptionsMenu(){
        System.out.println("** Menu Diagramme de Classe **");
        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Créer un nouveau diagramme de classes");
        System.out.println("2- Voir les diagrammes de classes existants");
        System.out.println("3- Modifier les diagrammes de classes existants");
        System.out.println("4- Supprimer un diagramme de classes existant");
    }
    public void afficherDiagrammes(){
        for (int i=0; i<listeDiagrammeClasse.size(); i++){
            listeDiagrammeClasse.get(i).afficher();
        }
    }
    public DiagrammeClasse choixDiagrammeDeClasse(){
        System.out.println("** Choix d'un Diagramme de Classe **");
        for (int i=0; i<listeDiagrammeClasse.size(); i++){
            System.out.print(i + " - " + listeDiagrammeClasse.get(i).getName() );
        }
        int choix;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Lequel voulez vous choisir ?");

            choix = sc.nextInt();
        }while(choix > listeDiagrammeClasse.size());

        return listeDiagrammeClasse.get(choix);

    }
}
