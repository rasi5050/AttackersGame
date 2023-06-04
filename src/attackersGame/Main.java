//the idea was inspired from "https://www.youtube.com/watch?v=EpB9u4ItOYU"
package attackersGame;
import java.util.Random;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        int choice = 0;
        Random rand = new Random();
        System.out.println("______________________________________________________________________________________________________");
        System.out.println(
                "| Welcome to 🐲Attackers Game🐲 " + "                                                                     |" +
                        "\n| You will be born with a random health⚡. " + "                                                           |" +
                        "\n| Your aim is to open maximum number of doors🚪with the health available." + "                            |" +
                        "\n| 1 point will be given for each door🚪tackled." + "                                                      |" +
                        "\n| You may encounter enemies🐲 at the door, " + "                                                          |" +
                        "\n| if u attack a enemy with insufficient health, you will die🪦." + "                                      |" +
                        "\n| You can use wildcards🃏 to drink health portion🍶 or run🏃 away, but only for a total of 3 times. " + " |" +
                        "\n| Happy Playing!✌️" + "                                                                                   |");
        System.out.println("|____________________________________________________________________________________________________|\n");

        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        Enemy enemy = new Enemy();
        do {
            if ((choice != 2  && !(player.wildcards==0 && choice==3)) && (rand.nextInt(2) == 0)) {
                System.out.println("Opening next door🚪\n");
                System.out.println("You are lucky👼🏻, no enemy at the door! ");
                System.out.println("🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃\n");
                System.out.println("Press enter to go for next door🚪\n");
                scanner.nextLine();
                player.score+=1;
            } else {

                if (choice != 2 && !(player.wildcards==0 && choice==3)) {
                    System.out.println("Opening next door🚪\n");
                    enemy = new Enemy();
                    System.out.println(enemy.name + " has arrived 🐲");
                }




                System.out.println(enemy.name + " has health " + enemy.health + "👹️");
                System.out.println("Your health is " + player.health + "⚡️");
                System.out.println("Number of wildcards available is " + player.wildcards + "🃏");
                System.out.println("Your total score is " + player.score + "🚀");
                System.out.println("What do u want to do now?🤔");
                System.out.println("1. Attack🤺");
                System.out.println("2. Drink health portion🍶");
                System.out.println("3. Run🏃‍");
                System.out.println("4. Die!🪦");

                choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        player.health -= enemy.health;
                        if (player.health <= 0) {
                            System.out.println("Bad choice of action. " + enemy.name + " killed you ☠️\n");

                        } else {
                            System.out.println("Good job," + "You killed🙌 " + enemy.name + " \n");
                            player.score += 1;
                        }
                        break;
                    }
                    case 2: {
                        if (player.wildcards>0) {
                            HealthPortion healthPortion = new HealthPortion();
                            player.health += healthPortion.drinkHealthPortion();
                            player.wildcards -= 1;
                            System.out.println("gulp! gulp!. Your health is now "+ player.health + "🍶\n");
                        } else {
                            System.out.println("\n🏴‍☠️🏴‍☠️You're out of wildcards🏴‍☠️🏴‍☠️\n");
                            System.out.println(enemy.name + " will kill you\n");
                        }
                        break;
                    }
                    case 3: {
                        if (player.wildcards>0) {
                            player.wildcards -= 1;
                            player.score += 1;
                            System.out.println("🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃\n");
                            System.out.println("You escaped the enemy👏🏻\n");
                        } else {
                            System.out.println("\n🏴‍☠️🏴‍☠️You're out of wildcards🏴‍☠️🏴‍☠️\n");
                            System.out.println(enemy.name + " will kill you\n");
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("You better die!🤬");
                        player.health = 0;
                        break;
                    }
                }
            }
        } while(player.health>0);





        player.score-=1;
        System.out.println("You're dead🪦!. Your Total score is "+ Math.max(0, player.score) + "🏆");
    }
}


class Player {
    int health, score, wildcards;
    Player() {
        Random rand = new Random();
//        initialize health with a random number from 50 to 100
        health = rand.nextInt(50) + 50;
        score = 0;
//        wildcards can be used if there are not enough health to attack a enemy; but it can be availed only 10 times
        wildcards = 3;

    }
}
class Enemy {
    int health;
    String[] enemies = {"Furious kripke🐲", "Dragon mother🐉", "Killing bee🐝", "Capricious Cheetah🐆"};

    String name;
    Enemy() {
        Random rand = new Random();
        Random enemySelector = new Random();
//        enemies will be born with random health upto 60
        health = rand.nextInt(60);
        char c = (char)(rand.nextInt(26) + 'A');
        int n = rand.nextInt(15);
        name = enemies[enemySelector.nextInt(enemies.length)] + c + n;

    }
}

class HealthPortion {
    int healthPortion;
    HealthPortion() {
        Random rand = new Random();
        healthPortion =  rand.nextInt(100);
    }
    int drinkHealthPortion () {
        return healthPortion;
    }
}