package se.elie.homegame;

import se.elie.homegame.model.Burglar;
import se.elie.homegame.model.Resident;

import java.util.Scanner;

public class Game {
    private final Resident resident;
    private final Burglar burglar;
    private boolean fryingPanFound = false;
    private boolean running = true;

    private final Scanner scanner = new Scanner(System.in);

    public Game() {
        resident = new Resident();
        burglar = new Burglar();
    }

    public void start() {
        System.out.println("Du vaknar upp i vardagsrummet och hör ett ljud från ett annat rum.");

        while (running && resident.isConscious()) {
            System.out.println(" Välj ett rum att gå till:");
            System.out.println("1. Köket");
            System.out.println("2. Hallen");
            System.out.println("3. Sovrummet");
            System.out.println("4. Kontoret");
            System.out.println("5. Avsluta spelet");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Ogiltigt val, försök igen.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1 -> visitKitchen();
                case 2 -> visitHall();
                case 3 -> visitBedroom();
                case 4 -> visitOffice();
                case 5 -> {
                    System.out.println("Spelet avslutas.");
                    running = false;
                }
                default -> System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }

    void visitKitchen() {
        System.out.println("Du går in i köket.");
        if (!fryingPanFound) {
            System.out.println("Du hittar en stekpanna och känner dig starkare!");
            resident.addDamage(10);
            fryingPanFound = true;
        } else {
            System.out.println("Köket är tomt, du har redan tagit stekpannan.");
        }
    }

    void visitHall() {
        System.out.println("Du går in i hallen och möter tjuven! Slagsmålet börjar.");
        fight();
    }

    private void fight() {
        int rounds = 0;

        while (resident.isConscious() && burglar.isConscious()) {
            rounds++;
            System.out.println("Runda " + rounds + ":");

            
            System.out.println("Du slår tjuven och gör " + resident.getDamage()+ " skada!");
            burglar.takeHit(resident.getDamage());



            if (!burglar.isConscious()) {
                System.out.println("Tjuven är medvetslös! Du vann!");
                return;
            }

            else {
                System.out.println("Tjuven slår tillbaka och gör " + burglar.getDamage() + " skada");
                resident.takeHit(burglar.getDamage());
            }

            if(resident.isConscious()){
                System.out.println("Residentens hälsa: " + resident.getHealth());
                System.out.println("Tjuvens hälsa: " + burglar.getHealth());
            }


        }


        if (!resident.isConscious()) {
            System.out.println("Du har förlorat slagsmålet. Spelet är över.");
            running = false;
        } else {
            System.out.println("Du knockade tjuven!");
        }
    }

    private void visitBedroom() {
        System.out.println("Du går in i sovrummet. Det finns inget särskilt att göra här. gå till kontoret och ring polisen");
    }

    private void visitOffice() {
        System.out.println("Du går in i kontoret.");
        if (burglar.isConscious()) {
            System.out.println("Du ser telefonen, men är för stressad för att tänka på att ringa.");
        } else {
            System.out.println("Du ringer polisen och spelet är över. Du är säker.");
            running = false;
        }


    }


    public Burglar getBurglar() {
        return burglar;
    }


}