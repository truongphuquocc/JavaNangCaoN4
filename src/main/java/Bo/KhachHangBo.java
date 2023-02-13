package Bo;

import Bean.KhachHangBean;
import Dao.KhachHangDao;

public class KhachHangBo {
  KhachHangDao khdao = new KhachHangDao();

  public KhachHangBean ktdn(String tendn, String mk) throws Exception {
    return khdao.ktdn(tendn, mk);
  }

  public Boolean ktdk(String HoTen, String DiaChi, String SoDienThoai, String Email,
      String TenDangNhap, String MatKhau) throws Exception {
    return khdao.ktdk(HoTen, DiaChi, SoDienThoai, Email, TenDangNhap, MatKhau);
  }

  public static String convertPassMd5(String mk) {
    String mkMd5 = KhachHangDao.getMd5Hash(mk);
    return mkMd5;
  }


}
