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
        setLayout(new BorderLayout());
        seatButtons = new ArrayList<>();
        computerList = new ArrayList<>(information.getComputerMap310().values());

        // 검색 패널 초기화
        JPanel searchPanel = createSearchPanel();
        add(searchPanel, BorderLayout.NORTH);

        // 버튼 패널 초기화
        JPanel buttonPanel = createButtonPanel();
        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.add(buttonPanel);
        add(buttonPanel2, BorderLayout.CENTER);
    }

    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel(new FlowLayout());
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("찾기");
        searchButton.setBackground(new Color(25, 42, 66));
        searchButton.setForeground(Color.white);

        searchPanel.add(new JLabel("찾을 컴퓨터: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        searchButton.addActionListener(e -> {
            String searchTerm = searchField.getText().trim();
            if (!searchTerm.isEmpty()) {
                highlightMatchingButtons(searchTerm);
            } else {
                JOptionPane.showMessageDialog(this, "검색어를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
            }
        });

        return searchPanel;
    }

    private JPanel createButtonPanel() {

        int numberOfRows = 4;
        int numberOfColumns = (int) Math.ceil((double) computerList.size() / numberOfRows); // 총 열 수 계산

        JPanel buttonPanel = new JPanel(new GridLayout(numberOfColumns,4,3,2));

        for (int i = 0; i < computerList.size(); i++) {
            JButton seatButton = new JButton("자리 " + (i + 1));
            seatButton.setBackground(new Color(9, 111, 232));
            seatButton.setSize(50,50);
            seatButton.setForeground(Color.white);
            seatButtons.add(seatButton);
            buttonPanel.add(seatButton);

            int index = i; // 해당 인덱스 저장
            seatButton.addActionListener(e -> createInfoFrame(index));
        }

        return buttonPanel;
    }

    private void highlightMatchingButtons(String searchTerm) {
        // 모든 버튼 색상 변경
        for (JButton button : seatButtons) {
            button.setBackground(new Color(9, 111, 232));
            button.setForeground(Color.white);
        }

        // 검색어와 일치하는 버튼의 배경색을 변경
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).contains(searchTerm)) {
                seatButtons.get(i).setBackground(Color.YELLOW);
                seatButtons.get(i).setForeground(Color.BLACK);
            }
        }
    }

    private void createInfoFrame(int index) {
        JFrame infoFrame = new JFrame("설치되어 있는 프로그램");
        infoFrame.setSize(320, 150);
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


    private String getProgramInfo(int index) {
        String computerName = computerList.get(index);
        return "자리 " + (index + 1) + "에 설치된 프로그램: " + (computerName != null ? computerName : "정보 없음");
    }
}