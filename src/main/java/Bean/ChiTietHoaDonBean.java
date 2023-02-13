package Bean;

public class ChiTietHoaDonBean {


  public Long getMaChiTietHD() {
    return MaChiTietHD;
  }

  public void setMaChiTietHD(Long maChiTietHD) {
    MaChiTietHD = maChiTietHD;
  }

  public String getMaSach() {
    return MaSach;
  }

  public void setMaSach(String maSach) {
    MaSach = maSach;
  }

  public int getSoLuongMua() {
    return SoLuongMua;
  }

  public void setSoLuongMua(int soLuongMua) {
    SoLuongMua = soLuongMua;
  }

  public Long getMaHoaDon() {
    return MaHoaDon;
  }

  public void setMaHoaDon(Long maHoaDon) {
    MaHoaDon = maHoaDon;
  }

  public Boolean getDamua() {
    return Damua;
  }

  public void setDamua(Boolean damua) {
    Damua = damua;
  }

  public ChiTietHoaDonBean(Long maChiTietHD, String maSach, int soLuongMua, Long maHoaDon,
      Boolean damua) {
    super();
    MaChiTietHD = maChiTietHD;
    MaSach = maSach;
    SoLuongMua = soLuongMua;
    MaHoaDon = maHoaDon;
    Damua = damua;
  }

  public ChiTietHoaDonBean() {
    super();
    // TODO Auto-generated constructor stub
  }

  private Long MaChiTietHD;
  private String MaSach;
  private int SoLuongMua;
  private Long MaHoaDon;
  private Boolean Damua;
}
