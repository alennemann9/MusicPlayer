/**
 * NoteConverter is a helper class to convert from a string version of a note to
 * an integer value. Note strings range start at C, but can range from A-G. The + symbol
 * moves the note up an octave. The # symbol (sharp) moves the note up halfway, i.e.,
 * C# is between C and D. The b symbol (flat) moves the note down a half step, i.e.,
 * Bb is between A and B.
 *
 * Examples of valid notes:
 * C
 * C# (C sharp)
 * C+ (up one octave)
 * C++ (up two octaves)
 * Db (D flat)
 * Db+ (D flat up one octave)
 *
 * No updates to this code should be necessary.
 *
 * @author Your CS Professors
 * Date: 10/18/2024
 */
public class NoteConverter {
    // we assume that our piano always starts at its lowest C.
    // for each octave up, add a + at the end.
    public static int convert(String s, int lowestOctave){
        int note = -1;
        boolean sharpOrFlat = false;
        if(s.length() == 0){
            return note;
        }

        if(s.substring(0,1).equals("C")){
            note = 0;
        }
        else if(s.substring(0,1).equals("D")){
            note = 2;
        }
        else if(s.substring(0,1).equals("E")){
            note = 4;
        }
        else if(s.substring(0,1).equals("F")){
            note = 5;
        }
        else if(s.substring(0,1).equals("G")){
            note = 7;
        }
        else if(s.substring(0,1).equals("A")){
            note = 9;
        }
        else if(s.substring(0,1).equals("B")) {
            note = 11;
        }

        if(s.length() > 1){
            if(s.substring(1,2).equals("#")){
                note++;
                sharpOrFlat = true;
            }
            else if(s.substring(1,2).equals("b")){
                note--;
                sharpOrFlat = true;
            }
        }

        int i = 1;
        if(sharpOrFlat){
            i = 2;
        }
        for(;i < s.length(); i++){
            if(s.substring(i,i+1).equals("+")){
                note += 12;
            }
        }
        note += lowestOctave * 12;

        return note;
    }

}
