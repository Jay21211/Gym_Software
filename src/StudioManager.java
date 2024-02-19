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
            String[] cmd_arr = commandLine.split(",");
            String command = cmd_arr[0].trim();
            if (commandLine.isEmpty()) {
                continue;
            }
            switch (command) {
                case "AB":

                    break;
                case "AF":

                    break;
                case "AP":

                    break;
                case "C":

                    break;
                case "S":

                    break;
                case "PM":

                    break;
                case "PC":

                    break;
                case "PF":

                    break;
                case "R":

                    break;
                case "U":

                    break;
                case "RG":

                    break;
                case "UG":

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

    private MemberList createMemberList(String[] cmd_arr){
        try{

        }
    }


    }




