package Library;

import java.util.Date;

public class MuonTra {
    private Sach sach;
    private DocGia docGia;
    private Date ngayMuon;
    private Date ngayTra;

    // Constructor, getter, setter

    public MuonTra() {

    }

    public MuonTra(Sach sach, DocGia docGia, Date ngayMuon, Date ngayTra) {
        this.sach = sach;
        this.docGia = docGia;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public DocGia getDocGia() {
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