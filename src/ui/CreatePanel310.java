package ui;

import cominformation.Information310;

import javax.swing.*;
import java.awt.*;

/**
 * 패널 1 UI 구성 로직을 캡슐화한 클래스입니다.
 *
 * 이 클래스는 강의실 06-310에 대한 정보를 표시하는 패널을 구성합니다.
 * 상단에는 강의실 이름, 중간에는 스크린 정보를, 하단에는 좌석 버튼 패널이 포함됩니다.
 *
 * @author KIM SIN UI
 * @version 1.0
 * @since 2024-12-05
 *
 * @changelog
 * <ul>
 *   <li>2024-12-05: 최초 생성 (KIM SIN UI)</li>
 *   <li>2024-12-05: Frame클래스의 패널 1 UI 구성 로직을 CreatePanel310 클래스로 캡슐화 (KIM SIN UI)</li>
 *   <li>2024-12-05: 상단 버튼 '06-408로 이동' 추가 및 클릭 시 패널 2로 전환하는 액션 리스너 설정 (KIM SIN UI)</li>
 *   <li>2024-12-05: 중간 레이블 '06-310 스크린' 추가 및 스타일 설정 (KIM SIN UI)</li>
 *   <li>2024-12-05: 하단 버튼 영역을 SeatButtonPanel310 클래스를 사용하여 구성 (KIM SIN UI)</li>
 *   <li>2024-12-05: GridBagLayout을 사용하여 패널 내부 구성 요소 배치 (KIM SIN UI)</li>
 *   <li>2024-12-06: panel1a의 상단 버튼 제거 및 액션 리스너 버튼 제거 </li>
 *   <li>2024-12-06: 새로운 라벨 추가 및 배경 색상 지정</li>
 * </ul>
 */

public class CreatePanel310 extends JPanel {

    /**
     * CreatePanel310 클래스의 생성자입니다.
     *
     * @param cardLayout 카드 레이아웃 객체로, 패널 전환에 사용됩니다.
     * @param cardPanel 카드 패널 객체로, 다른 패널과의 전환을 관리합니다.
     * @param information 강의실 06-310에 대한 정보를 포함하는 Information310 객체입니다.
     */
    public CreatePanel310(CardLayout cardLayout, JPanel cardPanel, Information310 information) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 패널 1a (상단 패널)
        JPanel panel1a = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("강의실:06-310호");
        label1.setForeground(Color.white);
        panel1a.setBackground(new Color(34, 113, 203));
        panel1a.add(label1);

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
    }
}
