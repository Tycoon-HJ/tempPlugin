package com.example.tempplugin.factory;

import com.example.tempplugin.ui.TempPluginUI;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author Mr.YinHaijun
 */
public class TempPluginWindowsFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        TempPluginUI tempPluginUI = new TempPluginUI(project, toolWindow);
        ContentFactory contentFactory = ContentFactory.getInstance();
        Content content = contentFactory.createContent(tempPluginUI.getPanel1(), "", false);
        toolWindow.getContentManager().addContent(content);
    }
}