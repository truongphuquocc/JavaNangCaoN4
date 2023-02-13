package Bo;

import Dao.ChiTietHoaDonDao;

public class ChiTietHoaDonBo {
  ChiTietHoaDonDao cthdDao = new ChiTietHoaDonDao();

  public int ThemCTHD(String maSach, long soLuongMua, long maHoaDon, boolean damua) {
    ChiTietHoaDonDao cthdDao = new ChiTietHoaDonDao();
    try {
      return cthdDao.themCTHDdao(maSach, soLuongMua, maHoaDon, damua);
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return 0;

    }
  }

}
