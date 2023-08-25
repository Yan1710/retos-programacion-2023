import java.io.*;

public class Yan1710 {

    public static void main(String[] args) {

        String fileName = "text.txt";
        String line;
        String input;
        File file = new File(fileName);
        int choice;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            if (file.exists()) {
                System.out.println("El archivo ya existe. ¿Deseas borrar su contenido? Si: 1, No: 0");
                choice = Integer.parseInt(reader.readLine());
                if (choice == 1) {
                    fileWriter.close();
                    fileWriter = new FileWriter(file);
                } else {
                    try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                        System.out.println("Contenido actual del archivo:");
                        while ((line = fileReader.readLine()) != null) {
                            System.out.println(line);
                        }
                    }
                }
            }

            System.out.println("Introduce texto escribe 'exit' en una línea separada para salir y guardar :");
            while (!(input = reader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(input + System.lineSeparator());
            }
            fileWriter.close();
            System.out.println("Texto guardado en el archivo.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
