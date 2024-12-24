package ui;

import cominformation.Information310;
import cominformation.Information408;

import javax.swing.*;
import java.awt.*;

/**
 * 자리 안내 프로그램의 메인 프레임을 관리하는 클래스입니다.
 *
 * 이 클래스는 카드 레이아웃을 사용하여 다양한 패널 간의 전환을 처리합니다.
 * 사용자는 2개의 강의실에 특정 컴퓨터에 대한 정보를 확인할 수 있습니다.
 *
 * @author KIM SIN UI
 * @version 1.0
 * @date 2024-12-23
 *
 * @changelog
 * <ul>
 *   <li>2024-12-05: 최초 생성 (KIM SIN UI)</li>
 *   <li>2024-12-05: 초기 프레임 구성 및 06-310 스크린 화면 추가 (KIM SIN UI)</li>
 *   <li>2024-12-05: 카드 레이아웃 추가 및 패널 전환 기능 구현 (KIM SIN UI)</li>
 *   <li>2024-12-05: Information310 클래스를 추가하여 컴퓨터 정보를 로드 (KIM SIN UI)</li>
 *   <li>2024-12-05: 버튼 클릭시 프로그램 정보 표시 기능 추가 (KIM SIN UI)</li>
 *   <li>2024-12-05: 패널 2 생성 메소드에서 버튼을 SeatButtonPanel408에서 만들 수 있도록 수정 (KIM SIN UI)</li>
 *   <li>2024-12-05: 사이드바 패널 생성 (KIM SIN UI)</li>
 *   <li>2024-12-05: Frame 클래스의 패널 클래스 분리 (KIM SIN UI)</li>
 *   <li>2024-12-05: createCardPanel과 createSideBarPanel 메서드를 추가하여 패널 생성 로직을 분리 (KIM SIN UI)</li>
 *   <li>2024-12-08: HomePanel 생성 및 카드 패널에 추가 (KIM SIN UI)</li>
 *   <li>2024-12-09: 프레임 구조 개선 및 카드 레이아웃 통합 (KIM SIN UI)</li>
 *   <li>2024-12-23: 일부 코드 개선 (KIM SIN UI)</li>
 *   <li>2024-12-23: 이미지 아이콘 지정한 이미지로 수정 (KIM SIN UI)</li>
 * </ul>
 */

public class Frame extends JFrame {

    private JPanel cardPanel; // 카드 패널을 클래스 필드로 선언

    /**
     * Frame 클래스의 생성자입니다.
     * 프레임의 기본 설정을 초기화하고 패널을 구성합니다.
     * 아이콘을 설정하고, 기본 제목 및 크기를 지정합니다.
     * 외부 카드 레이아웃 패널과 이너 카드 패널을 생성합니다.
     */
    public Frame() {
        // 아이콘 추가
        setIconImage(Toolkit.getDefaultToolkit().getImage("resources/images/imageicon.png")); // 아이콘 경로 지정
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

    /**
     * 이너 카드 패널을 생성합니다.
     *
     * @return 생성된 이너 카드 패널
     */
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

    /**
     * 사이드바 패널을 생성합니다.
     *
     * @return 생성된 사이드바 패널
     */
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
                    System.exit(0);
                    break;
            }
        });
    }

    /**
     * 프로그램의 메인 메서드입니다.
     *
     * @param args 실행 시 전달된 인수
     */
    public static void main(String[] args) {
        new Frame();
    }
}
