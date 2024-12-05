package ui;
//패널 2 UI 구성 로직을 CreatePanel408 클래스로 캡슐화
import cominformation.Information408;

import javax.swing.*;
import java.awt.*;

public class CreatePanel408 extends JPanel {
    public CreatePanel408(CardLayout cardLayout, JPanel cardPanel, Information408 information) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 패널 2a (상단 버튼)
        JPanel panel2a = new JPanel(new FlowLayout());
        JButton buttonToPanel1 = new JButton("06-310로 이동");
        panel2a.add(buttonToPanel1);

        // 패널 2b (중간 레이블)
        JPanel panel2b = new JPanel(new FlowLayout());
        JLabel screen408 = new JLabel("                   06-408 스크린                ");
        screen408.setOpaque(true);
        screen408.setBackground(new Color(45, 75, 122));
        screen408.setForeground(Color.WHITE);
        panel2b.add(screen408);

        // 패널 2c (하단 버튼들)
        JPanel panel2c = new SeatButtonPanel408(information); // Information408 사용하여 버튼 생성

        // GridBagConstraints 설정
        gbc.fill = GridBagConstraints.BOTH;

        // panel2a 추가 (1 비율)
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(panel2a, gbc);

        // panel2b 추가 (1 비율)
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(panel2b, gbc);

        // panel2c 추가 (8 비율)
        gbc.weightx = 8;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(panel2c, gbc);

        // 버튼에 액션 리스너 추가
        buttonToPanel1.addActionListener(e -> cardLayout.show(cardPanel, "패널 1"));
    }
}

