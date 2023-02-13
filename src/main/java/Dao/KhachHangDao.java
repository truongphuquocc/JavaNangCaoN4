package Dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Bean.KhachHangBean;


public class KhachHangDao {


  public static String getMd5Hash(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] messageDigest = md.digest(input.getBytes());
      BigInteger no = new BigInteger(1, messageDigest);
      String hashtext = no.toString(16);
      while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }



  public KhachHangBean ktdn(String tendn, String mk) throws Exception {
    // String PassMD5 = getMd5Hash(mk);

    KetNoi kn = new KetNoi();
    kn.KetNoi();

    String sql = "Select * from KhachHang where tendn=? and pass=?";
    PreparedStatement cmd = kn.cn.prepareStatement(sql);
    // String PassMD5 = getMd5Hash(mk);
    cmd.setString(1, tendn);
    cmd.setString(2, mk);

    ResultSet rs = cmd.executeQuery();

    KhachHangBean kh = null;
    if (rs.next()) {
      Integer MaKH = rs.getInt("makh");
      String HoTenKH = rs.getString("hoten");
      String DiaChi = rs.getString("diachi");
      String SDT = rs.getString("sodt");
      String Email = rs.getString("email");
      String TenDN = rs.getString("tendn");
      String MatKhau = rs.getString("pass");
      kh = new KhachHangBean(MaKH, HoTenKH, DiaChi, SDT, Email, TenDN, MatKhau);
    }
    // b6: Dong all
    rs.close();
    kn.cn.close();
    return kh;
  }

  public Boolean ktdk(String HoTen, String DiaChi, String SoDienThoai, String Email,
      String TenDangNhap, String MatKhau) throws Exception {

    // String PassMD5 = getMd5Hash(pass);

    KetNoi kn = new KetNoi();
    kn.KetNoi();
    try {
      String sql = "Insert into KhachHang Values (?,?,?,?,?,?)";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, HoTen);
      cmd.setString(2, DiaChi);
      cmd.setString(3, SoDienThoai);
      cmd.setString(4, Email);
      cmd.setString(5, TenDangNhap);
      cmd.setString(6, MatKhau);

      if (cmd.executeUpdate() == 1) {
        return true;
      } else
        return false;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return false;


  }

}
