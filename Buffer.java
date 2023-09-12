/*
 * The Buffer class encapsulates a queue of messages.
 * An agent may send a message to the end of the queue.
 * An agent may receive a message from the beginning
 * of the queue.
 * 
 * @author Adi
 * @version CS2030S AY23/24 Semester 1
 */
public class Buffer {
  /**
   * The queue of messages. Each message is a String.
   */
  private String[] messages;

  /**
   * The index indicating the end of the queue.
   */
  private int endIndex;

  /**
   * Creates a buffer with the given size.
   * 
   * @param size The maximum size of the buffer.
   */
  public Buffer(int size) {
    this.messages = new String[size];
    this.endIndex = 0;
  }

  /**
   * Used by an agent to send a message. The message
   * will be inserted to the end of the buffer if
   * there is a space in the buffer. Otherwise, the
   * message is dropped.
   * 
   * @param message The message to be added to the buffer.
   *                The message cannot be null.
   * @return true if the message is successfully added.
   *         false otherwise.
   */
  public void send(String message) throws BufferFullException {

    if (this.endIndex > this.messages.length) {
      throw new BufferFullException();
    } else {
      this.messages[this.endIndex] = message;
      this.endIndex++;
    }

  }

  /**
   * Used by an agent to receive a message. The message
   * is retrieved from the beginning of the buffer if any.
   * Otherwise, a null value is returned.
   * 
   * @return The message at the start of buffer if any.
   *         Null otherwise.
   */
  public String receive() throws BufferEmptyException {

    if (this.endIndex == 0) {
      throw new BufferEmptyException();
    } else {
      String message = this.messages[0];
      for (int i = 1; i < this.endIndex; i++) {
        this.messages[i - 1] = this.messages[i];
      }
      this.endIndex--;
      return message;
    }
  }
}
