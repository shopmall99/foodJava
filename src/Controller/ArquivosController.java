package Controller;

import javax.swing.*;
import javax.xml.namespace.QName;
import java.io.*;

public class ArquivosController implements iArquivosController {


    public ArquivosController(){
        super();
    }

    @Override
    public void readDir(String path) throws IOException {
        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for(File f: files) {
                if(f.isFile()){
                    System.out.println("     \t"+f.getName());
                } else {
                    System.out.println("<DIR>\t"+f.getName());
                }
            }
        } else {
            throw new IOException("Diretório inválido");
        }

    }

    @Override
    public void createFile(String path, String nome) throws IOException {
            File dir = new File(path);
            File arq = new File(path, nome + ".txt");
            if (dir.exists() && dir.isDirectory()) {
                boolean existe = false;
                if (arq.exists()) {
                    existe = true;
                }
                String conteudo = geratxt();
                FileWriter fileWriter = new FileWriter(arq,existe);
                PrintWriter print = new PrintWriter(fileWriter);
                print.write(conteudo);
                print.flush();
                print.close();
                fileWriter.close();

            } else {
                throw new IOException("Diretório inválido");
            }


    }

    private String geratxt() {
        StringBuffer buffer = new StringBuffer();
        String linha = "";
        while (!linha.equalsIgnoreCase("fim")){
            linha = JOptionPane.showInputDialog(null,"Digite uma frase", "Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
            if (!linha.equalsIgnoreCase("fim")) {
                buffer.append(linha + "\n");
            }

        }
        return buffer.toString();
    }

    @Override
    public void readFile(String path, String nome) throws IOException {
            File arq = new File(path, nome);
            if(arq.exists() && arq.isFile()) {
                FileInputStream fluxo = new FileInputStream(arq);
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);

                String linha = buffer.readLine();

                while(linha != null) {
                    String[] vet = linha.split(",");
                    if(vet[2].contains("Fruit")) {
                        System.out.printf("%-30s %-50s %-5s \n ", vet[0], vet[1], vet[3]);
                    }
                    linha = buffer.readLine();
                }
                buffer.close();
                leitor.close();
                fluxo.close();




            } else {
                throw new IOException("Arquivo inválido");
            }


    }

    @Override
    public void openFile(String path, String nome) throws IOException {

    }
}
