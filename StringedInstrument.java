// Murph Lennemann

import java.util.ArrayList;

public class StringedInstrument {
    protected ArrayList<Wire> wires;

    public ArrayList<Wire> getWires() {
        return wires;
    }

    public void addWire(Wire myWire) {
        wires.add(myWire);
    }

    public void setWires(int numWires) {
        wires = new ArrayList<>();
        for (int i=0; i<numWires; i++) {
            Wire newWire= new Wire();
            addWire(newWire);
        }
    }

    public StringedInstrument() {
        wires = new ArrayList<Wire>();
    }

    public StringedInstrument(int numWires) {
        wires = new ArrayList<Wire>();
        setWires(numWires);
    }
  // creates a check on the wire size
    public Boolean strikeWire(int wireNum) {
        if (wireNum>=0 && wireNum<=wires.size()) {
            (wires.get(wireNum)).strike();
            return true;
        }
        else {
            return false;
        }
    }

    public void play() {
        StdAudio.play(calculateSampleFromWires());
    }

    public Double calculateSampleFromWires() {
        double sum = 0;
        for (Wire w: wires) {
            sum+=w.sample();
        }
        return sum;
    }
}
