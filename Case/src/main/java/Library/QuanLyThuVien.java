package Library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuanLyThuVien {
    private List<Sach> dsSach;
    private List<DocGia> dsDocGia;
    private List<MuonTra> dsMuonTra;
    private List<NhanVien> dsNhanVien;

    public QuanLyThuVien() {
        dsSach = new ArrayList<>();
        dsDocGia = new ArrayList<>();
        dsMuonTra = new ArrayList<>();
        dsNhanVien = new ArrayList<>();
    }

    // Phương thức thêm/sửa/xóa sách, độc giả, mượn/trả sách, nhân viên
    public void themSach(Sach sach) {
        dsSach.add(sach);
    }

    public void suaSach(Sach sach) {
        for (Sach s : dsSach) {
            if (s.getMaSach().equals(sach.getMaSach())) {
                s.setTenSach(sach.getTenSach());
                s.setTacGia(sach.getTacGia());
                s.setSoLuong(sach.getSoLuong());
                break;
            }
        }
    }

    public void xoaSach(String maSach) {
        for (Sach sach : dsSach) {
            if (sach.getMaSach().equals(maSach)) {
                dsSach.remove(sach);
                break;
            }
        }
    }

// Tương tự cho độc giả, mượn/trả sách, nhân viên

    // Phương thức
// Phương thức tìm kiếm sách, độc giả, mượn/trả sách, nhân viên
    public Sach timKiemSach(String maSach) {
        for (Sach sach : dsSach) {
            if (sach.getMaSach().equals(maSach)) {
                return sach;
            }
        }
        return null;
    }


    public MuonTra timKiemMuonTra(String maSach, String maDocGia) {
        for (MuonTra muonTra : dsMuonTra) {
            if (muonTra.getSach().getMaSach().equals(maSach) && muonTra.getDocGia().getMaDocGia().equals(maDocGia)) {
                return muonTra;
            }
        }
        return null;
    }


    public void themDocGia(DocGia docGia ) {
        dsDocGia.add(docGia);
    }
    public DocGia timKiemDocGia(String maDocGia) {
        for (DocGia docGia : dsDocGia) {
            if (docGia.getMaDocGia().equals(maDocGia)) {
                return docGia;
            }
        }
        return null;
    }


    public void themNhanVien(NhanVien nhanVien) {
        dsNhanVien.add(nhanVien);
    }
    public NhanVien timKiemNhanVien(String maNhanvien) {
        for (NhanVien nhanVien : dsNhanVien) {
            if (nhanVien.getMaNhanVien().equals(maNhanvien)) {
                return nhanVien;
            }
        }
        return null;
    }

    // Phương thức mượn/trả sách
    public boolean muonSach(String maSach, String maDocGia) {
        Sach sach = timKiemSach(maSach);
        DocGia docGia = timKiemDocGia(maDocGia);
        if (sach == null || docGia == null) {
            return false;
        }

        if (sach.getSoLuong() <= 0) {
            return false;
        }

        MuonTra muonTra = new MuonTra(sach, docGia, new Date(), null);
        dsMuonTra.add(muonTra);
        sach.setSoLuong(sach.getSoLuong() - 1);
        return true;
    }

    public boolean traSach(String maSach, String maDocGia) {
        MuonTra muonTra = timKiemMuonTra(maSach, maDocGia);
        if (muonTra == null) {
            return false;
        }

        muonTra.setNgayTra(new Date());
        Sach sach = muonTra.getSach();
        sach.setSoLuong(sach.getSoLuong() + 1);
        return true;
    }
}


