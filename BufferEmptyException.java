/**
 * Checked exception for when buffer is empty and
 * there is an attempt to receive a message.
 *
 * @author XXX
 * @version CS2030S AY23/24 Semester 1
 */

class BufferEmptyException extends Exception {

    public BufferEmptyException() {
        super("Buffer is empty");
    }
}