abstract class Receiver extends Agent {

    private static int lastId = 0;
    private int agentId;

    /**
     * Constructor for a Receiver agent with running id.
     * 
     * @param actionTime The time the agent is taking action.
     * @param increment  The increment for next agent.
     */
    public Receiver(int actionTime) {
        super(actionTime);
        this.agentId = Receiver.lastId;
        Receiver.lastId = 1 - lastId;
    }

    public Receiver(int agentId, int actionTime) {
        super(actionTime);
        if (this.agentId > lastId) {
            Receiver.lastId = agentId;
        }

        this.agentId = Receiver.lastId;
    }

    public int getId() {
        return this.agentId;
    }

    /**
     * String representation of receiver agent.
     * 
     * @return A string representing the agent.
     */
    @Override
    public String toString() {
        return super.toString() + " R#" + this.getId();
    }

    @Override
    public abstract Agent act(Buffer buffer);
}