package views;

import model.PType;
import model.Product;
import model.Status;
import utils.PriceAscending;
import utils.PriceDescending;
import services.ProductService;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    DecimalFormat format = new DecimalFormat("###,###,###" + " $");
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    ProductService productService = new ProductService();


    public ProductView() {

    }

    public void add() throws InterruptedException {
        int id;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập mã cổ vật");
            System.out.print(" ═╬════► ");
            try {
                id = input.nextInt();
                if (id > 0) {
                    if (productService.existProduct(id)) {
                        System.out.println(" \uD83D\uDC80 mã này đã tồn tại \uD83D\uDC80");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("\t \uD83D\uDC80 Số lượng phải lớn hơn 0 \uD83D\uDC80");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("\t \uD83D\uDC80 Số lượng phải là 1 số \uD83D\uDC80");
                System.out.println();
            }
        }



        PType type = null;
        int luachon;
        while (true) {
            boolean check = false;
            System.out.println("\u001B[35m╔═══════════════════════\u001B[0m\u001B[36mNGUỒN GỐC\u001B[0m\u001B[35m═════════════════════════╗\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   1. EUROPE                                             \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   2. ASIA                                               \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   3. AMERICA                                            \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   4. AFRICA                                             \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");
            System.out.println("Nhập nguồn gốc cổ vật");
            System.out.print(" ═╬════► ");
            try {
                luachon = Integer.parseInt(scanner.nextLine());
                switch (luachon) {
                    case 1:
                        type = PType.EUROPE;
                        check = true;
                        break;
                    case 2:
                        type = PType.ASIA;
                        check = true;
                        break;
                    case 3:
                        type = PType.AMERICA;
                        check = true;
                        break;
                    case 4:
                        type = PType.AFRICA;
                        check = true;
                        break;
                    default:
                        System.out.println("\t\uD83D\uDC80 Nhập không đúng! Vui lòng nhập lại \uD83D\uDC80");
                        System.out.println("\t═════════════════════════════════════");
                        break;
                }
                if (check) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("\t \uD83D\uDC80 Lựa chọn phải là 1 số \uD83D\uDC80");
                System.out.println("\t═════════════════════════");
            }
        }
        String name;
        while (true) {
            System.out.println("Nhập tên Cổ vật");
            System.out.print(" ═╬════► ");
            String check = scanner.nextLine();
            if (productService.existProductName(check)) {
                System.out.println(" \uD83D\uDC80 Tên này đã tồn tại xin nhập tên khác \uD83D\uDC80");
            } else {
                name = check;
                break;
            }
        }
        int quantity;
        while (true) {
            System.out.println("Nhập số lượng cổ vật");
            System.out.print(" ═╬════► ");
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity > 0) {
                    break;
                }
                System.out.println("\t \uD83D\uDC80 Số lượng phải lớn hơn 0 \uD83D\uDC80");
                System.out.println();
            } catch (Exception e) {
                System.out.println("\t \uD83D\uDC80 Số lượng phải là 1 số \uD83D\uDC80");
                System.out.println();
            }
        }
        long price;
        while (true) {
            System.out.println("Nhập giá cổ vật");
            System.out.print(" ═╬════► ");
            try {
                price = Long.parseLong(scanner.nextLine());
                if (price > 0) {
                    break;
                }
                System.out.println("\t \uD83D\uDC80 Giá phải lớn hơn 0 \uD83D\uDC80");
                System.out.println();
            } catch (Exception e) {
                System.out.println("\t \uD83D\uDC80 Giá phải là 1 số \uD83D\uDC80");
                System.out.println();
            }
        }
        System.out.println("Nhập mô tả cổ vật");
        System.out.print(" ═╬════► ");
        String description = scanner.nextLine();
        Status status = Status.SOLD;
        Product product = new Product(id, type, name, quantity, price, description, status);
        productService.add(product);
        System.out.println("✔ Bạn đã thêm cổ vật thành công ✔\n");
        System.out.println("\u001B[35m═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\u001B[0m");
        menu.boss();
    }

    public void showProductBoss() throws InterruptedException {
        List<Product> products = productService.getProducts();
        System.out.println("═╬════► Danh sách cổ vật");
        System.out.println("\u001B[35m╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\u001B[0m");
        System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10s %-25s %-30s %-15s %-25s %-15s\u001B[0m\u001B[35m║\u001B[0m\n", "Mã", "Nguồn gốc cổ vật", "Tên cổ vật", "Số lượng", "Giá", "Trạng thái");
        for (Product product : products) {
            System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10d %-25s %-30s %-15d %-25s %-15s\u001B[0m\u001B[35m║\u001B[0m\n", product.getId(), product.getType(), product.getName(), product.getQuantity(), format.format(product.getPrice()), product.getStatus());
        }
        System.out.println("\u001B[35m╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[0m");
        menu.boss();
    }


    public void showProductGuest() throws InterruptedException {

        List<Product> products = productService.getProducts();
        System.out.println("═╬════► Danh sách cổ vật");
        System.out.println("\u001B[35m╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\u001B[0m");
        System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10s %-25s %-30s %-15s %-25s %-15s\u001B[0m\u001B[35m║\u001B[0m\n", "Mã", "Nguồn gốc cổ vật", "Tên cổ vật", "Số lượng", "Giá", "Trạng thái");
        for (Product product : products) {
            System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10d %-25s %-30s %-15d %-25s %-15s\u001B[0m\u001B[35m║\u001B[0m\n", product.getId(), product.getType(), product.getName(), product.getQuantity(), format.format(product.getPrice()), product.getStatus());
        }
        System.out.println("\u001B[35m╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[0m");
        menu.guest();
    }

    public void showProductDescriptionBoss() throws InterruptedException {
        List<Product> products = productService.getProducts();
        System.out.println("═╬════► Mô tả cổ vật");
        System.out.println("\u001B[35m╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\u001B[0m");
        System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10s %-25s %-30s %-50s       \u001B[0m\u001B[35m║\u001B[0m\n", "Mã", "Nguồn gốc cổ vật", "Tên cổ vật", "Mô tả");
        for (Product product : products) {
            System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10s %-25s %-30s %-50s       \u001B[0m\u001B[35m║\u001B[0m\n", product.getId(), product.getType(), product.getName(), product.getDescription());
        }
        System.out.println("\u001B[35m╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[0m");
        menu.boss();
    }

    public void showProductDescriptionGuest() throws InterruptedException {
        List<Product> products = productService.getProducts();
        System.out.println("═╬════► Mô tả cổ vật");
        System.out.println("\u001B[35m╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\u001B[0m");
        System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10s %-25s %-30s %-50s       \u001B[0m\u001B[35m║\u001B[0m\n", "Mã", "Nguồn gốc cổ vật", "Tên cổ vật", "Mô tả");
        for (Product product : products) {
            System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10s %-25s %-30s %-50s       \u001B[0m\u001B[35m║\u001B[0m\n", product.getId(), product.getType(), product.getName(), product.getDescription());
        }
        System.out.println("\u001B[35m╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[0m");
        menu.guest();
    }

    public void sortASC() throws InterruptedException {
        List<Product> p = productService.getProducts();
        p.sort(new PriceAscending());
        System.out.println("═╬════► Danh sách cổ vật");
        System.out.println("\u001B[35m╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\u001B[0m");
        System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10s %-25s %-30s %-15s %-25s %-15s\u001B[0m\u001B[35m║\u001B[0m\n", "Mã", "Nguồn gốc cổ vật", "Tên cổ vật", "Số lượng", "Giá", "Trạng thái");
        for (Product product : p) {
            System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10d %-25s %-30s %-15d %-25s %-15s\u001B[0m\u001B[35m║\u001B[0m\n", product.getId(), product.getType(), product.getName(), product.getQuantity(), format.format(product.getPrice()), product.getStatus());
        }
        System.out.println("\u001B[35m╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[0m");
        menu.guest();
    }

    public void sortDESC() throws InterruptedException {
        List<Product> p = productService.getProducts();
        p.sort(new PriceDescending());
        System.out.println("═╬════► Danh sách cổ vật");
        System.out.println("\u001B[35m╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\u001B[0m");
        System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10s %-25s %-30s %-15s %-25s %-15s\u001B[0m\u001B[35m║\u001B[0m\n", "Mã", "Nguồn gốc cổ vật", "Tên cổ vật", "Số lượng", "Giá", "Trạng thái");
        for (Product product : p) {
            System.out.printf("\u001B[35m║\u001B[0m \u001B[36m%-10d %-25s %-30s %-15d %-25s %-15s\u001B[0m\u001B[35m║\u001B[0m\n", product.getId(), product.getType(), product.getName(), product.getQuantity(), format.format(product.getPrice()), product.getStatus());
        }
        System.out.println("\u001B[35m╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[0m");
        menu.guest();
    }


    public void findProductbyTypeGuest() throws InterruptedException {
        int number = 0;
        try {
            System.out.println("\u001B[35m╔═════════════════════════════════════════════════════════╗\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   1. EUROPE                                             \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   2. ASIA                                               \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   3. AMERICA                                            \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   4. AFRICA                                             \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");
            System.out.print("Bạn muốn tìm loại cổ vật có nguồn gốc nào? ");
            System.out.print("\n═╬════► ");
            String input = scanner.nextLine();
            number = Integer.parseInt(input);
            String type;
            switch (number) {
                case 1:
                    type = "EUROPE";
                    break;
                case 2:
                    type = "ASIA";
                    break;
                case 3:
                    type = "AMERICA";
                    break;
                case 4:
                    type = "AFRICA";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    return;
            }
            boolean found = false;
            List<Product> products = productService.getProducts();
            System.out.println("Danh sách cổ vật");
            System.out.println("\u001B[35m═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\u001B[0m");
            System.out.printf("\t\t\t\t\u001B[36m%-10s %-25s %-30s %-15s %-25s %-25s\u001B[0m\n", "Mã", "Nguồn gốc cổ vật", "Tên cổ vật", "Số lượng", "Giá", "Trạng thái");
            for (Product product : products) {
                if (product.getType().equalsIgnoreCase(type)) {
                    System.out.printf("\t\t\t\t\u001B[36m%-10d %-25s %-30s %-15d %-25s %-25s\u001B[0m\n", product.getId(), product.getType(), product.getName(), product.getQuantity(), format.format(product.getPrice()), product.getStatus());
                    found = true;
                }
            }
            if (!found) {
                System.out.println(" Không có cổ vật này");
            }
            System.out.println("\u001B[35m═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\u001B[0m");
            menu.guest();
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ!");
            findProductbyTypeGuest();
        }
    }


    public void findProductbyTypeBoss() throws InterruptedException {
        int number = 0;
        try {
            System.out.println("\u001B[35m╔═════════════════════════════════════════════════════════╗\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   1. EUROPE                                             \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   2. ASIA                                               \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   3. AMERICA                                            \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   4. AFRICA                                             \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");
            System.out.print("Bạn muốn tìm loại cổ vật có nguồn gốc nào? ");
            System.out.print("\n═╬════► ");
            String input = scanner.nextLine();
            number = Integer.parseInt(input);
            String type;
            switch (number) {
                case 1:
                    type = "EUROPE";
                    break;
                case 2:
                    type = "ASIA";
                    break;
                case 3:
                    type = "AMERICA";
                    break;
                case 4:
                    type = "AFRICA";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    return;
            }
            boolean found = false;
            List<Product> products = productService.getProducts();
            System.out.println("Danh sách cổ vật");
            System.out.println("\u001B[35m═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\u001B[0m");
            System.out.printf("\t\t\t\t\u001B[36m%-10s %-25s %-30s %-15s %-25s %-25s\u001B[0m\n", "Mã", "Nguồn gốc cổ vật", "Tên cổ vật", "Số lượng", "Giá", "Trạng thái");
            for (Product product : products) {
                if (product.getType().equalsIgnoreCase(type)) {
                    System.out.printf("\t\t\t\t\u001B[36m%-10d %-25s %-30s %-15d %-25s %-25s\u001B[0m\n", product.getId(), product.getType(), product.getName(), product.getQuantity(), format.format(product.getPrice()), product.getStatus());
                    found = true;
                }
            }
            if (!found) {
                System.out.println(" Không có cổ vật này");
            }
            System.out.println("\u001B[35m═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\u001B[0m");
            menu.boss();
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ!");
            findProductbyTypeBoss();
        }
    }

    public void findProductbyNameBoss() throws InterruptedException {
        System.out.print("Nhập tên cổ vật cần tìm");
        System.out.print(" ═╬════► ");
        String name = scanner.nextLine().toUpperCase();
        boolean found = false;
        List<Product> p = productService.getProducts();
        System.out.println("Danh sách cổ vật");
        System.out.println("\u001B[35m═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\u001B[0m");
        System.out.printf("\u001B[36m%-10s %-25s %-30s %-15s %-25s %-25s\u001B[0m\n", "Mã", "Nguồn gốc cổ vật", "Tên cổ vật", "số lượng", "giá", "trạng thái");
        for (Product product : p) {
            if (product.getName().toUpperCase().contains(name)) {
                System.out.printf("\u001B[36m%-10d %-25s %-30s %-15d %-25s %-25s\u001B[0m\n", product.getId(), product.getType(), product.getName(), product.getQuantity(), format.format(product.getPrice()), product.getStatus());
                found = true;
            }
        }
        if (!found) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t  Không có cổ vật này ");
            menu.FindBoss();
        }
        System.out.println("\u001B[35m═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\u001B[0m");
        menu.boss();
    }

    public void findProductbyNameGuest() throws InterruptedException {
        System.out.print("Nhập tên cổ vật cần tìm");
        System.out.print(" ═╬════► ");
        String name = scanner.nextLine().toUpperCase();

        if (name.isEmpty()) {
            System.out.println("Bạn chưa nhập tên cổ vật. Vui lòng thử lại.");
            return;
        }

        boolean found = false;
        List<Product> p = productService.getProducts();
        System.out.println("Danh sách cổ vật");
        System.out.println("\u001B[35m═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\u001B[0m");
        System.out.printf("\u001B[36m%-10s %-25s %-30s %-15s %-25s %-25s\u001B[0m\n", "Mã", "Nguồn gốc cổ vật", "Tên cổ vật", "Số lượng", "Giá", "Trạng thái");
        for (Product product : p) {
            if (product.getName().toUpperCase().contains(name)) {
                System.out.printf("\u001B[36m%-10d %-25s %-30s %-15d %-25s %-25s\u001B[0m\n", product.getId(), product.getType(), product.getName(), product.getQuantity(), format.format(product.getPrice()), product.getStatus());
                found = true;
            }
        }
        if (!found) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t  Không có cổ vật này ");
            menu.FindGuest();
        }
        System.out.println("\u001B[35m═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\u001B[0m");
        menu.guest();
    }

    public void updateProduct() throws InterruptedException {
        int id = 0;
        Product update = null;
        while (true) {
            System.out.println("Nhập ID cổ vật cần sửa");
            System.out.print(" ═╬════► ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id > 0) {
                    if (productService.existProduct(id)) {
                        update = productService.findProductbyID(id);
                        break;
                    } else {
                        System.out.println(" \uD83D\uDC80 Mã này không tồn tại \uD83D\uDC80");
                    }
                } else {
                    System.out.println("\t \uD83D\uDC80 Mã phải lớn hơn 0 \uD83D\uDC80");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("\t \uD83D\uDC80 Mã phải là 1 số \uD83D\uDC80");
                System.out.println();
            }
        }
        setPType(update);
        while (true) {
            System.out.println("Nhập tên cần sửa");
            System.out.print(" ═╬════► ");
            String name = scanner.nextLine();
            if (!name.equals("-1")) {
                if (productService.existProductName(name)) {
                    System.out.println(" \uD83D\uDC80 Tên này đã tồn tại xin nhập tên khác \uD83D\uDC80");
                } else {
                    update.setName(name);
                    break;
                }
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Nhập số lượng cổ vật: ");
            System.out.print(" ═╬════► ");
            try {
                int quantity = Integer.parseInt(scanner.nextLine());
                if (!(quantity == -1)) {
                    if (quantity >= 0) {
                        update.setQuantity(quantity);
                        break;
                    }
                    System.out.println("\t \uD83D\uDC80 Số lượng phải lớn hơn 0 \uD83D\uDC80");
                    System.out.println();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("\t \uD83D\uDC80 Số lượng phải là 1 số \uD83D\uDC80");
                System.out.println();
            }
        }
        while (true) {
            System.out.println("Nhập giá cổ vật: ");
            System.out.print(" ═╬════► ");
            try {
                long price = Long.parseLong(scanner.nextLine());
                if (!(price == -1)) {
                    if (price >= 0) {
                        update.setPrice(price);
                        break;
                    }
                    System.out.println("\t \uD83D\uDC80 Giá phải lớn hơn 0 \uD83D\uDC80");
                    System.out.println();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("\t \uD83D\uDC80 Giá phải là 1 số \uD83D\uDC80");
                System.out.println();
            }
        }
        while (true) {
            System.out.println("Nhập mô tả cổ vật: ");
            System.out.print(" ═╬════► ");
            String description = scanner.nextLine();
            if (!(description.equals("-1"))) {
                update.setDescription(description);
                break;
            } else {
                break;
            }
        }
        productService.update(id, update);
        System.out.println("✔ Bạn đã cập nhật cổ vật thành công ✔\n");
        System.out.println("\u001B[35m═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\u001B[0m");
        productService.checkExist();
        menu.boss();
    }


    public void setPType(Product product) throws InterruptedException {
        int number = 0;
        boolean checkAction = false;
        String type = null;
        do {
            System.out.println("\u001B[35m╔════════════════════════\u001B[0m\u001B[36mSET TYPE\u001B[0m\u001B[35m═════════════════════════╗\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   1. EUROPE                                             \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   2. ASIA                                               \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   3. AMERICA                                            \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   4. AFRICA                                             \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   5. Quay lại menu                                      \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m║\u001B[0m\u001B[36m   6. Thoát                                              \u001B[0m\u001B[35m║\u001B[0m");
            System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");
            System.out.print("Bạn muốn tìm loại cổ vật có nguồn gốc nào? ");
            System.out.print(" ═╬════► ");
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\t \uD83D\uDC80 Lựa chọn phải là 1 số \uD83D\uDC80");
                continue;
            }
            switch (number) {
                case 1:
                    product.setType(PType.EUROPE);
                    break;
                case 2:
                    product.setType(PType.ASIA);
                    break;
                case 3:
                    product.setType(PType.AMERICA);
                    break;
                case 4:
                    product.setType(PType.AFRICA);
                    break;
                case 5:
                    menu.boss();
                    break;
                case 6:
                    menu.exitBoss();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    checkAction = true;
                    break;
            }
        } while (!checkAction);
    }


    public void setStatus(Product product) {
        System.out.println("\u001B[35m╔════════════════════════\u001B[0m\u001B[36mSET STATUS\u001B[0m\u001B[35m═══════════════════════╗\u001B[0m");
        System.out.println("\u001B[35m║\u001B[0m\u001B[36m   1. SOLD                                               \u001B[0m\u001B[35m║\u001B[0m");
        System.out.println("\u001B[35m║\u001B[0m\u001B[36m   2. NOTSOLD                                            \u001B[0m\u001B[35m║\u001B[0m");
        System.out.println("\u001B[35m╚═════════════════════════════════════════════════════════╝\u001B[0m");
        System.out.println("Chọn Status: ");
        System.out.print(" ═╬════► ");
        int options;
        try {
            options = Integer.parseInt(scanner.nextLine());
            switch (options) {
                case -1:
                    break;
                case 1:
                    product.setStatus(Status.SOLD);
                    break;
                case 2:
                    product.setStatus(Status.NOTSOLD);
                    break;
                default:
                    System.out.println("Nhập không đúng! Vui lòng nhập lại");
                    setStatus(product);
            }

        } catch (Exception e) {
            System.out.println("\t \uD83D\uDC80 Lựa chọn phải là 1 số \uD83D\uDC80");
            System.out.println("\t═════════════════════════");
            setStatus(product);
        }

    }


}
