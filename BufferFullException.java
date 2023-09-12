/**
 * Checked exception for when buffer is full and
 * there is an attempt to send a message.
 *
 * @author XXX
 * @version CS2030S AY23/24 Semester 1
 */

class BufferFullException extends Exception {

    public BufferFullException() {
        super("Buffer is full");
    }
}
