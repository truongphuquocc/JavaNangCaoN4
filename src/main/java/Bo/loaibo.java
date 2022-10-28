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
}
