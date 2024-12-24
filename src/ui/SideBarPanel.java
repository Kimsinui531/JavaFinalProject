package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * {@code SideBarPanel} 클래스의 생성자입니다.
 * <p>
 * 이 생성자는 사이드바의 레이아웃과 디자인을 초기화하며, 버튼 클릭 시 발생하는
 * 이벤트를 처리하기 위해 {@link ActionListener} 객체를 사용합니다.
 * </p>
 *
 * @param ac 각 버튼 클릭 시 이벤트를 처리할 {@link ActionListener} 객체
 *
 * @author KIM SIN UI
 * @version 1.0
 * @since 2024-12-05
 *
 * @changelog
 * <ul>
 *   <li>2024-12-05: 최초 생성 (KIM SIN UI)</li>
 *   <li>2024-12-05: 사이드바 패널 기본 구조 추가 (KIM SIN UI)</li>
 *   <li>2024-12-05: 사이드바 항목 및 버튼 추가(KIM SIN UI)</li>
 *   <li>2024-12-05: 버튼 크기 조정 및 액션 리스너 추가(KIM SIN UI)</li>
 *   <li>2024-12-05: 사이드 바에 버튼 추가 및 사이드바 패널 크기 설정 (KIM SIN UI)</li>
 *   <li>2024-12-24: 일부 코드 수정 및 자바독 추가 (KIM SIN UI)</li>
 * </ul>
 */
public class SideBarPanel extends JPanel {

    /**
     * {@code SideBarPanel} 클래스의 생성자입니다.
     * <p>
     * 이 생성자는 사이드바의 레이아웃과 디자인을 초기화하며, 버튼 클릭 시 발생하는
     * 이벤트를 처리하기 위해 {@link ActionListener} 객체를 사용합니다.
     * </p>
     *
     * @param ac 각 버튼 클릭 시 이벤트를 처리할 {@link ActionListener} 객체
     */
    public SideBarPanel(ActionListener ac) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // 세로 방향으로 구성
        setBackground(new Color(245, 245, 245)); // 배경색 설정

        // 사이드바 항목 추가
        JLabel menu = new JLabel("     Menu");
        menu.setOpaque(true);
        menu.setBackground(new Color(45, 75, 122)); // 배경색 설정
        menu.setForeground(Color.WHITE); // 글자색 설정
        menu.setPreferredSize(new Dimension(70, 40)); // JLabel 크기 설정

        JButton move310Button = new JButton("06-310");
        move310Button.setBackground(new Color(26, 99, 177));
        move310Button.setForeground(Color.white);

        JButton move408Button = new JButton("06-408");
        move408Button.setBackground(new Color(26, 99, 177));
        move408Button.setForeground(Color.white);

        JButton logoutButton = new JButton("나가기");
        logoutButton.setBackground(new Color(252, 75, 108));
        logoutButton.setForeground(Color.white);

        // 버튼 크기 조정
        menu.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        move310Button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        move408Button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        logoutButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        // 버튼에 액션 리스너 추가
        move310Button.addActionListener(ac);
        move408Button.addActionListener(ac);
        logoutButton.addActionListener(ac);

        // 사이드바에 버튼 추가
        add(menu);
        add(move310Button);
        add(move408Button);
        add(logoutButton);

        // 사이드바 패널의 크기 조정
        setPreferredSize(new Dimension(70, Integer.MAX_VALUE)); // 사이드바의 너비 설정
    }
}
