
public abstract class PrinterDecorator implements Printer {

    protected final Printer wrapped;

    protected PrinterDecorator(Printer wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void print(String message) {
        wrapped.print(message);
    }
}
