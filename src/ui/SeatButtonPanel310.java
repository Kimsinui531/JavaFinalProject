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

        // 검색을 위한 패널과 컴포넌트 설정
        JPanel searchPanel = new JPanel(new FlowLayout());
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("찾기");

        searchPanel.add(new JLabel("찾을 컴퓨터: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);


    }
}
