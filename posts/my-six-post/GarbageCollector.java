import java.util.*;

public class GarbageCollector {
    private List<ObjInMemory> memory = new ArrayList<>();
    private Set<ObjInMemory> variableRoot = new HashSet<>();

    public void trackObjInMemory(Object obj, String name) {
        ObjInMemory objInMemory = new ObjInMemory(obj,name);
        memory.add(objInMemory);
    }

    public void addReference(String name) {
        for (ObjInMemory obj : variableRoot) {
            if (obj.getName().equals(name)) {
                variableRoot.add(obj);
            }

        }
    }

    public void removeReference(String name) {
        for (ObjInMemory obj : variableRoot) {
            if (obj.getName().equals(name)) {
                variableRoot.remove(obj);
            }
        }
    }

    public void mark(){
        for (ObjInMemory obj: memory ){
            obj.setReachable(false);
        }

        for(ObjInMemory root: variableRoot){
            markReachable(root);
        }
    }

    public void markReachable(ObjInMemory obj){
        if (!obj.isReachable()) {
            obj.setReachable(true);
        }
    }

    public void sweep() {
        Iterator<ObjInMemory> iterator = memory.iterator();
        while (iterator.hasNext()) {
            ObjInMemory obj = iterator.next();
            if (!obj.isReachable()) {
                iterator.remove();
            }
        }
    }

    public void run() {
        mark();
        sweep();
    }

}
