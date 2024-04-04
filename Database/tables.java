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
            st.executeUpdate("create table nguoidung(nguoidung_pk int AUTO_INCREMENT primary key,userRole varchar(50),name varchar(200),mobileNumber varchar(50),email varchar(200),password varchar(50), address varchar(200),status varchar(50))");
            st.executeUpdate("insert into nguoidung (userRole,name,mobileNumber,email,password,address,status) values('QuanLy','Quan Ly','12345','ad','admin','Vietnam','true')");
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
