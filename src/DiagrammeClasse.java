import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiagrammeClasse {
    String nom;
    List<Classe> listeClasses;
    List<Association> listeAssociations;
    List<String> listeTypes;

    public DiagrammeClasse(String mName) {
        this.nom = mName;
        listeClasses = new ArrayList<>();
        listeAssociations = new ArrayList<>();
        listeTypes = new ArrayList<String>();
        listeTypes.add("String");
        listeTypes.add("int");
        listeTypes.add("float");
        listeTypes.add("boolean");
    }

    public void menu(Scanner sc) {
        int choix = -1;
        String reponseUser;
        while (choix != 0) {
            afficherOptionsMenu();
            reponseUser = sc.nextLine();
			if(reponseUser.matches("^(10|[0-9])$")){
				choix = Integer.parseInt(reponseUser);
	            switch (choix) {
		            case 1:
		                System.out.println("Vous avez saisi : choix 1");
		                creerNouvelleClasse(sc);
		                break;
		            case 2:
		                System.out.println("Vous avez saisi : choix 2");
		                afficherClasses();
		                break;
		            case 3:
		                System.out.println("Vous avez saisi : choix 3");
		                if(listeClasses.size() >= 1){
		                    choixClasse(sc).menu(sc, listeTypes, listeClasses);
		                }else {
		                    System.out.println("Aucune classe");
		                }
		                break;
		            case 4:
		                System.out.println("Vous avez saisi : choix 4");
		                if(listeClasses.size() >= 1){
		                    supprimerClasse(sc);
		                }else {
		                    System.out.println("Aucune classe");
		                }
		                break;
		            case 5:
		                System.out.println("Vous avez saisi : choix 5");
		                creerNouvelleAssociation(sc);
		                break;
		            case 6:
		                System.out.println("Vous avez saisi : choix 6");
		                afficherAssociations();
		                break;
		            case 7:
		                System.out.println("Vous avez saisi : choix 7");
		                if(listeAssociations.size() >= 1){
		                    choixAssociation(sc).menu(sc);
		                }else {
		                    System.out.println("Aucune association");
		                }
		                break;
		            case 8:
		                System.out.println("Vous avez saisi : choix 8");
		                if(listeAssociations.size() >= 1){
		                    supprimerAssociation(sc);
		                }else {
		                    System.out.println("Aucune association");
		                }
		                break;
		            case 9:
		                System.out.println("Vous avez saisi : choix 9");
		                System.out.println("Non implementes");
		                break;
		            case 10:
		                System.out.println("Vous avez saisi : choix 10");
		                renommer(sc);
		                break;
		            default:
	            }
	        }
			else {
				System.out.println("Merci de saisir un choix du menu");
			}
        }
    }

    private void creerNouvelleClasse(Scanner sc) {
        System.out.println("** Creation d'une classe **");
        System.out.println("Donner un nom a votre classe");
        String str = "";
        while (str.equals("")) {
            str = sc.nextLine();
            if(listeTypes.contains(str)) {
            	System.out.println("Cette classe existe déjà");
            	str = "";
            }
        }
        Classe c = new Classe(str);
        this.listeClasses.add(c);
        this.listeTypes.add(str);
        c.menu(sc, listeTypes, listeClasses);
    }

    private void creerNouvelleAssociation(Scanner sc) {
        if (listeClasses.size() >= 1) {
            System.out.println("** Creation d'un association de classes **");
            System.out.println("Les associations non binaires ne sont pas implementees"); // todo
            System.out.println("Choissisez la classe d'origine");
            Classe co = choixClasse(sc);
            System.out.println("Choissisez la classe d'arrivee de l'association");
            Classe ce = choixClasse(sc);
            System.out.println("Choissisez la classe d'origine");
            Association a = new Association(co, ce);
            a.menu(sc);
        } else {
            System.out.println("Vous devez d'abord creer une classe");
        }
    }

    private void afficherOptionsMenu() {
        System.out.println("** Menu Classe **");

        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Creer une nouvelle classe");
        System.out.println("2- Voir les classes existantes");
        System.out.println("3- Modifier les classes existantes");
        System.out.println("4- Supprimer une classe existante");
        System.out.println("5- Creer une nouvelle association");
        System.out.println("6- Voir les associations existantes");
        System.out.println("7- Modifier les associations existantes");
        System.out.println("8- Supprimer une association existante");
        System.out.println("9- Gerer les relations d'heritage");
        System.out.println("10- Renommer le diagramme de classe");

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private void renommer(Scanner sc) {
        String str = "";
        while (str.equals("")) {
            str = sc.nextLine();
        }
        setNom(str);
    }

    public void afficher() {
        System.out.println("** Diagramme de Classes " + this.getNom() + " **");
        System.out.println("\t** Liste des Classes **");
        for (Classe classe : listeClasses) {
            classe.afficher();
        }
        System.out.println("\t** Liste des Associations **");
        for (Association asso : listeAssociations) {
            asso.afficher();
        }
    }

    public void afficherClasses() {
        System.out.println("** Classes du Diagramme de Classes " + this.getNom() + " **");
        for (Classe classe : listeClasses) {
            classe.afficher();
        }
    }

    public void afficherAssociations() {
        System.out.println("** Associations du Diagramme de Classes " + this.getNom() + "**");
        for (Association asso : listeAssociations) {
            asso.afficher();
        }
    }

    public Classe choixClasse(Scanner sc) {
        System.out.println("** Choix d'une Classe **");
        for (int i = 0; i < listeClasses.size(); i++) {
            System.out.println(i + " - " + listeClasses.get(i).getNom());
        }
        int choix;
        do {
            System.out.println("Lequel voulez vous choisir ?");
            choix = Integer.parseInt(sc.nextLine());
        } while (choix > listeClasses.size());
        System.out.println("Vous avez choisi la classe " + listeClasses.get(choix).getNom());

        return listeClasses.get(choix);
    }

    public Association choixAssociation(Scanner sc) {
        System.out.println("** Choix d'une Association **");
        for (int i = 0; i < listeAssociations.size(); i++) {
            System.out.println(i + " - " + listeAssociations.get(i).getNom());
        }
        int choix;
        do {
            System.out.println("Lequel voulez vous choisir ?");

            choix = Integer.parseInt(sc.nextLine());
        } while (choix > listeAssociations.size());

        return listeAssociations.get(choix);
    }

    private void supprimerClasse(Scanner sc) {
        Classe classe = choixClasse(sc);
        for (Association asso : listeAssociations) {
            if (asso.origine.equals(classe) || asso.extremite.equals(classe)) {
                listeAssociations.remove(asso);
            }
        }
        for (Classe cl : listeClasses) {
            cl.supprimerElementsEnRelationAvecClasse(classe);
        }
        listeClasses.remove(classe);
        System.out.println("La classe " + classe.getNom() + " et toutes ses associations associees ont bien ete supprimees");
        listeTypes.remove(classe.getNom());
    }

    private void supprimerAssociation(Scanner sc) {
        Association asso = choixAssociation(sc);
        listeAssociations.remove(asso);
        System.out.println("L'association " + asso.getNom() + " a bien ete supprimee");
    }
}
