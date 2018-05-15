package TheMulitThreads.gui;

/**
 * Created by tangjialiang on 2018/1/25.
 *
 * GuiExecutor.instance().execute() ;
 */

public class GuiExecutor {
    private static volatile GuiExecutor instance = null ;

    public static GuiExecutor instance() {
        if (instance == null) {
            synchronized (GuiExecutor.class) {
                if (instance == null) {
                    instance = new GuiExecutor() ;
                }
            }
        }
        return instance ;
    }

    public void execute(Runnable thread) {

    }
}
