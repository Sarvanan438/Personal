package problems.usersignup;

public class UserRepository implements Repository<User>{


    private Storage<User> storage;
    UserRepository(Storage<User> storage){
            this.storage=storage;
    }

    @Override
    public void save(User user) {
        this.storage.insert(user);
    }
}
