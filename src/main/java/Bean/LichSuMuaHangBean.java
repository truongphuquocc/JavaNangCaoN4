package Bean;

import java.util.Date;

public class LichSuMuaHangBean {
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

  public boolean isDamua() {
    return damua;
  }

  public void setDamua(boolean damua) {
    this.damua = damua;
  }

  public long getThanhTien() {
    return ThanhTien;
  }

  public void setThanhTien(long thanhTien) {
    ThanhTien = thanhTien;
  }

  public long getGia() {
    return gia;
  }

  public void setGia(long gia) {
    this.gia = gia;
  }

  public int getSoLuongMua() {
    return SoLuongMua;
  }

  public void setSoLuongMua(int soLuongMua) {
    SoLuongMua = soLuongMua;
  }

  public String getTensach() {
    return tensach;
  }

  public void setTensach(String tensach) {
    this.tensach = tensach;
  }

  public LichSuMuaHangBean(long maHoaDon, long makh, String hoten, Date ngayMua, boolean damua,
      long thanhTien, long gia, int soLuongMua, String tensach) {
    super();
    MaHoaDon = maHoaDon;
    this.makh = makh;
    this.hoten = hoten;
    NgayMua = ngayMua;
    this.damua = damua;
    ThanhTien = thanhTien;
    this.gia = gia;
    SoLuongMua = soLuongMua;
    this.tensach = tensach;
  }

  public LichSuMuaHangBean() {
    super();
    // TODO Auto-generated constructor stub
  }

  private long MaHoaDon;
  private long makh;
  private String hoten;
  private Date NgayMua;
  private boolean damua;
  private long ThanhTien;
  private long gia;
  private int SoLuongMua;
  private String tensach;
}
