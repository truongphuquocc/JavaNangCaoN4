package Bo;

import java.util.ArrayList;
import Bean.LichSuMuaHangBean;
import Dao.LichSuMuaHangDao;

public class LichSuMuaHangBo {
  LichSuMuaHangDao lsdao = new LichSuMuaHangDao();
  ArrayList<LichSuMuaHangBean> ds;

  public ArrayList<LichSuMuaHangBean> getLichSuMuaHang(long makh) throws Exception {
    ds = lsdao.getLichSuMuaHang(makh);
    return ds;
  }

}
