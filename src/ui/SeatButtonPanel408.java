package ui;

import cominformation.Information408;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeatButtonPanel408 extends JPanel {
    private ArrayList<JButton> seatButtons;
    private ArrayList<String> computerList;
    private Information408 information;

    public SeatButtonPanel408(Information408 information) {
        this.information = information;
        setLayout(new BorderLayout()); // BorderLayout 설정
        seatButtons = new ArrayList<>();
        computerList = new ArrayList<>(information.getComputerMap408().values());

        // 검색을 위한 패널과 컴포넌트 설정
        JPanel searchPanel = new JPanel(new FlowLayout());
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("찾기");

        searchPanel.add(new JLabel("찾을 컴퓨터: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // 버튼 패널 설정
        JPanel buttonPanel = new JPanel(new FlowLayout());

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
        add(searchPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    }
}

