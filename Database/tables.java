package Database;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            st.executeUpdate("create table NhanVien(Id int AUTO_INCREMENT primary key primary key, Vitri varchar(50),Ten varchar(200),Sdt varchar(50), Taikhoan varchar(50), Matkhau varchar(50), Email varchar(200),Status varchar(50))");
            st.executeUpdate("insert into NhanVien(Vitri,Ten,Sdt,Taikhoan,Matkhau,Email,Status) values('Quản lí','Nguyễn Ngọc Tuấn','081231244','tuan','123','tuan@gmail.com','true')");
//            st.executeUpdate("create table SanPham(Id int AUTO_INCREMENT primary key, Ten varchar(50),Xuatxu varchar(50), Giatien varchar(50),Soluongconlai int,Status varchar(50))");
//            st.executeUpdate("insert into SanPham(Ten,Xuatxu,Giatien,Soluongconlai,Status) values('Lego','Vietnam','200.000d',45,'true')");
            JOptionPane.showMessageDialog(null, "Da tao bang thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
