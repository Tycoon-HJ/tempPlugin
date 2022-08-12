package com.example.tempplugin.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

/**
 * @author Mr.YinHaijun
 */
public class TempPluginUI {
    private JPanel panel1;
    private JButton button2;
    private JButton button1;
    private JScrollPane jScrollPane;
    private JTable table1;


    public void init() {

        table1.setModel(TempData.DEFAULT_TABLE_MODEL);
        table1.setVisible(true);

    }

    public TempPluginUI(Project project, ToolWindow toolWindow) {
        init();
        button1.addActionListener(e -> new Dialog().show());
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
