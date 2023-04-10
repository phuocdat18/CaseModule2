package product.model;

import library.DocGia;
import library.Sach;

import java.util.Date;

public class MuonTra {
    private library.Sach sach;
    private library.DocGia docGia;
    private Date ngayMuon;
    private Date ngayTra;

    // Constructor, getter, setter

    public MuonTra() {

    }

    public MuonTra(library.Sach sach, library.DocGia docGia, Date ngayMuon, Date ngayTra) {
        this.sach = sach;
        this.docGia = docGia;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public library.Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public library.DocGia getDocGia() {
        return docGia;
    }

    public void setDocGia(DocGia docGia) {
        this.docGia = docGia;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }


    @Override
    public String toString() {
        return "MuonTra{" +
                "sach=" + sach +
                ", docGia=" + docGia +
                ", ngayMuon=" + ngayMuon +
                ", ngayTra=" + ngayTra +
                '}';
    }
}