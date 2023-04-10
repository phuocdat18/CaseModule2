package Library;
public class Main {
    public static void main(String[] args) {
        QuanLyThuVien quanLyThuVien = new QuanLyThuVien();
        Sach sach1 = new Sach("MS001", "Toi thay hoa vang tren co xanh", "Nguyen Nhat Anh", 10);
        Sach sach2 = new Sach("MS002", "Oxford Advanced Learner's Dictionary", "Oxford University Press", 5);
        quanLyThuVien.themSach(sach1);
        quanLyThuVien.themSach(sach2);

        // tiếp tục code ở Main
        DocGia docGia1 = new DocGia("DG001", "Nguyen Van A", "123456789", "Ha Noi");
        DocGia docGia2 = new DocGia("DG002", "Le Thi B", "987654321", "Hai Phong");
        quanLyThuVien.themDocGia(docGia1);
        quanLyThuVien.themDocGia(docGia2);

        NhanVien nhanVien1 = new NhanVien("NV001", "Đạt","Trưởng phòng", "Huế", "0856479555");
        NhanVien nhanVien2 = new NhanVien("NV002", "Đá", "Nhân viên", "Đà nẵng", "987654321");
        quanLyThuVien.themNhanVien(nhanVien1);
        quanLyThuVien.themNhanVien(nhanVien2);

        // Mượn sách
        boolean muonSach = quanLyThuVien.muonSach("MS001", "DG001");
        if (muonSach) {
            System.out.println("Muon sach thanh cong");
        } else {
            System.out.println("Muon sach that bai");
        }

        // Trả sách
        boolean traSach = quanLyThuVien.traSach("MS001", "DG001");
        if (traSach) {
            System.out.println("Tra sach thanh cong");
        } else {
            System.out.println("Tra sach that bai");
        }
    }
}


