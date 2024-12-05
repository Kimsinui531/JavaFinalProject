package ui;

import cominformation.Information310;
import cominformation.Information408;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        setTitle("자리 안내 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);

        // 카드 레이아웃 생성
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // 정보 객체 생성
        Information310 info310 = new Information310();
        Information408 info408 = new Information408();

        // 패널 추가
        cardPanel.add(createPanel1(cardLayout, cardPanel, info310), "패널 1");
        cardPanel.add(createPanel2(cardLayout, cardPanel, info408), "패널 2");

        // 메인 패널에 카드 패널 추가
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(cardPanel, BorderLayout.CENTER); // 카드 패널을 중앙에 추가

        // 프레임에 메인 패널 추가
        add(mainPanel);
        setVisible(true); // JFrame을 보여줌
        setLocationRelativeTo(null); // 화면 중앙에 위치
    }

    // 패널 1 생성 메서드
    private static JPanel createPanel1(CardLayout cardLayout, JPanel cardPanel, Information310 information) {
        JPanel panel1 = new JPanel(new GridBagLayout());
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

        // 버튼에 액션 리스너 추가
        buttonToPanel2.addActionListener(e -> cardLayout.show(cardPanel, "패널 2"));

        return panel1;
    }

    // 패널 2 생성 메서드
    private static JPanel createPanel2(CardLayout cardLayout, JPanel cardPanel, Information408 information) {
        JPanel panel2 = new JPanel(new GridBagLayout());
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
        JPanel panel2c = new SeatButtonPanel408(information); // Information310 사용하여 버튼 생성

        // GridBagConstraints 설정
        gbc.fill = GridBagConstraints.BOTH;

        // panel2a 추가 (1 비율)
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel2.add(panel2a, gbc);

        // panel2b 추가 (1 비율)
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel2.add(panel2b, gbc);

        // panel2c 추가 (8 비율)
        gbc.weightx = 8;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel2.add(panel2c, gbc);

        // 버튼에 액션 리스너 추가
        buttonToPanel1.addActionListener(e -> cardLayout.show(cardPanel, "패널 1"));
        return panel2;
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}
