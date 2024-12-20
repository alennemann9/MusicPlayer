// Murph Lennemann

public class SimulatedWire extends Wire {
    public SimulatedWire(int wireNumber) {
        super(wireNumber, 0.996);
    }

    @Override
    public Double generateValue(Integer index, Integer wireLength) {
        if(index % (wireLength / 2) < wireLength / 4) {
            return 0.5;
        }
        else {
            return -0.5;
        }
    }
}
