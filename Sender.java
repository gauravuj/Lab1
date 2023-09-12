/**
 * The Sender class encapsulates a sender agent
 * that can send message(s).
 *
 * @author XXX
 * @version CS2030S AY23/24 Semester 1
 */
abstract class Sender extends Agent {
    public static int lastId = 0;
    public int agentId;

    /**
     * Constructor for a Sender agent with running id.
     * 
     * @param actionTime The time the agent is taking action.
     * @param increment  The increment for next agent.
     */

    public Sender(int actionTime) {
        super(actionTime);
        this.agentId = Sender.lastId;
        Sender.lastId++;
    }

    /**
     * String representation of sender agent.
     * 
     * @return A string representing the agent.
     */
    @Override
    public String toString() {
        return super.toString() + " S#" + this.agentId;
    }

    @Override
    public abstract Agent act(Buffer buffer);
}
