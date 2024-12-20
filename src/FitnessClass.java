public class FitnessClass {
    private Offer classInfo;
    private Instructor instructor;
    private Location studio;
    private Time time;
    private MemberList members;
    private MemberList guests;


    public FitnessClass(Offer classInfo, Instructor instructor, Location studio, Time time, MemberList members, MemberList guests){
        this.classInfo = classInfo;
        this.instructor = instructor;
        this.studio = studio;
        this.time = time;
        this.members = members;
        this.guests = guests;
    }

    public Offer getClassInfo(){
        return classInfo;
    }

    public Instructor getInstructor(){

        return instructor;
    }

    public Location getLocation(){

        return studio;
    }

    public Time getTime(){
        return time;
    }

    public MemberList getMembers(){

        return members;
    }

    public MemberList getGuests(){

        return guests;
    }
}