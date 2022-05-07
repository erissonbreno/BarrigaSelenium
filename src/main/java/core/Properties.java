package core;

import static core.Properties.Browsers.CHROME;

public class Properties {
    public static boolean FECHAR_BROWSER = false;

    public static Browsers BROWSER = CHROME;

    public static executionType EXECUTION_TYPE = executionType.LOCAL;

    public enum Browsers {
        CHROME,
        EDGE
    }

    public enum executionType {
        LOCAL,
        GRID,
        CLOUD
    }
}
