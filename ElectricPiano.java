// Murph Lennemann

import java.util.ArrayList;

public class ElectricPiano extends Piano{
    public ElectricPiano() {
        super();
    }

    public ElectricPiano(int numWires) {
        super(numWires);
    }

    // Make sure to use "i" as the input for the newWire
    @Override
    public void setWires(int numWires) {
        wires = new ArrayList<>();
        int i;
        for (i = 0; i < numWires; i++) {
            SimulatedWire newWire = new SimulatedWire(i);
            wires.add(newWire);
        }
    }
}
