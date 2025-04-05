package controlador;

import sortingAlgorithms.SortingAlgorithms;
import sortingAlgorithms.Notificar;
import model.Dades;

/**
 * Classe que implementa l'algorisme de InsertionSort
 * @author jriba
 */
public class InsertionSort extends Thread implements Notificar {
    private boolean cancel;
    private final SortingAlgorithms princ;

    public InsertionSort(SortingAlgorithms p) { princ = p; }

    public void run() {
        cancel = false;
        Dades dad = princ.getDades();

        long startTime = System.currentTimeMillis();
        for (int i = 1; (i < dad.getTamElements()) && (!cancel); i++) {
            int key = dad.getElement(i);
            int j = i - 1;

            while ((j >= 0) && (dad.getElement(j) > key) && (!cancel)) {
                dad.setElement(j + 1, dad.getElement(j));
                j--;
                princ.notificar("pintar");
            }
            dad.setElement(j + 1, key);
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
