package ui;

import cominformation.Information310;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeatButtonPanel408 extends JPanel {
    private ArrayList<JButton> seatButtons;
    private ArrayList<String> computerList;
    private Information310 information;

    public SeatButtonPanel408(Information310 information) {
        this.information = information;
        setLayout(new BorderLayout()); // BorderLayout 설정
        seatButtons = new ArrayList<>();
        computerList = new ArrayList<>(information.getComputerMap310().values());

        // 패널을 구성할 컴포넌트 추가
    }
}

