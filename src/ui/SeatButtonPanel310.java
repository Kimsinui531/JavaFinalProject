package ui;
//cominformation패키지 안에 있는 Information310 클래스에서 만든 LinkedHashMap에 있는 데이터들을 이용해서 자리버튼을 만드는 클래스
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
        computerList = new ArrayList<>(information.getComputerMap310().values()); // 정보를 가져옴

        // 검색을 위한 패널과 컴포넌트 설정
        JPanel searchPanel = new JPanel(new FlowLayout());
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("찾기");
        searchButton.setBackground(new Color(25, 42, 66));
        searchButton.setForeground(Color.white);

        searchPanel.add(new JLabel("찾을 컴퓨터: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // 버튼 패널 설정
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // 자리 버튼 생성 및 배치
        for (int i = 0; i < computerList.size(); i++) {
            JButton seatButton = new JButton("자리 " + (i + 1));
            seatButtons.add(seatButton);
            seatButton.setBackground(new Color (9, 111, 232));
            seatButton.setForeground(Color.white);
            buttonPanel.add(seatButton);

            int index = i;
            seatButton.addActionListener(e -> createInfoFrame(index)); // 버튼 클릭 시 팝업 창 생성
        }
        searchButton.addActionListener(e -> {
            String searchTerm = searchField.getText().trim();
            highlightMatchingButtons(searchTerm); // 검색어에 맞는 버튼 하이라이트
        });
        add(searchPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    // 검색어에 맞는 버튼 하이라이트
    private void highlightMatchingButtons(String searchTerm) {
        // 모든 버튼 색상 변경
        for (JButton button : seatButtons) {
            button.setBackground(new Color (9, 111, 232));
            button.setForeground(Color.white);
        }

        // 검색어와 일치하는 버튼의 배경색을 변경
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).contains(searchTerm)) {
                seatButtons.get(i).setBackground(Color.YELLOW); // 일치하는 버튼 노란색으로 강조
                seatButtons.get(i).setForeground(Color.BLACK);
            }
        }
    }

    // 선택한 자리의 프로그램 정보 팝업
    private void createInfoFrame(int index) {
        JFrame infoFrame = new JFrame("설치되어 있는 프로그램");
        infoFrame.setSize(280, 150);
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText(getProgramInfo(index)); // 해당 자리의 프로그램 정보 가져오기
        panel.add(textArea);

        infoFrame.getContentPane().add(panel);
        infoFrame.setVisible(true); // 팝업 창 표시
    }

    // 선택한 자리의 프로그램 정보 반환
    private String getProgramInfo(int index) {
        String computerName = computerList.get(index);
        String programInfo = computerName;
        return "자리 " + (index + 1) + "에 설치된 프로그램: " + (programInfo != null ? programInfo : "정보 없음");
    }
}

