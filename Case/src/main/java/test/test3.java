package test;
import java.util.Scanner;
import java.util.Random;

public class test3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int maxNumber = 0;
        int playerNumber, computerNumber;
        String[] items = {"Vương miện nữ hoàng Elizabeth", "Viên kim cương Der Blaue Wittelsbach", "Sổ chép tay Leonardo Da Vinci"};
        int index = random.nextInt(items.length);
        String item = items[index];
        String description = "";

        if (item.equals("Vương miện nữ hoàng Elizabeth")) {
            description = "Vương miện của Nữ hoàng Elizabeth II là một chiếc vương miện được làm bằng vàng, bọc đá quý và đính lông vũ phía sau. \nChiếc vương miện này được tạo thành từ nhiều thành phần khác nhau và thường được đeo cùng với chiếc áo choàng hào quang trong các \nsự kiện quan trọng của hoàng gia Anh.";
        } else if (item.equals("Viên kim cương Der Blaue Wittelsbach")) {
            description = "Viên kim cương Der Blaue Wittelsbach là một viên kim cương màu xanh lam có nguồn gốc từ Ấn Độ, sau đó được chế tác thành \nviên trang sức cho các vị quý tộc châu Âu. Viên kim cương này được tìm thấy vào năm 1642 và đã được sở hữu bởi nhiều gia đình quý \ntộc khác nhau. ";
        } else if (item.equals("Sổ chép tay Leonardo Da Vinci")) {
            description = "Sổ chép tay của Leonardo da Vinci là một tài liệu ghi chép tay của nhà khoa học, nhà điêu khắc, nhà vẽ tranh và phát minh \ngia người Ý Leonardo da Vinci. Sổ chép này bao gồm hơn 5,000 trang với các ghi chép về các chủ đề như khoa học, toán học, vẽ tranh, \nkiến trúc và máy móc. Nhiều ghi chép trong sổ đã trở thành nguồn cảm hứng cho các nhà khoa học và nghệ sĩ sau này. Sổ chép tay của Leonardo da Vinci được cho \nlà đã được viết trong khoảng từ năm 1490 đến 1519, khi ông qua đời.";
        }
        System.out.println("\033[33m\uD83D\uDC80════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\uD83D\uDC80\033[0m");

        int[] computerBids = new int[3];
        Thread.sleep(2000);
        System.out.println("Chào mừng bạn đến với Phiên đấu giá hôm nay");
        Thread.sleep(2000);
        System.out.println("Cổ vật đấu giá hôm nay là " + item);
        Thread.sleep(2000);
        System.out.println(description);
        Thread.sleep(2000);
        System.out.println("Giá khởi điểm là 500$");


        System.out.println("\033[33m\uD83D\uDC80════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\uD83D\uDC80\033[0m");
        System.out.print("Bạn là người bắt đầu cho cuộc đấu giá này. Mời ra giá: ");
        playerNumber = input.nextInt();


        while (playerNumber <= 500 || playerNumber >= 1000) {
            System.out.print("Giá không hợp lệ. Mời ra giá lại: ");
            playerNumber = input.nextInt();
        }


        if (playerNumber > maxNumber) {
            maxNumber = playerNumber;
        }

        int selectedComputer = random.nextInt(3) + 1;
        computerNumber = random.nextInt(501) + playerNumber;
        System.out.println("Doanh nhân " + selectedComputer + " ra giá " + computerNumber);

        if (computerNumber > maxNumber) {
            maxNumber = computerNumber;
        }

        while (true) {
            while (playerNumber < computerNumber) {
                System.out.print("Mời ra giá lớn hơn " + computerNumber + ": ");
                playerNumber = input.nextInt();
            }

            if (playerNumber > maxNumber) {
                maxNumber = playerNumber;
            }

            if (playerNumber > 11000) {

                System.out.println("\n\t\t\t\t🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆");
                System.out.println("\t\t\t\t\t\033[35mChúc mừng Bạn đã chiến thắng cuộc đấu giá với giá " + playerNumber + "\033[0m");
                System.out.println("\t\t\t\t🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇");

                return;
            }

            selectedComputer = random.nextInt(3) + 1;
            computerNumber = random.nextInt(501) + maxNumber;
            System.out.println("Thương nhân " + selectedComputer + " ra giá " + computerNumber);

            if (computerNumber > maxNumber) {
                maxNumber = computerNumber;
            }

            if (computerNumber > 11000) {

                System.out.println("\n\t\t\t\t🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆");
                System.out.println("\t\t\t\t\033[35mChúc mừng Thương nhân " + selectedComputer + " đã chiến thắng cuộc đấu giá với giá " + computerNumber + "\033[0m");
                System.out.println("\t\t\t\t🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇🎆🎇");

                return;
            }
        }
    }
}
