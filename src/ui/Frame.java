package ui;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        setTitle("자리 안내 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);

        // 메인 패널 설정
        JPanel mainPanel = new JPanel(new BorderLayout());

        // 패널 1 생성
        JPanel panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 패널 1a (상단 버튼)
        JPanel panel1a = new JPanel(new FlowLayout());
        JButton buttonToPanel2 = new JButton("06-408로 이동"); // 버튼은 유지하되 기능은 없음
        panel1a.add(buttonToPanel2);

        // 패널 1b (중간 레이블)
        JPanel panel1b = new JPanel(new FlowLayout());
        JLabel screen310 = new JLabel("                   06-310 스크린                ");
        screen310.setOpaque(true);
        screen310.setBackground(new Color(51, 153, 255));
        screen310.setForeground(Color.WHITE);
        panel1b.add(screen310);

        // 패널 1c (하단 버튼들)
        JPanel panel1c = new JPanel(new FlowLayout());
        for (int i = 0; i < 5; i++) {
            JButton seatButton = new JButton("자리 " + (i + 1));
            panel1c.add(seatButton);}

        // GridBagConstraints 설정
        gbc.fill = GridBagConstraints.BOTH;

        // panel1a 추가 (1 비율)
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(panel1a, gbc);

        // panel1b 추가 (1 비율)
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(panel1b, gbc);

        // panel1c 추가 (8 비율)
        gbc.weightx = 8;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(panel1c, gbc);

        // 메인 패널에 패널 추가
        mainPanel.add(panel1, BorderLayout.CENTER); // 중앙에 추가

        // 프레임에 메인 패널 추가
        add(mainPanel);
        setVisible(true); // JFrame을 보여줌
        setLocationRelativeTo(null); // 화면 중앙에 위치
    }
    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}
