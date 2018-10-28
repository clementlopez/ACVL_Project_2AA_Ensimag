import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiagrammeClasse {
    String nom;
    List<ClasseAbstraite> listeClasses;
    List<Association> listeAssociations;

    public DiagrammeClasse(String mName) {
        this.nom = mName;
        listeClasses = new ArrayList<>();
        listeAssociations = new ArrayList<>();
    }

    public void menu(Scanner sc){
    	int choix = -1;
        while(choix!=0){
        	afficherOptionsMenu();
	        choix = sc.nextInt();
	
	        switch (choix){
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
	                choixClasse(sc).menu();
	                break;
	            case 4:
	                System.out.println("Vous avez saisi : choix 4");
	                System.out.println("Non implementes");
	                //TODO
	                break;
	            case 5:
	                System.out.println("Vous avez saisi : choix 5");
	                creerNouvelleAssociation();
	                break;
	            case 6:
	                System.out.println("Vous avez saisi : choix 6");
	                afficherAssociations();
	                break;
	            case 7:
	                System.out.println("Vous avez saisi : choix 7");
	                choixAssociation().menu();
	                break;
	            case 8:
	                System.out.println("Vous avez saisi : choix 8");
	                System.out.println("Non implementes");
	                //TODO
	                break;
	            case 9:
	                System.out.println("Vous avez saisi : choix 9");
	                System.out.println("Non implementes");
	                //TODO
	                break;
	            case 10:
	                System.out.println("Vous avez saisi : choix 10");
	                renommer(sc);
	                //TODO
	                break;
	            default:
	        }
        }
    }
    private void creerNouvelleClasse(Scanner sc){
        System.out.println("** Creation d'une classe **");
        System.out.println("Donner un nom a votre classe");
        String str = "";
        while(str.equals("")){
        	str = sc.nextLine();
        }
        Classe c = new Classe(str);
        this.listeClasses.add(c);
        c.menu(); //ça devrait peut être pas être là
    }

    private void creerNouvelleAssociation(){
        if(listeClasses.size()>=1){
            System.out.println("** Creation d'un association de classes **");
            System.out.println("Les associations non binaires ne sont pas implementees"); //todo
            System.out.println("Choissisez la classe d'origine");
            ClasseAbstraite co = choixClasse();
            System.out.println("Choissisez la classe d'arrivee de l'association");
            ClasseAbstraite ce = choixClasse();
            System.out.println("Choissisez la classe d'origine");
            Association a = new Association(co,ce);
            a.menu();
        }else {
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
        System.out.println("9- Gerer les relations d'heritage");//TODO
        System.out.println("10- Renommer le diagramme de classe");//TODO

    }

    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
		this.nom = nom;
	}

	private void renommer(Scanner sc){
    	String str = "";
        while(str.equals("")){
        	str = sc.nextLine();
        }
        setNom(str);
    }
	
    public void afficher () {
        System.out.println("** Diagramme de Classes"+ this.getNom() +"**");
        //TODO
    }

    public void afficherClasses () {
        System.out.println("** Classes du Diagramme de Classes"+ this.getNom() +"**");
        //TODO
    }
    public void afficherAssociations () {
        System.out.println("** Associations du Diagramme de Classes"+ this.getNom() +"**");
        //TODO
    }

    public ClasseAbstraite choixClasse(Scanner sc){
        System.out.println("** Choix d'une Classe **");
        for (int i=0; i<listeClasses.size(); i++){
            System.out.print(i + " - " + listeClasses.get(i).getNom() );
        }
        int choix;
        do{
            System.out.println("Lequel voulez vous choisir ?");
            choix = sc.nextInt();
        }while(choix > listeClasses.size());
        System.out.println("Vous avez choisi la classe " + listeClasses.get(choix).getNom());

        return listeClasses.get(choix);
    }

    public Association choixAssociation(){
        System.out.println("** Choix d'une Association **");
        for (int i = 0; i< listeAssociations.size(); i++){
            System.out.print(i + " - " + listeAssociations.get(i).getName() );
        }
        int choix;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Lequel voulez vous choisir ?");

            choix = sc.nextInt();
        }while(choix > listeAssociations.size());

        return listeAssociations.get(choix);
    }

}

