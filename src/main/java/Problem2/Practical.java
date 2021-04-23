package Problem2;

/**
 *  Helper class to determine location based on direction.
 */

class Particles {

    private Direction DIRECTION;
    private int START_LOCATION;
    private int SPEED;

    public Particles(char direction, int startLocation, int speed) {
        if (!(direction == 'R' || direction == 'L')) {
            throw new RuntimeException("Unable to determine L=Left, R=Right");
        }
        if (direction == 'R') {
            this.DIRECTION = Direction.RIGHT;
        } else {
            this.DIRECTION = Direction.LEFT;
        }

        this.SPEED = speed;
        this.START_LOCATION = startLocation;
    }

    public int locationAfter(int time) {
        if (DIRECTION == Direction.RIGHT) {
            return (time * SPEED) + START_LOCATION;
        }
        return START_LOCATION - (time * SPEED);
    }
}