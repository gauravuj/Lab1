import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * This class implements a network.
 *
 * @author Adi
 * @version CS2030S AY23/24 Semester 1
 */
public class Network {
    /**
     * A queue of agent arranged in ascending order of
     * arrival time.
     */
    private PriorityQueue<Agent> queue;

    /**
     * Message buffer to communicate between agents.
     */
    private Buffer buffer;

    /*
     * Different types of agents
     */
    public static final String SINGLE_SENDER = "SSC";
    public static final String MULTI_SENDER = "MS";
    public static final String SINGLE_RECEIVER = "SR";
    public static final String MULTI_RECEIVER = "MR";

    public Network() {
        this.queue = new PriorityQueue<Agent>();
    }

    public void init(Scanner scanner) {
        this.buffer = new Buffer(scanner.nextInt());
        int numAgent = scanner.nextInt();

        for (int i = 0; i < numAgent; i++) {
            String agentType = scanner.next();

            if (agentType.equals(Network.SINGLE_SENDER)) {
                int actionTime = scanner.nextInt();
                int increment = scanner.nextInt();
                int maxRetry = scanner.nextInt();
                String message = scanner.next();
                queue.add(new SingleSender(actionTime, increment, maxRetry, message));
            } else if (agentType.equals(Network.MULTI_SENDER)) {
                int actionTime = scanner.nextInt();
                int numMessages = scanner.nextInt();
                String[] messages = new String[numMessages];
                for (int j = 0; j < numMessages; j++) {
                    String message = scanner.next();
                    messages[j] = message;
                }
                queue.add(new MultiSender(actionTime, messages));
            } else if (agentType.equals(Network.SINGLE_RECEIVER)) {
                int actionTime = scanner.nextInt();
                int increment = scanner.nextInt();
                int agentId = 0;
                queue.add(new SingleReceiver(agentId, actionTime, increment));
            } else if (agentType.equals(Network.MULTI_RECEIVER)) {
                int actionTime = scanner.nextInt();
                int numOfMessages = scanner.nextInt();
                queue.add(new MultiReceiver(actionTime, numOfMessages));
            }
        }
    }

    public void run() {
        Agent agent = null;
        Agent next = null;
        while (!this.queue.isEmpty()) {
            agent = this.queue.poll();
            next = agent.act(this.buffer);

            System.out.println(agent);

            if (next != null) {
                this.queue.add(next);
            }
        }
    }
}
