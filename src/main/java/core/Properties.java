package core;

import static core.Properties.Browsers.CHROME;

public class Properties {
    public static boolean FECHAR_BROWSER = false;

    public static Browsers browser = CHROME;

    public enum Browsers {
        CHROME,
        EDGE
    }
}
