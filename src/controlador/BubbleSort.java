package controlador;

import sortingAlgorithms.SortingAlgorithms;
import sortingAlgorithms.Notificar;
import model.Dades;

/**
 * Classe que implementa l'algorisme de BubbleSort
 * @author jriba
 */
public class BubbleSort extends Thread implements Notificar {
    private boolean cancel;
    private final SortingAlgorithms princ;

    public BubbleSort(SortingAlgorithms p) { princ = p; }

    public void run() {
        cancel = false;
        Dades dad = princ.getDades();

        long startTime = System.currentTimeMillis();
        for (int i = 1; (i < dad.getTamElements()) && (!cancel); i++) {
            for(int j = 0; (j < dad.getTamElements() - i) && (!cancel); j++) {
                if (dad.getElement(j) > dad.getElement(j + 1)) {
                    int aux = dad.getElement(j);
                    dad.setElement(j, dad.getElement(j + 1));
                    dad.setElement(j + 1, aux);
                    princ.notificar("pintar");
                }
            }
        }

        if (!cancel) {
            dad.setTime(System.currentTimeMillis() - startTime);
            princ.notificar("pintar");
        }
    }

    private void aturar() {
        cancel = true;
    }

    @Override
    public void notificar(String s) {
        if (s.contentEquals("aturar")) {
            aturar();
        }
    }
}
