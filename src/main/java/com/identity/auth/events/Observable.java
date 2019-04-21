package com.identity.auth.events;

/**
 * Event Handler to manage Events
 */
public interface Observable<T extends Observer, R extends Event> {
    /**
     * Register an Observer
     *
     * @param t
     */
    void register(T t);

    /**
     * UnRegister an Observer
     * @param t
     */
    void unRegister(T t);

    /**
     * Notify all observers
     *
     * @param r
     */
    void notifyObservers(R r);
}
