public class Premium extends Member{
    private int guestPass;
    public Premium(Profile profile, Date expire, Location homeStudio){
        super(profile, expire, homeStudio);
        //must override the bill() method,
    }
}
