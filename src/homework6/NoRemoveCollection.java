package homework6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class NoRemoveCollection extends ArrayList {
    @Override
    public boolean remove(Object o){
        return false;
    }

    @Override
    public Object remove(int index){
        return false;
    }

    @Override
    public boolean removeAll(Collection c){
        return false;
    }

    @Override
    public boolean removeIf(Predicate filter){
       return false;
    }

    @Override
    public void removeRange(int fromIndex, int toIndex){}

    public boolean retainAll(Collection c){
        return false;
    }
}
