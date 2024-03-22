/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Demo;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Admin
 */
public class Customer {
    public String hoten;
    public int tuoi;
    
    public Customer(String hoten, int tuoi) {
        this.hoten = hoten;
        this.tuoi = tuoi;
    }
    
    public void Show() {
        JPanel panel = new JPanel();
        panel.setSize(100,200);
        JLabel label = new JLabel(this.hoten);
        panel.add(label);
    }
}
