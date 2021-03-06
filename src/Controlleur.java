import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlleur {
    private List<DiagrammeClasse> listeDiagrammeClasse;

    public Controlleur() {
        listeDiagrammeClasse = new ArrayList<>();
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        int choix = -1;
        String reponseUser;
        while (choix != 0) {
            afficherOptionsMenu();
            reponseUser = sc.nextLine();
			if(reponseUser.matches("^[0-4]$")){
				choix = Integer.parseInt(reponseUser);

	            switch (choix) {
	            case 1:
	                System.out.println("Vous avez saisi : choix 1");
	                creerNouveauDiagrammeDeClasse(sc);
	                break;
	            case 2:
	                System.out.println("Vous avez saisi : choix 2");
	                afficherDiagrammes();
	                break;
	            case 3:
	                System.out.println("Vous avez saisi : choix 3");
	                if(listeDiagrammeClasse.size() >= 1){
	                    choixDiagrammeDeClasse(sc).menu(sc);
	                }else {
	                    System.out.println("Aucune methode");
	                }
	                break;
	            case 4:
	                System.out.println("Vous avez saisi : choix 4");
	                if(listeDiagrammeClasse.size() >= 1){
	                    supprimerDiagrammeClasse(sc);
	                }else {
	                    System.out.println("Aucune methode");
	                }
	                break;
	            default:
	            }
			}
			else {
				System.out.println("Merci de saisir un choix du menu");
			}
        }
        sc.close();
    }

    private void creerNouveauDiagrammeDeClasse(Scanner sc) {
        System.out.println("** Creation d'un diagramme de classe **");
        System.out.println("Donner un nom a votre diagramme de classe");
        String str = "";
        while (str.equals("")) {
            str = sc.nextLine();
        }
        DiagrammeClasse d = new DiagrammeClasse(str);
        this.listeDiagrammeClasse.add(d);
        d.menu(sc);
    }

    private void afficherOptionsMenu() {
    	System.out.println("########################");
        System.out.println("** Menu Controlleur **");
        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Creer un nouveau diagramme de classes");
        System.out.println("2- Voir les diagrammes de classes existants");
        System.out.println("3- Modifier les diagrammes de classes existants");
        System.out.println("4- Supprimer un diagramme de classes existant");
    }

    public void afficherDiagrammes() {
        System.out.println("** Diagrammes de classe **");
        for (int i = 0; i < listeDiagrammeClasse.size(); i++) {
        	System.out.println("________________________");
            listeDiagrammeClasse.get(i).afficher();
        }
    }

    public DiagrammeClasse choixDiagrammeDeClasse(Scanner sc) {
        System.out.println("** Choix d'un Diagramme de Classe **");
        for (int i = 0; i < listeDiagrammeClasse.size(); i++) {
            System.out.println(i + " - " + listeDiagrammeClasse.get(i).getNom());
        }
        int choix;
        do {
            System.out.println("Lequel voulez vous choisir ?");
            choix = Integer.parseInt(sc.nextLine());
        } while (choix > listeDiagrammeClasse.size());
        return listeDiagrammeClasse.get(choix);
    }

    private void supprimerDiagrammeClasse(Scanner sc) {
        DiagrammeClasse diag = choixDiagrammeDeClasse(sc);
        listeDiagrammeClasse.remove(diag);
        System.out.println("Le diagramme " + diag.getNom() + " a bien �t� supprim�");
    }
}
