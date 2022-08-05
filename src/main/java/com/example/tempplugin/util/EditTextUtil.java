package com.example.tempplugin.util;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.editor.richcopy.settings.RichCopySettings;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * 用于编辑选中的文本
 *
 * @author Mr.YinHaijun
 */
public class EditTextUtil {

    private EditTextUtil() {
    }

    /**
     * 将选中的内容放到剪切板中
     *
     * @return 返回选中的内容
     */
    public static String getSysClipboardText() {
        String ret = "";
        Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
        //获取剪切板中的内容
        Transferable contents = sysClip.getContents(null);
        if (contents != null) {
            //检查是否是文本类型
            if (!contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return ret;
            }
            try {
                ret = (String) contents.getTransferData(DataFlavor.stringFlavor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }


    /**
     * 将剪切板的内容设为空
     *
     * @param writeText 之前剪切板存在的内容
     */
    public static void setSysClipboardText(String writeText) {
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(writeText);
        systemClipboard.setContents(stringSelection, null);
    }

    /**
     * 替换选中的文字
     *
     * @param e AnActionEvent
     */
    public static void replaceMsg(AnActionEvent e) {
        RichCopySettings settings = RichCopySettings.getInstance();
        settings.setEnabled(true);
        ActionManager.getInstance().getAction("EditorCopy").actionPerformed(e);
        settings.setEnabled(settings.isEnabled());

        String sysClipboardText = getSysClipboardText();
        Messages.showMessageDialog(sysClipboardText, "您确定要替换吗", Messages.getInformationIcon());

        String tempText = "我是要替换的文字！！！！！";

        Project project = e.getData(CommonDataKeys.PROJECT);
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        if (null == editor) {
            return;
        }
        e.getPresentation().setVisible(project != null && editor.getSelectionModel().hasSelection());
        Document document = editor.getDocument();
        SelectionModel selectionModel = editor.getSelectionModel();
        int start = selectionModel.getSelectionStart();
        int end = selectionModel.getSelectionEnd();
        Runnable runnable = () -> document.replaceString(start, end, tempText);
        WriteCommandAction.runWriteCommandAction(project, runnable);
        selectionModel.removeSelection();
        setSysClipboardText(sysClipboardText);
    }
}
