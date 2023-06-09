package views;

import model.User;
import java.util.Scanner;


public class Menu {
    static ProductView productView = new ProductView();
    static PaymentView paymentView = new PaymentView();
    static Scanner scanner = new Scanner(System.in);

    private static User currentUser = null;
    private static boolean isFinished = false;


    public static void boss() throws InterruptedException {
        boolean isLoggedIn = checkLogin();
        if (!isLoggedIn) {
            login();
            return;
        }
        boolean isFinished = false;
        Scanner scanner = new Scanner(System.in);
        menuBoss();
        int number = 0;
        while (!isFinished) {
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai! Mời nhập lại");
                continue;
            }
            switch (number) {
                case 1:
                    productView.showProductBoss();
                    break;
                case 2:
                    productView.showProductDescriptionBoss();
                    break;
                case 3:
                    productView.add();
                    break;
                case 4:
                    productView.updateProduct();
                    break;
                case 5:
                    productView.findProductbyNameBoss();
                    break;
                case 6:
                    productView.findProductbyTypeBoss();
                    break;
                case 7:
                    paymentView.showAllIncome();
                    break;
                case 8:
                    selectTable();
                    break;
                case 9:
                    exit();
                    isFinished = true;
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Mời chọn lại");
            }
        }
    }

//    public static void boss() {
//        boolean isLoggedIn = checkLogin();
//        if (!isLoggedIn) {
//            login();
//            return;
//        }
//        boolean isFinished = false;
//        Scanner scanner = new Scanner(System.in);
//        menuBoss();
//        while (!isFinished) {
//            try {
//                System.out.println("\nChọn chức năng ");
//                System.out.print("\t➺ ");
//                int number = scanner.nextInt();
//                switch (number) {
//                    case 1:
//                        productView.showProductBoss();
//                        break;
//                    case 2:
//                        productView.showProductDescriptionBoss();
//                        break;
//                    case 3:
//                        productView.add();
//                        break;
//                    case 4:
//                        productView.updateProduct();
//                        break;
//                    case 5:
//                        productView.findProductbyNameBoss();
//                        break;
//                    case 6:
//                        productView.findProductbyTypeBoss();
//                        break;
//                    case 7:
//                        paymentView.showAllIncome();
//                        break;
//                    case 8:
//                        selectTable();
//                        break;
//                    case 9:
//                        exit();
//                        isFinished = true;
//                        break;
//                    default:
//                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Nhập sai! vui lòng nhập lại");
//                scanner.nextLine();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }


    public static User login() {
        Loginview loginView = new Loginview();
        boolean isLoggedIn = false;
        User user = null;
        while (!isLoggedIn) {
            try {
                user = loginView.login();
                isLoggedIn = true;
                currentUser = user;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Có lỗi khi đăng nhập. Vui lòng thử lại.");
                return null;
            }
        }
        return user;
    }

    public static boolean checkLogin() {
        if (currentUser == null) {
            System.out.println("Hãy đăng nhập trước khi sử dụng chức năng này!");
            return false;
        }
        return true;
    }


    public static void guest() throws InterruptedException {
        menuGuest();
        int number = 0;
        boolean checkAction = false;
        do {
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai! Mời nhập lại");
                continue;
            }
            switch (number) {
                case 1:
                    productView.showProductGuest();
                    break;
                case 2:
                    productView.showProductDescriptionGuest();
                    break;
                case 3:
                    productView.findProductbyNameGuest();
                    break;
                case 4:
                    productView.findProductbyTypeGuest();
                    break;
                case 5:
                    productView.sortASC();
                    break;
                case 6:
                    productView.sortDESC();
                    break;
                case 7:
                    paymentView.buy();
                    break;
                case 8:
                    selectTable();
                    break;
                case 9:
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Mời chọn lại");
                    checkAction = true;
                    break;
            }
        } while (!checkAction);
    }

    public static void auctionByName() throws InterruptedException {
        joinAuctionByName();
        int number = 0;
        boolean checkAction = false;
        do {
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai! Mời nhập lại");
                continue;
            }
            switch (number) {
                case 1:
                    productView.findProductbyNameGuest();
                    break;
                case 2:
                    paymentView.auctionProgram();
                    break;
                case 3:
                    guest();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Mời chọn lại");
                    checkAction = true;
                    break;
            }
        } while (!checkAction);
    }


    public static void auctionById() throws InterruptedException {
        joinAuctionById();
        int number = 0;
        boolean checkAction = false;
        do {
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai! Mời nhập lại");
                continue;
            }
            switch (number) {
                case 1:
                    paymentView.buy();
                    break;
                case 2:
                    productView.findProductbyNameGuest();
                    break;
                case 3:
                    paymentView.auctionProgram();
                    break;
                case 4:
                    guest();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Mời chọn lại");
                    checkAction = true;
                    break;
            }
        } while (!checkAction);
    }

    public static void selectTable() throws InterruptedException {

        int number = 0;
        boolean checkAction = false;
        do {
            menuMain();
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai! Mời nhập lại");
                continue;
            }
            switch (number) {
                case 1:
                    boss();
                    break;
                case 2:
                    guest();
                    break;
                case 3:
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Mời chọn lại");
                    checkAction = true;
                    selectTable();
                    break;
            }
        } while (!checkAction);
    }

    public static void menuMain() {
//        System.out.println("\n");
//        System.out.println("\u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[34m★\u001B[0m \u001B[35m★\u001B[0m \u001B[36m★\u001B[0m \u001B[30m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[31m--ĐẠT ĐỒ CỔ--\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[34m★\u001B[0m \u001B[35m★\u001B[0m \u001B[36m★\u001B[0m \u001B[30m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m");
//        System.out.println("\u001B[32m★\u001B[0m                                                          \u001B[34m★\u001B[0m ");
//        System.out.println("\u001B[36m★        1. Quản trị viên                                  ★\u001B[0m");
//        System.out.println("\u001B[32m★        2. Khách hàng                                     ★\u001B[0m");
//        System.out.println("\u001B[31m★        3. Thoát                                          ★\u001B[0m");
//        System.out.println("\u001B[32m★\u001B[0m                                                          \u001B[34m★\u001B[0m ");
//        System.out.println("\u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[34m★\u001B[0m \u001B[35m★\u001B[0m \u001B[36m★\u001B[0m \u001B[30m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[30m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[34m★\u001B[0m \u001B[35m★\u001B[0m \u001B[36m★\u001B[0m \u001B[30m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[34m★\u001B[0m \u001B[35m★\u001B[0m");
        System.out.println("\n");
        System.out.println("\u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[34m★\u001B[0m \u001B[35m★\u001B[0m \u001B[36m★\u001B[0m \u001B[30m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[31m--ĐẠT ĐỒ CỔ--\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[34m★\u001B[0m \u001B[35m★\u001B[0m \u001B[36m★\u001B[0m \u001B[30m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m");
        System.out.println("\u001B[32m★\u001B[0m                                                        \u001B[34m★\u001B[0m ");
        System.out.println("\u001B[36m★        1. Quản trị viên                                ★\u001B[0m");
        System.out.println("\u001B[32m★        2. Khách hàng                                   ★\u001B[0m");
        System.out.println("\u001B[31m★        3. Thoát                                        ★\u001B[0m");
        System.out.println("\u001B[32m★\u001B[0m                                                        \u001B[34m★\u001B[0m ");
        System.out.println("\u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[34m★\u001B[0m \u001B[35m★\u001B[0m \u001B[36m★\u001B[0m \u001B[30m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[30m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[34m★\u001B[0m \u001B[35m★\u001B[0m \u001B[36m★\u001B[0m \u001B[30m★\u001B[0m \u001B[31m★\u001B[0m \u001B[32m★\u001B[0m \u001B[33m★\u001B[0m \u001B[34m★\u001B[0m");
    }


    public static void exit() {
        System.out.println("\t\t\t\t\t  Cám ơn quý khách");
        System.out.println("\t\t\t\t\t  ⚰️Hẹn gặp lại⚰️");

        System.exit(0);
    }

    public static void exitBoss() {
        System.out.println("\t\t\t\t\t  ⚰️Hẹn gặp lại⚰️");

        System.exit(0);
    }

    public static void comeBackLose() {
        comeBackStoreLose();
        int number = 0;
        boolean checkAction = false;
        do {
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai! Mời nhập lại");
                continue;
            }
            switch (number) {
                case 1:
                    menuGuest();
                    break;
                case 2:
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Mời chọn lại");
                    checkAction = true;
                    break;
            }
        } while (!checkAction);
    }


    public static void comeBackWin() {
        comeBackStoreWin();
        int number = 0;
        boolean checkAction = false;
        do {
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai! Mời nhập lại");
                continue;
            }
            switch (number) {
                case 1:
                    menuGuest();
                    break;
                case 2:
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Mời chọn lại");
                    checkAction = true;
                    break;
            }
        } while (!checkAction);
    }

    public void FindBoss() throws InterruptedException {
        int number = 0;
        boolean checkAction = false;
        do {
            afterFind();
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai! Mời nhập lại");
                continue;
            }
            switch (number) {
                case 1:
                    productView.findProductbyNameBoss();
                    break;
                case 2:
                    boss();
                    break;
                case 3:
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Mời chọn lại");
                    checkAction = true;
                    break;
            }
        } while (!checkAction);
    }

    public void FindGuest() throws InterruptedException {
        int number = 0;
        boolean checkAction = false;
        do {
            afterFind();
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai! Mời nhập lại");
                continue;
            }
            switch (number) {
                case 1:
                    productView.findProductbyNameGuest();
                    break;
                case 2:
                    auctionByName();
                    break;
                case 3:
                    guest();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Mời chọn lại");
                    checkAction = true;
                    break;
            }
        } while (!checkAction);
    }

    public static void menuBoss() {
        System.out.println("\u001B[35m╔═════════════════════════════════════════════════════════╗");
        System.out.println("\u001B[35m║                 \u001B[1m\u001B[36mGiao diện Quản trị viên \u001B[0m                \u001B[35m║");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m1. Hiển thị danh sách Cổ Vật                          \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m2. Hiển thị mô tả Cổ vật                              \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m3. Thêm Cổ vật vào danh sách                          \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m4. Sửa thông tin Cổ vật                               \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m5. Tìm kiếm Cổ vật theo tên                           \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m6. Tìm kiếm Cổ vật theo loại                          \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m7. Xem doanh thu                                      \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m8. Quay lại                                           \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m9. Thoát                                              \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");
    }

    public static void menuGuest() {
        System.out.println("\u001B[35m╔═════════════════════════════════════════════════════════╗");
        System.out.println("\u001B[35m║                  \u001B[1m\u001B[36mGiao diện Khách hàng\u001B[0m                   \u001B[35m║");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m1. Hiển thị danh sách Cổ vật                          \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m2. Hiển thị mô tả Cổ vật                              \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m3. Tìm kiếm Cổ vật theo tên                           \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m4. Tìm kiếm Cổ vật theo loại                          \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m5. Sắp xếp Cổ vật theo giá tăng dần                   \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m6. Sắp xếp Cổ vật theo giá giảm dần                   \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m7. Mua Cổ vật                                         \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m8. Quay lại                                           \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m9. Thoát                                              \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");
    }

    public static void joinAuctionById() {
        System.out.println("\u001B[35m╔═════════════════════════════════════════════════════════╗");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mRất tiếc món đồ của bạn không có tại cửa hàng         \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mTuy nhiên chúng tôi biết hiện tại đang có 1 phiên đấu \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mgiá rất hấp dẫn, có thể sẽ có món đồ của bạn đang tìm.\u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mBạn có muốn tham gia phiên đấu giá không?             \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m1. Tìm món khác                                       \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m2. Tìm theo tên                                       \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m3. Tham gia đấu giá                                   \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m4. Quay lại Menu                                      \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m5. Thoát                                              \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");

    }


    public static void joinAuctionByName() {
        System.out.println("\u001B[35m╔═════════════════════════════════════════════════════════╗");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mRất tiếc món đồ của bạn không có tại cửa hàng         \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mTuy nhiên chúng tôi biết hiện tại đang có 1 phiên đấu \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mgiá rất hấp dẫn, có thể sẽ có món đồ của bạn đang tìm.\u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mBạn có muốn tham gia phiên đấu giá không?             \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m1. Tìm món khác                                       \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m2. Tham gia đấu giá                                   \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m3. Quay lại Menu                                      \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m4. Thoát                                              \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");

    }

    public static void comeBackStoreLose() {

        System.out.println("\u001B[35m╔═════════════════════════════════════════════════════════╗");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mTôi rất tiếc khi bạn không giành lấy                  \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mđược món đồ bạn muốn. Tuy nhiên ở cửa hàng chúng      \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mtôi có rất nhiều thứ khác xịn xò hơn                  \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mBạn có muốn quay lại không?                           \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m1. Quay lại cửa hàng                                  \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m2. Thoát                                              \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");
    }

    public static void comeBackStoreWin() {

        System.out.println("\u001B[35m╔═════════════════════════════════════════════════════════╗");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mChúc mừng ba đã giành lấy được                        \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mmón đồ tuyệt vời. Tuy nhiên ở cửa hàng chúng          \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mtôi có rất nhiều thứ khác xịn xò hơn                  \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mBạn có muốn quay lại không?                           \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m1. Quay lại cửa hàng                                  \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m2. Thoát                                              \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");
    }

    public void afterFind() {
        System.out.println("\u001B[35m╔═════════════════════════════════════════════════════════╗");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36mKhông tìm thấy cổ vật                                 \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m1. Tìm món khác                                       \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m2. Quay lại menu                                      \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║   \u001B[1m\u001B[36m3. Thoát                                              \u001B[0m\u001B[35m║");
        System.out.println("\u001B[35m║                                                         ║");
        System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");
    }

}
