/* agent. An agent encapsulates only the time the agent acts.
* A subclass of agent _must_ override 
* the act(Buffer) method to implement the logic of the 
* action when this agent performs its action.
* 
* The act(Buffer) method potentially returns another agent,
* which the network will then add to the network queue.
* Note that an agent also implements the Comparable interface
* so that a PriorityQueue can arrange the agent in the order
* of action time.
* 
* The act(Buffer) method may mutates the given buffer.
*
* @author Adi
* @version CS2030S AY23/24 Semester 1
*/
public abstract class Agent implements Comparable<Agent> {
    /**
     * The time the agent acts.
     */
    private final int actionTime;

    /**
     * Creates an agent that will act at the given time.
     * 
     * @param time The time that the action occurs.
     */
    public Agent(int actionTime) {
        this.actionTime = actionTime;
    }

    /**
     * Accessor to return the action time of the agent
     * with some increment.
     * 
     * @param increment The increment to the action time.
     * @return The action time plus the increment.
     */
    public int getTime(int increment) {
        return this.actionTime + increment;
    }

    /**
     * Compare this agent with the other agent.
     * 
     * @param agent The other agent.
     * @return Negative number if this agent acts earlier than the other agent.
     *         Zero if this agent acts at the same time as the other agent.
     *         Positive number if this agent acts later than the other agent.
     */
    @Override
    public int compareTo(Agent agent) {
        return this.actionTime - agent.actionTime;
    }

    /**
     * String representation of the given agent.
     * 
     * @return A string consisting only of the action time with prefix @.
     */
    @Override
    public String toString() {
        String str = String.format("%03d", this.actionTime);
        return "(@" + str + ")";
    }

    /**
     * The action perform by the agent
     * 
     * @param buffer The buffer that may be mutated.
     * @return Potentially another agent.
     */
    public abstract Agent act(Buffer buffer);
}