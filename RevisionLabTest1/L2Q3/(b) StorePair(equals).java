Override the Object equals() method in the StorePair class to compare the first values of two objects for equality.

public boolean equals(Object obj){
        if(this == obj) {                       //1st check if 2 objects being compared are same object
            return true;
        }
        if(!(obj instanceof StorePair)){        //check if 'obj' is an instanceOf 'StorePair' (if not then false) (must true to cast)
            return false;
        }
        StorePair other = (StorePair)obj;       //cast 'obj' to 'StorePair' and compare the 'first' values of the 2 objects
        return this.first == other.first;
    }
