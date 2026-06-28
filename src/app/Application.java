package app;

import menu.MainMenu;

public class Application {

    private final MainMenu mainMenu;

    public Application() {

        mainMenu = new MainMenu();

    }

    public void start() {

        mainMenu.show();

    }

}