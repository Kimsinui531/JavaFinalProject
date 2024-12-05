package ui;
//패널 1 UI 구성 로직을 CreatePanel310 클래스로 캡슐화한 클래스
import cominformation.Information310;

import javax.swing.*;
import java.awt.*;

public class CreatePanel310 extends JPanel {
    public CreatePanel310(CardLayout cardLayout, JPanel cardPanel, Information310 information) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 패널 1a (상단 버튼)
        JPanel panel1a = new JPanel(new FlowLayout());
        JButton buttonToPanel2 = new JButton("06-408로 이동");
        panel1a.add(buttonToPanel2);

        // 패널 1b (중간 레이블)
        JPanel panel1b = new JPanel(new FlowLayout());
        JLabel screen310 = new JLabel("                   06-310 스크린                ");
        screen310.setOpaque(true);
        screen310.setBackground(new Color(51, 153, 255));
        screen310.setForeground(Color.WHITE);
        panel1b.add(screen310);

        // 패널 1c (하단 버튼들)
        JPanel panel1c = new SeatButtonPanel310(information); // Information310 사용하여 버튼 생성

        // GridBagConstraints 설정
        gbc.fill = GridBagConstraints.BOTH;

        // panel1a 추가 (1 비율)
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(panel1a, gbc);

        // panel1b 추가 (1 비율)
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(panel1b, gbc);

        // panel1c 추가 (8 비율)
        gbc.weightx = 8;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(panel1c, gbc);

        // 버튼에 액션 리스너 추가
        buttonToPanel2.addActionListener(e -> cardLayout.show(cardPanel, "패널 2"));
    }
}
