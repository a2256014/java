package ch16.scheduler;

public interface Scheduler {
    void getNextCall();
    void sendCallToAgent();
}
