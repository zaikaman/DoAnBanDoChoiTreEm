package com.TaiKhoan;

import com.NguoiDung.NguoiDung;
import com.KhachHang.KhachHang;
import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

// Lớp TaiKhoan quản lý đăng ký và đăng nhập người dùng
public class TaiKhoan {

    private NguoiDung[] nguoiDung = new NguoiDung[100]; // Sử dụng mảng cố định với một kích thước tối đa
    public int soLuongNguoiDung = 0; // Biến để theo dõi số lượng người dùng
    private String tenFile = "Tai Khoan Nguoi Dung.txt";

    // Default constructor
    public TaiKhoan() {
    }

    // Constructor with all fields
    public TaiKhoan(NguoiDung[] nguoiDung, int soLuongNguoiDung, String tenFile) {
        this.nguoiDung = nguoiDung;
        this.soLuongNguoiDung = soLuongNguoiDung;
        this.tenFile = tenFile;
    }

    // Copy constructor
    public TaiKhoan(TaiKhoan other) {
        this.nguoiDung = other.nguoiDung.clone();  // This creates a new array that is a copy of the original
        this.soLuongNguoiDung = other.soLuongNguoiDung;
        this.tenFile = other.tenFile;
    }

    // Getters
    public NguoiDung[] getNguoiDung() {
        return nguoiDung;
    }

    public int getSoLuongNguoiDung() {
        return soLuongNguoiDung;
    }

    public String getTenFile() {
        return tenFile;
    }

    // Setters
    public void setNguoiDung(NguoiDung[] nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public void setSoLuongNguoiDung(int soLuongNguoiDung) {
        this.soLuongNguoiDung = soLuongNguoiDung;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
    }

    public void dangKy(NguoiDung nguoiDung) throws IOException {
        docDanhSachNguoiDung(); // Đọc danh sách tài khoản từ tệp trước khi thêm tài khoản mới

        for (int i = 0; i < soLuongNguoiDung; i++) {
            if (this.nguoiDung[i].sTenDangNhap.equals(nguoiDung.sTenDangNhap)) {
                System.out.println("Ten dang nhap da ton tai. Vui long chon mot ten dang nhap khac");
                return; // Không thực hiện đăng ký nếu tên đăng nhập đã tồn tại
            }
        }

        // Check if the username and password are at least 6 characters long
        if (nguoiDung.sTenDangNhap.length() < 6 || nguoiDung.sMatKhau.length() < 6) {
            System.out.println("Ten dang nhap va mat khau phai co it nhat 6 ky tu.");
            return;
        }

        this.nguoiDung[soLuongNguoiDung] = nguoiDung;
        soLuongNguoiDung++;

        ghiDanhSachNguoiDung(); // Ghi danh sách tài khoản mới vào tệp

        System.out.println("Dang ky thanh cong!");
    }

    public void docThongTinNguoiDung(KhachHang khachHang) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Thong Tin Nguoi Dung.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 5 && parts[1].equals(khachHang.sTenDangNhap)) {
                khachHang.sMaNguoiDung = parts[0];
                khachHang.sHoTen = parts[2];
                khachHang.sSoDienThoai = parts[3];
                khachHang.sDiaChi = parts[4];
                break;
            }
        }

        reader.close();
    }

    void docDanhSachNguoiDung() throws IOException {
        File file = new File(tenFile);

        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader(tenFile));
        String line;
        soLuongNguoiDung = 0; // Đặt lại biến đếm

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                if ("KhachHang".equals(parts[2])) {
                    this.nguoiDung[soLuongNguoiDung] = new KhachHang(parts[0], parts[1]);
                }

                soLuongNguoiDung++;
            }
        }
        reader.close();
    }

    void ghiDanhSachNguoiDung() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(tenFile));
        for (int i = 0; i < soLuongNguoiDung; i++) {
            writer.write(nguoiDung[i].sTenDangNhap + "," + nguoiDung[i].sMatKhau + "," + nguoiDung[i].sVaiTro + "\n");
        }
        writer.close();
    }

    void suaThongTinNguoiDung(String tenDangNhap, String hoTenMoi, String soDienThoaiMoi, String diaChiMoi) throws IOException {
        docDanhSachNguoiDung(); // Đọc danh sách tài khoản từ tệp trước khi thực hiện sửa đổi

        for (int i = 0; i < soLuongNguoiDung; i++) {
            if (this.nguoiDung[i].sTenDangNhap.equals(tenDangNhap)) {
                this.nguoiDung[i].sHoTen = hoTenMoi;
                this.nguoiDung[i].sSoDienThoai = soDienThoaiMoi;
                this.nguoiDung[i].sDiaChi = diaChiMoi;
                break;
            }
        }

        ghiDanhSachNguoiDung(); // Ghi danh sách tài khoản mới vào tệp

        System.out.println("Sua thong tin thanh cong!");
    }

    void xoaThongTinNguoiDung(String sTenDangNhap) throws IOException {
        docDanhSachNguoiDung(); // Đọc danh sách tài khoản từ tệp trước khi thực hiện xóa

        int index = -1;
        for (int i = 0; i < soLuongNguoiDung; i++) {
            if (this.nguoiDung[i].sTenDangNhap.equals(sTenDangNhap)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Di chuyển tất cả các phần tử sau index một bước về phía trước
            for (int i = index; i < soLuongNguoiDung - 1; i++) {
                this.nguoiDung[i] = this.nguoiDung[i + 1];
            }
            soLuongNguoiDung--;
        }

        ghiDanhSachNguoiDung(); // Ghi danh sách tài khoản mới vào tệp

        System.out.println("Xoa thong tin thanh cong!");
    }

    public boolean dangNhap(String tenDangNhap, String matKhau) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(tenFile));
        String line;
        boolean found = false;
        boolean userExists = false;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3 && parts[0].equals(tenDangNhap)) {
                userExists = true;
                if (parts[1].equals(matKhau)) {
                    System.out.println("Dang nhap thanh cong voi vai tro " + parts[2] + "!");
                    found = true;
                }
                break;
            }
        }

        reader.close();

        if (userExists && !found) {
            System.out.println("Mat khau khong dung.");
            System.out.println("Vui long thu lai.");
        } else if (!userExists) {
            System.out.println("Tai khoan khong ton tai.");
            System.out.println("Vui long dang ky tai khoan.");
        }

        return found;
    }

    public void saveUserInfoToFile(NguoiDung nguoiDung) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Thong Tin Nguoi Dung.txt", true));
        writer.write(nguoiDung.sMaNguoiDung + "," + nguoiDung.sTenDangNhap + "," + nguoiDung.sHoTen + ","
                + nguoiDung.sSoDienThoai + "," + nguoiDung.sDiaChi + "\n");
        writer.close();
    }
}
