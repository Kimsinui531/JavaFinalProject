package ui;
//코드를 실행 시켰을때 화면에 처음으로 나오는 화면
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
    String imagepath = "resources/images/OsImage.png"; //이미지 경로 지정

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
        setButtonConstraints();  // 버튼 배치
    }

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
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }



}
