import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Майкл Джексон", 999));
        players.add(new Player("дима", 321));
        players.add(new Player("вика", 99));
        players.add(new Player("Илья", 34));
        players.add(new Player("Олег", 812));
        int choice = -1;
        while (choice != 0){
            System.out.println("Выберите действие:1-показать игроков,2-найти лучшего,3-выдать бонус,4-посчитать средний счет игроков,5-добавить игрока,6-удалить игрока,7-изменить счет игроку,8-показать игрока по номеру,0-выйти");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    for (Player player:players){
                        System.out.println(player.name+ ": "+player.score);
                    }
                    break;
                case 2:
                    Player best = bestPlayer(players);
                    if (best == null){
                        System.out.println("Список игроков пуст!");
                    }
                    else{
                        System.out.println("Лучший игрок: "+best.name+" с "+best.score+" очками");
                    }
                    break;
                case 3:
                    System.out.println("Введите сумму бонуса:");
                    int bonus = scanner.nextInt();
                    addBonus(players,bonus);
                    break;
                case 4:
                    double avg = avgScore(players);
                    if (players.isEmpty()){
                        System.out.println("Список игроков пуст!");
                    }
                        else{
                    System.out.println("Средний счет игроков: "+avg);
                }
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Введите имя игрока:");
                    String newname = scanner.nextLine();
                    System.out.println("Введите счет игрока:");
                    int newscore = scanner.nextInt();
                    addPlayer(players, newname, newscore);
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.println("Введите имя игрока, которого хотите удалить:");
                    String name = scanner.nextLine();
                    removePlayer(players,name);
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.println("Введите имя игрока, счет которого хотите изменить:");
                    String editname = scanner.nextLine();
                    System.out.println("Введите новый счет:");
                    int scoreedit = scanner.nextInt();
                    editScore(players, editname, scoreedit);
                    break;
                case 8:
                    scanner.nextLine();
                    System.out.println("Введите номер игрока:");
                    int target = scanner.nextInt();
                    Player pplayer = showPlayerNumber(players, target);
                    System.out.println(pplayer.name + ": "+ pplayer.score);
                    break;
                case 0:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Такого выбора нет");
                    break;
            }
        }

    }
    public static Player showPlayerNumber(ArrayList<Player> players, int target){
        return players.get(target-1);
    }
    public static void editScore(ArrayList<Player> players, String editname, int scoreedit){
        for (Player player:players){
            if (player.name.equals(editname)){
                player.score = scoreedit;
            }
        }
    }
    public static void removePlayer(ArrayList<Player> players, String name){
        players.removeIf(player -> player.name.equals(name));
    }
    public static void addPlayer(ArrayList<Player> players, String newname, int newscore){
        players.add(new Player(newname, newscore));
    }
    public static void addBonus(ArrayList<Player> players, int bonus){
        for (Player player:players){
            player.score += bonus;
        }
    }
    public static double avgScore(ArrayList<Player> players){
        int allscore = 0;
        int count = 0;
        double avg;
        for (int i = 0; i<players.size();i++){
            allscore += players.get(i).score;
            count++;
        }
        avg = (double ) allscore/count;
        return avg;
    }
    public static Player bestPlayer(ArrayList<Player> players){
        if (players.isEmpty()){
            return null;
        }
            Player best = players.get(0);
            for (Player player: players){
                if (best.score<player.score){
                    best = player;
                }
            }
            return best;
        }
    public static class Player{
        String name;
        int score;
        Player(String name, int score){
            this.name = name;
            this.score=score;
        }
    }
}