package problems.usersignup;

import java.util.ArrayList;

public class MemoryStorage<T> implements Storage<T>{
    ArrayList<T> list= new ArrayList<>();
    MemoryStorage(){

    }
    @Override
    public T insert(T item) {
        this.list.add(item);
        return item;
    }
}
