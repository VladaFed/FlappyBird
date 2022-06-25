package view;

public class PipeView {
    private int Xpipe;
    private int YbottomPipe;
    private int YtopPipe;
    private boolean passed = false;

    public PipeView(int x, int yPipe1, int yPipe2, boolean pass){
        this.Xpipe = x;
        this.YbottomPipe = yPipe1;
        this.YtopPipe = yPipe2;
        this.passed = pass;
    }

    public int XPipe() {
        return Xpipe;
    }

    public int YBottomPipe() {
        return YbottomPipe;
    }

    public int YTopPipe() { return YtopPipe; }

    public boolean IsPassed(){
        return passed;
    }

    public void setPassed() {
        passed = true;
    }
}
