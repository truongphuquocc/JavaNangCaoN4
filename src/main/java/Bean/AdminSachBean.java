package Bean;

import java.sql.Date;

public class AdminSachBean {
  private String masach;
  private String tensach;
  private String tacgia;
  private Long gia;
  private Long soluong;
  private String anh;
  private String maloai;
  private Date ngayNhap;
  private String soTap;

  public String getMasach() {
    return masach;
  }

  public void setMasach(String masach) {
    this.masach = masach;
  }

  public String getTensach() {
    return tensach;
  }

  public void setTensach(String tensach) {
    this.tensach = tensach;
  }

  public String getTacgia() {
    return tacgia;
  }

  public void setTacgia(String tacgia) {
    this.tacgia = tacgia;
  }

  public Long getGia() {
    return gia;
  }

  public void setGia(Long gia) {
    this.gia = gia;
  }

  public Long getSoluong() {
    return soluong;
  }

  public void setSoluong(Long soluong) {
    this.soluong = soluong;
  }

  public String getAnh() {
    return anh;
  }

  public void setAnh(String anh) {
    this.anh = anh;
  }

  public String getMaloai() {
    return maloai;
  }

  public void setMaloai(String maloai) {
    this.maloai = maloai;
  }

  public Date getNgayNhap() {
    return ngayNhap;
  }

  public void setNgayNhap(Date ngayNhap) {
    this.ngayNhap = ngayNhap;
  }

  public String getSoTap() {
    return soTap;
  }

  public void setSoTap(String soTap) {
    this.soTap = soTap;
  }

  public AdminSachBean(String masach, String tensach, String tacgia, Long gia, Long soluong,
      String anh, String maloai, Date ngayNhap, String soTap) {
    super();
    this.masach = masach;
    this.tensach = tensach;
    this.tacgia = tacgia;
    this.gia = gia;
    this.soluong = soluong;
    this.anh = anh;
    this.maloai = maloai;
    this.ngayNhap = ngayNhap;
    this.soTap = soTap;
  }

  public AdminSachBean() {
    super();
    // TODO Auto-generated constructor stub
  }
}
