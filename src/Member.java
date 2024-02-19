public class Member implements Comparable<Member> {
    private Profile profile;
    private Date expire;
    private Location homeStudio;

    public Member(Profile profile, Date expire, Location homeStudio){
        this.profile = profile;
        this.expire = expire;
        this.homeStudio = homeStudio;
    }

    public Profile getProfile(){

        return profile;
    }

    public Date getExpire(){

        return  expire;
    }

    public Location getHomeStudio(){

        return homeStudio;
    }

    public double bill() {

    } //return the next due amount


    @Override
    public boolean equals(Object obj) {
        Member s = (Member) obj;
    if(!this.profile.equals(s.profile)){
        return false;
    }
    if(!this.expire.equals(s.expire)){
        return false;
    }

    if(!this.homeStudio.equals(s.homeStudio)){
        return false;
    }


    return true;
    }

}