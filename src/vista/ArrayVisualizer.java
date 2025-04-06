package vista;

import sortingAlgorithms.SortingAlgorithms;
import model.Dades;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que dibuixa els punts a la finestra
 * @author jriba
 */
public class ArrayVisualizer extends JPanel {
    private SortingAlgorithms prin;

    public ArrayVisualizer(int w, int h, SortingAlgorithms p) {
        prin = p;
        this.setBounds(0, 0, w, h);
    }

    public void pintar() {
        if (this.getGraphics() != null) {
            paintComponent(this.getGraphics());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dades dad = prin.getDades();
        int w = this.getWidth() - 1;
        int h = this.getHeight() - 1;
        g.setColor(Color.white);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.orange);
        if (dad != null) {
            int barWidth = (w + 1) / dad.getTamElements();
            for (int i = 0; i < dad.getTamElements(); i++) {
                int barHeight = (int) ((dad.getElement(i) / 800.0) * h);
                g.fillRect(i * barWidth, h - barHeight, barWidth, barHeight);
            }

            if (dad.getTime() > 0) {
                g.setColor(Color.black);
                g.drawString("Temps: " + dad.getTime() + "ms", 10, 20);
            }
        }
    }
}
