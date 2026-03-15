
public class DevelopmentSuggestionHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(CustomerFeedbackMessage message) {
        return message.getMessageType() == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected String process(CustomerFeedbackMessage message) {
        String content = message.getMessageContent().toLowerCase();

        if (content.contains("app") || content.contains("feature") || content.contains("improve")) {
            return "Development suggestion from " + message.getSenderEmail()
                    + " has been logged and marked as high priority.";
        }

        return "Development suggestion from " + message.getSenderEmail()
                + " has been logged for future review.";
    }
}