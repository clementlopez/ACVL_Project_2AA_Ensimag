import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlleur {
    private List<DiagrammeClasse> listeDiagrammeClasse;

    public Controlleur() {
        listeDiagrammeClasse = new ArrayList<>();

    }
    public void play(){
    	int choix = -1;
    	Scanner sc = null;
    	while(choix!=0){
	       afficherOptionsMenu();
	        sc = new Scanner(System.in);
	        choix = sc.nextInt();
	       
	        switch (choix){
	        	case 1:
	                System.out.println("Vous avez saisi : choix 1");
	                crerNouveauDiagrammeDeClasse(sc);
	                break;
	            case 2:
	                System.out.println("Vous avez saisi : choix 2");
	                afficherDiagrammes();
	                break;
	            case 3:
	            	System.out.println("Vous avez saisi : choix 3");
	                choixDiagrammeDeClasse(sc).menu(sc);
	                break;
	            case 4:
	                System.out.println("Vous avez saisi : choix 4");
                    System.out.println("Non implementes");
                    //TODO
	                break;
	            default:
    		}
    	}
    }
    private void crerNouveauDiagrammeDeClasse(Scanner sc){
        System.out.println("** Creation d'un diagramme de classe **");
        System.out.println("Donner un nom a votre diagramme de classe");
    	String str = "";
        while(str.equals("")){
        	str = sc.nextLine();
        }
        DiagrammeClasse d = new DiagrammeClasse(str);
        this.listeDiagrammeClasse.add(d);
        d.menu(sc);
    }
    
    private void afficherOptionsMenu(){
        System.out.println("** Menu Diagramme de Classe **");
        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Crer un nouveau diagramme de classes");
        System.out.println("2- Voir les diagrammes de classes existants");
        System.out.println("3- Modifier les diagrammes de classes existants");
        System.out.println("4- Supprimer un diagramme de classes existant");
    }
    
    public void afficherDiagrammes(){
        System.out.println("** Diagrammes de classe **");
        for (int i=0; i<listeDiagrammeClasse.size(); i++){
            listeDiagrammeClasse.get(i).afficher();
        }
    }
    
    public DiagrammeClasse choixDiagrammeDeClasse(Scanner sc){
        System.out.println("** Choix d'un Diagramme de Classe **");
        for (int i=0; i<listeDiagrammeClasse.size(); i++){
            System.out.println(i + " - " + listeDiagrammeClasse.get(i).getNom() );
        }
        int choix;
        do{
            System.out.println("Lequel voulez vous choisir ?");
            choix = sc.nextInt();
        }while(choix > listeDiagrammeClasse.size());

        return listeDiagrammeClasse.get(choix);

    }
}
