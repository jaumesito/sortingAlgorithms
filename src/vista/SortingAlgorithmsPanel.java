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
        JButton insertionButton = new JButton("Insertion");
        JButton aturarButton = new JButton("Aturar");
        JButton reiniciarButton = new JButton("Reiniciar");

        topBar.add(bubbleButton);
        topBar.add(insertionButton);
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

        insertionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.notificar("insertion");
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
