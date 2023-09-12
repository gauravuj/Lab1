class SingleSender extends Sender {

    private String message;
    private int increment;
    private int maxRetry;
    private int counter;

    public SingleSender(int actionTime, int increment, int maxRetry, String message) {
        super(actionTime);
        this.message = message;
        this.increment = increment;
        this.maxRetry = maxRetry;
        this.counter = 0;
    }

    @Override
    public String toString() {
        String str = super.toString();

        if (this.counter == 0) {
            str += " failed to send '" + this.message + "'";
        } else {
            str += " successfully sent '" + this.message + "'";
        }
        return str;
    }

    @Override
    public Agent act(Buffer buffer) {
        try {
            while (counter < this.maxRetry) {
                buffer.send(this.message);
                this.increment = increment + this.getTime(this.increment);
                this.counter++;
                // return new SingleSender(this.getTime(this.increment),
                // this.increment,this.maxRetry, this.message);
            }
        } catch (BufferFullException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}