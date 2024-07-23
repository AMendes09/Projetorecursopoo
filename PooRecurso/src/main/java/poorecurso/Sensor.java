/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poorecurso;

/**
 *
 * @author Andre
 */

public abstract class Sensor extends Equipamento {
    public Sensor(String nome) {
        super(nome);
    }

    public abstract Object medir();
}
