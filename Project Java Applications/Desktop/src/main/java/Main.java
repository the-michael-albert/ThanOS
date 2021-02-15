import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Terminal term = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(term);
        WindowBasedTextGUI gui = new MultiWindowTextGUI(screen);
        screen.startScreen();


        MyWindow myWindow = new MyWindow();
        gui.addWindow(myWindow);

        myWindow.waitUntilClosed();
        screen.stopScreen();
    }
}
