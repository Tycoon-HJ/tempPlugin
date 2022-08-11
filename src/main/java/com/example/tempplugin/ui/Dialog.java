package com.example.tempplugin.ui;


import com.example.tempplugin.dto.DataInDto;
import com.example.tempplugin.dto.MessageInDto;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * 当前类，用于显示一个对话框
 *
 * @author Mr.YinHaijun
 */
public class Dialog extends DialogWrapper {
    private static final Logger logger = Logger.getInstance(Dialog.class);

    public Dialog() {
        super(true);
        // 这个是窗口的标题
        setTitle("Test DialogWrapper");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {

        // 从网站上动态获取数据，使得每次更新都会加载新的数据
        RestTemplate restTemplate = new RestTemplate();
        MessageInDto messageInDto = new MessageInDto();
        ResponseEntity<MessageInDto> forEntity = restTemplate.getForEntity("https://api.nextrt.com/V1/Dutang", MessageInDto.class);
        if (ObjectUtils.isEmpty(forEntity)) {
            return null;
        }
        HttpStatus httpStatus = forEntity.getStatusCode();
        if (httpStatus.is2xxSuccessful()) {
            messageInDto = forEntity.getBody();
        }
        if (ObjectUtils.isEmpty(messageInDto)) {
            messageInDto = new MessageInDto();
            DataInDto dataInDto = new DataInDto();
            dataInDto.setContent("没有联网，暂时获取不到数据");
            messageInDto.setData(Arrays.asList(dataInDto));
        }


        //创建一个画板
        JPanel dialogPanel = new JPanel(new BorderLayout());

        // 这个里面存放要显示的内容
        JLabel label = new JLabel(messageInDto.getData().get(0).getContent());

        //设置窗口的大小
        label.setPreferredSize(new Dimension(600, 400));

        //将label放在这个画板上
        dialogPanel.add(label, BorderLayout.SOUTH);

        JButton jButton = new JButton();
        jButton.setText("没事可以点一下这里");


        jButton.addActionListener(actionEven -> {
            // fix 修改死循环导致内存溢出的问题
            if (new Dialog().showAndGet()) {
                logger.info("点击就会出现问题的");
            } else {
                logger.error("上面没走");
            }
        });
        dialogPanel.add(jButton);
        return dialogPanel;
    }
}
