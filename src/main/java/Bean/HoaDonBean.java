package Bean;

import java.sql.Date;

public class HoaDonBean {


  public long getMaHoaDon() {
    return MaHoaDon;
  }

  public void setMaHoaDon(long maHoaDon) {
    MaHoaDon = maHoaDon;
  }

  public long getMaKH() {
    return maKH;
  }

  public void setMaKH(long maKH) {
    this.maKH = maKH;
  }

  public Date getNgayMua() {
    return NgayMua;
  }

  public void setNgayMua(Date ngayMua) {
    NgayMua = ngayMua;
  }

  public boolean isDamua() {
    return damua;
  }

  public void setDamua(boolean damua) {
    this.damua = damua;
  }

  public HoaDonBean(long maHoaDon, long maKH, Date ngayMua, boolean damua) {
    super();
    MaHoaDon = maHoaDon;
    this.maKH = maKH;
    NgayMua = ngayMua;
    this.damua = damua;
  }

  public HoaDonBean() {
    super();
    // TODO Auto-generated constructor stub
  }

  private long MaHoaDon;
  private long maKH;
  private Date NgayMua;
  private boolean damua;
}
