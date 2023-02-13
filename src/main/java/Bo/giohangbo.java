package Bo;

import java.util.ArrayList;
import java.util.List;
import Bean.giohangbean;



public class giohangbo {
  public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();

  public void Them(String masach, String tensach, long gia, long soluong) {
    for (giohangbean h : ds)
      if (h.getMasach().equals(masach)) {
        h.setSoluong(h.getSoluong() + soluong);
        return;
      }

    ds.add(new giohangbean(masach, tensach, gia, soluong));
  }

  public long Tongtien() {
    long s = 0;
    for (giohangbean h : ds)
      s = s + h.getThanhtien();
    return s;
  }

  public void Sua(String maSach, long sl) {
    for (giohangbean g : ds) {
      if (g.getMasach().equals(maSach)) {
        g.setSoluong(sl);
        return;
      }
    }
  }

  public void Xoa(String maSach) {
    for (giohangbean g : ds) {
      if (g.getMasach().equals(maSach)) {
        ds.remove(g);
        return;
      }
    }
  }

  public void XoaALL() {
    ds.clear();
  }

  public List<giohangbean> getall() {
    return ds;
  }

}
