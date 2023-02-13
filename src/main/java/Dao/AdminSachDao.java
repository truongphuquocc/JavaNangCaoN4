package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Bean.AdminSachBean;


public class AdminSachDao {
  KetNoi kn = new KetNoi();

  public ArrayList<AdminSachBean> getsach() throws Exception {
    kn.KetNoi();
    ArrayList<AdminSachBean> ds = new ArrayList<AdminSachBean>();
    String sql = "select * from sach";
    PreparedStatement cmd = kn.cn.prepareStatement(sql);
    ResultSet rs = cmd.executeQuery();
    while (rs.next()) {
      String masach = rs.getString("masach");
      String tensach = rs.getString("tensach");
      Long soluong = rs.getLong("soluong");
      Long gia = rs.getLong("gia");
      String maloai = rs.getString("maloai");
      String anh = rs.getString("anh");
      String tacgia = rs.getString("tacgia");
      String sotap = rs.getString("sotap");
      Date ngaynhap = rs.getDate("ngaynhap");
      AdminSachBean sach =
          new AdminSachBean(masach, tensach, tacgia, gia, soluong, anh, maloai, ngaynhap, sotap);
      ds.add(sach);
    }
    rs.close();
    return ds;
  }

  public AdminSachBean getBook(String masach) throws Exception {
    kn.KetNoi();
    AdminSachBean sach = null;
    String sql = "select * from sach where masach=?";
    PreparedStatement cmd = kn.cn.prepareStatement(sql);
    cmd.setString(1, masach);
    ResultSet rs = cmd.executeQuery();
    while (rs.next()) {
      String ms = rs.getString("masach");
      String tensach = rs.getString("tensach");
      Long soluong = rs.getLong("soluong");
      Long gia = rs.getLong("gia");
      String maloai = rs.getString("maloai");
      String anh = rs.getString("anh");
      String tacgia = rs.getString("tacgia");
      String sotap = rs.getString("sotap");
      Date ngaynhap = rs.getDate("ngaynhap");
      sach = new AdminSachBean(ms, tensach, tacgia, gia, soluong, anh, maloai, ngaynhap, sotap);
    }
    rs.close();
    return sach;
  }

  public int addSach(String maSach, String TenSach, String tg, Long gia, Long soluong, String anh,
      String maloai, java.util.Date ngay, String soTap) throws Exception {
    // b1: ket noi vao csdl
    kn.KetNoi();
    String ktra = "select * from sach where masach=?";
    PreparedStatement ktradk = kn.cn.prepareStatement(ktra);
    ktradk.setString(1, maSach);
    ResultSet ktdk = ktradk.executeQuery();
    int rs;
    if (ktdk.next() != false)
      return -1;
    else if (ktdk.next() == false) {
      String sql =
          "insert into sach (masach,tensach,tacgia,gia,soluong,anh,maloai,NgayNhap,sotap) values (?,?,?,?,?,?,?,?,?)";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, maSach);
      cmd.setString(2, TenSach);
      cmd.setString(3, tg);
      cmd.setLong(4, gia);
      cmd.setLong(5, soluong);
      cmd.setString(6, anh);
      cmd.setString(7, maloai);
      cmd.setDate(8, new java.sql.Date(ngay.getTime()));
      cmd.setString(9, soTap);
      // b4: Thuc hien cau lieu
      rs = cmd.executeUpdate();
    } else
      return 0;
    // b6: Dong all
    ktdk.close();
    kn.cn.close();
    return rs;
  }

  public int deleteBook(String maSach) throws Exception {
    kn.KetNoi();
    int rs;
    String sql = "Delete sach where masach=?";
    PreparedStatement cmd = kn.cn.prepareStatement(sql);
    cmd.setString(1, maSach);
    rs = cmd.executeUpdate();
    // b6: Dong all
    kn.cn.close();
    return rs;
  }

  public int editBook(String maSach, String TenSach, String tg, Long gia, Long soluong,
      String maloai, java.util.Date ngay, String soTap) throws Exception {
    kn.KetNoi();
    String sql =
        "Update sach SET tensach =?,tacgia=?,gia= ?, soluong=?, maloai =?,NgayNhap =?, sotap=? WHERE masach = ?";
    PreparedStatement cmd = kn.cn.prepareStatement(sql);
    cmd.setString(1, TenSach);
    cmd.setString(2, tg);
    cmd.setLong(3, gia);
    cmd.setLong(4, soluong);
    cmd.setString(5, maloai);
    cmd.setDate(6, new java.sql.Date(ngay.getTime()));
    cmd.setString(7, soTap);
    cmd.setString(8, maSach);
    int check = cmd.executeUpdate();
    kn.cn.close();
    return check;
  }

  public int editBook2(String maSach, String TenSach, String tg, Long gia, Long soluong, String anh,
      String maloai, java.util.Date ngay, String soTap) throws Exception {
    try {
      kn.KetNoi();
      String sql =
          "Update sach SET tensach =?,tacgia=?,gia= ?, soluong=?, anh = ?, maloai =?,NgayNhap =?, sotap=? WHERE masach = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, TenSach);
      cmd.setString(2, tg);
      cmd.setLong(3, gia);
      cmd.setLong(4, soluong);
      cmd.setString(5, anh);
      cmd.setString(6, maloai);
      cmd.setDate(7, new java.sql.Date(ngay.getTime()));
      cmd.setString(8, soTap);
      cmd.setString(9, maSach);
      int check = cmd.executeUpdate();
      kn.cn.close();
      return check;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return 0;
    }
  }
}
