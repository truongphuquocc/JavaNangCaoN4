package Bo;

import java.util.Date;
import Dao.HoaDonDao;

public class HoaDonBo {
  HoaDonDao hdDao = new HoaDonDao();

  public int ThemHoaDon(Long makh, Date ngaymua, boolean damua) throws Exception {
    return hdDao.ThemHoaDon(makh, ngaymua, damua);
  }

  public long GetHoaDon() throws Exception {
    return hdDao.GetHoaDon();
  }
}
