package com.example.tempplugin.ui;

import javax.swing.table.DefaultTableModel;

/**
 * @author Mr.YinHaijun
 */
public class TempData {

    /**
     * 创建一个表头
     */
    public static String[] HEADER = {"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"};

    /**
     * 创建死数据便于演示
     */
    public static Object[][] TABLE_DATA = {
            {"Kathy", "Smith", "Snowboarding", 5, false},
            {"John", "Doe", "Rowing", 3, true},
            {"Sue", "Black", "Knitting", 2, false},
            {"Jane", "White", "Speed reading", 20, true},
            {"Joe", "Brown", "Pool", 10, false}};

    public static DefaultTableModel DEFAULT_TABLE_MODEL = new DefaultTableModel(TABLE_DATA, HEADER);

}