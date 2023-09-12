class MultiReceiver extends Receiver {

    private String[] messages;
    private int numOfMessages;
    private int counter;

    public MultiReceiver(int actionTime, int numOfMessages) {
        super(actionTime);
        this.numOfMessages = numOfMessages;
        this.counter = 1;
    }

    @Override
    public String toString() {
        String str = super.toString();
        String receivedMessages = "";

        for (int i = 0; i < messages.length; i++) {
            receivedMessages = receivedMessages + messages[i];
        }

        if (this.counter == messages.length) {
            str += " received '" + counter + "/" + this.numOfMessages + " messages: " + receivedMessages + "'";
        } else {
            str += " failed to receive message";
        }
        return str;

    }

    @Override
    public Agent act(Buffer buffer) {
        try {
            for (int i = 0; i < numOfMessages; i++) {
                this.messages[i] = buffer.receive();
                this.counter++;
            }
            return new MultiReceiver(this.getTime(this.numOfMessages), this.numOfMessages);
        } catch (BufferEmptyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}