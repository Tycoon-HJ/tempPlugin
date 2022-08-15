package com.example.tempplugin.config;


import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import org.jetbrains.annotations.NotNull;

/**
 * idea打开的时候配置
 * 使用StartupActivity 代替 ApplicationComponent
 *
 * @author Mr.YinHaijun
 */
public class ProjectStartConfig implements StartupActivity {

    @Override
    public void runActivity(@NotNull Project project) {

        // 当项目打开的时候会自动弹出一个毒鸡汤的窗口
        // new Dialog().show();
    }
}
