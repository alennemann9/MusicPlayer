import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * The Player class gives a basic menu for choosing
 * - the instrument sound,
 * - free play or file play mode, and
 * - (optionally) the file to select.
 *
 * No updates to this code should be necessary.
 *
 * @author Your CS Professors
 * Creation date: 3/31/2023
 * Last updated: 10/18/2024
 */
public class Player {

    public static final String DEFAULT_FILENAME = "MarySimple.txt";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Which instrument to play?\n\t(p) Piano \n\t(e) Electric Piano\n\t(h) Harpsichord");
        System.out.print("Enter selection (or hit Enter for piano): ");
        String tone = input.nextLine();

        StringedInstrument instrument = null;
        if(tone.equals("e")){
            instrument = new ElectricPiano();
        }else if (tone.equals("h")){
            instrument = new Harpsichord();
        }else{
            instrument = new Piano();
        }

        System.out.println("Which mode to play\n\t(fp) Free Play\n\t(fi) file? ");
        System.out.print("Enter selection (or hit Enter for file mode): ");
        String mode = input.nextLine();

        if(mode.equals("fp")){
            startFreePlayMode(instrument);
        }
        else{
            startFilePlayMode(input, instrument);
        }
    }

    private static void startFilePlayMode(Scanner input, StringedInstrument instrument) {
        System.out.printf("Enter input file (or hit Enter for %s): ", DEFAULT_FILENAME);
        String dataSource = input.nextLine();
        dataSource = dataSource.isBlank() ? DEFAULT_FILENAME : dataSource;
        Scanner file = getFileScanner(dataSource);

        while (file != null && file.hasNextLine()) {
            String[] notes = file.nextLine().split(" ");
            for(String s : notes) {
                int wireNum = NoteConverter.convert(s, 0);
                System.out.print(s + ": " + wireNum + " ");
                instrument.strikeWire(wireNum);
            }
            System.out.println();
            for(int i = 0; i < StdAudio.SAMPLE_RATE / 2; i++) {
                instrument.play();
            }
        }
    }

    private static void startFreePlayMode(StringedInstrument instrument) {
        String keys = "w3e4rt6y7u8izsxdcvgbhnjm,";
        StdDraw.setFont(new Font("Monospaced", Font.PLAIN, 16));
        StdDraw.textLeft(0.0, 1.00, "     PIANO KEY MAPPINGS");
        StdDraw.textLeft(0.0, 0.91, " 3 4   6 7 8   s d   g h j");
        StdDraw.textLeft(0.0, 0.88, "w e r t y u i z x c v b n m ,");
        StdDraw.textLeft(0.0, 0.83, "^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^");
        StdDraw.textLeft(0.0, 0.80, "C D E F G A B C D E F G A B C");

        instrument.setWires(keys.length());
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                instrument.strikeWire(keys.indexOf(StdDraw.nextKeyTyped()));
            }
            instrument.play();
        }
    }

    // this method will be provided to you in all programs for a while
    // sometime later in our course we will discuss how this works
    public static Scanner getFileScanner(String fileName) {
        try {
            FileInputStream textFileStream = new FileInputStream(fileName);
            Scanner inputFile = new Scanner(textFileStream);
            return inputFile;
        }
        catch (IOException ex) {
            System.out.println("Warning: could not open " + fileName);
            return null;
        }
    }
}
