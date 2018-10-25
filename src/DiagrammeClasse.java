import java.util.List;
import java.util.Scanner;

@SuppressWarnings("StatementWithEmptyBody")
public class DiagrammeClasse {
    String nom;
    List<ClasseAbstraite> listeClasses;
    List<Association> listeAssociations;

    public DiagrammeClasse(String mName) {
        this.nom = mName;
    }

    public void menu(){

        afficherOptionsMenu();

        int choix;
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();

        switch (choix){
            case 1:
                System.out.println("Vous avez saisi : choix 1");
                creerNouvelleClasse();
                break;
            case 2:
                System.out.println("Vous avez saisi : choix 2");
                afficherClasses();
                break;
            case 3:
                System.out.println("Vous avez saisi : choix 3");
                choixClasse().menu();
                break;
            case 4:
                System.out.println("Vous avez saisi : choix 4");
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
                //TODO
                break;
            default:
        }
    }
    private void creerNouvelleClasse(){
        System.out.println("Donner un nom à votre classe");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Classe c = new Classe(str);
        this.listeClasses.add(c);
        c.menu(); //ça devrait peut être pas être là
    }

    private void creerNouvelleAssociation(){
        if(listeClasses.size()>=1){
            //TODO
        }else {
            System.out.println("Vous devez d'abord créer une classe");
        }
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

    public String getNom() {
        return nom;
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

    public ClasseAbstraite choixClasse(){
        System.out.println("** Choix d'une Classe **");
        for (int i=0; i<listeClasses.size(); i++){
            System.out.print(i + " - " + listeClasses.get(i).getNom() );
        }
        int choix;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Lequel voulez vous choisir ?");

            choix = sc.nextInt();
        }while(choix > listeClasses.size());

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

