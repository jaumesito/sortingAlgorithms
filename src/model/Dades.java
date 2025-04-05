package model;

import java.util.ArrayList;

/**
 *
 * @author jriba
 */
public class Dades {

    private ArrayList<Integer> elements;
    private long time;

    public Dades() {
        elements = new ArrayList<>();
    }

    public void clear() {
        elements.clear();
        time = 0;
    }

    public int getTamElements() {
        return elements.size();
    }

    public int getElement(int i) {
        return elements.get(i);
    }

    public void posarElement(int n) {
        elements.add(n);
    }

    public void setElement(int i, int n) {
        elements.set(i, n);
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
