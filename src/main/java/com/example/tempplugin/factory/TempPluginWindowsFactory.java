package com.example.tempplugin.factory;

import com.example.tempplugin.ui.TempPluginUI;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * 这里是为了新增一个窗口工具
 * @author Mr.YinHaijun
 */
public class TempPluginWindowsFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        TempPluginUI tempPluginUi = new TempPluginUI(project, toolWindow);
        ContentFactory contentFactory = ContentFactory.getInstance();
        Content content = contentFactory.createContent(tempPluginUi.getPanel1(), "", false);
        toolWindow.getContentManager().addContent(content);
    }
}