package ru.geekbrains;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {

//        deleteThisDir(new File("123"));
        combineAllTxtFiles(new File("123/345"));
        System.out.println(txtCharSequence(new File("123/345/3.txt"), "java"));
        System.out.println(txtCharSequence(new File("123/345/3.txt"), "par"));
        System.out.println(findStrInTxt(new File("123/345/3.txt"), "par"));
        System.out.println(findStrInTxt(new File("123/345/3.txt"), "java"));




    }

    public static int txtCharSequence(File file, String str) throws IOException{
        if (!(file.getName().endsWith(".txt") || file.getName().endsWith(".TXT")))
            throw new RuntimeException("txtCharSequence works only with .txt files!!!");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        StringBuilder text = new StringBuilder();
        int count = 0;
        int x;
        while ((x = in.read()) != -1){
            text.append((char)x);
            if(text.indexOf(str) > -1){
                count++;
                text.delete(0, text.length());
            }
        }
        return count;
    }

    /**
     * Better method for finding same words un txt file
     */
    public static int findStrInTxt(File file, String str) throws IOException{
        int count = 0;
        char[] chars = str.toCharArray();
        int index = 0;

        if (!(file.getName().toLowerCase().endsWith(".txt")))
            throw new RuntimeException("txtCharSequence works only with .txt files!!!");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        int x;
        while((x = in.read()) != -1){
            if(chars[index] == (char)x){
                if (index == chars.length - 1){
                    count++;
                    index = 0;
                } else {
                    index++;
                }
            } else if (chars[0] == (char)x){ //without this method skips jjava in search of java
                index = 1;
            } else {
                index = 0;
            }
        }
        in.close();
        return count;
    }

    public static void combineAllTxtFiles(File dirPath) throws IOException {
        File[] files = dirPath.listFiles(pathname -> pathname.getName().toLowerCase().endsWith(".txt"));
        String combName = dirPath.getPath() + "\\" + files.length + "txtFilesCombined.txt";

        if (files.length == 0) throw new RuntimeException("There are no txt files");
        if (files.length == 1) throw new RuntimeException("There only 1 txt file");

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(combName));
        for (File file: files){
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            int x;
            while((x = in.read()) != -1){
                out.write(x);
            }
            out.write("\n".getBytes());
            in.close();
        }
        out.close();
        System.out.println("All txt files combined are in " + combName);
    }

    public static void deleteThisDir(File dirPath){
        if(!dirPath.exists())
            throw new RuntimeException("the entered path doesn't exist");
        File[] files = dirPath.listFiles();
        for (File file: files){
            if(file.isFile()){
                file.delete();
            }else{
                deleteThisDir(file);
                file.delete();
            }
        }
        dirPath.delete();
        System.out.printf("The %s dir has been deleted", dirPath);

    }


}
