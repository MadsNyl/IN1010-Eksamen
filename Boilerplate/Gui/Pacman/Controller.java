public class Controller {
    private View view;
    private Model model;

    public Controller() {
        view = new View(this);
        model = new Model(view, this);
    }
}