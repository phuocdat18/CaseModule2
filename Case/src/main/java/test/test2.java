package test;

import java.util.Random;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int highestBid = 0;
        int highestBidder = -1;
        int playerBid = 0;

        int[] computerBids = new int[3];

        while (true) {
            // Player's turn
            System.out.println("Đến lượt bạn trả giá. Nhập giá thầu của bạn: ");
            playerBid = scanner.nextInt();
            while (playerBid < 500 || playerBid > 11000 ) {
                System.out.println("Giá thầu không hợp lệ hoặc thấp hơn giá đã được đấu giá trước đó. Nhập lại giá thầu của bạn: ");
                playerBid = scanner.nextInt();
            }
            if (highestBid >= 9999) {
                System.out.println("Chúc mừng! Bạn đã chiến thắng với giá " + playerBid);
                break;
            }
            // Computers' turn
            int computerIndex = random.nextInt(3);
            int playerBid1 = random.nextInt(401) + 100 + playerBid; // Random bid between 100-500
            while (playerBid1 <= highestBid) {
                playerBid1 = random.nextInt(401) + 100;
            }


            computerBids[computerIndex] = playerBid1 ;
            System.out.println("Máy " + (computerIndex + 1) + " đấu giá " + playerBid1);

            // Determine the highest bidder and bid
            if (playerBid1 > playerBid) {
                highestBid = playerBid1;
                highestBidder = -1;
            }
            for (int i = 0; i < computerBids.length; i++) {
                if (computerBids[i] > highestBid) {
                    highestBid = computerBids[i];
                    highestBidder = i;
                }
            }

            if (highestBid >= 9999) {
                System.out.println("Máy " + (computerIndex + 1) + " đã chiến thắng với giá " + highestBid);
                break;
            }
        }
    }
}
