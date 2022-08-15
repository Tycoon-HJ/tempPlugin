package com.example.tempplugin.ui;

import com.example.tempplugin.util.StaticString;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.options.BaseConfigurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 创建一个开启和关闭音效的设置窗口
 *
 * @author Mr.YinHaijun
 */
public class MusicControllerUi extends BaseConfigurable implements SearchableConfigurable, PersistentStateComponent<MusicControllerUi> {
    private JButton startButton;
    private JButton stopButton;
    private JPanel Jpanel;
    private JButton uploadFileButton;


    public MusicControllerUi() {

        uploadFileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO 先简单的写一个文件上传的组件，后续优化
                eventOnImport(new JButton());
            }
        });

        startButton.addActionListener(e -> {
            StaticString.IS_START_PLAY_MUSIC = true;
            Messages.showMessageDialog("已开启音效", "音效控制器", Messages.getInformationIcon());
        });
        stopButton.addActionListener(e -> {
            StaticString.IS_START_PLAY_MUSIC = false;
            Messages.showMessageDialog("已关闭音效", "音效控制器", Messages.getInformationIcon());
        });
    }

    @Override
    public @Nullable MusicControllerUi getState() {
        return null;
    }

    @Override
    public void loadState(@NotNull MusicControllerUi state) {

    }

    @Override
    public @NotNull @NonNls String getId() {
        return "tempPluginId";
    }

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Play Music";
    }

    @Override
    public @Nullable JComponent createComponent() {
        return Jpanel;
    }

    @Override
    public void apply() throws ConfigurationException {

    }

    /**
     * 文件上传功能
     *
     * @param developer 按钮控件名称
     */
    public static void eventOnImport(JButton developer) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        // 过滤文件类型
        FileNameExtensionFilter filter = new FileNameExtensionFilter("mp3", "mp3");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showDialog(developer, "确定");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // 得到选择的文件
            File selectedFile = chooser.getSelectedFile();
            if (selectedFile == null) {
                Messages.showMessageDialog(StaticString.FAIL_MESSAGE, StaticString.TITLE_MESSAGE, Messages.getWarningIcon());
                return;
            }

            // 将文件上传到插件的位置
            try (FileInputStream input = new FileInputStream(selectedFile);
                 FileOutputStream out = new FileOutputStream(StaticString.UPLOAD_MUSIC_PATH)) {
                byte[] buffer = new byte[1024];
                input.read(buffer);
                while (-1 != input.read(buffer)) {
                    out.write(buffer);
                }
                Messages.showMessageDialog(StaticString.SUCCESS_MESSAGE, StaticString.TITLE_MESSAGE, Messages.getInformationIcon());
            } catch (Exception e) {
                Messages.showMessageDialog(StaticString.FAIL_MESSAGE + e, StaticString.TITLE_MESSAGE, Messages.getErrorIcon());
            }
        }
    }
}

