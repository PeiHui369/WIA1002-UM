public final class ArrayBag<T> implements BagInterface<T> {
    private final T[] bag;
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    //Constructor
    public ArrayBag(T[] ts){this(DEFAULT_CAPACITY);}

    public ArrayBag(int desiredCapacity){
        if(desiredCapacity <= MAX_CAPACITY){
            T[] tempBag = (T[]) new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
            initialized = true;
        }
        else{
            throw new IllegalStateException("Attempt to create a bag " + "whose capacity exceeds "+ "allowed maximum.");
        }
    }

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int getCurrentSize() {
        return this.numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries >= bag.length;
    }

    @Override
    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }

    private void checkInitialization(){
        if(!initialized){
            throw new SecurityException("ArrayBag object is not initialized properly.");
        }
    }

    @Override
    public boolean add(T newEntry) {
        checkInitialization();
        boolean result = true;
        if(isFull()){
            result = false;
        }else{
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    private T removeEntry(int givenIndex){
        T result = null;
        if(!isEmpty() && (givenIndex>=0)){
            result = bag[givenIndex];
            int lastIndex = numberOfEntries - 1;
            bag[givenIndex] = bag[lastIndex];
            bag[lastIndex] = null;
            numberOfEntries--;
        }
        return result;
    }
    @Override
    public T remove() {
        checkInitialization();
        T result = removeEntry(numberOfEntries-1);
        return result;
    }

    private int getIndexOf(T anEntry){
        int where = -1;
        boolean found = false;
        int index = 0;
        while(!found && (index<numberOfEntries)){
            if(anEntry.equals(bag[index])){
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }
    @Override
    public boolean remove(T anEntry) {
        checkInitialization();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    @Override
    public void clear() {
        while(!isEmpty()){
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        checkInitialization(); //#
        int counter = 0;
        for(int index=0; index<numberOfEntries; index++){
            if(bag[index].equals(anEntry)){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean contains(T anEntry) {
        checkInitialization();
        return getIndexOf(anEntry)>-1;
    }

    @Override
    public T[] toArray() { //#
        checkInitialization();
        T[] result = (T[]) new Object[numberOfEntries];
        for(int index = 0; index<numberOfEntries; index++){
            result[index] = bag[index];
        }
        return result;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag){
        int size1 = getCurrentSize(), size2 = anotherBag.getCurrentSize();
        ArrayBag<T> newBag = new ArrayBag<>(size1 + size2);

        T[] arr1 = this.toArray();
        T[] arr2 = anotherBag.toArray();

        for(int i = 0; i<arr1.length; i++){
            newBag.add(arr1[i]);
        }

        for(int i = 0; i<arr2.length; i++){
            newBag.add(arr2[i]);
        }
        return newBag;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag) {
        return batchRemove(anotherBag, false);
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag){
        return batchRemove(anotherBag,true);
    }

    public BagInterface<T> batchRemove(BagInterface<T> anotherBag, boolean complement){
        BagInterface<T> newBag = new ArrayBag<T>(numberOfEntries);

        for(int i = 0; i<numberOfEntries; i++){
            if(newBag.contains(bag[i])){
                continue;
            }

            int freq1 = getFrequencyOf(bag[i]);
            int freq2 = anotherBag.getFrequencyOf(bag[i]);
            int end = (complement)? freq1- freq2 : Math.min(freq1, freq2);

            for(int j = 0; i<end; j++){
                newBag.add(bag[i]);
            }
        }
        return new ArrayBag<T>(newBag.toArray());
    }
}

//How batchRemove method work for intersection and difference?

