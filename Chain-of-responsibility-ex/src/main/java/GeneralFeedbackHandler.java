
public class GeneralFeedbackHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(CustomerFeedbackMessage message) {
        return message.getMessageType() == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected String process(CustomerFeedbackMessage message) {
        return "General feedback from " + message.getSenderEmail()
                + " has been analyzed and a thank-you response has been sent.";
    }
}