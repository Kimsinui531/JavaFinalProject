package ui;

// 코드를 실행 시켰을 때 화면에 처음으로 나오는 화면
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.event.ActionListener;

/**
 * 프로그램의 초기 화면을 나타내는 패널입니다.
 *
 * 이 클래스는 로고 이미지와 "실행 " 버튼을 포함하며,
 * 버튼 클릭 시 지정된 ActionListener를 통해 이벤트를 처리합니다.
 *
 * @author KIM SIN UI
 * @version 1.0
 * @since 2024-12-08
 *
 * @changelog
 * <ul>
 *   <li>2024-12-08: 최초 생성 (KIM SIN UI)</li>
 *   <li>2024-12-08: frame 클래스를 시작하기전에 화면에 나타날 홈패널 생성(KIM SIN UI)</li>
 *   <li>2024-12-08: 지정된 경로에서 이미지를 로드하는 기능 구현 (KIM SIN UI)</li>
 *   <li>2024-12-08: '실행' 버튼 추가 및 스타일 설정 (KIM SIN UI)</li>
 *   <li>2024-12-08: GridBagLayout을 사용한 버튼 배치(KIM SIN UI)</li>
 *   <li>2024-12-08: paintComponent 메서드에서 배경 이미지 그리기 (KIM SIN UI)</li>
 *   <li>2024-12-08: 버튼 배치 코드 추가(KIM SIN UI)</li>
 *   <li>2024-12-23: 이미지 파일을 불러오는 방식 수정 (KIM SIN UI)</li>
 * </ul>
 */
public class HomePanel extends JPanel {
    private BufferedImage image; // 배경 이미지를 저장할 변수
    private JButton button; // 버튼 컴포넌트

    // 이미지 경로를 하드코딩
    String imagepath = "resources/images/OsImage.png"; // 이미지 경로 지정

    /**
     * HomePanel 클래스의 생성자입니다.
     *
     * @param ac 버튼 클릭 시 이벤트를 처리할 ActionListener 객체입니다.
     */
    public HomePanel(ActionListener ac) {
        loadImage(imagepath);  // 이미지 로드 호출
        initializeUI(ac);  // UI 초기화
    }

    /**
     * 이미지를 로드하는 메서드입니다.
     *
     * @param imagePath 로드할 이미지의 경로입니다.
     */
    private void loadImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath)); // 이미지 파일 읽기
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }

    /**
     * UI 구성 요소를 초기화하는 메서드입니다.
     *
     * @param ac 버튼 클릭 시 이벤트를 처리할 ActionListener 객체입니다.
     */
    private void initializeUI(ActionListener ac) {
        setLayout(new GridBagLayout());  // 레이아웃 설정
        button = new JButton("실행");  // 버튼 생성
        button.setBackground(new Color(40, 78, 184));  // 버튼 배경색 설정
        button.setForeground(Color.WHITE);  // 버튼 텍스트 색상 설정
        button.addActionListener(ac); // ActionListener 추가
        setButtonConstraints();  // 버튼 배치
    }

    /**
     * 버튼의 배치 제약 조건을 설정하는 메서드입니다.
     */
    private void setButtonConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;  // 버튼이 위치할 가로 위치
        gbc.gridy = 0;  // 버튼이 위치할 세로 위치
        gbc.anchor = GridBagConstraints.CENTER;  // 버튼을 중앙에 배치
        add(button, gbc);  // 버튼을 JPanel에 추가
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this); // 패널 크기에 맞게 이미지 그리기
        }
    }
}
