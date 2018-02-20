import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int inPut;
        double numPlayerWins = 0;
        double numDealerWins = 0;
        double numTieGames = 0;
        double percentPlayerWins;
        int playerCard = 0; // Generates a random card
        int playerHand = 0;
        int totalNumGames = 0;
        boolean quitGame = false;
        boolean gameOver = false;

        while (!quitGame) {

                try {
                    totalNumGames++; // adds one to total games played
                    System.out.println("START GAME #" + totalNumGames + "\n");
                    playerHand = 0;
                    playerCard = random.nextInt(13) + 1; // generates a random card

                    if (playerCard == 1) {
                        System.out.println("Your Card is an ACE."); // prints the random card
                        playerHand = playerHand + 1;
                        System.out.println("Your hand is: " + playerHand + "\n");

                    } else if (playerCard >= 2 && playerCard <= 10) {
                        System.out.println("Your Card is a " + playerCard); // prints the random card
                        playerHand = playerHand + playerCard;
                        System.out.println("Your hand is: " + playerHand + "\n");

                    } else if (playerCard == 11) {
                        System.out.println("Your Card is a JACK"); // prints the random card
                        playerHand = playerHand + 10;
                        System.out.println("Your hand is: " + playerHand + "\n");
                    } else if (playerCard == 12) {
                        System.out.println("Your Card is a QUEEN"); // prints the random card
                        playerHand = playerHand + 10;
                        System.out.println("Your hand is: " + playerHand + "\n");
                    } else if (playerCard == 13) {
                        System.out.println("Your Card is a KING"); // prints the random card
                        playerHand = playerHand + 10;
                        System.out.println("Your hand is: " + playerHand + "\n");
                    }

                    System.out.println("1. Get another card"); // prints the menu for the player
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print Statistics");
                    System.out.println("4. Exit \n");
                    System.out.print("Choose an option: ");

                    inPut = scan.nextInt(); // asks the players to input an option from the menu

                    if (inPut >= 1 && inPut <= 3) { // indicates if the input is 1, 2, or 3, then the while loop starts
                        gameOver = false;
                    }
                    else if (inPut == 4) { // if option 4 is entered then exit out of the program
                        return;
                    }
                    else { // if anything other than 1,2,3,4 is entered then the message below is printed
                        System.out.println("Invalid Input!");
                        System.out.println("Please enter an integer value between 1 and 4.\n");

                    }


                    while (!gameOver) { // while game over is true then the while loop plays
                        if (inPut == 1) {
                            playerCard = random.nextInt(13) + 1; // creates an additional random card

                            if (playerCard >= 2 && playerCard <= 10) { // if the new random card is 2,3,4,5,6,7,8,9,10
                                System.out.println("\nYour Card is a " + playerCard); // prints the random card
                                playerHand = playerHand + playerCard;
                                System.out.println("Your hand is: " + playerHand + "\n");
                            } else if (playerCard == 1) { // if the new random card is 1
                                System.out.println("\nYour Card is an ACE."); // prints the random card
                                playerHand = playerHand + 1;
                                System.out.println("Your hand is: " + playerHand + "\n");
                            } else if (playerCard == 11) { // if the new random card is a 11
                                System.out.println("\nYour Card is a JACK!"); // prints the random card
                                playerHand = playerHand + 10;
                                System.out.println("Your hand is: " + playerHand + "\n");
                            } else if (playerCard == 12) { // if the new random card is a 12
                                System.out.println("\nYour Card is a QUEEN!"); // prints the random card
                                playerHand = playerHand + 10;
                                System.out.println("Your hand is: " + playerHand + "\n");
                            } else if (playerCard == 13) { // if the new random card is a 13
                                System.out.println("\nYour Card is a KING!"); // prints the random card
                                playerHand = playerHand + 10;
                                System.out.println("Your hand is: " + playerHand + "\n");
                            }

                            if (playerHand > 21) { // if the player hand is greater than 21 then the if is executed.
                                System.out.println("Your Card is a " + playerCard); // prints the random card
                                System.out.println("Your hand is: " + playerHand + "\n");
                                System.out.println("You exceeded 21! You lose :(\n");
                                numDealerWins += 1;
                                gameOver = true;
                                break; // restarts the program

                            } else if (playerHand == 21) { // if the player hand is 21, the player wins and program restarts
                                System.out.println("You Win!\n");
                                numPlayerWins += 1;
                                gameOver = true;
                                break;


                            }


                        }
                        else if (inPut == 2) { // if the input 2 is entered then dealer is given a hand, and is analyzed
                            int dealerHand = random.nextInt(11) + 16;
                            System.out.println("\nDealer's Hand is: " + dealerHand);
                            System.out.println("Your hand is: " + playerHand);
                            if (dealerHand > 21) {
                                System.out.println("\nYou Win!\n");
                                numPlayerWins++;

                            } else if (dealerHand == playerHand) {
                                System.out.println("\nIt's a tie! No one wins!\n");
                                numTieGames++;


                            } else if (dealerHand > playerHand) {
                                System.out.println("\nDealer Wins!\n");
                                numDealerWins++;


                            } else if (dealerHand < playerHand) {
                                System.out.println("\nYou Win!\n");
                                numPlayerWins++;


                            }
                            playerHand = 0;
                            gameOver = true;
                            break;


                        }
                        else if (inPut == 3) { // prints the statistics of all the games
                            percentPlayerWins = (numPlayerWins / (totalNumGames - 1)) * 100;
                            System.out.println("\nNumber of Player wins: " + (int) numPlayerWins);
                            System.out.println("Number of Dealer wins: " + (int) numDealerWins);
                            System.out.println("Number of tie games: " + (int) numTieGames);
                            System.out.println("Total # of games played: " + (totalNumGames - 1));
                            System.out.println("Percentage of player wins: " + String.format("%.1f", percentPlayerWins) + "%\n");
                            /*System.out.println("\n1. Get another card");
                            System.out.println("2. Hold hand");
                            System.out.println("3. Print Statistics");
                            System.out.println("4. Exit \n");
                            System.out.print("Choose an option: ");
                            inPut = scan.nextInt();*/

                        }
                        else if (inPut == 4) { // if 4 is entered then the program ends
                            gameOver = false;
                            return;
                        }


                        System.out.println("1. Get another card"); // asks for the menu again if the program has not ended
                        System.out.println("2. Hold hand");
                        System.out.println("3. Print Statistics");
                        System.out.println("4. Exit \n");
                        System.out.print("Choose an option: ");

                        inPut = scan.nextInt();

                        if (inPut >= 1 && inPut <= 3) { // restarts the while loop
                            gameOver = false;
                        }
                        if (inPut < 1 || inPut > 4) { // faulty input
                            System.out.println("Invalid Input!");
                            System.out.println("Please enter an integer value between 1 and 4.\n");
                        } else if ((Math.round(inPut) != inPut)) { // faulty input
                            System.out.println("Invalid Input!");
                            System.out.println("Please enter an integer value between 1 and 4.\n");
                            System.out.println("1. Get another card");
                            System.out.println("2. Hold hand");
                            System.out.println("3. Print Statistics");
                            System.out.println("4. Exit \n");
                            System.out.print("Choose an option: ");
                            inPut = scan.nextInt();
                        }
                    }
                }
                catch (InputMismatchException except) {
                    System.out.println("Invalid Input!");
                    System.out.println("Please enter an integer value between 1 and 4.\n");
                    scan.nextLine();
                }


            }
        }
    }




