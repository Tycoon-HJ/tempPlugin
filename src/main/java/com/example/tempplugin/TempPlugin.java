package com.example.tempplugin;


import com.example.tempplugin.util.PlayMusic;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.EditorEventListener;
import org.jetbrains.annotations.NotNull;

/**
 * @author Mr.YinHaijun
 */
public class TempPlugin extends AnAction {
    private static final Logger logger = Logger.getInstance(TempPlugin.class);

    @Override
    public void actionPerformed(AnActionEvent e) {


        Editor editor = e.getData(CommonDataKeys.EDITOR);
        Document document = editor.getDocument();

        document.addDocumentListener(new EditorEventListener() {
            @Override
            public void beforeDocumentChange(@NotNull DocumentEvent event) {
                EditorEventListener.super.beforeDocumentChange(event);
                logger.info("开始播放音乐了！");

                //打包插件之前采用相对路径，才可以访问静态资源
//                PlayMusic.playMusic("/static/1.mp3");

                //在本地测试的话，还是推荐绝对路径
                new Thread(() -> PlayMusic.playMusic("/Users/Mr.YinHaijun/IdeaProjects/tempPlugin/tempPlugin/src/main/resources/static/1.mp3")).start();

                logger.info("播放完毕了！");
            }
        });
//
//        //消息通知类，用于提示一些错误，或者警告
//        Notification notification = new Notification(StaticString.GROUP_ID, StaticString.CONTENT, NotificationType.INFORMATION);
//        Notifications.Bus.notify(notification);
//
//        // 这个是可以弹出一个提示框
//        Messages.showMessageDialog("内容", "标题", Messages.getInformationIcon());
//
//        // 这种日志无法在控制台查看，只能在idea.log里找到
//        logger.info("添加一些信息，这里是日志打印！！！！！");
//        EditTextUtil.replaceMsg(e);


//        Dialog myDialog = new Dialog();
//        // 出现一个窗口
//        myDialog.show();
        // exitCode ----- 0:代表点的是OK   1：代表的是点击取消，或者关闭窗口
//        int exitCode = myDialog.getExitCode();


    }
}
