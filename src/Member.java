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

    public Date setExpire(Date newExpire){
        this.expire = newExpire;
        return expire;
    }

    public Location getHomeStudio(){

        return homeStudio;
    }

    public double bill() {
return 0.0;
    } //return the next due amount

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(profile.getFname()).append(":").append(profile.getLname()).append(profile.getDob().toString()).append(", Membership expires ").append(expire.toString()).append(", Location: ").append(homeStudio.toString());
        return sb.toString();
    }


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


    @Override
    public int compareTo(Member o) {
        return 0;
    }
}