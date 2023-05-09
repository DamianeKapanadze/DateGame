import java.util.Scanner;

final class Date{
    public int month;
    public int day;
    public Date(int month, int day){
        this.month=month;
        this.day=day;
    }
}

public class DateGame {
    public static int whichPlayer(int a) {
        if (a % 2 == 0)
            return 2;
        else
            return 1;
    }
    public static Date ai(Date date){
        if(date.day == date.month + 19){ // mashin wavaget mainc
            date.day = 31;
        }else if(date.day < date.month + 19){
            date.day = date.month + 19;
        }else{
            date.month = date.day - 19;
        }
        return date;
    }

    public static void main(String[] args) {
        Date date = new Date(1,1);
        int turn = 0;
        while (date.day <= 31 && date.month <= 12) {
            if(turn%2 == 0) {
                date = ai(date);
                System.out.println("player 2 made move. The date is " + date.month + " " + date.day);
                turn++;
            }else{
                if (date.day == 31 && date.month == 12) {
                    System.out.println(whichPlayer(turn) + " player won");
                    break;
                }
                turn++;
                System.out.print(whichPlayer(turn) + " player, current date is " + date.month + " " + date.day
                        + " which are u going to change - M or D ");
                Scanner s = new Scanner(System.in);
                String q = s.nextLine();
    
                if (q.equals("M") || q.equals("m")) {
                    System.out.println("Enter your month- " + whichPlayer(turn) + " player ");
                    int player = s.nextInt();
                    if (player > date.month && player < 13) {
                        date.month = player;
                    } else {
                        turn--;
                        System.out.println("invalid month, try again " + whichPlayer(turn) + " player");
                    }
                } else if (q.equals("D") || q.equals("d")) {
                    System.out.println("Enter your day- " + whichPlayer(turn) + " player ");
                    int player = s.nextInt();
                    if (player > date.day && player < 32) {
                        date.day = player;
                    } else {
                        turn--;
                        System.out.println("invalid date, try again " + whichPlayer(turn) + " player");
                    }
                } else {
                    turn--;
                }
            }
        }
    }
}