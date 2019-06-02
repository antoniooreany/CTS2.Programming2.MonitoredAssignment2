package com.cts2.programming2.assignment2.barChartExamples.barChartExample1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    @FXML
    public BarChart<String,Number> barchart;


    @FXML
    RadioButton redbutton=new RadioButton("Red");

    @FXML
    RadioButton bluebutton=new RadioButton("Blue");


    @FXML
    ToggleGroup group=new ToggleGroup();
    public void selam(ActionEvent a){

        //Array to store number of occurrences of each letter in file
        //Ex = if exist 2 "a" and 4 "d" then counter[0]=2  and counter[3]=4
        int[] counter = new int[26];


        //Read file
        try {
            File file = new File("C:/new1.txt");
            Scanner scanner = new Scanner(file,"utf-8");
            while (scanner.hasNext()) {
                char[] chars = scanner.nextLine().toLowerCase().toCharArray();

                for (Character karakter : chars) {
                    if(Character.isLetter(karakter)) {
                        //add to array
                        counter[karakter - 'a']++;
                    }
                }
            }
        } catch (FileNotFoundException e) {

            System.out.println("File does not exist");

        }

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int orderofletter=0;
        XYChart.Series series1 = new XYChart.Series();
        //Add number of occurrences of each letter to XY chart
        for (char c:alphabet){
            series1.getData().add(new XYChart.Data(String.valueOf(c), counter[orderofletter]));
            orderofletter++;
        }


        // CHANGE COLOR
        if(redbutton.isSelected()){
            barchart.setStyle("-fx-bar-fill: red;");
            System.out.println("Red");
        }

        if(bluebutton.isSelected()){
            barchart.setStyle("-fx-bar-fill: blue;");
        }
        //Add xychart to barchart
        barchart.getData().addAll(series1);
    }
}
