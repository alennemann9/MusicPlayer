// Murph Lennemann

import java.util.ArrayList;

public class Piano extends StringedInstrument {
    public Piano() {
        super(36);
    }

    public Piano(int numWires) {
        super();
        if (numWires >= 0 && numWires <= 88) {
            setWires(numWires);
        } else {
            setWires(36);
        }
    }
// Make sure to use "i" as the input for the newWire
    @Override
    public void setWires(int numWires) {
        wires = new ArrayList<>();
        for (int i = 0; i < numWires; i++) {
            PianoWire newWire = new PianoWire(i);
            addWire(newWire);
        }
    }
}
