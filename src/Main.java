import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Bienvenue dans ce simulateur de diagrammes de classe");
        Controlleur c = new Controlleur();
        c.play();
		/*Scanner sc = new Scanner(System.in);
		String reponseUser;
        reponseUser = sc.nextLine();
        if(reponseUser.matches("^(10|[0-9])$")){
        	System.out.println("oui!!!");
        }*/
	}
}
