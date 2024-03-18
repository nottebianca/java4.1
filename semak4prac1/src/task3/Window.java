package task3;

class Window {
    String categoryAccepted;
    boolean busy;

    public Window(String categoryAccepted) {
        this.categoryAccepted = categoryAccepted;
        this.busy = false;
    }

    public boolean isAcceptable(People people) {
        return people.getCategory().equals(categoryAccepted);
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
