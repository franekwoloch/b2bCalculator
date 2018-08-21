package utils;

import data.Calculations;

import java.io.*;

public class FileManager {
    public static final String FILE_NAME="Calculations.o";
    public void writeCalculationsToFile(Calculations calc){
        try(
                FileOutputStream fos=new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos=new ObjectOutputStream(fos);
        ){
            oos.writeObject(calc);
        }catch (FileNotFoundException e){
            System.err.println("Nie odnaleziono pliku: "+FILE_NAME);
        } catch (IOException e){
            System.err.println("Blad podczas zapisu danych do pliku");
        }
    }

    public Calculations readCalculationsFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        Calculations calc=null;
        try(
                FileInputStream fis=new FileInputStream(FILE_NAME);
                ObjectInputStream ois=new ObjectInputStream(fis);
        ) {
            calc=(Calculations) ois.readObject();
        } catch (FileNotFoundException e){
            System.err.println("Nie odnaleziono pliku: "+FILE_NAME);
            throw e;
        } catch (IOException e){
            System.err.println("Blad podczas zapisu danych do pliku");
            throw e;
        } catch (ClassNotFoundException e){
            System.err.println("Nieprawidlowy format pliku");
            throw e;
        }
        return calc;
    }
}
