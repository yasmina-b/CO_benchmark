package controller;

import bench.IBenchmark;
import bench.cpu.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.Duration;

public class AppMainController {

    @FXML
    public TextField nrOfDigits;

    @FXML
    public Text warmup;

    @FXML
    public Text time;

    @FXML
    public Text time2;

    @FXML
    public Label stringErrorLabel;

    @FXML
    public Label piLabel;


    public void warmup() throws InterruptedException {
        for (int i = 1; i <= 10000; i++) {
            for (int j = 1; j <= 10000; j++) {
                CPUDigitsOfPI test = new CPUDigitsOfPI();
                ConsoleLogger test2 = new ConsoleLogger();
                Timer test3 = new Timer();
            }
        }

        warmup.setText("Warm-Up done! Let's GO!");

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


    @FXML
    public void getDigitsOfPi() throws InterruptedException {

        if(isNumeric(nrOfDigits.getText())){

            stringErrorLabel.setText("");

            warmup();

            ITimer timer = new Timer();
            ILog log = new ConsoleLogger();
            int n = Integer.parseInt(nrOfDigits.getText());
            TimeUnit timeUnit = TimeUnit.Nano;
            IBenchmark bench = new CPUDigitsOfPI();

            bench.intialize(n);

            for (int i = 0; i < 1; i++)
            {
                timer.start();
                bench.run();
                time.setText(log.writeTime(timer.stop(), timeUnit));
            }
            log.close();
            piLabel.setText(CPUDigitsOfPI.pi_aux.toString());

        }
        else{

            stringErrorLabel.setText("PLEASE ENTER A NUMBER BRUV!!!!");
            stringErrorLabel.setStyle("-fx-font-size: 23");
        }

    }
    @FXML
    public void getDigitsOfPi2() throws InterruptedException {

        if(isNumeric(nrOfDigits.getText())){
            stringErrorLabel.setText("");

            warmup();
            warmup.setText("");

            ITimer timer = new Timer();
            ILog log = new ConsoleLogger();
            int n = Integer.parseInt(nrOfDigits.getText());
            TimeUnit timeUnit = TimeUnit.Nano;
            IBenchmark bench = new ArctanMethod(n);

            bench.intialize(n);
            for (int i = 0; i < 1; i++)
            {
                timer.start();
                bench.run(n);
                piLabel.setText(ArctanMethod.piF.toString());
                time.setText(log.writeTime(timer.stop(), timeUnit));
            }
            log.close();
        }
        else{

            stringErrorLabel.setText("PLEASE ENTER A NUMBER BRUV!!!!");
            stringErrorLabel.setStyle("-fx-font-size: 23");
        }

    }

    @FXML
    public void getDigitsOfPi3() throws InterruptedException {

        if(isNumeric(nrOfDigits.getText())){

            stringErrorLabel.setText("");

            warmup();
            warmup.setText("");

            ITimer timer = new Timer();
            ILog log = new ConsoleLogger();
            int n = Integer.parseInt(nrOfDigits.getText());
            TimeUnit timeUnit = TimeUnit.Nano;
            IBenchmark bench = new PiSpigot(n);

            bench.intialize(n);
            for (int i = 0; i < 1; i++)
            {
                timer.start();
                bench.run();
                time.setText(log.writeTime(timer.stop(), timeUnit));
                piLabel.setText(PiSpigot.predigits.toString());
                PiSpigot.predigits.setLength(0);
            }
            log.close();

        }
        else{

            stringErrorLabel.setText("PLEASE ENTER A NUMBER BRUV!!!!");
            stringErrorLabel.setStyle("-fx-font-size: 23");
        }

    }
    @FXML
    public void getPrime() throws InterruptedException {

        if(isNumeric(nrOfDigits.getText())){

            stringErrorLabel.setText("");

            warmup();
            warmup.setText("");

            ITimer timer = new Timer();
            ILog log = new ConsoleLogger();
            int n = Integer.parseInt(nrOfDigits.getText());
            TimeUnit timeUnit = TimeUnit.Nano;
            IBenchmark bench = new CPUPrimeNumbers();

            bench.intialize(n);
            for (int i = 0; i < 1; i++)
            {
                timer.start();
                bench.run(n);
                //System.out.println(CPUPrimeNumbers.result);
                piLabel.setText(CPUPrimeNumbers.result);
                time.setText(log.writeTime(timer.stop(), timeUnit));
            }
            log.close();
        }
        else{

            stringErrorLabel.setText("PLEASE ENTER A NUMBER BRUV!!!!");
            stringErrorLabel.setStyle("-fx-font-size: 23");
        }

    }
}