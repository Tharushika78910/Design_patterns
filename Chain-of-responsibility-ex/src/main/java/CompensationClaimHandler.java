
public class CompensationClaimHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(CustomerFeedbackMessage message) {
        return message.getMessageType() == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected String process(CustomerFeedbackMessage message) {
        String content = message.getMessageContent().toLowerCase();

        if (content.contains("late") || content.contains("broken") || content.contains("damaged")) {
            return "Compensation claim from " + message.getSenderEmail()
                    + " has been reviewed and approved for further processing.";
        }

        return "Compensation claim from " + message.getSenderEmail()
                + " has been reviewed and rejected due to insufficient justification.";
    }
}