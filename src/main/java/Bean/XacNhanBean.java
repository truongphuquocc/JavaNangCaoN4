package Bean;

import java.util.Date;

public class XacNhanBean {
  private long MaHoaDon;
  private long makh;
  private String hoten;
  private Date NgayMua;
  private long ThanhTien;
  private boolean damua;

  public XacNhanBean() {
    super();
    // TODO Auto-generated constructor stub
  }

  public long getMaHoaDon() {
    return MaHoaDon;
  }

  public void setMaHoaDon(long maHoaDon) {
    MaHoaDon = maHoaDon;
  }

  public long getMakh() {
    return makh;
  }

  public void setMakh(long makh) {
    this.makh = makh;
  }

  public String getHoten() {
    return hoten;
  }

  public void setHoten(String hoten) {
    this.hoten = hoten;
  }

  public Date getNgayMua() {
    return NgayMua;
  }

  public void setNgayMua(Date ngayMua) {
    NgayMua = ngayMua;
  }

  public long getThanhTien() {
    return ThanhTien;
  }

  public void setThanhTien(long thanhTien) {
    ThanhTien = thanhTien;
  }

  public boolean isDamua() {
    return damua;
  }

  public void setDamua(boolean damua) {
    this.damua = damua;
  }

  public XacNhanBean(long maHoaDon, long makh, String hoten, Date ngayMua, long thanhTien,
      boolean damua) {
    super();
    MaHoaDon = maHoaDon;
    this.makh = makh;
    this.hoten = hoten;
    NgayMua = ngayMua;
    ThanhTien = thanhTien;
    this.damua = damua;
  }

}
