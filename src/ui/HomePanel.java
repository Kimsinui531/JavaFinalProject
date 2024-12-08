package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {
    private BufferedImage image;
    private JButton button;

    // 이미지 경로를 하드코딩
    String imagepath = "C:\\Users\\ksy05\\Desktop\\2-2 수업\\자바스터디\\OsImage.png"; //이미지 경로 지정

    private void loadImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HomePanel(ActionListener ac) {
        loadImage(imagepath);  // 이미지 로드 호출
        initializeUI(ac);  // UI 초기화
    }

    private void initializeUI(ActionListener ac) {
        setLayout(new GridBagLayout());  // 레이아웃 설정
        button = new JButton("실행");  // 버튼 생성
        button.setBackground(new Color(40, 78, 184));  // 버튼 배경색 설정
        button.setForeground(Color.WHITE);  // 버튼 텍스트 색상 설정
        button.addActionListener(ac);

    }

}
