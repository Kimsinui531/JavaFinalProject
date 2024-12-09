package ui;

import cominformation.Information310;
import cominformation.Information408;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private JPanel cardPanel; // cardPanel을 클래스 필드로 선언

    public Frame() {
        setTitle("자리 안내 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);

        // 외부 카드 레이아웃 패널 생성
        CardLayout outerCardLayout = new CardLayout();
        JPanel outerCardPanel = new JPanel(outerCardLayout);

        // 이너 카드 패널 생성
        JPanel innerCardPanel = createInnerCardPanel();

        // 홈 패널 생성
        HomePanel homePanel = new HomePanel(e -> {
            // 버튼 클릭 시 외부 카드 패널에서 이너 카드 패널로 이동
            outerCardLayout.show(outerCardPanel, "이너 카드 패널");
            CardLayout innerCardLayout = (CardLayout) cardPanel.getLayout(); // cardPanel의 레이아웃 가져오기
            innerCardLayout.show(cardPanel, "패널 1"); // 패널 1로 전환
        });

        // 외부 카드 패널에 패널 추가
        outerCardPanel.add(homePanel, "홈 패널"); // 홈 패널 추가
        outerCardPanel.add(innerCardPanel, "이너 카드 패널"); // 이너 카드 패널 추가

        // 메인 패널에 외부 카드 패널 추가
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(outerCardPanel, BorderLayout.CENTER); // 외부 카드 패널을 메인 패널에 추가

        // 프레임에 메인 패널 추가
        add(mainPanel);
        setVisible(true);
    }

    private JPanel createInnerCardPanel() {
        // 이너 카드 레이아웃을 설정합니다.
        CardLayout innerCardLayout = new CardLayout();
        JPanel innerCardPanel = new JPanel(new BorderLayout()); // BorderLayout으로 설정

        // 사이드바 패널 생성
        SideBarPanel sidebar = createSideBarPanel(); // 사이드바 생성

        // 카드 패널을 위한 CardLayout 설정
        cardPanel = new JPanel(innerCardLayout); // cardPanel을 클래스 필드로 선언하여 사용

        Information310 info310 = new Information310();
        Information408 info408 = new Information408();

        // 다른 패널 추가
        cardPanel.add(new CreatePanel310(innerCardLayout, cardPanel, info310), "패널 1");
        cardPanel.add(new CreatePanel408(innerCardLayout, cardPanel, info408), "패널 2");

        // 기본 패널 설정: 패널 1을 첫 번째로 보여줌
        innerCardLayout.show(cardPanel, "패널 1");

        // 사이드바와 카드 패널을 이너 패널에 추가
        innerCardPanel.add(sidebar, BorderLayout.WEST); // 사이드바를 왼쪽에 추가
        innerCardPanel.add(cardPanel, BorderLayout.CENTER); // 카드 패널을 중앙에 추가

        return innerCardPanel;
    }

    private SideBarPanel createSideBarPanel() {
        return new SideBarPanel(e -> {
            JButton source = (JButton) e.getSource();
            // 카드 전환을 위해 cardPanel을 사용
            CardLayout innerCardLayout = (CardLayout) cardPanel.getLayout(); // cardPanel의 레이아웃 가져오기
            switch (source.getText()) {
                case "06-310":
                    innerCardLayout.show(cardPanel, "패널 1");
                    break;
                case "06-408":
                    innerCardLayout.show(cardPanel, "패널 2");
                    break;
                case "나가기":

                    break;
            }
        });
    }

    public static void main(String[] args) {
        new Frame();
    }
}
