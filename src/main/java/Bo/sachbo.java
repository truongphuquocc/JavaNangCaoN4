package Bo;

import java.util.ArrayList;
import Bean.sachbean;
import Dao.sachdao;

public class sachbo {
  sachdao sdao = new sachdao();
  ArrayList<sachbean> ds;

  public ArrayList<sachbean> getsach() {
    ds = sdao.getsach();
    return ds;
  }

  // Phan trang total
  public ArrayList<sachbean> getPaging(int index) {
    ds = sdao.getPaging(index);
    return ds;
  }

  // Phan trang theo tim kiem sach
  public ArrayList<sachbean> getPagingSearch(String key, int index) {
    ds = sdao.getPagingSearch(key, index);
    return ds;
  }

  // Phan trang theo loai sach
  public ArrayList<sachbean> getPagingCategories(String key, int index) {
    ds = sdao.getPagingCategories(key, index);
    return ds;
  }

  public ArrayList<sachbean> TimMa(String maloai) {
    ArrayList<sachbean> tam = new ArrayList<sachbean>();
    for (sachbean s : ds)
      if (s.getMaloai().equals(maloai))
        tam.add(s);
    return tam;
  }

  public ArrayList<sachbean> Tim(String key) {
    ArrayList<sachbean> tam = new ArrayList<sachbean>();
    for (sachbean s : ds)
      if (s.getTensacj().toLowerCase().contains(key.toLowerCase())
          || s.getTacgia().toLowerCase().contains(key.toLowerCase())
          || s.getMaloai().toLowerCase().contains(key.toLowerCase()))
        tam.add(s);
    return tam;
  }


  public int getPageNumber() {
    sachdao sdao = new sachdao();
    return sdao.getPageNumber();
  }

  public int getPageNumberSearch(String maloai) {
    sachdao sdao = new sachdao();
    return sdao.getPageNumberSearch(maloai);
  }

  public int getPageNumberCategories(String key) {
    sachdao sdao = new sachdao();
    return sdao.getPageNumberCategories(key);
  }

}
