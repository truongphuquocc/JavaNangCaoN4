package Bo;

import java.util.ArrayList;
import Bean.AdminChiTietDonHangBean;
import Dao.AdminChiTietDonHangDao;
import Dao.XacNhanDao;

public class AdminChiTietDonHangBo {
  AdminChiTietDonHangDao adct = new AdminChiTietDonHangDao();
  XacNhanDao xndao = new XacNhanDao();

  public ArrayList<AdminChiTietDonHangBean> getdanhsach(long mahoadon) {
    return adct.getdanhsach(mahoadon);
  }

  /*
   * public ArrayList<AdminChiTietDonHangBean> getAdanhsach(long machitiet) { return
   * adct.getAdanhsach(machitiet); }
   */
  public int xacnhanchitiet(int mact) throws Exception {
    return adct.xacnhanchitiet(mact);
  }



}
