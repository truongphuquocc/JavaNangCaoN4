package Bean;

public class sachbean {
	public sachbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sachbean(String masach, String tensacj, String tacgia, int soluong, int gia, String anh, String maloai) {
		super();
		this.masach = masach;
		this.tensacj = tensacj;
		this.tacgia = tacgia;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
		this.maloai = maloai;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensacj() {
		return tensacj;
	}
	public void setTensacj(String tensacj) {
		this.tensacj = tensacj;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	private String masach;
	private String tensacj;
	private String tacgia;
	private int soluong;
	private int gia;
	private String anh;
	private String maloai;
	
}
