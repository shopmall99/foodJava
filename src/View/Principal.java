package View;

import Controller.ArquivosController;
import Controller.iArquivosController;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) {

        iArquivosController arqCont = new ArquivosController();
        String dirWin = "C:\\Windows";
        String path = "C:\\TEMP\\Aula";
        String nome = "generic_food.csv";

        try {
          //  arqCont.readDir(dirWin);
         //   arqCont.createFile(path,nome);
            arqCont.readFile(path,nome);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }


    }
}
