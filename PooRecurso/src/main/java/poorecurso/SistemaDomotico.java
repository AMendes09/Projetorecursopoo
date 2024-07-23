/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poorecurso;

/**
 *
 * @author Andre
 */
import java.io.*;

public class SistemaDomotico implements Serializable {
    private Habitacao habitacao;

    public SistemaDomotico(Habitacao habitacao) {
        this.habitacao = habitacao;
    }

    public Habitacao getHabitacao() {
        return habitacao;
    }

    public void salvarEstado(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this.habitacao);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarEstado(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            this.habitacao = (Habitacao) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
