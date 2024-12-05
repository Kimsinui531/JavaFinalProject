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
        cardPanel.add(new CreatePanel310(cardLayout, cardPanel, info310), "패널 1");
        cardPanel.add(new CreatePanel408(cardLayout, cardPanel, info408), "패널 2");

        // 사이드바 패널 생성
        SideBarPanel sidebar = new SideBarPanel(e -> {
            JButton source = (JButton) e.getSource();
            switch (source.getText()) {
                case "06-310":
                    cardLayout.show(cardPanel, "패널 1");
                    break;
                case "06-408":
                    cardLayout.show(cardPanel, "패널 2");
                    break;
                case "나가기":
                    System.exit(0);
                    break;
            }
        });

        // 메인 패널에 카드 패널 및 사이드 패널 추가
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(cardPanel, BorderLayout.CENTER);

        // 프레임에 메인 패널 추가
        add(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new Frame();
    }
}

