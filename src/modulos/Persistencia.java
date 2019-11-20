package modulos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {
	private static final String NOME_DIRETORIO = "files";
    public static final String EXTENSAO_ARQUIVO = ".dat";
    private final String caminhoDiretorio;

    public Persistencia() {
        this(NOME_DIRETORIO);
    }

    public Persistencia(String nomeDiretorio) {
        this.caminhoDiretorio = nomeDiretorio + File.separator;
    }

    public void salvar(Object obj, String nomeArquivo) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(this.caminhoDiretorio + nomeArquivo + EXTENSAO_ARQUIVO);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Object carregar(String nomeArquivo) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Object obj = null;
        File file = new File(this.caminhoDiretorio + nomeArquivo + EXTENSAO_ARQUIVO);

        if (file.length() != 0) {
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                obj = ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return obj;
    }
}

