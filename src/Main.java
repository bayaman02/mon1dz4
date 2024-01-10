import java.util.Random;

public class Main {
    //hi sensei
    public static int bossHealth = 800;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static int[] heroesHealth = {300, 270, 250,300 };
    public static int[] heroesDamage = {10, 15, 20,0};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic"};
    public static int roundNumber;

    public static void main(String[] args) {
        printStatistics();
        while (!isGameOver()) {
            playRound();
        }
    }

    public static void medic(){
        int hill = 35;
        for (int i = 0; i <heroesHealth.length ; i++) {
            if (heroesAttackType[i].equals("Medic")){
                continue;
            }
            if (heroesHealth[i] < 100 && heroesHealth[i] > 0 && heroesHealth[3]> 0) {
                heroesHealth[i] += hill;
                System.out.println("Медик выдечил: " + heroesAttackType[i]);
                break;
            }

        }

    }




    public static void chooseBossDefence() {
        Random random = new Random();
        int randomDef = random.nextInt(heroesAttackType.length);
        bossDefence = heroesAttackType[randomDef];
    }

    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        bossAttack();
        heroesAttack();
        medic();
        printStatistics();
    }

    public static void printStatistics() {
        System.out.println("ROUND " + roundNumber + " ------------");
        //if (bossDefence == null){
        //  bossDefence = "No defence";
        //}
        System.out.println("Boss health: " + bossHealth + " damage: " + bossDamage
                + " defence: " + (bossDefence == null ? "No defence" : bossDefence));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i] + " damage: " + heroesDamage[i]);
        }
    }

    public static void bossAttack() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] - bossDamage < 0) {
                heroesHealth[i] = 0;
            } else {
                heroesHealth[i] -= bossDamage;
            }
        }
    }

    public static void heroesAttack() {
        for (int i = 0; i < heroesDamage.length; i++) {
            int damage = heroesDamage[i];
            if (heroesAttackType[i] == bossDefence) {
                Random random = new Random();
                int coeff = random.nextInt(9) + 2;
                damage = heroesDamage[i] * coeff;
                System.out.println("Critical damage: " + damage);
            }
            if (bossHealth > 0 && damage > 0){
                if (bossHealth - damage < 0) {
                    bossHealth = 0;
                } else {
                    bossHealth -= damage;
                }
        }
        }
    }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

}


 /*   public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static int[] heroesHealth = {280, 270, 250};
    public static int[] heroesDamage = {10, 15, 20};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic"};
    public static int roundNumber;

    public static void main(String[] args) {
        printStatistics();
        while (!isGameOver()) {
            playRound();
        }
    }

    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        bossAttack();
        heroesAttack();
        printStatistics();
    }

    public static void chooseBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefence = heroesAttackType[randomIndex];

    }

    public static void heroesAttack() {
        for (int i = 0; i < heroesDamage.length; i++) {
            int damage = heroesDamage[i];
            if (heroesAttackType[i] == bossDefence) {
                Random random = new Random();
                int coeff = random.nextInt(8) + 2;
                damage = heroesDamage[i] * coeff;
                System.out.println("Critical damage: " + damage);
            }
            if (bossHealth - damage < 0) {
                bossHealth = 0;
            } else {
                bossHealth -= damage;
            }
            // if (heroesHealth[i] >0 && bossHealth >0) {
            //   bossHealth -= heroesDamage[i];
            //}
        }
    }

    public static void bossAttack() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] - bossDamage < 0) {
                heroesHealth[i] = 0;
            } else {
                heroesHealth[i] -= bossDamage;
            }
            //if (heroesHealth[i] > 0) {
            //  heroesHealth[i] -= bossDamage;
            //}
        }
    }*/



        /*  public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static int[] heroesHealth = {270, 220, 160, 180};
    public static int medicHealth = 300;
    public static int[] heroesDamage = {20, 25, 35, 17};
    public static int medicDamage = 0;
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic", "Lucky"};
    public static int roundNumber;

        printStatistic();
        while (!isGameOver()) {
            playRound();
        }

           public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        bossAttack();
        heroesAttack();
        medic();
        printStatistic();
    }

    public static void lucky() {
                boolean nePopal = true;
                Random random = new Random();
                random.nextBoolean(nePopal); - t
    }

    public static void medic() {
        Random random = new Random();
        int health = 20;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesAttackType[i].equals("Medic")) {
                continue;
            }
            if (heroesHealth[i] < 100 && heroesHealth[i] > 0) {
                heroesHealth[i] += health;
                System.out.println("Medic вылечил: " + heroesAttackType[i]);
                break;
            }
            //break;
        }
    }


    public static void chooseBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefence = heroesAttackType[randomIndex];
    }

    public static void bossAttack() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                heroesHealth[i] -= bossDamage; // heroesHealth[i] = heroesHealth[i] - bossHealth;
                if (heroesHealth[i] < 0) { // второй вариант
                    heroesHealth[i] = 0;
                }
            }
        }
    }

    public static void heroesAttack() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                int damage = heroesDamage[i];
                if (heroesAttackType[i] == bossDefence) {
                    Random random = new Random();
                    int coeff = random.nextInt(8) + 2;
                    damage = heroesDamage[i] * coeff;
                    System.out.println("Critical damage: " + damage);
                }
                if (bossHealth - damage < 0) { //первый вариант
                    bossHealth = 0;
                } else {
                    bossHealth -= damage;
                }
            }
        }
    }

    public static void printStatistic() {
        System.out.println("ROUND " + roundNumber + "-------------");
        String defence;
       /* if (bossDefence == null){
            defence = "No defence";
        }else {
            defence = bossDefence;
          }
        */
      /*  System.out.println("Boss health: " + bossHealth + " damage: " + bossDamage + " defence: " +
                (bossDefence == null ? "No defence" : bossDefence));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i] + " damage: " + heroesDamage[i]);
        }

    }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
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
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;

















        for (int i = 0; i <heroesHealth.length ; i++) {
            if (heroesHealth[i] <= 0 ){
                System.out.println("Boss won!!!");
                return true;
            }
        }

         */

       /* if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
            System.out.println("Boss won!!!");
            return true;
        }

        */







































/*public class Main {
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

 */








