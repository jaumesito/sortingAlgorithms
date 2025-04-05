package sortingAlgorithms;

import controlador.BubbleSort;
import controlador.InsertionSort;
import controlador.SelectionSort;
import model.Dades;
import vista.SortingAlgorithmsPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jriba
 */
public class SortingAlgorithms implements Notificar {
    private SortingAlgorithmsPanel finestra;
    private ArrayList<Notificar> procesos = null;
    private Dades dad = null;
    private Random rand = new Random();

    public static void main(String[] args) {
        (new SortingAlgorithms()).inicio();
    }

    private void inicio() {
        dad = new Dades();
        procesos = new ArrayList <> ();
        preparar();
        JFrame frame = new JFrame("Sorting algorithms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra = new SortingAlgorithmsPanel(this);
        frame.setContentPane(finestra);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void preparar() {
        procesos = new ArrayList <> ();
        dad.clear();
        for (int i = 0; i < 100; i++) {
            dad.posarElement(rand.nextInt(1, 100));
        }
    }

    @Override
    public synchronized void notificar(String s) {
        int vius;
        switch (s) {
            case "bubble" -> {
                vius = 0;
                for(int i=0;i<procesos.size();i++) {
                    if (((Thread)procesos.get(i)).isAlive()) {
                        vius++;
                    }
                }
                if (vius == 0) {
                    procesos.add(new BubbleSort(this));
                    for (int i = 0; i < procesos.size(); i++) {
                        ((Thread) procesos.get(i)).start();
                    }
                }
            }
            case "selection" -> {
                vius = 0;
                for(int i=0;i<procesos.size();i++) {
                    if (((Thread)procesos.get(i)).isAlive()) {
                        vius++;
                    }
                }
                if (vius == 0) {
                    procesos.add(new SelectionSort(this));
                    for (int i = 0; i < procesos.size(); i++) {
                        ((Thread) procesos.get(i)).start();
                    }
                }
            }
            case "insertion" -> {
                vius = 0;
                for(int i=0;i<procesos.size();i++) {
                    if (((Thread)procesos.get(i)).isAlive()) {
                        vius++;
                    }
                }
                if (vius == 0) {
                    procesos.add(new InsertionSort(this));
                    for (int i = 0; i < procesos.size(); i++) {
                        ((Thread) procesos.get(i)).start();
                    }
                }
            }
            case "aturar" -> {
                for (int i = 0; i < procesos.size(); i++) {
                    procesos.get(i).notificar("aturar");
                }
            }
            case "reiniciar" -> {
                for (int i = 0; i < procesos.size(); i++) {
                    procesos.get(i).notificar("aturar");
                }
                preparar();
                finestra.notificar("pintar");
            }
            case "pintar" -> {
                finestra.notificar("pintar");
            }
            default -> {
            }
        }
    }

    public Dades getDades() {
        return dad;
    }
}