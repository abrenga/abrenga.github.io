import java.util.*;

public class GarbageCollector {
    //questa classe  simula il Gc.
    //ha come parametri, la lista di oggetti nella memoria e Oggetti di riferimento (variabili principali) -root di rifermiento
    /*tieni presente che la root di riferimeno serve per identificare le variabili che ospitano il puntamento in memoria*/


    private List<ObjInMemory> memory = new ArrayList<>();//questa proprietà simula la memoria, viene rappresentata come una lista che andrà riempita con i miei object
    private Set<ObjInMemory> variableRoot = new HashSet<>();// questa proprietà rappresenta le variabili che hanno il puntamento in memoria dei nostri obj


//Adesso abbiamo bisogno di un metodo che simuli l'aggiunta del mio object in memoria

    public void allocateObjInMemory(String name) {
        ObjInMemory obj = new ObjInMemory(name);
        memory.add(obj);
    }

    //aggiungere un riferimento dell'oggetto ad una variabile
    public void addReference(String name) {
        for (ObjInMemory obj : variableRoot) {
            if (obj.getName().equals(name)) {
                variableRoot.add(obj);// qui semplicemente diciamo controlla in memoria, se è presente il nome dell'ogetto, se è presnete  rappresentano quelli raggiungibili.
            }

        }
    }

// qui in egual modo togliamo il referimento dalla variabile
    public void removeReference(String name) {
        for (ObjInMemory obj : variableRoot) {
            if (obj.getName().equals(name)) {
                variableRoot.remove(obj);
            }
        }
    }

    //dopo la fase mi allocazione in memoria e creazione dell'oggetto bisogna passare alla marcatura.
    //La marcatura serve per contrassegnare gli oggetti come raggiungibili quindi

    public void mark(){
        for (ObjInMemory obj: memory ){
            obj.setReachable(false);//prima di marcare come raggiungibile, settiamo tutti  gli oggetti in memoria a non raggiungibili.
        }

        for(ObjInMemory root: variableRoot){
            markReachable(root);
        }
    }


    public void markReachable(ObjInMemory obj){
        if (!obj.isReachable()) {
            obj.setReachable(true); // Marca l'oggetto come utilizzato trovato
        }
    }


    // fase di raccolta. Dobbiamo infatti iterare sulla lista memory verifica se un oggetto è ancora raggiungibile se
    //l'oggetto non è contrrassegnato come raggiungibili vuol dire che non viene usato

    public void sweep() {
        System.out.println("Inizio eliminazione...");
        Iterator<ObjInMemory> iterator = memory.iterator();
        while (iterator.hasNext()) {
            ObjInMemory obj = iterator.next();
            if (!obj.isReachable()) { // Se l'oggetto non è raggiungibile
                System.out.println("Eliminato: " + obj.getName());
                iterator.remove();    // Rimuovi l'oggetto dalla memoria
            }
        }
    }

//esegue
    public void run() {
        mark();  // Fase di marcatura
        sweep(); // Fase di raccolta
    }

}
