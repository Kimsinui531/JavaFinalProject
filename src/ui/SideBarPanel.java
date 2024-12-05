package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SideBarPanel extends JPanel {
    public SideBarPanel(ActionListener ac) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // 세로 방향으로 구성
        setBackground(new Color(245, 245, 245)); // 배경색 설정

        // 사이드바 항목 추가
        JLabel home = new JLabel("     Home");
        home.setOpaque(true);
        home.setBackground(new Color(45, 75, 122)); // 배경색 설정
        home.setForeground(Color.WHITE); // 글자색 설정
        home.setPreferredSize(new Dimension(70, 40)); // JLabel 크기 설정

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
        home.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        move310Button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        move408Button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        logoutButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        // 버튼에 액션 리스너 추가
        move310Button.addActionListener(ac);
        move408Button.addActionListener(ac);
        logoutButton.addActionListener(ac);

        // 사이드바에 버튼 추가
        add(home);
        add(move310Button);
        add(move408Button);
        add(logoutButton);

        // 사이드바 패널의 크기 조정
        setPreferredSize(new Dimension(70 , Integer.MAX_VALUE)); // 사이드바의 너비 설정
    }
}
