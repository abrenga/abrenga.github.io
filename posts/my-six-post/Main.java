public class Main {
    public static void main(String[] args) {
        GarbageCollector gc = new GarbageCollector();
        gc.allocateObjInMemory("Oggetto1");
        gc.allocateObjInMemory("Oggetto2");
        gc.allocateObjInMemory("Oggetto3");


        gc.removeReference("Oggetto1");
        gc.removeReference("Oggetto3");


        gc.run();

        //a  questo punto l'oggetto 2 non allocato verà cancellato.
    }


}