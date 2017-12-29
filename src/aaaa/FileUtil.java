/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaaa;

/**
 *
 * @author Nanda-PC
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Haqqi
 */
public class FileUtil {
  /* *******variables area****** */

  /* *****constructors area***** */
  /**
   * Untuk mencegah pembuatan object
   */
  private FileUtil() {
  }

  /* ********methods area******* */
  /**
   * Set the file based on relative path
   * @param filePath Path of the file
   * @return Generated file
   */
  public static File setFile(String filePath) {
    // membuat object file baru
    File file = null;
    // mencari path dari direktori kerja
    // bisa dicek dengan print
    String path = System.getProperty("user.dir")
        + File.separatorChar + filePath;
    try {
      // construct the file based on the path
      file = new File(path);
     //System.out.println("Konstruksi file berhasil");
    } catch (Exception e) {
      e.printStackTrace();
    }
    // jika file tidak ditemukan, maka error
    if (file == null) {
      throw new RuntimeException();
    }
    // jika file tidak ada, maka membuat file baru
    if (!file.exists()) {
      try {
        file.createNewFile();
        //System.out.println("File tidak ditemukan, membuat file baru di " + path);
      } catch (IOException ex) {}
    }
    return file;
  }

  /**
   * Menulis array string ke dalam sebuah file. file yang akan
   * ditulis akan menjadi text file biasa.
   * @param text array string yang akan disimpan
   * @param file File
   * @return true jika sukses, false jika gagal
   */
  public static boolean fileWrite(String[] text, File file) {
    try {
      // membuat buffer
      BufferedWriter out = new BufferedWriter(new FileWriter(file));
      PrintWriter writeOut = new PrintWriter(out);
      // menulis text ke file
      for (int i = 0; i < text.length; i++) {
        writeOut.println(text[i]);
        //System.out.println("Menulis baris : " + text[i]);
      }
      // menutup writer
      writeOut.close();
      //System.out.println("Selesai menulis file");
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Membaca file text
   * @param file
   * @return
   */
  public static String[] fileRead(File file) {
    try {
      // Membuat buffered reader
      BufferedReader readIn = new BufferedReader(new FileReader(file));
      // ArrayList untuk menyimpan string setiap baris
      ArrayList<String> list = new ArrayList<String>();
      // Object sementara
      String data;
      // Membaca setiap baris sampai akhir
      while ((data = readIn.readLine()) != null) {
        list.add(data);
       // System.out.println("Membaca baris : " + data);
      }
      // Menutup reader
      readIn.close();
      // mengembalikan array dalam bentuk string
      //System.out.println("Selesai membaca file");
      return list.toArray(new String[0]);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
