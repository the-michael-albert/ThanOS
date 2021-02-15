package com.company;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {
    public static int w;
    public static int h;

    public static WelcomeWindow welcomeWindow;


    public static void main(String[] args) throws IOException {
        Terminal term = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(term);
        h = term.getTerminalSize().getRows();
        w = term.getTerminalSize().getColumns();


        WindowBasedTextGUI gui = new MultiWindowTextGUI(screen);
        screen.startScreen();


        welcomeWindow = new WelcomeWindow();
        gui.addWindow(welcomeWindow);

        welcomeWindow.waitUntilClosed();
        screen.stopScreen();
    }
}

