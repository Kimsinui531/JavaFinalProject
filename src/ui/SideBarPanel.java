package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SideBarPanel extends JPanel {
    public SideBarPanel(ActionListener ac) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // 세로 방향으로 구성
        setBackground(new Color(245, 245, 245)); // 배경색 설정
    }
}
