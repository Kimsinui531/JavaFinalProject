package ui;

//cominformation패키지 안에 있는 Information408 클래스에서 만든 LinkedHashMap에 있는 데이터들을 이용해서 자리버튼을 만드는 클래스
import cominformation.Information408;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * SeatButtonPanel408 클래스는 자리 버튼 패널을 생성하고 관리하는 역할을 합니다.
 * <p>
 * 이 클래스는 cominformation.Information408에서 가져온 LinkedHashMap 데이터를 사용하여 자리 버튼을 동적으로 생성하며,
 * 검색 기능과 자리 정보를 표시하는 팝업을 제공합니다.
 * </p>
 *
 * @author KIM SIN UI
 * @version 1.0
 * @since 2024-12-05
 *
 * @changelog
 * <ul>
 *   <li>2024-12-05: 최초 생성 (KIM SIN UI)</li>
 *   <li>2024-12-05: 컴퓨터 검색 필드 및 버튼 추가 (KIM SIN UI)</li>
 *   <li>2024-12-05: 자리 버튼 생성 및 이벤트 추가 (KIM SIN UI)</li>
 *   <li>2024-12-05: 자리 버튼을 생성하고, 클릭 시 해당 자리 정보 창을 띄우는 이벤트 추가 (KIM SIN UI)</li>
 *   <li>2024-12-05: 검색어와 일치하는 버튼을 하이라이트 하는 기능 구현, 자리 버튼 강조 (KIM SIN UI)</li>
 *   <li>2024-12-05: 하이라이트 처리 메소드 추가 (KIM SIN UI)</li>
 *   <li>2024-12-05: 프로그램 정보 팝업 창 생성 메소드 추가 (KIM SIN UI)</li>
 *   <li>2024-12-05: 자리별 설치된 프로그램 정보를 반환 메소드 추가 (KIM SIN UI)</li>
 *   <li>2024-12-05: 각 자리의 프로그램 정보를 반환하는 기능 구현 (KIM SIN UI)</li>
 *   <li>2024-12-06: SeatButtonPanel408 클래스의 GUI 색상 변경 (KIM SIN UI)</li>
 *   <li>2024-12-06: 버튼 생성 로직 분리 (KIM SIN UI)</li>
 *   <li>2024-12-06: 검색어 유효성 검사 추가 (KIM SIN UI)</li>
 *   <li>2024-12-06: 프레임 크기 수정 (KIM SIN UI)</li>
 *   <li>2024-12-07: 레이아웃 조정(KIM SIN UI)</li>
 *   <li>2024-12-09: 자리 버튼 레이아웃 수정 (KIM SIN UI)</li>
 *   <li>2024-12-23: 불필요한 코드 제거(KIM SIN UI)</li>
 *   <li>2024-12-23: 이미지 아이콘 수정 (KIM SIN UI)</li>
 *   <li>2024-12-24: 자바독 추가 (KIM SIN UI)</li>
 * </ul>
 */
public class SeatButtonPanel408 extends JPanel {

    private ArrayList<JButton> seatButtons;
    private ArrayList<String> computerList;

    /**
     * SeatButtonPanel408 클래스의 생성자입니다.
     *
     * @param information 강의실 06-408의 컴퓨터 정보를 포함하는 Information408 객체입니다.
     */
    public SeatButtonPanel408(Information408 information) {

        setLayout(new BorderLayout());
        seatButtons = new ArrayList<>();
        computerList = new ArrayList<>(information.getComputerMap408().values());

        // 검색 패널 초기화
        JPanel searchPanel = createSearchPanel();
        add(searchPanel, BorderLayout.NORTH);

        // 버튼 패널 초기화
        JPanel buttonPanel = createButtonPanel();
        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.add(buttonPanel);
        add(buttonPanel2, BorderLayout.CENTER);
    }

    /**
     * 자리 버튼 패널을 생성합니다.
     * <p>
     * 컴퓨터 리스트를 기반으로 동적으로 자리 버튼을 생성하고 {@link GridLayout}을 사용하여 배치합니다.
     * 각 버튼 클릭 시 자리의 프로그램 정보를 표시하는 팝업이 나타납니다.
     * </p>
     *
     * @return 생성된 자리 버튼 패널
     */
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

    /**
     * 자리 버튼 패널을 생성합니다.
     * <p>
     * 컴퓨터 리스트를 기반으로 동적으로 자리 버튼을 생성하고 GridLayout을 사용하여 배치합니다.
     * 각 버튼 클릭 시 자리의 프로그램 정보를 표시하는 팝업이 나타납니다.
     * </p>
     *
     * @return 생성된 자리 버튼 패널
     */
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

    /**
     * 검색어와 일치하는 버튼을 하이라이트합니다.
     * <p>
     * 일치하는 버튼의 배경색은 노란색으로 변경되며, 텍스트는 검정색으로 표시됩니다.
     * 검색어가 일치하지 않으면 버튼 색상은 기본값으로 초기화됩니다.
     * </p>
     *
     * @param searchTerm 검색어
     */
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

    /**
     * 선택된 자리의 프로그램 정보를 표시하는 팝업 창을 생성하는 메서드입니다.
     *
     * @param index 선택된 자리의 인덱스
     */
    private void createInfoFrame(int index) {
        JFrame infoFrame = new JFrame("설치되어 있는 프로그램");
        // 아이콘 이미지 설정
        infoFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/images/imageicon.png"));
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

    /**
     * 선택된 자리의 프로그램 정보를 반환하는 메서드입니다.
     *
     * @param index 선택된 자리의 인덱스
     * @return 해당 자리의 프로그램 정보
     */
    private String getProgramInfo(int index) {
        String computerName = computerList.get(index);
        return "자리 " + (index + 1) + "에 설치된 프로그램: " + (computerName != null ? computerName : "정보 없음");
    }
}