package controlador;

import sortingAlgorithms.SortingAlgorithms;
import sortingAlgorithms.Notificar;
import model.Dades;

/**
 * Classe que implementa l'algorisme de HeapSort
 * @author jriba
 */
public class HeapSort extends Thread implements Notificar {
    private boolean cancel;
    private final SortingAlgorithms princ;

    public HeapSort(SortingAlgorithms p) { princ = p; }

    public void run() {
        cancel = false;
        Dades dad = princ.getDades();

        long startTime = System.currentTimeMillis();
        int n = dad.getTamElements();
        for (int i = n / 2 - 1; (i >= 0) && (!cancel); i--) {
            heapify(dad, n, i);
        }

        for (int i = n - 1; (i > 0) && (!cancel); i--) {
            int aux = dad.getElement(0);
            dad.setElement(0, dad.getElement(i));
            dad.setElement(i, aux);
            princ.notificar("pintar");
            heapify(dad, i, 0);
        }

        if (!cancel) {
            dad.setTime(System.currentTimeMillis() - startTime);
            princ.notificar("pintar");
        }
    }

    private void heapify(Dades dad, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if ((l < n) && (dad.getElement(l) > dad.getElement(largest)) && (!cancel)) {
            largest = l;
        }

        if ((r < n) && (dad.getElement(r) > dad.getElement(largest)) && (!cancel)) {
            largest = r;
        }

        if (largest != i) {
            int aux = dad.getElement(i);
            dad.setElement(i, dad.getElement(largest));
            dad.setElement(largest, aux);
            princ.notificar("pintar");
            heapify(dad, n, largest);
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
