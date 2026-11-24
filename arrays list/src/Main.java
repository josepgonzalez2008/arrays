import java.util.ArrayList;
import java.util.Scanner;
    static Scanner llegir = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Float> notesAlumnes = new ArrayList<>();
        ArrayList<String> nomsAlumnes = new ArrayList<>();

        int opcio = 0;

        while (opcio != 5) {
            mostrarMenu();
            opcio = llegirEnter("Tria una opcio: ");

            if (opcio == 1) {
                introduirNota(notesAlumnes, nomsAlumnes);
            } else if (opcio == 2) {
                consultarNota(notesAlumnes, nomsAlumnes);
            } else if (opcio == 3) {
                eliminarNota(notesAlumnes, nomsAlumnes);
            } else if (opcio == 4) {
                modificarNota(notesAlumnes, nomsAlumnes);
            } else if (opcio == 5) {
                System.out.println("Adeu!");
            } else {
                System.out.println("Opcio no valida (1-5).");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println();
        System.out.println("===== NOTES M04-UF1 =====");
        System.out.println("1. Introduir nota");
        System.out.println("2. Consultar nota");
        System.out.println("3. Eliminar nota");
        System.out.println("4. Modificar nota");
        System.out.println("5. Sortir");
    }

    public static void introduirNota(ArrayList<Float> notes, ArrayList<String> noms) {
        System.out.print("Nom de l'alumne: ");
        String nom = llegir.nextLine();
        float nota = llegirNota("Nota: ");

        noms.add(nom);
        notes.add(nota);
        System.out.println("Alumne afegit a l'index " + (notes.size() - 1));
    }

    public static void consultarNota(ArrayList<Float> notes, ArrayList<String> noms) {
        if (notes.size() == 0) {
            System.out.println("No hi ha notes.");
        } else {
            int index = llegirIndex(notes.size());
            System.out.println(noms.get(index) + ": " + notes.get(index));
        }
    }

    public static void eliminarNota(ArrayList<Float> notes, ArrayList<String> noms) {
        if (notes.size() == 0) {
            System.out.println("No hi ha notes.");
        } else {
            int index = llegirIndex(notes.size());
            noms.remove(index);
            notes.remove(index);
            System.out.println("Alumne eliminat.");
        }
    }

    public static void modificarNota(ArrayList<Float> notes, ArrayList<String> noms) {
        if (notes.size() == 0) {
            System.out.println("No hi ha notes.");
        } else {
            int index = llegirIndex(notes.size());
            System.out.println("Nota actual de " + noms.get(index) + ": " + notes.get(index));
            float novaNota = llegirNota("Nova nota: ");
            notes.set(index, novaNota);
            System.out.println("Nota modificada.");
        }
    }

    public static int llegirEnter(String missatge) {
        int numero = 0;
        boolean correcte = false;

        while (!correcte) {
            System.out.print(missatge);
            try {
                numero = Integer.parseInt(llegir.nextLine());
                correcte = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: has d'introduir un numero enter.");
            }
        }
        return numero;
    }

    public static float llegirNota(String missatge) {
        float nota = 0;
        boolean correcte = false;

        while (!correcte) {
            System.out.print(missatge);
            try {
                nota = Float.parseFloat(llegir.nextLine());
                if (nota >= 0 && nota <= 10) {
                    correcte = true;
                } else {
                    System.out.println("Error: la nota ha de ser entre 0 i 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: has d'introduir un numero.");
            }
        }
        return nota;
    }

    public static int llegirIndex(int mida) {
        int index = -1;

        while (index < 0 || index >= mida) {
            index = llegirEnter("Index (0 a " + (mida - 1) + "): ");
            if (index < 0 || index >= mida) {
                System.out.println("Error: index fora de rang.");
            }
        }
        return index;
    }