public class UlamTest {

    public static void main(String[] args) {

        // Teste alle Zahlen von 1 bis 999999
        for (int i = 1; i < 1_000_000; i++) {

            long n = i;

            // Berechne die Collatz-Folge
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;      // gerade Zahl
                } else {
                    n = 3 * n + 1;  // ungerade Zahl
                }
            }
        }

        // Ausgabe, wenn alle Zahlen erfolgreich 1 erreichen
        System.out.println("Alle Zahlen < 1.000.000 erreichen 1.");
    }
}

