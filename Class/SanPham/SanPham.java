package com.SanPham;

public interface SanPham {

    public abstract String getIdSanpham();

    public abstract String getName();

    public abstract float getGia();

    public abstract int getSoluong();

    public abstract String getNgaySx();

    public abstract String getDonviSx();

    public abstract void setIdSanpham();

    public abstract void nhapSanpham();

    public abstract void xuatSanpham();

    public double getFinalPrice();
}
