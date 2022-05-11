public class Model {
    private View view;
    private Controller controller;

    public Model(View view, Controller controller) {
        this.view = view;
        this.controller = controller;
    }
}
