package Bo;

import java.util.ArrayList;
import Bean.loaibean;
import Dao.loaidao;

public class loaibo {
  loaidao ldao = new loaidao();
  ArrayList<loaibean> ds;

  public ArrayList<loaibean> getloai() {
    ds = ldao.getloai();
    return ds;
  }

  public ArrayList<loaibean> Tim(String key) throws Exception {
    ArrayList<loaibean> tam = new ArrayList<loaibean>();
    ArrayList<loaibean> ds = getloai();
    for (loaibean s : ds)
      if (s.getTenloai().toLowerCase().trim().contains(key.toLowerCase().trim()))
        tam.add(s);
    return tam;
  }

  public int editcategory(String maloai, String tenloai) throws Exception {
    return ldao.editcategory(maloai, tenloai);
  }

  public int deleteCategory(String maloai) throws Exception {
    return ldao.deleteCategory(maloai);
  }

  public int addCategory(String maloai, String tenloai) throws Exception {
    return ldao.addCategory(maloai, tenloai);
  }

  public loaibean getCategory(String maloai) {
    try {
      return ldao.getCategory(maloai);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }

  }

  public int getTongLoai() {
    ldao.getloai();
    return ldao.getTongLoai();
  }

}
