package controller;

import bench.IBenchmark;
import bench.cpu.CPUDigitsOfPI;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class AppMainController {

    @FXML
    public TextField nrOfDigits;
    public Text warmup;
    public Text time;

    public void warmup()
    {
        for (int i = 1; i <= 10000; i++) {
            for (int j = 1; j <= 10000; j++) {
                CPUDigitsOfPI test = new CPUDigitsOfPI();
                ConsoleLogger test2 = new ConsoleLogger();
                Timer test3 = new Timer();
            }

        }
        warmup.setText("Warm-Up done! Let's GO!");
    }

    public void getDigitsOfPi(){

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
    }
}