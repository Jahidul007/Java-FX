
import javafx.scene.control.Button;

public class Controller
{
    public Button button;
    
    
    public void handleButtonClick()
    {
        System.out.println("Run some code user dosen't see");
        button.setText("Stop touching me");
    }
}