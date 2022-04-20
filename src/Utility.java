import java.util.ArrayList;

public class Utility {
    ArrayList<Integer> sequence;
    int initial;

    public ArrayList<Integer> Simulator(String seq, int initial) {
        sequence = new ArrayList<>();
        try {
            String[] seqs = seq.trim().split(" ");
            for (String string : seqs) {
                int position = Integer.parseInt(string);
                sequence.add(position);
            }
            this.initial = initial;
        } catch (Exception e) {
            System.out.println("here");
        }
        return sequence;
    }
}
