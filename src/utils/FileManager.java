package utils;

import data.Calculations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    public static final String FILE_NAME = "Calculations.o";
    //new JFileChooser().getFileSystemView().getDefaultDirectory().toString();

    String pathText = System.getProperty("user.home") + File.separatorChar + "My Documents";
    Path path = Paths.get(pathText, "b2bCalculator");
    String totalPathtext=path.toString();

    public FileManager(){
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCalculationsToFile(Calculations calc) {
        System.out.println("Domyslna lokalizacja:");
        System.out.println(path);

        try (
                FileOutputStream fos = new FileOutputStream((totalPathtext + File.separatorChar + FILE_NAME));
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(calc);
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku: " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Blad podczas zapisu danych do pliku");
        }
        System.out.println("Zapisano dane");
    }

    public Calculations readCalculationsFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        Calculations calc = null;
        try (
                FileInputStream fis = new FileInputStream((totalPathtext + File.separatorChar + FILE_NAME));
                ObjectInputStream ois = new ObjectInputStream(fis);
                ) {

            calc = (Calculations) ois.readObject();
        }
        catch(FileNotFoundException e){
            System.err.println("Nie odnaleziono pliku: " + FILE_NAME + " w domyslnej lokalizacji");
            throw e;
        } catch(IOException e){
            System.err.println("Blad podczas zapisu danych do pliku");
            throw e;
        } catch(ClassNotFoundException e){
            System.err.println("Nieprawidlowy format pliku");
            throw e;
        }
        return calc;
    }
}

