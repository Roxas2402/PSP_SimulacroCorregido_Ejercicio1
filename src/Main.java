import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "Separacion.jar");
        Process process = processBuilder.start();
        processBuilder.redirectErrorStream(true);

        InputStreamReader isr = new InputStreamReader(process.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = process.getOutputStream();
        PrintStream ps = new PrintStream(os);

        Scanner sc = new Scanner(System.in);
        System.out.println("Dime una frase: ");
        String frase = sc.nextLine();

        //Le paso la frase al hijo
        ps.println(frase);
        ps.flush();

        //Leo su respuesta
        String palabra;

        while (!(palabra = br.readLine()).equalsIgnoreCase("fin")) {
            System.out.println(palabra);
        }
    }
}