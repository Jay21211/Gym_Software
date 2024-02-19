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
        for (int i = 0; i < size; i++) {
            if (members[i] != null && members[i].equals(members)) {
                return i;
            }
        }
        return NOT_FOUND;
    }



    private void grow() {
        if(size>= members.length) {
            Member[] newAlbums = new Member[members.length + GROWTH_FACTOR];
            System.arraycopy(members, 0, newAlbums, 0, size);
            members = newAlbums;
        }
    }

    public boolean contains(Member member) {
        for(int i = 0; i< size; i++){
            if(members[i].equals(member)){
                return true;
            }
        }
        return false;
    }

    public boolean add(Member member) {
        if (contains(member)) {
            return false; // Album already exists
        } else {
            if (size >= members.length) {
                grow();
            }
            if(member.getExpire().isValid() && member.getProfile().getDob().isValid()) {
                members[size++] = member;
                return true;
            }
        }
        return false;

    } //add to end of array
    public boolean remove(Member member) {
        if (contains(member)) {
            int index = find(member);
            if (index == NOT_FOUND) {
                return false; // Album not found
            } else {
                Member copy = members[index];
                if (member.equals(copy)) {
                    // Shift elements up one position
                    for (int i = index; i < size - 1; i++) {
                        members[i] = members[i + 1];
                    }
                    members[size - 1] = null; // Set the last element to null
                    size--;
                    return true;
                }
            }
        }
        return false;
    }
    public void load(File file) throws IOException {

    }//from the text file
    public void printByCounty() {

    } //sort by county then zip code
    public void printByMember() {

    } //sort by member profile
    public void printFees(){

    } //print the array as is with the next due amounts
}