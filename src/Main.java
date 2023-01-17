import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        //Entrée du prénom
        System.out.println("Quel est votre prénom ?");
        String prenom = sc.nextLine();

        //Entrée du nom
        System.out.println("Quel est votre nom ?");
        String nom = sc.nextLine();

        //Entrée de la date de naissance au format jj/mm/aaaa
        System.out.println("Quelle est votre date de naissance au format jj/mm/aaaa ?");
        String dateNaissance = sc.next();

        //Entrée de la taille
        System.out.println("Quelle est votre taille ? (en cm)");
        double taille = sc.nextDouble();

        //Entrée du poids
        System.out.println("Quel est votre poids ? (en kg)");
        double poids = sc.nextDouble();

        //Entrée du sexe
        System.out.println("Quel est votre sexe ? (M ou F)");
        String sexe = sc.next();
        while (!sexe.equals("M") && !sexe.equals("F")) {
            System.out.println("Veuillez entrer M ou F");
            sexe = sc.next();
        }

        sc.close();

        System.out.println("--------------------------------------------");

        //Calculer l'Age à partir de la date de naissance
        String[] dateNaissanceSplit = dateNaissance.split("/");
        int jour = Integer.parseInt(dateNaissanceSplit[0]);
        int mois = Integer.parseInt(dateNaissanceSplit[1]);
        int annee = Integer.parseInt(dateNaissanceSplit[2]);
        int age = 2022 - annee;
        if (mois > 10) {
            age++;
        }
        else if (mois == 10 && jour > 15) {
            age++;
        }

        //Calculer l'IMC
        double imc = poids / (taille / 100 * taille / 100);

        //Déterminer l'indice de masse corporelle
        String indiceMasseCorporelle;
        if (imc < 16.5) {
            indiceMasseCorporelle = "dénutrition ou famine";
        }
        else if (imc < 18.5) {
            indiceMasseCorporelle = "maigreur";
        }
        else if (imc < 25) {
            indiceMasseCorporelle = "corpulence normale";
        }
        else if (imc < 30) {
            indiceMasseCorporelle = "surpoids";
        }
        else if (imc < 35) {
            indiceMasseCorporelle = "obésité modérée";
        }
        else if (imc < 40) {
            indiceMasseCorporelle = "obésité sévère";
        }
        else {
            indiceMasseCorporelle = "obésité morbide ou massive";
        }

        //Déterminer le poids idéal
        double poidsIdeal;
        if (sexe.equals("M")) {
            poidsIdeal = 50 + 0.75 * (taille - 150);
        }
        else {
            poidsIdeal = 45.5 + 0.75 * (taille - 150);
        }

        //Modifie le poids avec un nombre après la virgule
        poids = (double) Math.round(poids * 10) / 10;

        //Convertit la taille en mètres avec deux chiffres après la virgule
        taille = (double) Math.round(taille / 100 * 100) / 100;

        //Calcule l'IMC avec un seul chiffre après la virgule
        imc = (double) Math.round(poids / (taille * taille) * 10) / 10;

        //Détermine le sexe de l'utilisateur
        if (sexe.equals("M")) {
            sexe = "Homme";
        } else {
            sexe = "Femme";
        }

        //Afficher les résultats

        System.out.println("Prénom: " + prenom);
        System.out.println("Nom: " + nom);
        System.out.println("Date de naissance: " + dateNaissance);
        System.out.println("Age: " + age);
        System.out.println("Sexe: " + sexe);
        System.out.println("Taille: " + taille + " cm");
        System.out.println("Poids: " + poids + " kg");
        System.out.println("IMC: " + imc + " ---> "+ indiceMasseCorporelle);
        System.out.println("\t" + "--> Poids idéal: " + poidsIdeal + " kg");


        //Créer un fichier texte avec les informations de l'utilisateur

        FileWriter fw = new FileWriter("C:\\Users\\gwenv\\OneDrive\\Bureau\\" + prenom + "_" + nom + ".txt");

        fw.write("Nom : " + nom + "\n");
        fw.write("Prénom : " + prenom + "\n");
        fw.write("Date de naissance : " + dateNaissance + "\n");
        fw.write("Age : " + age + "\n");
        fw.write("Sexe : " + sexe + "\n");
        fw.write("Taille : " + taille + "\n");
        fw.write("Poids : " + poids + "\n");
        fw.write("IMC : " + imc + " ---> " + indiceMasseCorporelle + "\n");
        fw.write("Poids idéal : " + poidsIdeal + "\n");
        fw.close();
    }
}