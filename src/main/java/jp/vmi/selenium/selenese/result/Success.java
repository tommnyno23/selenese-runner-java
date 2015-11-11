package jp.vmi.selenium.selenese.result;

/**
 * Result of success.
 */
public class Success extends Result {

    /** Default success */
    public static final Success SUCCESS = new Success("Success");

    /**
     * Constructor.
     *
     * @param message success message.
     */
    public Success(String message) {
        super(message);
    }

    @Override
    public Level getLevel() {
        return Level.SUCCESS;
    }
}
