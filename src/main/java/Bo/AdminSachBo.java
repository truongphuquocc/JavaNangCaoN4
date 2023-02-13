package Bo;

import java.util.ArrayList;
import Bean.AdminSachBean;
import Dao.AdminSachDao;



public class AdminSachBo {
  AdminSachDao adsdao = new AdminSachDao();
  ArrayList<AdminSachBean> ds;

  public ArrayList<AdminSachBean> getsach() throws Exception {
    ds = adsdao.getsach();
    return ds;
  }

  public ArrayList<AdminSachBean> Tim(String key) throws Exception {
    ArrayList<AdminSachBean> tam = new ArrayList<AdminSachBean>();
    ArrayList<AdminSachBean> ds = getsach();
    for (AdminSachBean s : ds)
      if (s.getTensach().toLowerCase().trim().contains(key.toLowerCase().trim())
          || s.getTacgia().toLowerCase().trim().contains(key.toLowerCase().trim()))
        tam.add(s);
    return tam;
  }

  public AdminSachBean getBook(String masach) throws Exception {
    return adsdao.getBook(masach);
  }

  public int addSach(String maSach, String TenSach, String tg, Long gia, Long soluong, String anh,
      String maloai, java.util.Date ngay, String soTap) throws Exception {
    return adsdao.addSach(maSach, TenSach, tg, gia, soluong, anh, maloai, ngay, soTap);
  }

  public int deleteBook(String maSach) throws Exception {
    return adsdao.deleteBook(maSach);
  }

  public int editBook(String maSach, String TenSach, String tg, Long gia, Long soluong,
      String maloai, java.util.Date ngay, String soTap) throws Exception {
    return adsdao.editBook(maSach, TenSach, tg, gia, soluong, maloai, ngay, soTap);
  }

  public int editBook2(String maSach, String TenSach, String tg, Long gia, Long soluong, String anh,
      String maloai, java.util.Date ngay, String soTap) throws Exception {
    return adsdao.editBook2(maSach, TenSach, tg, gia, soluong, anh, maloai, ngay, soTap);
  }
}
