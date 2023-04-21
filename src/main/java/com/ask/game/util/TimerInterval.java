package com.ask.game.util;

import com.ask.game.dto.TimerInvoker;

import java.io.Serializable;
import java.util.TimerTask;

/**
 *
 * @author Daniel/DaniDaniel09
 * @param <T>
 */
public class TimerInterval<T extends TimerInvoker> extends TimerTask  implements Serializable {

    private T taskCaller;

    /**
     *
     * @param t
     */
    public TimerInterval(T t) {
        this.taskCaller = t;
    }

    /**
     *
     */
    public void run() {
        taskCaller.beep();
    }
}
