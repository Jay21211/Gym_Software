import java.io.File;
import java.io.IOException;

public class MemberList {
    private Member [] members; //holds Basic, Family, or Premium objects
    private int size; //number of objects in the array

    private static final int INITIAL_CAPACITY = 4;
    private static final int GROWTH_FACTOR = 4;
    private static final int NOT_FOUND = -1;
    private static final int EMPTY = 0;

    public MemberList(){
        this.members = new Member[INITIAL_CAPACITY];
        this.size = 0;
    }
    private int find(Member member) {

    }



    private void grow() { }
    public boolean contains(Member member) {

    }
    public boolean add(Member member) {

    } //add to end of array
    public boolean remove(Member member) {

    } //shift up to remove
    public void load(File file) throws IOException {

    }//from the text file
    public void printByCounty() {

    } //sort by county then zip code
    public void printByMember() {

    } //sort by member profile
    public void printFees(){

    } //print the array as is with the next due amounts
}