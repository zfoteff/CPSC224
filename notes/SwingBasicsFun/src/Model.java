public class Model {
    // can have a reference to the controller
    // for our simple login app, the model doesn't broadcast anything
    // /fire any events, so the model does not need a reference to the controller

    public boolean authenticate(String username, String password) {
        // dummy method!!
        if (username.compareTo("admin") == 0 && password.compareTo("12345") == 0) {
            return true;
        }
        return false;
    }
}
