package com.company;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WelcomeWindow extends BasicWindow {
    Panel horizontalPanel = new Panel();

    public WelcomeWindow() {
        super("Welcome");
        super.setFixedSize(new TerminalSize(Main.w - 5, Main.h - 5));

        init();
    }

    public void init(){
        horizontalPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
        Panel leftPanel = new Panel();


        horizontalPanel.addComponent(leftPanel);
        leftPanel.addComponent(new Label(""));
        leftPanel.addComponent(new Label("Welcome to Than-OS!"));

        TextBox command = new TextBox("Which stone do you want to use?");

        Label commandOutput = new Label("");

        leftPanel.addComponent(command);


        leftPanel.addComponent(new Button("Enter", new Runnable() {
            @Override
            public void run() {
                String cmd = command.getText();
                switch ((cmd).toLowerCase()) {
                    case "time":
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        commandOutput.setText(formatter.format(new Date()));
                        break;
                    case "exit":
                        Main.welcomeWindow.close();
                        break;

                }

            }
        }));
        leftPanel.addComponent(new Label(""));
        leftPanel.addComponent(new Label(""));
        leftPanel.addComponent(commandOutput);



        // This ultimately links in the panels as the window content
        setComponent(horizontalPanel);
    }
}