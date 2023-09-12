class SingleReceiver extends Receiver {

    private String message;
    private int increment;

    public SingleReceiver(int actionTime, int increment) {
        super(actionTime);
        this.increment = increment;
    }

    public SingleReceiver(int agentId, int actionTime, int increment) {
        super(agentId, actionTime);
        this.increment = increment;
    }

    @Override
    public String toString() {
        String str = super.toString();

        if (message != null) {
            str += " received '" + this.message + "'";
        } else {
            str += " failed to receive message";
        }
        return str;
    }

    @Override
    public Agent act(Buffer buffer) {
        try {
            String message = buffer.receive();
            this.message = message;
            return new SingleReceiver(this.getId(), this.getTime(this.increment), this.increment);
        } catch (BufferEmptyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}