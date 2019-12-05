package com.deepclone.examples;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 
 * @author Sergio Besada
 * 
 */
public class DelayObject implements Delayed {
    private final String data;
    private final long startTime;

    public DelayObject(final String data, final long delay) {
        this.data = data;
        this.startTime = System.currentTimeMillis() + delay;
    }

    @Override
    public long getDelay(final TimeUnit unit) {
        final long diff = this.startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(final Delayed o) {
        if (this.startTime < ((DelayObject) o).startTime) {
            return -1;
        }
        if (this.startTime > ((DelayObject) o).startTime) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "{" +
                "data='" + this.data + '\'' +
                ", startTime=" + this.startTime +
                '}';
    }
}