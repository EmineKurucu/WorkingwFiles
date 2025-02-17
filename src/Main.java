import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //createFile();
        getFileInfo(); // File Name: students.txt
        readFile();
        fileWrite();
        readFile();

    }

    public static void createFile(){
        File file = new File("C:\\javademos\\files\\students.txt");
        try {
            if(file.createNewFile()){ // yeni file ekledik ama try catch olmalı/ Oluşturu true,false döner
                System.out.println("Dosya olusturuldu.");
            } else {
                System.out.println("Dosya zaten mevcut.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getFileInfo(){
        File file = new File("C:\\javademos\\files\\students.txt");
        file.exists(); // ilgili dizinde dosya varsa true döndürür
        if (file.exists()){
            System.out.println("File Name: "+ file.getName());
            System.out.println("Dosya Yolu: "+ file.getAbsolutePath());// Dosya Yolu: C:\javademos\files\students.txt
            System.out.println("Dosya yazilabilir mi: "+ file.canWrite());
            System.out.println("Dosya okunabilir mi: "+ file.canRead());
            System.out.println("Dosya boyutu(byte): "+ file.length());
        }
    }

    public static void readFile(){
        File file = new File("C:\\javademos\\files\\students.txt");
        // dosyada okuma yapabilmek için Scanner'dan faydalanılır
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){ // okunacak satır varsa anlamında
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fileWrite(){
        try {
            BufferedWriter writer =new BufferedWriter(new FileWriter("C:\\javademos\\files\\students.txt", true));
            // "C:\\javademos\\files\\students.txt" bu haldeyken dosyanın üzerine ayzar önceki yazilanlar gider
            writer.write("\nDiger satirlar\n");
            writer.write("Bir satir daha");
            System.out.println("Dosyaya yazildi.");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /* writer.newLine()
        writer.write() yazarsak önce yeni satır oluşturur sonra yazar
         */

    }
}