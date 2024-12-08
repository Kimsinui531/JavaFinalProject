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

    }
}
