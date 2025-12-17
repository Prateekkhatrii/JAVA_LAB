package SEE;
import CIE.Personal;
public class External extends Personal {
    public int[] externalMarks = new int[5];
    public External(String usn, String name, int sem, int[] ext){
        super(usn, name, sem);
        for(int i = 0; i < 5; i++){
            externalMarks[i] = ext[i];
        }
    }
}
