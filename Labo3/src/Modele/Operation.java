package Modele;

import java.io.Serializable;

public interface Operation extends Serializable {
    public void execute();
    public void undo();
    public void redo();

}
