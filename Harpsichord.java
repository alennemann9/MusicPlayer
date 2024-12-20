// Murph Lennemann

import java.util.ArrayList;

public class Harpsichord extends StringedInstrument {
    public Harpsichord() {
        super(48);
    }

    public Harpsichord(int numWires) {
        super();
        if (numWires>=0 && numWires<=60) {
            setWires(numWires);
        }
        else {
            setWires(48);
        }
    }

    // Make sure to use "i" as the input for the newWire
    @Override
    public void setWires(int numWires) {
        wires = new ArrayList<>();
        int i;
        for (i = 0; i < numWires; i++) {
            HarpsichordWire newWire = new HarpsichordWire(i);
            wires.add(newWire);
        }
    }
}
