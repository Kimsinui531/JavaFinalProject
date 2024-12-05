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

        // 버튼 패널 설정
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // 자리 버튼 생성 및 배치
        for (int i = 0; i < computerList.size(); i++) {
            JButton seatButton = new JButton("자리 " + (i + 1));
            seatButtons.add(seatButton);
            buttonPanel.add(seatButton);

            int index = i;
            seatButton.addActionListener(e -> createInfoFrame(index));
        }
        searchButton.addActionListener(e -> {
            String searchTerm = searchField.getText().trim();
            highlightMatchingButtons(searchTerm); // 검색어에 맞는 버튼 하이라이트
        });

        private void highlightMatchingButtons(String searchTerm) {
            // 모든 버튼을 기본 배경으로 설정
            for (JButton button : seatButtons) {
                button.setBackground(UIManager.getColor("Button.background"));
            }

            // 검색어와 일치하는 버튼의 배경색을 변경
            for (int i = 0; i < computerList.size(); i++) {
                if (computerList.get(i).contains(searchTerm)) {
                    seatButtons.get(i).setBackground(Color.YELLOW); // 일치하는 버튼 강조
                }
            }
        }


    }
}
