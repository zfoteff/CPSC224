public class Model
{
    //  Can have reference to the controller
    //  for our simple login app, the model doesn't broadcast anything/fire any events, so the model doesn't need a
    //  reference to the controller

    public boolean authenticate(String username, String password)
    {
        //  Dummy method
        if (username.compareTo("admin") == 0 && password.compareTo("12345") == 0)
            return true;
        return false;
    }

    //  for PA 5 this will be all state and game logic for hangman
}
