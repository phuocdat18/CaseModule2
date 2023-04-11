package test;

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int playerBid = 0;
        int[] computerBids = new int[3];
        int highestBid = 0;
        int highestBidder = -1; // -1: player, 0-2: computers
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Chào mừng đến với trò chơi đấu giá!");
        System.out.println("Bạn đang chơi với 3 người chơi máy tính.");
        System.out.println("Mỗi người chơi có 10000 xu để bắt đầu.");

        // Game loop
        while (true) {
            // Player's turn
            System.out.println("Đến lượt bạn trả giá. Nhập giá thầu của bạn (100-500):");
            playerBid = scanner.nextInt();
            while (playerBid < 100 || playerBid > 10000) {
                System.out.println("Giá thầu không hợp lệ. Nhập lại giá thầu của bạn (100-500):");
                playerBid = scanner.nextInt();
            }

            // Computers' turn
            int computerIndex = random.nextInt(3);
            int computerBid = random.nextInt(401) + 100 + playerBid; // Random bid between 100-500
            computerBids[computerIndex] = computerBid;
            System.out.println("Máy " + (computerIndex + 1) + " đấu giá " + computerBid);

            // Determine the highest bidder and bid
            if (playerBid > highestBid) {
                highestBid = playerBid;
                highestBidder = -1;
            }
            for (int i = 0; i < computerBids.length; i++) {
                if (computerBids[i] > highestBid) {
                    highestBid = computerBids[i];
                    highestBidder = i;
                }
            }
            System.out.println("\n" +
                    "Giá thầu cao nhất là " + highestBid + " bởi " +
                    (highestBidder == -1 ? "Bạn" : "Máy " + (highestBidder + 1)));

            // Check if the game ends
            if (highestBidder == -1 && playerBid == 0) {
                System.out.println("Bạn bỏ cuộc chơi. Trò chơi kết thúc!");
                break;
            } else if (highestBidder != -1 && highestBidder != 0 && random.nextDouble() < 0.1) {
                System.out.println("Máy " + (highestBidder + 1) + " bỏ cuộc chơi. Bạn thắng!");
                break;
            } else if (highestBid >= 1000) {
                System.out.println("Giá thầu cao nhất đạt 1000 xu. Trò chơi kết thúc!");
                break;
            } else if (highestBidder == -1 || highestBidder == 0) {
                System.out.println("Bạn là người chiến thắng!");
                break;
            }
        }

        // Game over
        scanner.close();
        System.out.println("Cảm ơn bạn đã chơi trò chơi đấu giá!");
    }
}
