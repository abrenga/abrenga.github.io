public class ObjInMemory {
    private String name;
    private boolean isReachable;

    public ObjInMemory(String name) {
        this.name = name; //rappresenta il nome dell'oggetto di riferimento da allocare poi in memoria
        this.isReachable = false;// è raggiungibile? fissiamo di default a falso.
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

    public void setName(String name) {
        this.name = name;
    }
}
// questa classe rappresenta il mio oggetto, che andrà poi allocato in memoria, avrà infatti un nome con il quale verrà identificato.