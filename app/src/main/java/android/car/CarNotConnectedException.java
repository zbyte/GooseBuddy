package android.car;

public class CarNotConnectedException extends Exception {
    private static final long serialVersionUID = 0xB1E126C33C076709L;

    public CarNotConnectedException() {
    }

    public CarNotConnectedException(Exception cause) {
        super(cause);
    }

    public CarNotConnectedException(String name) {
        super(name);
    }

    public CarNotConnectedException(String name, Throwable cause) {
        super(name, cause);
    }
}

