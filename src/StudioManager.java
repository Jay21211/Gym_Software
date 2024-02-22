import java.util.Scanner;
public class StudioManager {

    private MemberList memberList;

    public StudioManager(){

        this.memberList = new MemberList();
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Studio Manager is up running.");
        while (true) {
            String commandLine = scanner.nextLine();
            String[] cmd_arr = commandLine.split(" ");
            String command = cmd_arr[0].trim();
            if (commandLine.isEmpty()) {
                continue;
            }
            switch (command) {
                case "AB":
                    addBasic(commandLine,cmd_arr,command);
                    break;
                case "AF":
                    addFamily(commandLine,cmd_arr,command);
                    break;
                case "AP":
                    addPremium(commandLine,cmd_arr,command);
                    break;
                case "C":
                    cancel(commandLine,cmd_arr,command);
                    break;
                case "S":
                    schedule(commandLine,cmd_arr,command);
                    break;
                case "PM":
                    pm(cmd_arr);
                    break;
                case "PC":
                    pc(cmd_arr);
                    break;
                case "PF":
                    pf(cmd_arr);
                    break;
                case "R":
                    memberAttendance(commandLine,cmd_arr,command);
                    break;
                case "U":
                    removeMember(commandLine,cmd_arr,command);
                    break;
                case "RG":
                    guestAttendance(commandLine,cmd_arr,command);
                    break;
                case "UG":
                    removeGuest(commandLine,cmd_arr,command);
                    break;
                case "Q":
                    System.out.println("Studio Manager terminated.");
                    scanner.close();
                    break;
                case " ":
                    continue;
                default:
                    System.out.println("Invalid Command!");
                    break;
            }
        }
    }
    private  void addBasic(String commandLine, String[] cmd_arr, String command) {
    if(cmd_arr.length == 5){
    Member member = createMember(cmd_arr);
    if(member!= null){
    if(!memberList.contains(member)){
    memberList.add(member);
    System.out.println(member.getProfile().getFname() + " " + member.getProfile().getLname() + " added.");
    }
    }
    }
    }

    private  void addFamily(String commandLine, String[] cmd_arr, String command) {

    }

    private  void addPremium(String commandLine, String[] cmd_arr, String command) {

    }

    private  void cancel(String commandLine, String[] cmd_arr, String command) {

    }
    private  void schedule(String commandLine, String[] cmd_arr, String command) {
    }

    private void pm(String[] cmd_arr){

    }

    private void pc(String[] cmd_arr){
    memberList.printByCounty();
    }
    private void pf(String[] cmd_arr){

    }
    private void memberAttendance(String commandLine, String[] cmd_arr, String command){

    }
    private void removeMember(String commandLine, String[] cmd_arr, String command){

    }

    private void guestAttendance(String commandLine, String[] cmd_arr, String command){

    }
    private void removeGuest(String commandLine, String[] cmd_arr, String command){

    }

    private Member createMember(String[] cmd_arr){
        try{
            String firstName = cmd_arr[1];
            String lastName = cmd_arr[2];
            String birthDate = cmd_arr[3];
            String location = cmd_arr[4];

            String[] dobArr = birthDate.split("/");
            int dobMonth = Integer.parseInt(dobArr[0]);
            int dobDay = Integer.parseInt(dobArr[1]);
            int dobYear = Integer.parseInt(dobArr[2]);

            Date dob = new Date(dobYear,dobMonth,dobDay);
            if(!dob.isValid()){
                System.out.println("DOB " + dob.toString() + ": invalid calender date!");
            }
            Profile p1 = new Profile(firstName,lastName, dob);

            Location l1 = Location.findLocation(location);


            Date expire = Date.calculateExpiration(cmd_arr[0]);
            if(cmd_arr[0].equals("AB")) {
                return new Basic(p1, expire, l1);
            }
            if(cmd_arr[0].equals("AF")){
                return new Family(p1,expire,l1);
            }
            if(cmd_arr[0].equals("AP")){
                return new Premium(p1,expire,l1);
            }
        } catch (IllegalArgumentException ignored) {
        }
        return null;
    }


    }




