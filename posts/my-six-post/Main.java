public class Main {
    public static void main(String[] args) {
        GarbageCollector gc = new GarbageCollector();

        PrototypeClass prototype = new PrototypeClass();

        gc.trackObjInMemory(prototype,"Oggetto1");
        gc.trackObjInMemory(prototype,"Oggetto2");
        gc.trackObjInMemory(prototype,"Oggetto3");

        gc.removeReference("Oggetto1");
        gc.removeReference("Oggetto3");

        gc.run();

    }


}