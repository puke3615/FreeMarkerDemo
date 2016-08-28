package com.mogujie.callback.core;

/**
 * @author zijiao
 * @version 16/8/26
 *          Mark
 */
public interface CallbackHolder {

    interface Callback1 extends Callback {
        void call1(int age);
    }

    interface Callback2 extends Callback {
        void call2(int age);
    }

    interface Callback3 extends Callback {
        void call3(int age);
    }

    interface Callback4 extends Callback {
        void call4(int age);
    }


}
