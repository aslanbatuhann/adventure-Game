import java.util.Scanner;

public class Toolstore extends NormalLoc {
    public Toolstore(Player player) {
        super(player, "TOOL STORE");
    }

    @Override
    public boolean onLocation() {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Money : " + player.getMoney());
        System.out.println("EN İYİ SİLAHLAR İÇİN  1 ||EN İYİ ZIRHLAR İÇİN  2||ÇIKIŞ İÇİN 0");
        int select = scan.nextInt();
        int selItemNum;
        switch (select) {
            case 1:
                selItemNum = weaponMenu();
                buyWeapon(selItemNum);
                break;
            case 2:
                selItemNum = armorMenu();
                buyArmor(selItemNum);
                break;
            default:
                break;

        }
        return true;
    }


    public int armorMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ARMORS");
        System.out.println("Light Armor  1 ---> DEFENCE : 2 --- GOLD : 25");
        System.out.println("Medium Armor   2 ---> DEFENCE : 3 --- GOLD : 35");
        System.out.println("Heavy Armor   3 ---> DEFENCE : 7 --- GOLD : 45");
        System.out.println("BACK 4");
        System.out.println("YOUR CHOICE: ");
        return scan.nextInt();
    }

    public void buyArmor(int itemNum) {
        int avoid = 0, price = 0;
        String aName = null;

        switch (itemNum) {
            case 1:
                avoid = 1;
                aName = "Light Armor";
                price = 15;
                break;
            case 2:
                avoid = 3;
                aName = "Medium Armor";
                price = 25;
                break;
            case 3:
                avoid = 5;
                aName = "Heavy Armor";
                price = 40;
                break;
            case 4:
                System.out.println("Exiting.");
                break;
            default:
                System.out.println("Invalid Input !");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setArmorDefence(avoid);
                player.getInventory().setArmorName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You've bought " + aName + " Defence : " + player.getInventory().getArmorDefence());
                System.out.println("Current Money :" + player.getMoney());
            } else {
                System.out.println("Not enough money !");
            }
        }
    }

    public int weaponMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("WEAPONS");
        System.out.println("Gun         1 ---> DAMAGE : 2 --- GOLD : 25");
        System.out.println("Sword       2 ---> DAMAGE : 3 --- GOLD : 35");
        System.out.println("Rifle       3 ---> DAMAGE : 2 --- GOLD : 45");
        System.out.println("BACK 4");
        System.out.println("YOUR CHOICE: ");

        return scan.nextInt();
    }

    public void buyWeapon(int itemNum) {
        int damage = 0, price = 0;
        String wName = null;

        switch (itemNum) {
            case 1:
                damage = 2;
                wName = "Gun";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "Sword";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "Rifle";
                price = 45;
                break;
            case 4:
                System.out.println("Exiting.");
                break;
            default:
                System.out.println("Invalid Input !");
                break;
        }

        if (price > 0) {
            if (player.getMoney() > price) {
                player.getInventory().setWeaponDamage(damage);
                player.getInventory().setWeaponName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You've bought " + wName + "  Old Damage :" + player.getDamage() + ", New Damage : "
                        + player.getTotalDamage());
                System.out.println("Current Money :" + player.getMoney());
            } else {
                System.out.println("Not Enough Money !");
            }
        }

    }


}


