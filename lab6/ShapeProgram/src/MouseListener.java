import java.awt.event.MouseEvent;

public interface MouseListener {
    public void mouseClicked(MouseEvent event);

    public void mousePressed(MouseEvent event);

    public void mouseReleased(MouseEvent event);

    public void mouseEntered(MouseEvent event);

    public void mouseExited(MouseEvent event);
}
