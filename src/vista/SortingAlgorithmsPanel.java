package vista;

import sortingAlgorithms.SortingAlgorithms;
import sortingAlgorithms.Notificar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingAlgorithmsPanel extends JPanel implements Notificar {

    private SortingAlgorithms principal;
    private ArrayVisualizer arrayVisualizer;

    public SortingAlgorithmsPanel(SortingAlgorithms p) {
        principal = p;
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());

        JPanel topBar = new JPanel();

        JButton bubbleButton = new JButton("Bubble");
        JButton selectionButton = new JButton("Selection");
        JButton insertionButton = new JButton("Insertion");
        JButton heapButton = new JButton("Heap");
        JButton aturarButton = new JButton("Aturar");
        JButton reiniciarButton = new JButton("Reiniciar");

        topBar.add(bubbleButton);
        topBar.add(selectionButton);
        topBar.add(insertionButton);
        topBar.add(heapButton);
        topBar.add(aturarButton);
        topBar.add(reiniciarButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 800, 600);
        arrayVisualizer = new ArrayVisualizer(800, 600, principal);
        mainPanel.add(arrayVisualizer);

        add(topBar, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        bubbleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.notificar("bubble");
            }
        });

        selectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.notificar("selection");
            }
        });

        insertionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.notificar("insertion");
            }
        });

        heapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.notificar("heap");
            }
        });

        aturarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.notificar("aturar");
            }
        });

        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.notificar("reiniciar");
            }
        });

    }

    @Override
    public void notificar(String s) {
        if (s.startsWith("pintar")) {
            arrayVisualizer.pintar();
        }
    }
}
