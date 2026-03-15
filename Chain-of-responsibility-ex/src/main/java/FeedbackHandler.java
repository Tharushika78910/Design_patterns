
public abstract class FeedbackHandler {
    private FeedbackHandler nextHandler;

    public FeedbackHandler setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public String handle(CustomerFeedbackMessage message) {
        if (canHandle(message)) {
            return process(message);
        }

        if (nextHandler != null) {
            return nextHandler.handle(message);
        }

        return "No handler found for message from " + message.getSenderEmail();
    }

    protected abstract boolean canHandle(CustomerFeedbackMessage message);

    protected abstract String process(CustomerFeedbackMessage message);
}