public class Profile implements Comparable<Profile> {
    private String fname;
    private String lname;
    private Date dob;

    MemberList memberList = new MemberList();
    public Profile(String fname, String lname, Date dob) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    public String getFname() {

        return fname;
    }

    public String getLname() {
        return
                lname;
    }

    public Date getDob() {
        return
                dob;
    }

    @Override
    public boolean equals(Object obj) {
        Profile s = (Profile) obj;
        if (!this.fname.toUpperCase().equals(s.fname.toUpperCase())) {
            return false;

        }
        if (!this.lname.toUpperCase().equals(s.fname.toUpperCase())) {
            return false;
        }

        if (((this.dob.compareTo(s.dob)) != 0)) {
            return false;
        }


        return true;
    }

    @Override
    public int compareTo(Profile other) {
        int lastNameComparison = lname.compareTo(other.lname);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        int firstNameComparison = fname.compareTo(other.fname);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        return dob.compareTo(other.dob);
    }

    @Override
    public String toString() {

StringBuilder sb = new StringBuilder();
sb.append(fname).append(":").append(lname).append(dob).append(", Membership expires ").append()

    }
}
