public class ObjInMemory {
    private String name;
    private boolean isReachable;
    private Object object;

    public ObjInMemory(Object object, String name) {
        this.name = name;
        this.isReachable = false;
        this.object = object;
    }

    public boolean isReachable() {
        return isReachable;
    }

    public void setReachable(boolean reachable) {
        isReachable = reachable;
    }

    public String getName() {
        return name;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void setName(String name) {
        this.name = name;
    }
}