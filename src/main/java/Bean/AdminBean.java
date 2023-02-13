package Bean;

public class AdminBean {
  private String Tendn;
  private String MatKhau;
  private Boolean Quyen;

  public AdminBean(String tendn, String matKhau, Boolean quyen) {
    super();
    Tendn = tendn;
    MatKhau = matKhau;
    Quyen = quyen;
  }

  public String getTendn() {
    return Tendn;
  }

  public void setTendn(String tendn) {
    Tendn = tendn;
  }

  public String getMatKhau() {
    return MatKhau;
  }

  public void setMatKhau(String matKhau) {
    MatKhau = matKhau;
  }

  public Boolean getQuyen() {
    return Quyen;
  }

  public void setQuyen(Boolean quyen) {
    Quyen = quyen;
  }

}
