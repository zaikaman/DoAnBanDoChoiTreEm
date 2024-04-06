package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SHOW TABLES LIKE 'nguoidung'");
            if (!rs.next()) {
                st.executeUpdate("create table nguoidung(id int AUTO_INCREMENT primary key,vaiTro varchar(50),ten varchar(200),sdt varchar(50),email varchar(200),matKhau varchar(50), diaChi varchar(200),status varchar(50))");
            }
            st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi,status) values('QuanLy','Quan Ly','12345','ad','admin','Vietnam','true')");
            st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi,status) values('Nhan Vien','Sang','123456','nv1','password1','Vietnam','true')");
            st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi,status) values('Nhan Vien','Quốc','123457','nv2','password2','Vietnam','true')");
            st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi,status) values('Nhan Vien','Thịnh','123458','nv3','password3','Vietnam','true')");

            rs = st.executeQuery("SHOW TABLES LIKE 'khachhang'");
            if (!rs.next()) {
                st.executeUpdate("create table khachhang(id AUTO_INCREMENT primary key, ten varchar(200), email varchar(200), diaChi varchar(200), sdt varchar(50))");
            }
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into khachhang (ten, email, diaChi, sdt) values('Khach Hang " + i + "','kh" + i + "@mail.com','Dia Chi " + i + "','12345" + i + "')");
            }
            rs = st.executeQuery("SHOW TABLES LIKE 'sanpham'");
            if (!rs.next()) {
                st.executeUpdate("create table sanpham(id AUTO_INCREMENT primary key, ten varchar(200), xuatxu varchar(200), gia decimal(10,2), soluong int)");
            }
            st.executeUpdate("ALTER TABLE sanpham ADD COLUMN theloai varchar(200)");
            // Đồ chơi phương tiện
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into sanpham (ten, xuatxu, gia, soluong, theloai) values('Do Choi Phuong Tien " + i + "', 'Vietnam', 100.00, 10, 'Do Choi Phuong Tien')");
            }

// Đồ chơi theo phim
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into sanpham (ten, xuatxu, gia, soluong, theloai) values('Do Choi Theo Phim " + i + "', 'Vietnam', 100.00, 10, 'Do Choi Theo Phim')");
            }

// Đồ chơi thời trang
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into sanpham (ten, xuatxu, gia, soluong, theloai) values('Do Choi Thoi Trang " + i + "', 'Vietnam', 100.00, 10, 'Do Choi Thoi Trang')");
            }

// Đồ chơi lắp ghép
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into sanpham (ten, xuatxu, gia, soluong, theloai) values('Do Choi Lap Ghep " + i + "', 'Vietnam', 100.00, 10, 'Do Choi Lap Ghep')");
            }

// Robot
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into sanpham (ten, xuatxu, gia, soluong, theloai) values('Robot " + i + "', 'Vietnam', 100.00, 10, 'Robot')");
            }

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
