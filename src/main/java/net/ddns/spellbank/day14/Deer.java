package net.ddns.spellbank.day14;

public class Deer {
    private String name;
    private int speed;
    private int runTime;
    private int rest;
    private int time;
    int distance;
    private boolean resting;
    int score;

    public Deer(String name, int speed, int runTime, int rest) {
        this.name = name;
        this.speed = speed;
        this.runTime = runTime;
        this.rest = rest;
        time = 0;
        distance = 0;
        resting = false;
        score = 0;
    }

    public void update() {
        time++;
        if (resting) {
            if (time == rest) {
                resting = false;
                time = 0;
            }
        } else {
            distance += speed;
            if (time == runTime) {
                resting = true;
                time = 0;
            }
        }
    }

    public void score() {
        score++;
    }

    public void print() {
        System.out.println(name);
        System.out.println(speed);
        System.out.println(runTime);
        System.out.println(rest);
    }

}
