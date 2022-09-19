package dome.web.oem.Service;

public interface BaseEnity {
    public abstract boolean ValidateEmpty();
    public abstract boolean ValidateUnique();
    public abstract boolean AutoFill();
    public abstract Object getKey();
    public abstract String getText();
}
