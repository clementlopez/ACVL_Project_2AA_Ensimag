import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Classe {

    private String nom;
    private List<Attribut> listeAttributs;
    private List<Methode> listeMethodes;
    private boolean estAbstraite;

    public Classe(String mName) {
        this.nom = mName;
        listeAttributs = new ArrayList<>();
        listeMethodes = new ArrayList<>();
        this.estAbstraite = false;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Attribut> getListeAttributs() {
        return listeAttributs;
    }

    public void setListeAttributs(List<Attribut> listeAttributs) {
        this.listeAttributs = listeAttributs;
    }

    public boolean isEstAbstraite() {
        return estAbstraite;
    }

    public void setEstAbstraite(boolean estAbstraite) {
        this.estAbstraite = estAbstraite;
    }

    public void menu(Scanner sc, List<String> listeTypes, List<Classe> listeClasses) {
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
		                creerNouvelAttribut(sc, listeTypes);
		                break;
		            case 2:
		                System.out.println("Vous avez saisi : choix 2");
		                afficherAttributs();
		                break;
		            case 3:
		                System.out.println("Vous avez saisi : choix 3");
		                if(listeAttributs.size() >= 1){
		                    choixAttribut(sc).menu(sc, listeTypes);
		                }else {
		                    System.out.println("Aucun attribut");
		                }
		                break;
		            case 4:
		                System.out.println("Vous avez saisi : choix 4");
		                if(listeAttributs.size() >= 1){
		                    supprimerAttribut(sc);
		                }else {
		                    System.out.println("Aucun attribut");
		                }
		                break;
		            case 5:
		                System.out.println("Vous avez saisi : choix 5");
		                creerNouvelleMethode(sc, listeTypes);
		                break;
		            case 6:
		                System.out.println("Vous avez saisi : choix 6");
		                if(listeMethodes.size() >= 1){
		                	afficherMethodes();
		                }else {
		                    System.out.println("Aucune methode");
		                }
		                break;
		            case 7:
		                System.out.println("Vous avez saisi : choix 7");
		                if(listeMethodes.size() >= 1){
		                    choixMethode(sc).menu(sc, listeTypes);
		                }else {
		                    System.out.println("Aucune methode");
		                }
		                break;
		            case 8:
		                System.out.println("Vous avez saisi : choix 8");
		                if(listeMethodes.size() >= 1){
		                    supprimerMethode(sc);
		                }else {
		                    System.out.println("Aucune methode");
		                }
		                break;
		            case 9:
		                System.out.println("Vous avez saisi : choix 9");
		                System.out.println("Comment voulez vous appeler cette Classe");
		                renommer(sc, listeTypes, listeClasses);
		                break;
		            case 10:
		                System.out.println("Vous avez saisi : choix 10");
		                changeAbstrait();
		                break;
		            default:
	            }
			}
			else {
				System.out.println("Merci de saisir un choix du menu");
			}
        }
    }

    private void afficherOptionsMenu() {
    	System.out.println("########################");
        System.out.println("** Menu Classe **");

        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Creer un nouvel attribut");
        System.out.println("2- Voir les attributs existants");
        System.out.println("3- Modifier les attributs existants");
        System.out.println("4- Supprimer un attribut existant");
        System.out.println("5- Creer une nouvelle methode");
        System.out.println("6- Voir les methodes existantes");
        System.out.println("7- Modifier les methodes existantes");
        System.out.println("8- Supprimer une methode existante");
        System.out.println("9- Renommer la classe");
        if (isEstAbstraite()) {
            System.out.println("10- Rendre la classe non-abstraite");
        } else {
            System.out.println("10- Rendre la classe abstraite");
        }
    }

    private void creerNouvelAttribut(Scanner sc, List<String> listeTypes) {
        System.out.println("Creation d'un nouvel attribut");
        System.out.println("Donner un nom a votre attribut");
        String str = sc.nextLine();
        Attribut a = new Attribut(str);
        this.listeAttributs.add(a);
        a.menu(sc, listeTypes);
    }

    private void creerNouvelleMethode(Scanner sc, List<String> listeTypes) {
        System.out.println("Creation d'une nouvelle methode");
        System.out.println("Donner un nom a votre methode");
        String str = sc.nextLine();
        Methode m = new Methode(str);
        this.listeMethodes.add(m);
        m.menu(sc, listeTypes);
    }

    public Attribut choixAttribut(Scanner sc) {
        System.out.println("** Choix d'un Attribut **");
        for (int i = 0; i < listeAttributs.size(); i++) {
            System.out.println(i + " - " + listeAttributs.get(i).getNom());
        }
        int choix;
        do {
            System.out.println("Lequel voulez vous choisir ?");

            choix = Integer.parseInt(sc.nextLine());
        } while (choix > listeAttributs.size());
        System.out.println("Vous avez choisi l'attribut " + listeAttributs.get(choix).getNom());
        return listeAttributs.get(choix);
    }

    public Methode choixMethode(Scanner sc) {
        System.out.println("** Choix d'une Methode **");
        for (int i = 0; i < listeMethodes.size(); i++) {
            System.out.println(i + " - " + listeMethodes.get(i).getNom());
        }
        int choix;
        do {
            System.out.println("Laquelle voulez vous choisir ?");

            choix = Integer.parseInt(sc.nextLine());
        } while (choix > listeMethodes.size());
        System.out.println("Vous avez choisi la methode " + listeMethodes.get(choix).getNom());
        return listeMethodes.get(choix);
    }

    public void afficherAttributs() {
        System.out.println("** Attributs de la  Classe " + this.getNom() + " **");
        for (Attribut att : listeAttributs) {
            att.afficher();
        }
    }

    public void afficherMethodes() {
        System.out.println("** Methodes de la  Classe " + this.getNom() + "**");
        for (Methode meth : listeMethodes) {
            meth.afficher();
        }
    }

    private void renommer(Scanner sc, List<String> listeTypes, List<Classe> listeClasses) {
        String str = "";
        while (str.equals("")) {
        	str = sc.nextLine();
            if(listeTypes.contains(str)&&!str.equals(getNom())) {
            	System.out.println("Cette classe existe déjà");
            	str = "";
            }
        }
        for(Classe classe : listeClasses) {
        	classe.repercuterModifNomClasse(getNom(), str);
        }
        setNom(str);
    }

    public String getNom() {
        return nom;
    }

    public void afficher() {
    	if(isEstAbstraite()) {
    		System.out.println("\t\t<<abstract>>");
    	}
        System.out.println("\t\t- " + getNom());
        System.out.println("\t\t\tListe des attributs");
        for (Attribut att : listeAttributs) {
            att.afficher();
        }
        System.out.println("\t\t\tListe des methodes");
        for (Methode meth : listeMethodes) {
            meth.afficher();
        }
    }

    public void supprimerElementsEnRelationAvecClasse(Classe classe) {
        for (Attribut att : listeAttributs) {
            if (att.getType().equals(classe.getNom())) {
                listeAttributs.remove(att);
            }
        }
        for (Methode meth : listeMethodes) {
            if (meth.getTypeRetour().equals(classe.getNom())) {
                listeMethodes.remove(meth);
            }
        }
    }
    
    public void repercuterModifNomClasse(String ancienNomClasse, String nouveauNomClasse) {
    	for (Attribut att : listeAttributs) {
            if (att.getType().equals(ancienNomClasse)) {
                att.setType(nouveauNomClasse);
            }
        }
        for (Methode meth : listeMethodes) {
        	meth.repercuterModifNomClasse(ancienNomClasse, nouveauNomClasse);
        }
    }

    private void changeAbstrait() {
        setEstAbstraite(!isEstAbstraite());
        if (isEstAbstraite()) {
            System.out.println("La Classe " + getNom() + " est desormais abstraite");
        } else {
            System.out.println("La Classe " + getNom() + " n'est plus abstraite");
        }
    }

    private void supprimerAttribut(Scanner sc) {
        Attribut att = choixAttribut(sc);
        listeAttributs.remove(att);
        System.out.println("L'attribut " + att.getNom() + " a bien ï¿½tï¿½ supprimï¿½");
    }

    private void supprimerMethode(Scanner sc) {
        Methode meth = choixMethode(sc);
        listeMethodes.remove(meth);
        System.out.println("La methode " + meth.getNom() + " a bien ï¿½tï¿½ supprimï¿½e");
    }
}
