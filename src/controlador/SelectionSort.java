package controlador;

import model.Dades;
import sortingAlgorithms.Notificar;
import sortingAlgorithms.SortingAlgorithms;

/**
 * Classe que implementa l'algorisme de SelectionSort
 * @author jriba
 */
public class SelectionSort extends Thread implements Notificar {
    private boolean cancel;
    private final SortingAlgorithms princ;

    public SelectionSort(SortingAlgorithms p) { princ = p; }

    public void run() {
        cancel = false;
        Dades dad = princ.getDades();

        long startTime = System.currentTimeMillis();
        for (int i = 0; (i < dad.getTamElements() - 1) && (!cancel); i++) {
            int minIndex = i;
            for (int j = i + 1; (j < dad.getTamElements()) && (!cancel); j++) {
                if (dad.getElement(j) < dad.getElement(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int aux = dad.getElement(i);
                dad.setElement(i, dad.getElement(minIndex));
                dad.setElement(minIndex, aux);
                princ.notificar("pintar");
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
