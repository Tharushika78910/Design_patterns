
public class ContactRequestHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(CustomerFeedbackMessage message) {
        return message.getMessageType() == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected String process(CustomerFeedbackMessage message) {
        return "Contact request from " + message.getSenderEmail()
                + " has been forwarded to customer service.";
    }
}