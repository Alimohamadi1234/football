import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner i = new Scanner(System.in);
        System.out.println("whats your job?   1=AddClub   2=DeleteClub   3=PlayMatch");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        if (in==1) {
            System.out.println("enter Club:");
            String inputStr = i.next();
            Football footballDAO = new Football();
            footballDAO.addUser(inputStr);
        }
        if (in==2) {
            System.out.println("enter name of Club:");
            String inputStr2 = i.next();
            Football footbalDAO = new Football();
            footbalDAO.deleteuser(inputStr2);
        }
        if (in==3) {
            Scanner keyboardInput = new Scanner(System.in);
            System.out.println("enter name of club 1");
            String inputStr3 = i.next();
            System.out.println("enter name of club 2");
            String inputStr4 = i.next();
            System.out.print(" Please enter the score "+inputStr3);
            int score1 = keyboardInput.nextInt();
            System.out.print(" Please enter the score "+inputStr4);
            int score2 = keyboardInput.nextInt();
            if (score2>score1){
                System.out.print(inputStr3+" is winner");
                Football footballDAO = new Football();
                footballDAO.update(inputStr4,"1","1","0","0","3");
                footballDAO.update(inputStr3 ,"1","0","1","0","0");
            }
            else if (score1>score2) {
                System.out.print(inputStr3+"is Winner ");
                Football footballDAO = new Football();
                footballDAO.update(inputStr4,"1","0","1","0","0");
                footballDAO.update(inputStr3,"1","1","0","0","3");
            }
            else {
                System.out.print("equal");
                Football footballDAO = new Football();
                footballDAO.update(inputStr3,"1","0","0","1","1");
                footballDAO.update(inputStr4,"1","0","0","1","1");
            }
            keyboardInput.close();
        }
    }

}
