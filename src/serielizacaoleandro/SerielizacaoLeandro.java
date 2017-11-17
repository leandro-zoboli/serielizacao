package serielizacaoleandro;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerielizacaoLeandro {

    static class Pessoa implements Serializable {

        private String nome;
        private Pessoa proximo;
        private Pessoa Primeira;
        private Pessoa ultima;
    }

    static class Livro implements Serializable {

        private String nome;
        private Livro proximo;

    }

    public static void main(String[] args) {
        carregaFila();
        carregaPilha();
    }

    public static void carregaFila() {
        Pessoa p1 = new Pessoa();
        p1.nome = "One";
        Pessoa p2 = new Pessoa();
        p2.nome = "Two";
        Pessoa p3 = new Pessoa();
        p3.nome = "Three";
        p1.proximo = p2;
        p2.proximo = p3;
        p3.proximo = null;

        Pessoa primeira = new Pessoa();
        primeira = p1;

        Pessoa ultima = new Pessoa();
        ultima = p2;

        Pessoa atual = new Pessoa();
        atual = primeira;

        try {
            FileOutputStream fos = new FileOutputStream("fila.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            while (atual != null) {
                oos.writeObject(atual);
                atual = atual.proximo;
            }
            oos.flush();
            fos.flush();
            oos.close();
            fos.close();
            System.out.println("Fila gravada com sucesso!!!");
        } catch (IOException ex) {
            System.out.println("Ocorreu um erro ao gravar a fila!!!");
        }

    }

    public static void carregaPilha() {
        Livro l1 = new Livro();
        l1.nome = "Um";
        Livro l2 = new Livro();
        l2.nome = "Dois";
        Livro l3 = new Livro();
        l3.nome = "Três";
        l1.proximo = l2;
        l2.proximo = l3;
        l3.proximo = null;

        Livro topo = new Livro();
        topo = l1;

        Livro atual = new Livro();
        atual = topo;
        try {
            FileOutputStream fos = new FileOutputStream("pilha.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            while (atual != null) {
                oos.writeObject(atual);
                atual = atual.proximo;
            }
            oos.flush();
            fos.flush();
            oos.close();
            fos.close();
            System.out.println("Pilha gravada com sucesso!!!");
        } catch (IOException ex) {
            System.out.println("Ocorreu um erro ao gravar a Pilha!!!");
        }

    }

}
