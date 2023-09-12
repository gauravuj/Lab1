public class MultiSender extends Sender {

    private String[] messages;
    private int counter;

    public MultiSender(int actionTime, String[] messages) {
        super(actionTime);
        this.messages = messages;
        this.counter = 0;
    }

    @Override
    public String toString() {
        String str = super.toString();

        if (this.counter == messages.length) {
            str += " sent all messages";
        } else {
            str += " sent " + counter + "/" + this.messages.length + " messages";
        }
        return str;
    }

    @Override
    public Agent act(Buffer buffer) {
        try {
            for (int i = this.counter; i < this.messages.length; i++) {
                buffer.send(this.messages[i]);
                counter += 1;
            }
        } catch (BufferFullException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}