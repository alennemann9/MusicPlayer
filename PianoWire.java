// Murph Lennemann

public class PianoWire extends Wire{
    public PianoWire(int wireNumber) {
        super(wireNumber, 0.996);
    }

    @Override
    public Double generateValue(Integer index, Integer wireLength) {
        return (Math.sin((double)index / (Math.PI * (double)wireLength / 2.0)) - 0.5);
    }
}
