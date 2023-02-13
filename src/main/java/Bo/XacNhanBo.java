package Bo;

import java.util.ArrayList;
import Bean.XacNhanBean;
import Dao.XacNhanDao;



public class XacNhanBo {
  XacNhanDao xndao = new XacNhanDao();
  ArrayList<XacNhanBean> ds;

  public ArrayList<XacNhanBean> getdanhsach() {
    ds = xndao.getdanhsach();
    return ds;
  }

  public ArrayList<XacNhanBean> getlistbuy() {
    ds = xndao.getlistbuy();
    return ds;
  }

  public int countCTHD(long mahoadon) throws Exception {
    return xndao.countCTHD(mahoadon);
  }

  public void autoXacNhan(long mahoadon) throws Exception {
    int count = countCTHD(mahoadon);
    if (count == 0) {
      xndao.xacnhanHD(mahoadon);
    }
  }

  public int xacnhanHD(long mahoadon) throws Exception {
    xndao.xacnhanCTHD(mahoadon);
    return xndao.xacnhanHD(mahoadon);
  }
}


