package product.model;

public class DocGia {
    private String maDocGia;
    private String tenDocGia;
    private String diaChi;
    private String soDienThoai;

    // Constructor, getter, setter


    public DocGia() {

    }
    public DocGia(String maDocGia, String tenDocGia, String diaChi, String soDienThoai) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "DocGia{" +
                "maDocGia='" + maDocGia + '\'' +
                ", tenDocGia='" + tenDocGia + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}