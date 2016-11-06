package es.cesalberca.calculator.observer;

/**
 * Created by Cesar
 */
public interface Subject {
    void registerObserver (Observer o);
    @SuppressWarnings("unused")
    void unregisterObserver (Observer o);
    void notifyObservers ();
}
