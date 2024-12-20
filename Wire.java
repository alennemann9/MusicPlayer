// Murph Lennemann

import java.util.LinkedList;
import java.util.Queue;

public class Wire {
    protected double decayRate;
    protected Queue<Double> noteQueue;
    protected int wireNum;

    // Getters
    public double getDecayRate() {
        return decayRate;
    }
    public Queue<Double> getNoteQueue() {
        return noteQueue;
    }
    public Integer getWireNum() {
        return wireNum;
    }

    public Integer calculateWireLength(int wireNum) {
        return (int)(StdAudio.SAMPLE_RATE * (Math.pow(2.0,(22.0-wireNum)/12.0))/440.0);
    }

    public void buildWire(int wireLength) {
        int i;
        noteQueue = new LinkedList<>();
        for (i=0;i<wireLength;i++) {
            noteQueue.add(0.0);
        }
    }

    public Wire() {
        buildWire(calculateWireLength(0));
        decayRate = 0.995;
    }

    public Wire(Integer wireNumber) {
        buildWire(calculateWireLength(wireNumber));
        decayRate = 0.995;
    }

    public Wire(Integer wireNumber, Double decayRate) {
        buildWire(calculateWireLength(wireNumber));
        this.decayRate = decayRate;
    }

    public Double generateValue(Integer index, Integer wireLength) {
        return Math.random()-0.5;
    }
// This is what is actually changing the note
    public void strike() {
        int i;
        for (i=0;i<noteQueue.size();++i){
            noteQueue.remove();
            noteQueue.add(generateValue(i, noteQueue.size()));
        }
    }

    public Double sample() {
        double firstVal = noteQueue.remove();
        noteQueue.add(((firstVal+noteQueue.peek())/2.0)*decayRate);
        return firstVal;
    }

}
