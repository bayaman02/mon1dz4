import java.util.Random;

public class Main {
    public static int bossHealth = 850;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static int[] heroesHealth = {300, 250, 215, 300};
    public static int[] heroesDamage = {15, 25, 30, 0};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic"};
    public static int roundNumber;

    public static void medicHealth() {
        Random random = new Random();
        int healthPoint = random.nextInt(15, 20);
        for (int i = 0; i < heroesAttackType.length; i++) {
            if (heroesAttackType.equals("Medic")) {
                continue;
            } else if (heroesHealth[i] < 100 && heroesHealth[i] > 0 && heroesHealth[3] > 0) {
                heroesHealth[i] += healthPoint;
                System.out.println("Медик вылечил " + heroesAttackType[i]);
                break;

            }


        }
    }


    public static void main(String[] args) {
        showStatistics();
        while (!isGameOver()) {
            playRound();
        }
    }


    public static void playRound() {
        roundNumber++;
        choosBossDefence();
        bossHits();
        heroesHit();
        showStatistics();
        medicHealth();
    }

    public static void choosBossDefence() {
        Random random = new Random();
        int random1 = random.nextInt(heroesAttackType.length);
        bossDefence = heroesAttackType[random1];
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }
        }
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                int damage = heroesDamage[i];
                if (heroesAttackType[i] == bossDefence) {
                    Random random = new Random();
                    int coff = random.nextInt(9) + 2;
                    damage = heroesDamage[i] * coff;
                    System.out.println("Criritical damage: " + damage);

                }
                if (bossHealth - damage < 0) {
                    bossHealth = 0;
                } else {
                    bossHealth = bossHealth - damage;
                }
            }
        }
    }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won! ");
        }
        return allHeroesDead;
    }


    public static void showStatistics() {
        System.out.println("ROUND " + roundNumber + " ------------");
        System.out.println("Boss health: " + bossHealth + " Damage: " + bossDamage + " Defence: " +
                (bossDefence == null ? " No defence" : bossDefence));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i] + " damage: " + heroesDamage[i]);

        }

    }

}




