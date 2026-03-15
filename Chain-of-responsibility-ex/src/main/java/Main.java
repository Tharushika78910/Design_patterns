
public class Main {
    public static void main(String[] args) {
        // Build the chain
        FeedbackHandler compensationHandler = new CompensationClaimHandler();
        FeedbackHandler contactHandler = new ContactRequestHandler();
        FeedbackHandler developmentHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalHandler = new GeneralFeedbackHandler();

        compensationHandler
                .setNextHandler(contactHandler)
                .setNextHandler(developmentHandler)
                .setNextHandler(generalHandler);

        CustomerFeedbackMessage[] messages = {
                new CustomerFeedbackMessage(
                        MessageType.COMPENSATION_CLAIM,
                        "My package arrived late and the product was damaged.",
                        "alice@example.com"
                ),
                new CustomerFeedbackMessage(
                        MessageType.CONTACT_REQUEST,
                        "Please contact me about my recent order.",
                        "bob@example.com"
                ),
                new CustomerFeedbackMessage(
                        MessageType.DEVELOPMENT_SUGGESTION,
                        "You should improve the mobile app and add a dark mode feature.",
                        "carol@example.com"
                ),
                new CustomerFeedbackMessage(
                        MessageType.GENERAL_FEEDBACK,
                        "I am very happy with your service. Keep it up!",
                        "dave@example.com"
                ),
                new CustomerFeedbackMessage(
                        MessageType.COMPENSATION_CLAIM,
                        "I want compensation.",
                        "eve@example.com"
                )
        };

        for (CustomerFeedbackMessage message : messages) {
            System.out.println("Message type: " + message.getMessageType());
            System.out.println("Sender: " + message.getSenderEmail());
            System.out.println("Content: " + message.getMessageContent());
            System.out.println("Result: " + compensationHandler.handle(message));
            System.out.println("--------------------------------------------------");
        }
    }
}