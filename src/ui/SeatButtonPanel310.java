package ui;

import cominformation.Information310;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeatButtonPanel310 extends JPanel {
    private ArrayList<JButton> seatButtons;
    private ArrayList<String> computerList;
    private Information310 information;

    public SeatButtonPanel310(Information310 information) {
        this.information = information;
        setLayout(new BorderLayout()); // BorderLayout으로 레이아웃 설정
        seatButtons = new ArrayList<>();
        computerList = new ArrayList<>(information.getComputerMap310().values());

    }
}
