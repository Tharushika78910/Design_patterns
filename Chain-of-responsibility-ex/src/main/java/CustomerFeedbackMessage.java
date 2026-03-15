
public class CustomerFeedbackMessage {
    private final MessageType messageType;
    private final String messageContent;
    private final String senderEmail;

    public CustomerFeedbackMessage(MessageType messageType, String messageContent, String senderEmail) {
        this.messageType = messageType;
        this.messageContent = messageContent;
        this.senderEmail = senderEmail;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getSenderEmail() {
        return senderEmail;
    }
}